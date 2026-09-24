package com.openai.client.okhttp

import com.openai.helpers.ChatCompletionAccumulator
import com.openai.helpers.ResponseAccumulator
import com.openai.models.chat.completions.ChatCompletionCreateParams
import com.openai.models.responses.Response
import com.openai.models.responses.ResponseCreateParams
import java.util.concurrent.TimeUnit
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Execution(ExecutionMode.SAME_THREAD)
internal class LargePayloadContractTest {
    // High memory use is INTENTIONAL: protect historically supported payloads against
    // new arbitrary body, event, or line caps. 16 MiB + 1 catches new 8/16 MiB caps
    // while staying below Jackson's longstanding 20,000,000-character string limit.
    // Preserve that existing limit; do not shrink this fixture or raise client limits
    // to make new restrictions pass. This is a regression probe, not an API maximum.
    // Generate data in memory and keep these few cases sequential.
    private val payloadSize = 16 * 1024 * 1024 + 1

    @Test
    fun blockingResponsesJsonPreservesLargeOutputText() {
        val text = "x".repeat(payloadSize)
        MockWebServer().use { server ->
            server.enqueue(
                MockResponse()
                    .setHeader("Content-Type", "application/json")
                    .setBody(responseJson(text))
            )
            val client = client(server)
            try {
                assertCompleteText(outputText(client.responses().create(params())), text)
            } finally {
                client.close()
            }
        }
    }

    @Test
    fun streamingResponsesPreservesLargeFinalResponse() {
        val text = "x".repeat(payloadSize)
        val jsonText = "\"$text\""
        MockWebServer().use { server ->
            server.enqueue(
                MockResponse()
                    .setHeader("Content-Type", "text/event-stream")
                    .setBody(
                        "event: response.completed\ndata: " +
                            """{"type":"response.completed","response":${responseJson(jsonText)},"sequence_number":1}""" +
                            "\n\ndata: [DONE]\n\n"
                    )
            )
            val client = client(server)
            try {
                val accumulator = ResponseAccumulator.create()
                client.responses().createStreaming(params()).use { response ->
                    val events = response.stream().iterator()
                    accumulator.accumulate(events.next())
                    assertThat(events.hasNext()).isFalse()
                }
                assertCompleteText(outputText(accumulator.response()), jsonText)
                // Typed output uses a separate mapper; exercise it without another large fixture.
                assertCompleteText(
                    accumulator
                        .response(String::class.java)
                        .output()
                        .single()
                        .asMessage()
                        .content()
                        .single()
                        .outputText()
                        .get(),
                    text,
                )
            } finally {
                client.close()
            }
        }
    }

    @Test
    fun asyncChatStreamPreservesLargeDeltaAndAccumulatedCompletion() {
        val text = "x".repeat(payloadSize)
        MockWebServer().use { server ->
            server.enqueue(
                MockResponse()
                    .setHeader("Content-Type", "text/event-stream")
                    .setBody(
                        "data: " +
                            chatChunk(text, "null") +
                            "\n\n" +
                            "data: " +
                            chatChunk("end", "\"stop\"") +
                            "\n\ndata: [DONE]\n\n"
                    )
            )
            val client =
                OpenAIOkHttpClientAsync.builder()
                    .apiKey("test-key")
                    .baseUrl(server.url("/").toString())
                    .maxRetries(0)
                    .build()
            try {
                val accumulator = ChatCompletionAccumulator.create()
                var chunks = 0
                client
                    .chat()
                    .completions()
                    .createStreaming(
                        ChatCompletionCreateParams.builder()
                            .model("gpt-4o-mini")
                            .addUserMessage("Hello")
                            .build()
                    )
                    .subscribe { chunk ->
                        if (chunks++ == 0) {
                            assertCompleteText(
                                chunk.choices().single().delta().content().get(),
                                text,
                            )
                        }
                        accumulator.accumulate(chunk)
                    }
                    .onCompleteFuture()
                    .get(30, TimeUnit.SECONDS)
                assertThat(chunks).isEqualTo(2)
                assertCompleteText(
                    accumulator.chatCompletion().choices().single().message().content().get(),
                    text + "end",
                )
            } finally {
                client.close()
            }
        }
    }

    private fun client(server: MockWebServer) =
        OpenAIOkHttpClient.builder()
            .apiKey("test-key")
            .baseUrl(server.url("/").toString())
            .maxRetries(0)
            .build()

    private fun params() =
        ResponseCreateParams.builder().model("gpt-4o-mini").input("Hello").build()

    private fun outputText(response: Response) =
        response.output().single().asMessage().content().single().asOutputText().text()

    private fun responseJson(text: String): String {
        val escapedText = text.replace("\"", "\\\"")
        return """{"id":"resp_test","object":"response","status":"completed","created_at":0,"model":"gpt-4o-mini","error":null,"incomplete_details":null,"instructions":null,"metadata":{},"parallel_tool_calls":true,"temperature":1,"tool_choice":"auto","tools":[],"top_p":1,"output":[{"type":"message","id":"msg_test","role":"assistant","status":"completed","content":[{"type":"output_text","text":"$escapedText","annotations":[],"logprobs":[]}]}]}"""
    }

    private fun chatChunk(text: String, finishReason: String) =
        """{"id":"chatcmpl_test","object":"chat.completion.chunk","created":0,"model":"gpt-4o-mini","choices":[{"index":0,"delta":{"role":"assistant","content":"$text"},"finish_reason":$finishReason}]}"""

    private fun assertCompleteText(actual: String, expected: String) {
        // Do not dump tens of MiB into test output on failure.
        assertThat(actual == expected).describedAs("complete large output text").isTrue()
    }
}
