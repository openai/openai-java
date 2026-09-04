package com.openai.core.http

import com.fasterxml.jackson.databind.json.JsonMapper
import com.openai.auth.AzureManagedIdentityTokenProvider
import com.openai.auth.GcpIdTokenProvider
import com.openai.auth.SubjectTokenProvider
import com.openai.auth.SubjectTokenType
import com.openai.auth.WorkloadIdentity
import com.openai.client.OpenAIClientImpl
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.Sleeper
import com.openai.errors.InternalServerException
import com.openai.errors.OpenAIRetryableException
import java.time.Clock
import java.time.Duration
import java.time.Instant
import java.time.ZoneOffset
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class WorkloadIdentityRetryAfterTest {
    private class Transport(private val retryHeaders: Headers) : HttpClient {
        var issuerCalls = 0
        var apiCalls = 0
        var closedApiResponses = 0

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
            val issuer = request.baseUrl.contains("auth.openai.com")
            if (issuer) issuerCalls++ else apiCalls++
            return object : HttpResponse {
                private var closed = false

                override fun statusCode() = if (issuer) 200 else 401

                override fun headers(): Headers {
                    check(!closed) { "Response headers released on close" }
                    return if (issuer) Headers.builder().build() else retryHeaders
                }

                override fun body() =
                    (if (issuer)
                            """{"access_token":"synthetic-issued-token","token_type":"Bearer","issued_token_type":"urn:ietf:params:oauth:token-type:access_token","expires_in":3600}"""
                        else
                            """{"error":{"type":"authentication_error","code":"invalid_api_key","message":"synthetic expired token"}}""")
                        .byteInputStream()

                override fun close() {
                    closed = true
                    if (!issuer) closedApiResponses++
                }
            }
        }

        override fun executeAsync(request: HttpRequest, requestOptions: RequestOptions) =
            CompletableFuture.completedFuture(execute(request, requestOptions))

        override fun close() {}
    }

    private class RecordingSleeper : Sleeper {
        val waits = mutableListOf<Duration>()
        var entered = CountDownLatch(1)
        var pending: CompletableFuture<Void>? = null

        override fun sleep(duration: Duration) {
            waits.add(duration)
        }

        override fun sleepAsync(duration: Duration): CompletableFuture<Void> {
            val result: CompletableFuture<Void> = pending ?: CompletableFuture.completedFuture(null)
            waits.add(duration)
            entered.countDown()
            return result
        }

        override fun close() {}
    }

    private fun client(
        transport: HttpClient,
        sleeper: RecordingSleeper,
        retries: Int = 1,
        subjectProvider: SubjectTokenProvider? = null,
    ) = OpenAIClientImpl(clientOptions(transport, sleeper, retries, subjectProvider))

    private fun clientOptions(
        transport: HttpClient,
        sleeper: RecordingSleeper,
        retries: Int = 1,
        subjectProvider: SubjectTokenProvider? = null,
    ): ClientOptions {
        val provider =
            object : SubjectTokenProvider {
                override fun tokenType() = SubjectTokenType.JWT

                override fun getToken(httpClient: HttpClient, jsonMapper: JsonMapper) =
                    "synthetic-subject-token"

                override fun getTokenAsync(httpClient: HttpClient, jsonMapper: JsonMapper) =
                    CompletableFuture.completedFuture("synthetic-subject-token")
            }
        return ClientOptions.builder()
            .baseUrl("https://sdk235.invalid")
            .workloadIdentity(
                WorkloadIdentity.builder()
                    .identityProviderId("synthetic-idp")
                    .serviceAccountId("synthetic-sa")
                    .provider(subjectProvider ?: provider)
                    .build()
            )
            .httpClient(transport)
            .sleeper(sleeper)
            .maxRetries(retries)
            .clock(Clock.fixed(Instant.parse("2026-09-04T00:00:00Z"), ZoneOffset.UTC))
            .build()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun credentialRefreshHonorsServerMinimumAndBudget(async: Boolean) {
        data class Case(
            val headers: Map<String, String>,
            val delay: Duration?,
            val attempts: Int = 2,
            val retries: Int = 1,
        )
        for (case in
            listOf(
                Case(mapOf("Retry-After" to "90"), Duration.ofSeconds(90)),
                Case(mapOf("Retry-After-Ms" to "90000"), Duration.ofSeconds(90)),
                Case(
                    mapOf("Retry-After" to "Fri, 04 Sep 2026 00:01:30 GMT"),
                    Duration.ofSeconds(90),
                ),
                Case(mapOf("Retry-After-Ms" to "1", "Retry-After" to "90"), Duration.ofMillis(1)),
                Case(mapOf("Retry-After" to "invalid"), null),
                Case(emptyMap(), null),
                Case(mapOf("Retry-After" to "1e999"), null, 1),
                Case(mapOf("Retry-After-Ms" to "1e999"), null, 1),
                Case(
                    mapOf("Retry-After" to "90", "X-Should-Retry" to "false"),
                    Duration.ofSeconds(90),
                ),
                Case(mapOf("X-Should-Retry" to "false"), null),
                Case(mapOf("Retry-After" to "90"), null, 1, 0),
                Case(mapOf("Retry-After" to "90"), Duration.ofSeconds(90), 3, 2),
            )) {
            val headers =
                Headers.builder()
                    .apply { case.headers.forEach { (key, value) -> put(key, value) } }
                    .build()
            val transport = Transport(headers)
            val sleeper = RecordingSleeper()
            val sdk = client(transport, sleeper, case.retries)
            val error =
                try {
                    if (async) sdk.async().models().retrieve("synthetic-model").join()
                    else sdk.models().retrieve("synthetic-model")
                    error("Expected token rejection")
                } catch (error: CompletionException) {
                    error.cause
                } catch (error: OpenAIRetryableException) {
                    error
                }
            assertThat(error)
                .isInstanceOf(OpenAIRetryableException::class.java)
                .hasMessage("OAuth token is expired")
            assertThat(transport.apiCalls).isEqualTo(case.attempts)
            assertThat(transport.issuerCalls).isEqualTo(case.attempts)
            assertThat(transport.closedApiResponses).isEqualTo(case.attempts)
            assertThat(sleeper.waits).hasSize(case.attempts - 1)
            for (wait in sleeper.waits) {
                if (case.delay != null) assertThat(wait).isEqualTo(case.delay)
                else assertThat(wait).isBetween(Duration.ofMillis(375), Duration.ofMillis(500))
            }
            sdk.close()
        }
    }

    private class BackgroundTransport(
        private val failureHeaders: Headers = Headers.builder().put("Retry-After", "90").build(),
        private val rejections: Map<Int, Int> = mapOf(2 to 401),
    ) : HttpClient {
        var issuerCalls = 0
        var apiCalls = 0
        var closedFailures = 0

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
            val issuer = request.baseUrl.contains("auth.openai.com")
            if (issuer) issuerCalls++ else apiCalls++
            val failure = issuer && issuerCalls == 2
            val rejectedStatus = if (issuer) null else rejections[apiCalls]
            return object : HttpResponse {
                override fun statusCode() = if (failure) 503 else rejectedStatus ?: 200

                override fun headers() = if (failure) failureHeaders else Headers.builder().build()

                override fun body() =
                    (when {
                            failure -> """{"error":"temporarily_unavailable"}"""
                            issuer ->
                                """{"access_token":"synthetic-token","token_type":"Bearer","issued_token_type":"urn:ietf:params:oauth:token-type:access_token","expires_in":60}"""
                            rejectedStatus != null -> """{"error":{"message":"expired"}}"""
                            else ->
                                """{"id":"synthetic-model","created":0,"object":"model","owned_by":"synthetic"}"""
                        })
                        .byteInputStream()

                override fun close() {
                    if (failure) closedFailures++
                }
            }
        }

        override fun executeAsync(request: HttpRequest, requestOptions: RequestOptions) =
            CompletableFuture.completedFuture(execute(request, requestOptions))

        override fun close() {}
    }

    @Test
    fun failedBackgroundGenerationDelaysOnlyItsLogicalRequest() {
        val transport = BackgroundTransport()
        val sleeper = RecordingSleeper()
        val sdk = client(transport, sleeper)
        val sharedOptions = RequestOptions.none()
        try {
            sdk.async().models().retrieve("synthetic-model", sharedOptions).join()
            sleeper.pending = CompletableFuture()
            val original = sdk.async().models().retrieve("synthetic-model", sharedOptions)
            assertThat(sleeper.entered.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(transport.issuerCalls).isEqualTo(2)
            assertThat(transport.closedFailures).isEqualTo(1)
            // Release the ordinary 401 retry backoff, then block the issuer minimum.
            val apiRetry = sleeper.pending!!
            sleeper.pending = CompletableFuture()
            val issuerWaitEntered = CountDownLatch(1)
            sleeper.entered = issuerWaitEntered
            apiRetry.complete(null)
            assertThat(issuerWaitEntered.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(sleeper.waits).hasSize(2)
            assertThat(sleeper.waits.last())
                .isBetween(Duration.ofSeconds(89), Duration.ofSeconds(90))
            assertThat(transport.issuerCalls).isEqualTo(2)
            assertThat(original.isDone).isFalse()
            // Reusing the same public options must not impose this request's minimum on a new call.
            sdk.async().models().retrieve("synthetic-model", sharedOptions).join()
            assertThat(transport.issuerCalls).isEqualTo(3)
            original.cancel(true)
            assertThat(sleeper.pending!!.isCancelled).isTrue()
        } finally {
            sdk.close()
        }
    }

    @Test
    fun backgroundMinimumPreservesGrammarTerminalErrorsAndCachedBearerUse() {
        data class Case(
            val headers: Map<String, String>,
            val minimum: Duration? = null,
            val terminal: Boolean = false,
            val cached: Boolean = false,
        )
        for (case in
            listOf(
                Case(mapOf("Retry-After" to "90"), Duration.ofSeconds(90)),
                Case(
                    mapOf("Retry-After-Ms" to "90000.25", "Retry-After" to "180"),
                    Duration.ofMillis(90000).plusNanos(250000),
                ),
                Case(
                    mapOf("Retry-After" to "Fri, 04 Sep 2026 00:01:30 GMT"),
                    Duration.ofSeconds(90),
                ),
                Case(mapOf("Retry-After" to "invalid")),
                Case(emptyMap()),
                Case(mapOf("Retry-After" to "1e999"), terminal = true),
                Case(mapOf("Retry-After" to "90", "X-Should-Retry" to "false"), terminal = true),
                Case(mapOf("Retry-After" to "90"), cached = true),
            )) {
            val headers =
                Headers.builder()
                    .apply { case.headers.forEach { (key, value) -> put(key, value) } }
                    .build()
            val transport = BackgroundTransport(headers, mapOf(2 to if (case.cached) 500 else 401))
            val sleeper = RecordingSleeper()
            val sdk = client(transport, sleeper)
            try {
                sdk.async().models().retrieve("synthetic-model").join()
                val result = sdk.async().models().retrieve("synthetic-model")
                if (case.terminal) {
                    val error =
                        try {
                            result.join()
                            error("Expected original issuer failure")
                        } catch (error: CompletionException) {
                            error.cause
                        }
                    assertThat(error)
                        .isInstanceOf(InternalServerException::class.java)
                        .hasMessage("503: temporarily_unavailable")
                    assertThat((error as InternalServerException).headers().values("Retry-After"))
                        .containsExactly(case.headers.getValue("Retry-After"))
                } else {
                    assertThat(result.join().id()).isEqualTo("synthetic-model")
                }
                assertThat(transport.closedFailures).isEqualTo(1)
                assertThat(transport.issuerCalls)
                    .isEqualTo(if (case.terminal || case.cached) 2 else 3)
                assertThat(sleeper.waits).hasSize(if (case.minimum == null) 1 else 2)
                case.minimum?.let { minimum ->
                    assertThat(sleeper.waits.last()).isBetween(minimum.minusSeconds(1), minimum)
                }
            } finally {
                sdk.close()
            }
        }
    }

    @ParameterizedTest
    @CsvSource(
        "false, delay",
        "true, delay",
        "false, cancel",
        "true, cancel",
        "false, absent",
        "true, absent",
        "false, malformed",
        "true, malformed",
        "false, no-retry",
        "true, no-retry",
        "false, no-retry-malformed",
        "true, no-retry-malformed",
    )
    fun backgroundFailureTimingPreservesRequestOutcome(pendingAtAttachment: Boolean, mode: String) {
        val terminal = mode.startsWith("no-retry")
        val delayed = mode == "delay" || mode == "cancel"
        val headers = buildMap {
            if (delayed) put("Retry-After", "90")
            if (mode.endsWith("malformed")) put("Retry-After", "invalid")
            if (terminal) put("X-Should-Retry", "false")
        }
        val delegate =
            BackgroundTransport(
                Headers.builder()
                    .apply { headers.forEach { (name, value) -> put(name, value) } }
                    .build()
            )
        val background = CompletableFuture<HttpResponse>()
        var failedResponse: HttpResponse? = null
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("Unexpected synchronous request")

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> {
                    val response = delegate.execute(request, requestOptions)
                    return if (
                        request.baseUrl.contains("auth.openai.com") && delegate.issuerCalls == 2
                    ) {
                        failedResponse = response
                        background
                    } else CompletableFuture.completedFuture(response)
                }

                override fun close() = delegate.close()
            }
        val sleeper = RecordingSleeper()
        val options = clientOptions(transport, sleeper)
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl(options.baseUrl())
                .addPathSegments("models", "synthetic-model")
                .build()
        try {
            options.httpClient.executeAsync(request, RequestOptions.none()).join().close()
            val apiBackoff = CompletableFuture<Void>()
            sleeper.pending = apiBackoff
            val result = options.httpClient.executeAsync(request, RequestOptions.none())
            assertThat(sleeper.waits).hasSize(1)
            assertThat(delegate.issuerCalls).isEqualTo(2)
            val minimumWait = CompletableFuture<Void>()
            sleeper.pending = minimumWait
            if (!pendingAtAttachment) background.complete(checkNotNull(failedResponse))
            // HTTP retries attach synchronously when this controlled API backoff completes.
            apiBackoff.complete(null)
            if (pendingAtAttachment) {
                assertThat(result.isDone).isFalse()
                background.complete(checkNotNull(failedResponse))
            }
            if (delayed) {
                assertThat(sleeper.waits).hasSize(2)
                assertThat(sleeper.waits.last())
                    .isBetween(Duration.ofSeconds(89), Duration.ofSeconds(90))
                assertThat(delegate.issuerCalls).isEqualTo(2)
                if (mode == "cancel") {
                    assertThat(result.cancel(true)).isTrue()
                    assertThat(minimumWait.isCancelled).isTrue()
                } else minimumWait.complete(null)
            }
            if (terminal) {
                val failure =
                    org.junit.jupiter.api.assertThrows<CompletionException> { result.join() }.cause
                assertThat(failure)
                    .isInstanceOf(InternalServerException::class.java)
                    .hasMessage("503: temporarily_unavailable")
                assertThat((failure as InternalServerException).headers().values("X-Should-Retry"))
                    .containsExactly("false")
            } else if (mode != "cancel") {
                result.join().use { assertThat(it.statusCode()).isEqualTo(200) }
            }
            assertThat(delegate.closedFailures).isEqualTo(1)
            assertThat(delegate.issuerCalls).isEqualTo(if (terminal || mode == "cancel") 2 else 3)
            assertThat(delegate.apiCalls).isEqualTo(if (terminal || mode == "cancel") 2 else 3)
            assertThat(sleeper.waits).hasSize(if (delayed) 2 else 1)
        } finally {
            background.cancel(true)
            sleeper.pending?.cancel(true)
            options.httpClient.close()
        }
    }

    @Test
    fun synchronousWaitersShareTheFailedIssuerGeneration() {
        val issuerStarted = CountDownLatch(1)
        val releaseIssuer = CountDownLatch(1)
        val issuerCalls = AtomicInteger()
        val closedResponses = AtomicInteger()
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse {
                    check(request.baseUrl.contains("auth.openai.com"))
                    if (issuerCalls.incrementAndGet() == 1) {
                        issuerStarted.countDown()
                        check(releaseIssuer.await(5, TimeUnit.SECONDS))
                    }
                    return object : HttpResponse {
                        override fun statusCode() = 503

                        override fun headers() = Headers.builder().put("Retry-After", "90").build()

                        override fun body() =
                            """{"error":"temporarily_unavailable"}""".byteInputStream()

                        override fun close() {
                            closedResponses.incrementAndGet()
                        }
                    }
                }

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> = error("sync only")

                override fun close() {}
            }
        val sdk = client(transport, RecordingSleeper(), retries = 0)
        val first = CompletableFuture<Throwable>()
        val second = CompletableFuture<Throwable>()
        fun caller(result: CompletableFuture<Throwable>) = Thread {
            try {
                sdk.models().retrieve("synthetic-model")
                result.completeExceptionally(AssertionError("Expected issuer failure"))
            } catch (error: Throwable) {
                result.complete(error)
            }
        }
        val leader = caller(first)
        val waiter = caller(second)
        try {
            leader.start()
            assertThat(issuerStarted.await(5, TimeUnit.SECONDS)).isTrue()
            waiter.start()
            val waitDeadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(5)
            while (waiter.state != Thread.State.WAITING && System.nanoTime() < waitDeadline) {
                Thread.yield()
            }
            assertThat(waiter.state).isEqualTo(Thread.State.WAITING)
            releaseIssuer.countDown()
            val failure = first.get(5, TimeUnit.SECONDS)
            assertThat(failure).isInstanceOf(InternalServerException::class.java)
            assertThat(second.get(5, TimeUnit.SECONDS)).isSameAs(failure)
            assertThat(issuerCalls.get()).isEqualTo(1)
            assertThat(closedResponses.get()).isEqualTo(1)
            // A later request owns a new generation rather than inheriting a global cooldown.
            org.junit.jupiter.api.assertThrows<InternalServerException> {
                sdk.models().retrieve("synthetic-model")
            }
            assertThat(issuerCalls.get()).isEqualTo(2)
        } finally {
            releaseIssuer.countDown()
            leader.join(5000)
            waiter.join(5000)
            sdk.close()
        }
    }

    @Test
    fun cancellingPublicFutureStopsTokenRefreshRetry() {
        val transport = Transport(Headers.builder().put("Retry-After", "90").build())
        val sleeper = RecordingSleeper().apply { pending = CompletableFuture() }
        val stopped = CountDownLatch(1)
        sleeper.pending!!.whenComplete { _, _ -> stopped.countDown() }
        val sdk = client(transport, sleeper)
        try {
            val result = sdk.async().models().retrieve("synthetic-model")
            assertThat(sleeper.entered.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(result.cancel(true)).isTrue()
            assertThat(stopped.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(sleeper.pending!!.isCancelled).isTrue()
            sleeper.pending!!.complete(null)
            assertThat(transport.issuerCalls).isEqualTo(1)
            assertThat(transport.apiCalls).isEqualTo(1)
        } finally {
            sdk.close()
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun expiredTokenRetainsOnlyFirstRetryControlValues(async: Boolean) {
        val headers =
            Headers.builder()
                .put("Retry-After", listOf("90", "1"))
                .put("Retry-After-Ms", listOf("90000", "1"))
                .put("X-Should-Retry", listOf("false", "true"))
                .put("Authorization", "synthetic-private-authorization")
                .put("Set-Cookie", "synthetic-private-cookie")
                .put("X-Custom", "synthetic-private-custom")
                .build()
        val transport = Transport(headers)
        val sleeper = RecordingSleeper()
        val sdk = client(transport, sleeper, retries = 0)
        try {
            val failure =
                try {
                    if (async) sdk.async().models().retrieve("synthetic-model").join()
                    else sdk.models().retrieve("synthetic-model")
                    error("Expected token rejection")
                } catch (failure: CompletionException) {
                    failure.cause!!
                } catch (failure: OpenAIRetryableException) {
                    failure
                }
            assertThat(failure)
                .isInstanceOf(OpenAIRetryableException::class.java)
                .hasMessage("OAuth token is expired")
            val retained = (failure.cause as WorkloadIdentityRetryHeaders).headers
            assertThat(retained.names())
                .containsExactlyInAnyOrder("Retry-After", "Retry-After-Ms", "X-Should-Retry")
            assertThat(retained.values("Retry-After")).containsExactly("90")
            assertThat(retained.values("Retry-After-Ms")).containsExactly("90000")
            assertThat(retained.values("X-Should-Retry")).containsExactly("false")
            assertThat(transport.apiCalls).isEqualTo(1)
            assertThat(transport.issuerCalls).isEqualTo(1)
            assertThat(transport.closedApiResponses).isEqualTo(1)
            assertThat(sleeper.waits).isEmpty()
        } finally {
            sdk.close()
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun cancellationStopsForegroundTokenExchange(providerPending: Boolean) {
        val dispatched = CountDownLatch(1)
        val stopped = CountDownLatch(1)
        val subject = CompletableFuture<String>()
        val issuer = CompletableFuture<HttpResponse>()
        val active = if (providerPending) subject else issuer
        active.whenComplete { _, _ -> stopped.countDown() }
        val provider =
            object : SubjectTokenProvider {
                override fun tokenType() = SubjectTokenType.JWT

                override fun getToken(httpClient: HttpClient, jsonMapper: JsonMapper): String =
                    error("Unexpected sync provider")

                override fun getTokenAsync(
                    httpClient: HttpClient,
                    jsonMapper: JsonMapper,
                ): CompletableFuture<String> {
                    if (providerPending) {
                        dispatched.countDown()
                        return subject
                    }
                    return CompletableFuture.completedFuture("synthetic-subject")
                }
            }
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("Unexpected sync request")

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> {
                    check(!providerPending)
                    check(request.baseUrl.contains("auth.openai.com"))
                    dispatched.countDown()
                    return issuer
                }

                override fun close() {}
            }
        val sdk = client(transport, RecordingSleeper(), subjectProvider = provider)
        try {
            val result = sdk.async().models().retrieve("synthetic-model")
            assertThat(dispatched.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(result.cancel(true)).isTrue()
            assertThat(stopped.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(active.isCancelled).isTrue()
        } finally {
            sdk.close()
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun cancellingPublicRequestStopsBuiltInMetadataProvider(azure: Boolean) {
        val dispatched = CountDownLatch(1)
        val stopped = CountDownLatch(1)
        val metadata = CompletableFuture<HttpResponse>()
        metadata.whenComplete { _, _ -> stopped.countDown() }
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("Unexpected synchronous request")

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> {
                    assertThat(request.baseUrl)
                        .contains(if (azure) "169.254.169.254" else "metadata.google.internal")
                    dispatched.countDown()
                    return metadata
                }

                override fun close() {}
            }
        val provider =
            if (azure) AzureManagedIdentityTokenProvider.builder().build()
            else GcpIdTokenProvider.builder().build()
        val sdk = client(transport, RecordingSleeper(), subjectProvider = provider)
        try {
            val result = sdk.async().models().retrieve("synthetic-model")
            assertThat(dispatched.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(result.cancel(true)).isTrue()
            assertThat(stopped.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(metadata.isCancelled).isTrue()
        } finally {
            metadata.cancel(true)
            sdk.close()
        }
    }
}
