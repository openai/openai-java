package com.openai.core.http

import com.openai.client.OpenAIClientAsyncImpl
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.models.responses.ResponseCreateParams
import java.io.IOException
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class X509AsyncStreamCancellationTest {
    @Test
    fun closeCancelsBlockedTokenExchange() {
        val authentication = CancellationObservedFuture<AuthenticatedHttpRequest>()
        val started = CountDownLatch(1)
        val authenticator =
            object : HttpRequestAttemptAuthenticator {
                override fun authenticate(
                    request: HttpRequest,
                    timeout: Duration?,
                ): AuthenticatedHttpRequest = error("sync path not expected")

                override fun authenticateAsync(
                    request: HttpRequest,
                    timeout: Duration?,
                ): CompletableFuture<AuthenticatedHttpRequest> {
                    started.countDown()
                    return authentication
                }
            }
        val client = fixedClient(NoDispatchClient, authenticator)

        try {
            val stream = client.responses().createStreaming(params())
            assertThat(started.await(5, TimeUnit.SECONDS)).isTrue()

            stream.close()

            assertThat(authentication.cancelled.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(stream.onCompleteFuture().get(5, TimeUnit.SECONDS)).isNull()
        } finally {
            client.close()
        }
    }

    @Test
    fun closeCancelsBlockedApiRequest() {
        val response = CancellationObservedFuture<HttpResponse>()
        val dispatched = CountDownLatch(1)
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
                    return response
                }

                override fun close() {}
            }
        val authenticator = ImmediateAuthenticator()
        val client = fixedClient(transport, authenticator)

        try {
            val stream = client.responses().createStreaming(params())
            assertThat(dispatched.await(5, TimeUnit.SECONDS)).isTrue()

            stream.close()

            assertThat(response.cancelled.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(stream.onCompleteFuture().get(5, TimeUnit.SECONDS)).isNull()
        } finally {
            client.close()
        }
    }

    @Test
    fun ordinaryStreamCloseKeepsLegacyDetachedRequest() {
        val response = CancellationObservedFuture<HttpResponse>()
        val dispatched = CountDownLatch(1)
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
                    return response
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
            val stream = client.responses().createStreaming(params())
            assertThat(dispatched.await(5, TimeUnit.SECONDS)).isTrue()

            stream.close()

            assertThat(response.isCancelled).isFalse()
            assertThat(stream.onCompleteFuture().get(5, TimeUnit.SECONDS)).isNull()
            response.completeExceptionally(IOException("test cleanup"))
        } finally {
            client.close()
        }
    }

    private fun fixedClient(transport: HttpClient, authenticator: HttpRequestAttemptAuthenticator) =
        OpenAIClientAsyncImpl(
            ClientOptions.builder()
                .fixedBearerAuthentication("https://example.test/v1")
                .fixedBearerTransport(transport, authenticator)
                .maxRetries(0)
                .build()
        )

    private fun params() =
        ResponseCreateParams.builder().model("gpt-4o-mini").input("Hello").build()

    private class ImmediateAuthenticator : HttpRequestAttemptAuthenticator {
        override fun authenticate(
            request: HttpRequest,
            timeout: Duration?,
        ): AuthenticatedHttpRequest = AuthenticatedHttpRequest.create(request) {}
    }

    private class CancellationObservedFuture<T> : CompletableFuture<T>() {
        val cancelled = CountDownLatch(1)

        override fun cancel(mayInterruptIfRunning: Boolean): Boolean =
            super.cancel(mayInterruptIfRunning).also { if (it) cancelled.countDown() }
    }

    private object NoDispatchClient : HttpClient {
        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
            error("API request must not be dispatched")

        override fun executeAsync(
            request: HttpRequest,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> = error("API request must not be dispatched")

        override fun close() {}
    }
}
