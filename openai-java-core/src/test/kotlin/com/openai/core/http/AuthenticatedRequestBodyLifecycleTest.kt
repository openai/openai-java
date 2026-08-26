package com.openai.core.http

import com.openai.errors.OpenAIIoException
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.time.Duration
import java.util.concurrent.CompletableFuture
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class AuthenticatedRequestBodyLifecycleTest {
    @Test
    fun repeatableBodyRemainsOpenAcrossSyncAndAsyncRetriesAndUnauthorizedReplay() {
        listOf(listOf(500, 200) to 1, listOf(401, 200) to 0).forEach { (statuses, maxRetries) ->
            listOf(false, true).forEach { async ->
                val body = InvalidatingRepeatableBody()
                val transport = ClosingBodyClient(statuses)
                val client = client(transport, CachingAuthenticator(), maxRetries)

                try {
                    if (async) {
                        client.executeAsync(request(body)).get().close()
                    } else {
                        client.execute(request(body)).close()
                    }

                    assertThat(body.writes).isEqualTo(2)
                    assertThat(body.closes).isEqualTo(1)
                    assertThat(transport.attemptBodies).hasSize(2)
                    assertThat(transport.attemptBodies[0])
                        .isNotSameAs(transport.attemptBodies[1])
                        .isNotSameAs(body)
                } finally {
                    client.close()
                }
            }
        }
    }

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

    private class InvalidatingRepeatableBody : HttpRequestBody {
        private var closed = false
        var writes = 0
        var closes = 0

        override fun writeTo(outputStream: OutputStream) {
            check(!closed) { "request body was closed before its final attempt" }
            writes++
            outputStream.write("payload".toByteArray())
        }

        override fun contentType(): String = "text/plain"

        override fun contentLength(): Long = 7

        override fun repeatable(): Boolean = true

        override fun close() {
            closes++
            closed = true
        }
    }

    private class ClosingBodyClient(statuses: List<Int>) : HttpClient {
        private val statuses = ArrayDeque(statuses)
        val attemptBodies = mutableListOf<HttpRequestBody>()

        override fun execute(
            request: HttpRequest,
            requestOptions: com.openai.core.RequestOptions,
        ): HttpResponse {
            val body = requireNotNull(request.body)
            attemptBodies += body
            try {
                body.writeTo(ByteArrayOutputStream())
            } finally {
                body.close()
            }
            return response(statuses.removeFirst())
        }

        override fun executeAsync(
            request: HttpRequest,
            requestOptions: com.openai.core.RequestOptions,
        ): CompletableFuture<HttpResponse> =
            CompletableFuture.completedFuture(execute(request, requestOptions))

        override fun close() {}
    }
}
