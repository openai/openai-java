package com.openai.client.okhttp

import java.util.concurrent.TimeUnit
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseSvgReasoningTest {
    @Test
    fun readsImageToolSvgReasoning() {
        MockWebServer().use { server ->
            val client =
                OpenAIOkHttpClient.builder()
                    .apiKey("test-key")
                    .baseUrl(server.url("/v1/").toString())
                    .maxRetries(0)
                    .build()
            try {
                for ((svg, expected) in
                    listOf(
                        """{"reasoning":{"effort":"high"}}""" to "high",
                        """{"reasoning":null}""" to null,
                        "{}" to null,
                    )) {
                    server.enqueue(
                        MockResponse()
                            .setHeader("Content-Type", "application/json")
                            .setBody("""{"tools":[{"type":"image_generation","svg":$svg}]}""")
                    )
                    val response = client.responses().retrieve("resp_fixture")
                    val reasoning =
                        response.tools().single().asImageGeneration().svg().get().reasoning()
                    val effort = reasoning.flatMap { it.effort() }.map { it.asString() }
                    assertThat(effort.orElse(null)).isEqualTo(expected)
                    assertThat(server.takeRequest(1, TimeUnit.SECONDS)?.path)
                        .isEqualTo("/v1/responses/resp_fixture")
                }
            } finally {
                client.close()
            }
        }
    }
}
