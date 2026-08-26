package com.openai.core

import com.openai.client.OpenAIClientImpl
import com.openai.core.http.AuthenticatedHttpRequest
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpRequestAttemptAuthenticator
import com.openai.core.http.HttpResponse
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.atomic.AtomicInteger
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class X509BlockingResponseLifecycleTest {
    @Test
    fun publicX509VoidResponseClosesAfterSuccessfulTerminalAction() {
        val response = CountingResponse()
        val client = client(response, x509 = true)

        try {
            assertThatCode { client.responses().delete("resp_test") }.doesNotThrowAnyException()
        } finally {
            client.close()
        }

        assertThat(response.closes).hasValue(1)
    }

    @Test
    fun publicOrdinaryVoidResponseKeepsLegacyCallerOwnership() {
        val response = CountingResponse()
        val client = client(response, x509 = false)

        try {
            assertThatCode { client.responses().delete("resp_test") }.doesNotThrowAnyException()
        } finally {
            client.close()
        }

        assertThat(response.closes).hasValue(0)
    }

    @Test
    fun publicX509VoidResponsePropagatesCloseFailure() {
        val failure = IllegalStateException("close failed")
        val response = CountingResponse(failure)
        val client = client(response, x509 = true)

        try {
            assertThatThrownBy { client.responses().delete("resp_test") }.isSameAs(failure)
        } finally {
            client.close()
        }

        assertThat(response.closes).hasValue(1)
    }

    private fun client(response: HttpResponse, x509: Boolean): OpenAIClientImpl {
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
        val options =
            if (x509) {
                val authenticator =
                    object : HttpRequestAttemptAuthenticator {
                        override fun authenticate(
                            request: HttpRequest,
                            timeout: Duration?,
                        ): AuthenticatedHttpRequest = AuthenticatedHttpRequest.create(request) {}
                    }
                ClientOptions.builder()
                    .fixedBearerAuthentication("https://example.test/v1")
                    .maxRetries(0)
                    .buildWithFixedBearerTransport(transport, authenticator)
            } else {
                ClientOptions.builder()
                    .apiKey("test-api-key")
                    .baseUrl("https://example.test/v1")
                    .httpClient(transport)
                    .maxRetries(0)
                    .build()
            }
        return OpenAIClientImpl(options)
    }

    private class CountingResponse(private val closeFailure: Throwable? = null) : HttpResponse {
        val closes = AtomicInteger()

        override fun statusCode(): Int = 204

        override fun headers(): Headers = Headers.builder().build()

        override fun body(): InputStream = ByteArrayInputStream(ByteArray(0))

        override fun close() {
            closes.incrementAndGet()
            closeFailure?.let { throw it }
        }
    }
}
