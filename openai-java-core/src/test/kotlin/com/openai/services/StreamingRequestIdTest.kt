package com.openai.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.client.OpenAIClient
import com.openai.client.OpenAIClientAsync
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.completions.CompletionCreateParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class StreamingRequestIdTest {

    private lateinit var blockingClient: OpenAIClient
    private lateinit var asyncClient: OpenAIClientAsync

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        blockingClient =
            OpenAIOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
        asyncClient =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
    }

    @Test
    fun requestId_isAvailableOnBlockingStream() {
        stubStreamingResponse("req_blocking")

        val response = blockingClient.completions().createStreaming(params())

        response.use {
            assertThat(response.requestId()).contains("req_blocking")
            assertThat(response.stream().count()).isEqualTo(1L)
        }
    }

    @Test
    fun requestId_isAvailableInAsyncHandler() {
        stubStreamingResponse("req_async")
        val response = asyncClient.completions().createStreaming(params())
        val requestIds = mutableListOf<String>()

        response.subscribe { response.requestId().ifPresent(requestIds::add) }
        response.onCompleteFuture().join()

        assertThat(requestIds).containsExactly("req_async")
        assertThat(response.requestId()).contains("req_async")
    }

    @Test
    fun requestId_isAvailableForHttpErrors() {
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400)
                        .withHeader("Content-Type", "application/json")
                        .withHeader("x-request-id", "req_error")
                        .withBody("""{"error":{"message":"bad request"}}""")
                )
        )
        val response = asyncClient.completions().createStreaming(params())
        val requestIds = mutableListOf<String>()
        val assertion =
            response.onCompleteFuture().exceptionally {
                response.requestId().ifPresent(requestIds::add)
                null
            }

        assertion.join()
        assertThat(requestIds).containsExactly("req_error")
    }

    private fun stubStreamingResponse(requestId: String) {
        stubFor(
            post(anyUrl())
                .willReturn(
                    ok()
                        .withHeader("Content-Type", "text/event-stream")
                        .withHeader("x-request-id", requestId)
                        .withBody(
                            "data: {\"id\":\"id\",\"choices\":[],\"created\":0,\"model\":\"model\"}\n\n" +
                                "data: [DONE]\n\n"
                        )
                )
        )
    }

    private fun params(): CompletionCreateParams =
        CompletionCreateParams.builder()
            .model(CompletionCreateParams.Model.GPT_3_5_TURBO_INSTRUCT)
            .prompt("This is a test.")
            .build()
}
