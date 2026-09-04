package com.openai.core.http

import com.fasterxml.jackson.databind.json.JsonMapper
import com.openai.auth.SubjectTokenProvider
import com.openai.auth.SubjectTokenType
import com.openai.auth.WorkloadIdentity
import com.openai.client.OpenAIClientImpl
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.Sleeper
import com.openai.errors.OpenAIRetryableException
import java.time.Clock
import java.time.Duration
import java.time.Instant
import java.time.ZoneOffset
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
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
                override fun statusCode() = if (issuer) 200 else 401

                override fun headers() = if (issuer) Headers.builder().build() else retryHeaders

                override fun body() =
                    (if (issuer)
                            """{"access_token":"synthetic-issued-token","token_type":"Bearer","issued_token_type":"urn:ietf:params:oauth:token-type:access_token","expires_in":3600}"""
                        else
                            """{"error":{"type":"authentication_error","code":"invalid_api_key","message":"synthetic expired token"}}""")
                        .byteInputStream()

                override fun close() {
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
        val entered = CountDownLatch(1)
        var pending: CompletableFuture<Void>? = null

        override fun sleep(duration: Duration) {
            waits.add(duration)
        }

        override fun sleepAsync(duration: Duration): CompletableFuture<Void> {
            waits.add(duration)
            entered.countDown()
            return pending ?: CompletableFuture.completedFuture(null)
        }

        override fun close() {}
    }

    private fun client(
        transport: Transport,
        sleeper: RecordingSleeper,
        retries: Int = 1,
    ): OpenAIClientImpl {
        val provider =
            object : SubjectTokenProvider {
                override fun tokenType() = SubjectTokenType.JWT

                override fun getToken(httpClient: HttpClient, jsonMapper: JsonMapper) =
                    "synthetic-subject-token"

                override fun getTokenAsync(httpClient: HttpClient, jsonMapper: JsonMapper) =
                    CompletableFuture.completedFuture("synthetic-subject-token")
            }
        return OpenAIClientImpl(
            ClientOptions.builder()
                .baseUrl("https://sdk235.invalid")
                .workloadIdentity(
                    WorkloadIdentity.builder()
                        .identityProviderId("synthetic-idp")
                        .serviceAccountId("synthetic-sa")
                        .provider(provider)
                        .build()
                )
                .httpClient(transport)
                .sleeper(sleeper)
                .maxRetries(retries)
                .clock(Clock.fixed(Instant.parse("2026-09-04T00:00:00Z"), ZoneOffset.UTC))
                .build()
        )
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
                Case(mapOf("Retry-After" to "90", "X-Should-Retry" to "false"), null, 1),
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

    @Test
    fun cancellingPublicFutureStopsTokenRefreshRetry() {
        val transport = Transport(Headers.builder().put("Retry-After", "90").build())
        val sleeper = RecordingSleeper().apply { pending = CompletableFuture() }
        val sdk = client(transport, sleeper)
        try {
            val result = sdk.async().models().retrieve("synthetic-model")
            assertThat(sleeper.entered.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(result.cancel(true)).isTrue()
            assertThat(sleeper.pending!!.isCancelled).isTrue()
            sleeper.pending!!.complete(null)
            assertThat(transport.issuerCalls).isEqualTo(1)
            assertThat(transport.apiCalls).isEqualTo(1)
        } finally {
            sdk.close()
        }
    }
}
