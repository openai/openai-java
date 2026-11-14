package com.openai.responses.okhttp

import java.util.concurrent.TimeUnit
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.jupiter.api.Test

internal class OpenAIResponsesOkHttpClientTest {
    @Test
    fun responsesRequestUsesBorrowedTransportAndConfiguredHeaders() {
        val native = OkHttpClient.Builder().readTimeout(7, TimeUnit.SECONDS).build()
        try {
            OpenAIResponsesOkHttpClient.builder()
                .apiKey("test-key")
                .baseUrl("https://example.invalid/v1")
                .okHttpClient(native)
                .putHeader("X-Test", "responses")
                .addInterceptor { chain ->
                    val request = chain.request()
                    assertEquals("/v1/responses/input_tokens", request.url.encodedPath)
                    assertEquals("responses", request.header("X-Test"))
                    assertEquals(7000, chain.readTimeoutMillis())
                    Response.Builder()
                        .request(request)
                        .protocol(Protocol.HTTP_1_1)
                        .code(200)
                        .message("OK")
                        .body(
                            """{"object":"response.input_tokens","input_tokens":13}"""
                                .toResponseBody()
                        )
                        .build()
                }
                .build()
                .use { client ->
                    assertEquals(13L, client.responses().inputTokens().count().inputTokensOrThrow())
                }

            assertFalse(native.dispatcher.executorService.isShutdown)
        } finally {
            native.connectionPool.evictAll()
            native.dispatcher.executorService.shutdown()
        }
    }
}
