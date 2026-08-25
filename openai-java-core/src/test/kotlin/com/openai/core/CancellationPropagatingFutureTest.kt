package com.openai.core

import com.openai.client.OpenAIClientAsyncImpl
import com.openai.client.OpenAIClientImpl
import com.openai.core.http.AuthenticatedHttpRequest
import com.openai.core.http.CloseOncePipelineHttpResponse
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpRequestAttemptAuthenticator
import com.openai.core.http.HttpResponse
import com.openai.errors.BadRequestException
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStream
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicReference
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CancellationPropagatingFutureTest {
    @Test
    fun cancellationBeforeAsyncCallbackClosesCompletedInput() {
        val tasks = ArrayDeque<Runnable>()
        val closes = AtomicInteger()
        val input =
            CloseOncePipelineHttpResponse(
                object : HttpResponse {
                    override fun statusCode(): Int = 200

                    override fun headers(): Headers = Headers.builder().build()

                    override fun body(): InputStream = ByteArrayInputStream(ByteArray(0))

                    override fun close() {
                        closes.incrementAndGet()
                    }
                }
            )
        val source = CancellationPropagatingFuture.completed(input, Executor { tasks.addLast(it) })
        val result = source.thenComposeAsync { CompletableFuture.completedFuture(Unit) }

        assertThat(tasks).hasSize(1)
        assertThat(result.cancel(true)).isTrue()
        tasks.removeFirst().run()

        assertThat(result.isCancelled).isTrue()
        assertThat(closes.get()).isEqualTo(1)
    }

    @Test
    fun failedComposedCancellationObservesAndClosesConcurrentSuccess() {
        val entered = CountDownLatch(1)
        val release = CountDownLatch(1)
        val closed = CountDownLatch(1)
        val closes = AtomicInteger()
        val closeable = AutoCloseable {
            closes.incrementAndGet()
            closed.countDown()
        }
        val completesOnCancel =
            object : CompletableFuture<AutoCloseable>() {
                override fun cancel(mayInterruptIfRunning: Boolean): Boolean {
                    complete(closeable)
                    return false
                }
            }
        val result =
            CancellationPropagatingFuture.completed(Unit).thenComposeAsync {
                entered.countDown()
                release.await(5, TimeUnit.SECONDS)
                completesOnCancel
            }

        assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
        assertThat(result.cancel(true)).isTrue()
        release.countDown()

        assertThat(closed.await(5, TimeUnit.SECONDS)).isTrue()
        assertThat(closes.get()).isEqualTo(1)
    }

    @Test
    fun cancellationClosesComposedValueThatLosesCompletionRace() {
        val entered = CountDownLatch(1)
        val release = CountDownLatch(1)
        val closed = CountDownLatch(1)
        val closes = AtomicInteger()
        val result =
            CancellationPropagatingFuture.completed(Unit).thenComposeAsync {
                entered.countDown()
                release.await(5, TimeUnit.SECONDS)
                CompletableFuture.completedFuture(
                    AutoCloseable {
                        closes.incrementAndGet()
                        closed.countDown()
                    }
                )
            }

        assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
        result.cancel(true)
        release.countDown()

        assertThat(result.isCancelled).isTrue()
        assertThat(closed.await(5, TimeUnit.SECONDS)).isTrue()
        assertThat(closes.get()).isEqualTo(1)
    }

    @Test
    fun cancellationOfVoidDependentCancelsComposedOperation() {
        val entered = CountDownLatch(1)
        val composed = CompletableFuture<Unit>()
        val result =
            CancellationPropagatingFuture.completed(Unit)
                .thenComposeAsync {
                    entered.countDown()
                    composed
                }
                .thenAccept {}

        assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
        result.cancel(true)

        assertThat(result.isCancelled).isTrue()
        assertThat(composed.isCancelled).isTrue()
    }

    @Test
    fun cancellationClosesInputWhileMapperIsRunning() {
        val entered = CountDownLatch(1)
        val closed = CountDownLatch(1)
        val finished = CountDownLatch(1)
        val closes = AtomicInteger()
        val input =
            CloseOncePipelineHttpResponse(
                object : HttpResponse {
                    override fun statusCode(): Int = 200

                    override fun headers(): Headers = Headers.builder().build()

                    override fun body() = ByteArrayInputStream(ByteArray(0))

                    override fun close() {
                        closes.incrementAndGet()
                        closed.countDown()
                    }
                }
            )
        val pending = CompletableFuture<HttpResponse>()
        val source = CancellationPropagatingFuture.completed(Unit).thenComposeAsync { pending }
        val result =
            source.thenApply { response ->
                try {
                    entered.countDown()
                    closed.await(5, TimeUnit.SECONDS)
                } finally {
                    response.close()
                    finished.countDown()
                }
            }

        CompletableFuture.runAsync { pending.complete(input) }
        assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
        result.cancel(true)

        assertThat(result.isCancelled).isTrue()
        assertThat(closed.await(5, TimeUnit.SECONDS)).isTrue()
        assertThat(finished.await(5, TimeUnit.SECONDS)).isTrue()
        assertThat(closes.get()).isEqualTo(1)
    }

    @Test
    fun ordinaryPublicAsyncCancellationKeepsLegacyDetachedTransport() {
        val dispatched = CountDownLatch(1)
        val transportResult = CompletableFuture<HttpResponse>()
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("sync path not expected")

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> {
                    dispatched.countDown()
                    return transportResult
                }

                override fun close() {}
            }
        val client =
            OpenAIClientAsyncImpl(
                ClientOptions.builder()
                    .apiKey("test-api-key")
                    .baseUrl("https://example.test/v1")
                    .httpClient(transport)
                    .maxRetries(0)
                    .build()
            )

        try {
            val result = client.files().list()
            assertThat(dispatched.await(5, TimeUnit.SECONDS)).isTrue()

            assertThat(result.cancel(true)).isTrue()

            assertThat(result.isCancelled).isTrue()
            assertThat(transportResult.isCancelled).isFalse()
            transportResult.completeExceptionally(IOException("test cleanup"))
        } finally {
            client.close()
        }
    }

    @Test
    fun x509PublicAsyncCancellationReachesPendingTransport() {
        val dispatched = CountDownLatch(1)
        val transportResult = CancellationObservedFuture<HttpResponse>()
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("sync path not expected")

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> {
                    dispatched.countDown()
                    return transportResult
                }

                override fun close() {}
            }
        val client = fixedAsyncClient(transport)

        try {
            val result = client.files().list()
            assertThat(dispatched.await(5, TimeUnit.SECONDS)).isTrue()

            assertThat(result.cancel(true)).isTrue()

            assertThat(transportResult.cancelled.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(transportResult.isCancelled).isTrue()
        } finally {
            client.close()
        }
    }

    @Test
    fun x509CancellationClosesLateResponseFromCancelResistantTransportOnce() {
        val dispatched = CountDownLatch(1)
        val closed = CountDownLatch(1)
        val closes = AtomicInteger()
        val transportResult = CancelResistantFuture<HttpResponse>()
        val response =
            object : HttpResponse {
                override fun statusCode(): Int = 200

                override fun headers(): Headers = Headers.builder().build()

                override fun body(): InputStream = ByteArrayInputStream(ByteArray(0))

                override fun close() {
                    closes.incrementAndGet()
                    closed.countDown()
                }
            }
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("sync path not expected")

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> {
                    dispatched.countDown()
                    return transportResult
                }

                override fun close() {}
            }
        val client = fixedAsyncClient(transport)

        try {
            val result = client.files().list()
            assertThat(dispatched.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(result.cancel(true)).isTrue()

            transportResult.complete(response)

            assertThat(closed.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(closes.get()).isEqualTo(1)
        } finally {
            client.close()
        }
        assertThat(closes.get()).isEqualTo(1)
    }

    @Test
    fun publicAsyncClientCancellationClosesResponseAndUnblocksParsing() {
        val readStarted = CountDownLatch(1)
        val readFinished = CountDownLatch(1)
        val releaseRead = CountDownLatch(1)
        val bodyClosed = AtomicBoolean()
        val closes = AtomicInteger()
        val body =
            object : InputStream() {
                override fun read(): Int {
                    readStarted.countDown()
                    try {
                        releaseRead.await(30, TimeUnit.SECONDS)
                        if (bodyClosed.get()) throw IOException("response closed")
                        return -1
                    } finally {
                        readFinished.countDown()
                    }
                }

                override fun close() {
                    bodyClosed.set(true)
                    releaseRead.countDown()
                }
            }
        val response =
            object : HttpResponse {
                override fun statusCode(): Int = 200

                override fun headers(): Headers =
                    Headers.builder().put("Content-Type", "application/json").build()

                override fun body(): InputStream = body

                override fun close() {
                    closes.incrementAndGet()
                    body.close()
                }
            }
        val transportResult = CompletableFuture<HttpResponse>()
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("sync path not expected")

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> = transportResult

                override fun close() {}
            }
        val authenticator =
            object : HttpRequestAttemptAuthenticator {
                override fun authenticate(
                    request: HttpRequest,
                    timeout: Duration?,
                ): AuthenticatedHttpRequest = AuthenticatedHttpRequest.create(request) {}
            }
        val client =
            OpenAIClientAsyncImpl(
                ClientOptions.builder()
                    .fixedBearerAuthentication("https://example.test/v1")
                    .maxRetries(0)
                    .buildWithFixedBearerTransport(transport, authenticator)
            )

        try {
            val result = client.files().list()
            CompletableFuture.runAsync { transportResult.complete(response) }
            assertThat(readStarted.await(5, TimeUnit.SECONDS)).isTrue()

            assertThat(result.cancel(true)).isTrue()

            assertThat(result.isCancelled).isTrue()
            assertThat(readFinished.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(closes.get()).isEqualTo(1)
        } finally {
            client.close()
        }
    }

    @Test
    fun publicBlockingX509ErrorResponseIsClosedOnce() {
        val closes = AtomicInteger()
        val response =
            object : HttpResponse {
                override fun statusCode(): Int = 400

                override fun headers(): Headers =
                    Headers.builder().put("Content-Type", "application/json").build()

                override fun body(): InputStream =
                    ByteArrayInputStream(
                        """{"error":{"message":"test error","type":"invalid_request_error"}}"""
                            .toByteArray()
                    )

                override fun close() {
                    closes.incrementAndGet()
                }
            }
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = response

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> = error("async path not expected")

                override fun close() {}
            }
        val authenticator =
            object : HttpRequestAttemptAuthenticator {
                override fun authenticate(
                    request: HttpRequest,
                    timeout: Duration?,
                ): AuthenticatedHttpRequest = AuthenticatedHttpRequest.create(request) {}
            }
        val client =
            OpenAIClientImpl(
                ClientOptions.builder()
                    .fixedBearerAuthentication("https://example.test/v1")
                    .maxRetries(0)
                    .buildWithFixedBearerTransport(transport, authenticator)
            )

        try {
            assertThrows<BadRequestException> { client.files().list() }
        } finally {
            client.close()
        }
        assertThat(closes.get()).isEqualTo(1)
    }

    @Test
    fun publicX509ErrorResponseIsClosedWhenRawResponseMappingThrows() {
        val closes = AtomicInteger()
        val response =
            object : HttpResponse {
                override fun statusCode(): Int = 400

                override fun headers(): Headers =
                    Headers.builder().put("Content-Type", "application/json").build()

                override fun body(): InputStream =
                    ByteArrayInputStream(
                        """{"error":{"message":"test error","type":"invalid_request_error"}}"""
                            .toByteArray()
                    )

                override fun close() {
                    closes.incrementAndGet()
                }
            }
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("sync path not expected")

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> = CompletableFuture.completedFuture(response)

                override fun close() {}
            }
        val authenticator =
            object : HttpRequestAttemptAuthenticator {
                override fun authenticate(
                    request: HttpRequest,
                    timeout: Duration?,
                ): AuthenticatedHttpRequest = AuthenticatedHttpRequest.create(request) {}
            }
        val client =
            OpenAIClientAsyncImpl(
                ClientOptions.builder()
                    .fixedBearerAuthentication("https://example.test/v1")
                    .maxRetries(0)
                    .buildWithFixedBearerTransport(transport, authenticator)
            )

        try {
            val result = client.files().list()
            assertThrows<ExecutionException> { result.get(5, TimeUnit.SECONDS) }
        } finally {
            client.close()
        }
        assertThat(closes.get()).isEqualTo(1)
    }

    @Test
    fun publicOrdinaryVoidResponseKeepsLegacyCallerOwnership() {
        val closes = AtomicInteger()
        val response =
            object : HttpResponse {
                override fun statusCode(): Int = 204

                override fun headers(): Headers = Headers.builder().build()

                override fun body(): InputStream = ByteArrayInputStream(ByteArray(0))

                override fun close() {
                    closes.incrementAndGet()
                }
            }
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("sync path not expected")

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> = CompletableFuture.completedFuture(response)

                override fun close() {}
            }
        val client =
            OpenAIClientAsyncImpl(
                ClientOptions.builder()
                    .apiKey("test-api-key")
                    .baseUrl("https://example.test/v1")
                    .httpClient(transport)
                    .maxRetries(0)
                    .build()
            )

        try {
            assertThat(client.responses().delete("resp_test").get(5, TimeUnit.SECONDS)).isNull()
        } finally {
            client.close()
        }
        assertThat(closes.get()).isZero()
    }

    @Test
    fun publicX509VoidResponseIsClosedAfterSuccessfulTerminalAction() {
        val closes = AtomicInteger()
        val response =
            object : HttpResponse {
                override fun statusCode(): Int = 204

                override fun headers(): Headers = Headers.builder().build()

                override fun body(): InputStream = ByteArrayInputStream(ByteArray(0))

                override fun close() {
                    closes.incrementAndGet()
                }
            }
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("sync path not expected")

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> = CompletableFuture.completedFuture(response)

                override fun close() {}
            }
        val authenticator =
            object : HttpRequestAttemptAuthenticator {
                override fun authenticate(
                    request: HttpRequest,
                    timeout: Duration?,
                ): AuthenticatedHttpRequest = AuthenticatedHttpRequest.create(request) {}
            }
        val client =
            OpenAIClientAsyncImpl(
                ClientOptions.builder()
                    .fixedBearerAuthentication("https://example.test/v1")
                    .maxRetries(0)
                    .buildWithFixedBearerTransport(transport, authenticator)
            )

        try {
            assertThat(client.responses().delete("resp_test").get(5, TimeUnit.SECONDS)).isNull()
        } finally {
            client.close()
        }
        assertThat(closes.get()).isEqualTo(1)
    }

    @Test
    fun publicX509RawResponseRemainsCallerOwnedAcrossDependentContinuations() {
        val closes = AtomicInteger()
        val body = ByteArrayInputStream("""{"object":"list","data":[]}""".toByteArray())
        val response =
            object : HttpResponse {
                override fun statusCode(): Int = 200

                override fun headers(): Headers =
                    Headers.builder().put("Content-Type", "application/json").build()

                override fun body(): InputStream = body

                override fun close() {
                    closes.incrementAndGet()
                }
            }
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("sync path not expected")

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> = CompletableFuture.completedFuture(response)

                override fun close() {}
            }
        val authenticator =
            object : HttpRequestAttemptAuthenticator {
                override fun authenticate(
                    request: HttpRequest,
                    timeout: Duration?,
                ): AuthenticatedHttpRequest = AuthenticatedHttpRequest.create(request) {}
            }
        val client =
            OpenAIClientAsyncImpl(
                ClientOptions.builder()
                    .fixedBearerAuthentication("https://example.test/v1")
                    .maxRetries(0)
                    .buildWithFixedBearerTransport(transport, authenticator)
            )

        try {
            val raw = client.files().withRawResponse().list()
            val saved = AtomicReference<HttpResponse>()
            raw.thenAccept { saved.set(it) }.get(5, TimeUnit.SECONDS)
            val failed = raw.thenApply<Unit> { throw IllegalStateException("dependent failed") }
            val failedComposed =
                raw.thenComposeAsync<Unit> {
                    throw IllegalStateException("composed dependent failed")
                }

            assertThrows<ExecutionException> { failed.get(5, TimeUnit.SECONDS) }
            assertThrows<ExecutionException> { failedComposed.get(5, TimeUnit.SECONDS) }
            assertThat(closes.get()).isZero()
            assertThat(saved.get().body().read()).isNotEqualTo(-1)
            saved.get().close()
            assertThat(closes.get()).isEqualTo(1)
        } finally {
            client.close()
        }
        assertThat(closes.get()).isEqualTo(1)
    }

    private fun fixedAsyncClient(transport: HttpClient): OpenAIClientAsyncImpl {
        val authenticator =
            object : HttpRequestAttemptAuthenticator {
                override fun authenticate(
                    request: HttpRequest,
                    timeout: Duration?,
                ): AuthenticatedHttpRequest = AuthenticatedHttpRequest.create(request) {}
            }
        return OpenAIClientAsyncImpl(
            ClientOptions.builder()
                .fixedBearerAuthentication("https://example.test/v1")
                .maxRetries(0)
                .buildWithFixedBearerTransport(transport, authenticator)
        )
    }

    private class CancelResistantFuture<T> : CompletableFuture<T>() {
        override fun cancel(mayInterruptIfRunning: Boolean): Boolean = false
    }

    private class CancellationObservedFuture<T> : CompletableFuture<T>() {
        val cancelled = CountDownLatch(1)

        override fun cancel(mayInterruptIfRunning: Boolean): Boolean =
            super.cancel(mayInterruptIfRunning).also { if (it) cancelled.countDown() }
    }
}
