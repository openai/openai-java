package com.openai.client.okhttp

import com.fasterxml.jackson.databind.ObjectMapper
import com.openai.azure.AzureUrlPathMode
import com.openai.client.OpenAIClient
import com.openai.core.http.AsyncStreamResponse
import com.openai.credential.BearerTokenCredential
import com.openai.errors.InvalidResourceIdException
import com.openai.models.chat.completions.ChatCompletionChunk
import com.openai.models.chat.completions.ChatCompletionCreateParams
import com.openai.models.embeddings.EmbeddingCreateParams
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import java.util.function.Supplier
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.assertThrows

internal class AzureRequestPreparationCompatibilityTest {
    @TestFactory
    fun invalidDeploymentIdsAreRejected() =
        listOf(false, true).flatMap { async ->
            listOf("", ".", "..").map { model ->
                dynamicTest("invalid deployment=$model async=$async") {
                    withClient { server, client ->
                        server.enqueue(embeddingResponse())
                        val params = embeddingParams(model)
                        if (async) {
                            val future = client.async().embeddings().create(params)
                            assertInvalidId(future)
                        } else {
                            assertThrows<InvalidResourceIdException> {
                                client.embeddings().create(params)
                            }
                        }
                        assertThat(server.requestCount).isZero()
                    }
                }
            }
        }

    @TestFactory
    fun acceptedDeploymentIdsPreserveLiteralSegmentsAndQuery() =
        listOf(false, true).flatMap { async ->
            listOf("%2e", "%2e%2e", "a/../b").map { model ->
                dynamicTest("literal deployment=$model async=$async") {
                    withClient { server, client ->
                        server.enqueue(embeddingResponse())
                        val params =
                            embeddingParams(model)
                                .toBuilder()
                                .putAdditionalQueryParam("routing", "request")
                                .putAdditionalQueryParam("api-version", "request-version")
                                .build()
                        if (async) {
                            client.async().embeddings().create(params).get(5, TimeUnit.SECONDS)
                        } else {
                            client.embeddings().create(params)
                        }
                        val url = server.takeRequest(5, TimeUnit.SECONDS)!!.requestUrl!!
                        assertThat(url.pathSegments)
                            .containsExactly("prefix", "openai", "deployments", model, "embeddings")
                        assertThat(url.queryParameterNames)
                            .containsExactlyInAnyOrder("routing", "api-version")
                        assertThat(url.queryParameterValues("routing")).containsExactly("request")
                        assertThat(url.queryParameterValues("api-version"))
                            .containsExactly("request-version")
                    }
                }
            }
        }

    @TestFactory
    fun bodyOnlyModelValuesRemainAccepted() =
        listOf(false, true).flatMap { async ->
            listOf(AzureUrlPathMode.AUTO, AzureUrlPathMode.UNIFIED).flatMap { mode ->
                listOf("", ".", "..").map { model ->
                    dynamicTest("body-only model=$model mode=$mode async=$async") {
                        withClient(mode) { server, client ->
                            server.enqueue(embeddingResponse())
                            val params = embeddingParams(model)
                            if (async) {
                                client.async().embeddings().create(params).get(5, TimeUnit.SECONDS)
                            } else {
                                client.embeddings().create(params)
                            }
                            val request = server.takeRequest(5, TimeUnit.SECONDS)!!
                            assertThat(request.path).isEqualTo("/prefix/embeddings")
                            assertThat(
                                    ObjectMapper()
                                        .readTree(request.body.readUtf8())
                                        .path("model")
                                        .asText()
                                )
                                .isEqualTo(model)
                        }
                    }
                }
            }
        }

    @TestFactory
    fun legacyAzureRequestsPreserveCredentialsAndOverrides() =
        listOf(false, true).flatMap { async ->
            listOf(false, true).map { overrideAuthorization ->
                dynamicTest("async=$async request authorization override=$overrideAuthorization") {
                    MockWebServer().use { server ->
                        server.enqueue(embeddingResponse())
                        val client =
                            OpenAIOkHttpClient.builder()
                                .credential(BearerTokenCredential.create(Supplier { "test-token" }))
                                .baseUrl(server.url("/prefix/").toString())
                                .azureUrlPathMode(AzureUrlPathMode.LEGACY)
                                .putHeader("Authorization", "Bearer client-token")
                                .putHeader("X-Override", "client")
                                .putHeader("X-Client-Only", "preserved")
                                .putQueryParam("routing", "client")
                                .putQueryParam("client-only", "preserved")
                                .maxRetries(0)
                                .build()
                        try {
                            val params =
                                embeddingParams("deployment-ok")
                                    .toBuilder()
                                    .putAdditionalHeader("X-Override", "request")
                                    .putAdditionalQueryParam("routing", "request")
                                    .putAdditionalQueryParam("api-version", "request-version")
                                    .apply {
                                        if (overrideAuthorization) {
                                            putAdditionalHeader(
                                                "Authorization",
                                                "Bearer request-token",
                                            )
                                        }
                                    }
                                    .build()
                            if (async) {
                                client.async().embeddings().create(params).get(5, TimeUnit.SECONDS)
                            } else {
                                client.embeddings().create(params)
                            }
                            val request = server.takeRequest(5, TimeUnit.SECONDS)!!
                            assertThat(request.method).isEqualTo("POST")
                            assertThat(request.requestUrl!!.encodedPath)
                                .isEqualTo("/prefix/openai/deployments/deployment-ok/embeddings")
                            assertThat(request.headers.values("Authorization"))
                                .containsExactly(
                                    if (overrideAuthorization) "Bearer request-token"
                                    else "Bearer test-token"
                                )
                            assertThat(request.headers.values("X-Override"))
                                .containsExactly("request")
                            assertThat(request.getHeader("X-Client-Only")).isEqualTo("preserved")
                            assertThat(request.requestUrl!!.queryParameterValues("routing"))
                                .containsExactly("request")
                            assertThat(request.requestUrl!!.queryParameterValues("api-version"))
                                .containsExactly("request-version")
                            assertThat(request.requestUrl!!.queryParameterValues("client-only"))
                                .containsExactly("preserved")
                            assertThat(server.requestCount).isEqualTo(1)
                        } finally {
                            client.close()
                        }
                    }
                }
            }
        }

    @Test
    fun invalidDeploymentRejectsSynchronousStreaming() {
        withClient { server, client ->
            server.enqueue(streamingResponse())
            assertThrows<InvalidResourceIdException> {
                client.chat().completions().createStreaming(streamingParams()).close()
            }
            assertThat(server.requestCount).isZero()
        }
    }

    @TestFactory
    fun failedAsyncStreamRetainsFailureWhenClosed() =
        listOf(false, true).map { closeBeforeObservingFailure ->
            dynamicTest("close before observing stream failure=$closeBeforeObservingFailure") {
                withClient { server, client ->
                    server.enqueue(streamingResponse())
                    val stream =
                        client.async().chat().completions().createStreaming(streamingParams())
                    try {
                        if (closeBeforeObservingFailure) stream.close()
                        assertInvalidId(stream.onCompleteFuture())
                        stream.close()
                        assertInvalidId(stream.onCompleteFuture())
                        assertThat(server.requestCount).isZero()
                    } finally {
                        stream.close()
                    }
                }
            }
        }

    @Test
    fun failedAsyncStreamDeliversTypedFailureToSubscriber() {
        withClient { server, client ->
            server.enqueue(streamingResponse())
            val stream = client.async().chat().completions().createStreaming(streamingParams())
            try {
                val completion = CompletableFuture<Throwable>()
                val chunks = AtomicInteger()
                stream.subscribe(
                    object : AsyncStreamResponse.Handler<ChatCompletionChunk> {
                        override fun onNext(value: ChatCompletionChunk) {
                            chunks.incrementAndGet()
                        }

                        override fun onComplete(error: Optional<Throwable>) {
                            completion.complete(error.orElse(null))
                        }
                    },
                    { it.run() },
                )
                val failure = completion.get(5, TimeUnit.SECONDS)
                assertThat(if (failure is CompletionException) failure.cause else failure)
                    .isInstanceOf(InvalidResourceIdException::class.java)
                assertThat(chunks.get()).isZero()
                stream.close()
                assertInvalidId(stream.onCompleteFuture())
                assertThat(server.requestCount).isZero()
            } finally {
                stream.close()
            }
        }
    }

    private fun withClient(
        mode: AzureUrlPathMode = AzureUrlPathMode.LEGACY,
        block: (MockWebServer, OpenAIClient) -> Unit,
    ) {
        MockWebServer().use { server ->
            val client =
                OpenAIOkHttpClient.builder()
                    .apiKey("test-key")
                    .azureUrlPathMode(mode)
                    .baseUrl(server.url("/prefix/").toString())
                    .maxRetries(0)
                    .build()
            try {
                block(server, client)
            } finally {
                client.close()
            }
        }
    }

    private fun assertInvalidId(future: CompletableFuture<*>) {
        assertThat(assertThrows<ExecutionException> { future.get(5, TimeUnit.SECONDS) }.cause)
            .isInstanceOf(InvalidResourceIdException::class.java)
    }

    private fun embeddingParams(model: String) =
        EmbeddingCreateParams.builder().model(model).input("test input").build()

    private fun embeddingResponse() =
        MockResponse()
            .setHeader("Content-Type", "application/json")
            .setBody(
                """{"data":[],"model":"server-model","object":"list","usage":{"prompt_tokens":1,"total_tokens":1}}"""
            )

    private fun streamingParams() =
        ChatCompletionCreateParams.builder().model(".").addUserMessage("test").build()

    private fun streamingResponse() =
        MockResponse().setHeader("Content-Type", "text/event-stream").setBody("data: [DONE]\n\n")
}
