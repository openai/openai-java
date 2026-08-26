package com.openai.core

import com.openai.client.OpenAIClientAsyncImpl
import com.openai.client.OpenAIClientImpl
import com.openai.core.http.CachingAuthenticator
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpRequestBody
import com.openai.core.http.HttpResponse
import com.openai.core.http.response
import com.openai.models.responses.ResponseCreateParams
import java.io.ByteArrayOutputStream
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class X509PublicRequestBodyLifecycleTest {
    @Test
    fun publicSyncAndAsyncRequestsUseFreshAttemptBodiesForRetryAndUnauthorizedReplay() {
        listOf(listOf(500, 400) to 1, listOf(401, 400) to 0).forEach { (statuses, maxRetries) ->
            listOf(false, true).forEach { async ->
                val transport = ClosingBodyClient(statuses)

                if (async) {
                    val client = OpenAIClientAsyncImpl(options(transport, maxRetries))
                    try {
                        val failure =
                            runCatching { client.responses().create(params()).get() }
                                .exceptionOrNull()
                        assertThat(failure).isInstanceOf(ExecutionException::class.java)
                    } finally {
                        client.close()
                    }
                } else {
                    val client = OpenAIClientImpl(options(transport, maxRetries))
                    try {
                        assertThat(runCatching { client.responses().create(params()) }.isFailure)
                            .isTrue()
                    } finally {
                        client.close()
                    }
                }

                assertThat(transport.attemptBodies).hasSize(2)
                assertThat(transport.attemptBodies[0]).isNotSameAs(transport.attemptBodies[1])
                assertThat(transport.payloads).hasSize(2)
                assertThat(transport.payloads[0])
                    .isNotEmpty()
                    .containsExactly(*transport.payloads[1])
            }
        }
    }

    private fun options(transport: HttpClient, maxRetries: Int): ClientOptions =
        ClientOptions.builder()
            .fixedBearerAuthentication("https://example.test/v1")
            .maxRetries(maxRetries)
            .buildWithFixedBearerTransport(transport, CachingAuthenticator())

    private fun params() =
        ResponseCreateParams.builder().model("gpt-4o-mini").input("Hello").build()

    private class ClosingBodyClient(statuses: List<Int>) : HttpClient {
        private val statuses = ArrayDeque(statuses)
        val attemptBodies = mutableListOf<HttpRequestBody>()
        val payloads = mutableListOf<ByteArray>()

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
            val body = requireNotNull(request.body)
            attemptBodies += body
            val output = ByteArrayOutputStream()
            try {
                body.writeTo(output)
                payloads += output.toByteArray()
            } finally {
                body.close()
            }
            return response(statuses.removeFirst())
        }

        override fun executeAsync(
            request: HttpRequest,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> =
            CompletableFuture.completedFuture(execute(request, requestOptions))

        override fun close() = Unit
    }
}
