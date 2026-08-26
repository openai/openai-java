package com.openai.core.http

import com.openai.errors.OpenAIIoException
import java.io.OutputStream
import java.time.Duration
import java.util.concurrent.CompletableFuture
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class AuthenticatedRequestBodyLifecycleTest {
    @Test
    fun syncAuthenticationFailureClosesRequestBodyOnce() {
        val failure = IllegalStateException("authentication failed")
        val body = CountingRequestBody()
        val authenticator =
            object : HttpRequestAttemptAuthenticator {
                override fun authenticate(
                    request: HttpRequest,
                    timeout: Duration?,
                ): AuthenticatedHttpRequest = throw failure
            }
        val client = client(ScriptedClient(response(200)), authenticator, maxRetries = 0)

        assertThatThrownBy { client.execute(request(body)) }.isSameAs(failure)
        assertThat(body.closes).isEqualTo(1)
    }

    @Test
    fun cancellingBlockedAuthenticationClosesRequestBodyOnce() {
        val body = CountingRequestBody()
        val authentication = CompletableFuture<AuthenticatedHttpRequest>()
        val authenticator =
            object : HttpRequestAttemptAuthenticator {
                override fun authenticate(
                    request: HttpRequest,
                    timeout: Duration?,
                ): AuthenticatedHttpRequest = error("sync path not expected")

                override fun authenticateAsync(
                    request: HttpRequest,
                    timeout: Duration?,
                ): CompletableFuture<AuthenticatedHttpRequest> = authentication
            }
        val client = client(ScriptedClient(response(200)), authenticator, maxRetries = 0)

        val result = client.executeAsync(request(body))
        result.cancel(true)

        assertThat(authentication.isCancelled).isTrue()
        assertThat(body.closes).isEqualTo(1)
    }

    @Test
    fun closedClientRejectsAndClosesRequestBody() {
        val body = CountingRequestBody()
        val client = client(ScriptedClient(response(200)), CachingAuthenticator(), maxRetries = 0)
        client.close()

        assertThatThrownBy { client.execute(request(body)) }
            .isInstanceOf(OpenAIIoException::class.java)
            .hasMessageContaining("closed")
        assertThat(body.closes).isEqualTo(1)

        val asyncBody = CountingRequestBody()
        assertThatThrownBy { client.executeAsync(request(asyncBody)).join() }
            .hasCauseInstanceOf(OpenAIIoException::class.java)
        assertThat(asyncBody.closes).isEqualTo(1)
    }

    private fun request(body: HttpRequestBody): HttpRequest =
        HttpRequest.builder()
            .method(HttpMethod.POST)
            .baseUrl("https://mtls.api.openai.com/v1")
            .body(body)
            .build()

    private class CountingRequestBody : HttpRequestBody {
        var closes = 0

        override fun writeTo(outputStream: OutputStream) {}

        override fun contentType(): String? = null

        override fun contentLength(): Long = 0

        override fun repeatable(): Boolean = true

        override fun close() {
            closes++
        }
    }
}
