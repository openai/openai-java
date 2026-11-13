package com.openai.client.okhttp

import com.openai.core.JsonValue
import com.openai.core.RequestOptions
import com.openai.core.jsonMapper
import com.openai.models.beta.responses.ResponseCompactParams as BetaCompactParams
import com.openai.models.beta.responses.ResponseCreateParams as BetaCreateParams
import com.openai.models.responses.ResponseCompactParams
import com.openai.models.responses.ResponseCreateParams
import java.util.concurrent.TimeUnit
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CompactionReplayTest {
    @Test fun gaHistory() = inspectAndReplayCompactedHistory(beta = false, strict = false)

    @Test fun strictGaHistory() = inspectAndReplayCompactedHistory(beta = false, strict = true)

    @Test fun betaHistory() = inspectAndReplayCompactedHistory(beta = true, strict = false)

    @Test fun strictBetaHistory() = inspectAndReplayCompactedHistory(beta = true, strict = true)

    private fun inspectAndReplayCompactedHistory(beta: Boolean, strict: Boolean) {
        val roles = listOf("user", "system", "developer")
        val inputMessages =
            roles.map { role ->
                """{"id":"msg_$role","type":"message","role":"$role","status":"completed",
                 "content":[{"type":"input_text","text":"from $role","future_part":42}]}"""
            }
        val output =
            (inputMessages +
                    listOf(
                        """{"id":"msg_assistant","type":"message","role":"assistant","status":"completed",
                 "content":[{"type":"output_text","text":"reply","annotations":[]}]}""",
                        """{"id":"cmp_1","type":"compaction","encrypted_content":"opaque","future_field":{"x":1}}""",
                    ))
                .joinToString(prefix = "[", postfix = "]")
        val compacted =
            """{"id":"resp_1","object":"response.compaction","created_at":1,
            "usage":{"input_tokens":5,"output_tokens":1,"total_tokens":6,
                     "input_tokens_details":{"cached_tokens":0,"cache_write_tokens":0},
                     "output_tokens_details":{"reasoning_tokens":0}},"output":$output}"""
        val options = RequestOptions.builder().responseValidation(strict).build()

        MockWebServer().use { server ->
            for (body in listOf(compacted, """{"id":"resp_2","object":"response","output":[]}""")) {
                server.enqueue(
                    MockResponse().addHeader("Content-Type", "application/json").setBody(body)
                )
            }
            val client =
                OpenAIOkHttpClient.builder()
                    .baseUrl(server.url("/v1").toString())
                    .apiKey("test")
                    .build()
            try {
                if (beta) {
                    val service = client.beta().responses()
                    val history =
                        service
                            .compact(BetaCompactParams.builder().model("gpt-4o").build(), options)
                            .outputOrThrow()
                    for ((index, role) in roles.withIndex()) {
                        val message = history[index].asBetaResponseInputMessageItem()
                        assertThat(message.roleOrThrow().asString()).isEqualTo(role)
                        assertThat(message.contentOrThrow().single().asInputText().textOrThrow())
                            .isEqualTo("from $role")
                    }
                    assertThat(
                            history[3]
                                .asBetaResponseOutputMessage()
                                .contentOrThrow()
                                .single()
                                .asOutputText()
                                .textOrThrow()
                        )
                        .isEqualTo("reply")
                    assertThat(history.last().asCompaction().encryptedContentOrThrow())
                        .isEqualTo("opaque")
                    service.create(
                        BetaCreateParams.builder()
                            .model("gpt-4o")
                            .input(JsonValue.from(history))
                            .build()
                    )
                } else {
                    val service = client.responses()
                    val history =
                        service
                            .compact(
                                ResponseCompactParams.builder().model("gpt-4o").build(),
                                options,
                            )
                            .outputOrThrow()
                    for ((index, role) in roles.withIndex()) {
                        val message = history[index].asResponseInputMessageItem()
                        assertThat(message.roleOrThrow().asString()).isEqualTo(role)
                        assertThat(message.contentOrThrow().single().asInputText().textOrThrow())
                            .isEqualTo("from $role")
                    }
                    assertThat(
                            history[3]
                                .asResponseOutputMessage()
                                .contentOrThrow()
                                .single()
                                .asOutputText()
                                .textOrThrow()
                        )
                        .isEqualTo("reply")
                    assertThat(history.last().asCompaction().encryptedContentOrThrow())
                        .isEqualTo("opaque")
                    service.create(
                        ResponseCreateParams.builder()
                            .model("gpt-4o")
                            .input(JsonValue.from(history))
                            .build()
                    )
                }
                val query = if (beta) "?beta=true" else ""
                assertThat(server.takeRequest(1, TimeUnit.SECONDS)?.path)
                    .isEqualTo("/v1/responses/compact$query")
                val replay = checkNotNull(server.takeRequest(1, TimeUnit.SECONDS))
                assertThat(replay.path).isEqualTo("/v1/responses$query")
                val mapper = jsonMapper()
                assertThat(mapper.readTree(replay.body.readUtf8())["input"])
                    .isEqualTo(mapper.readTree(output))
            } finally {
                client.close()
            }
        }
    }
}
