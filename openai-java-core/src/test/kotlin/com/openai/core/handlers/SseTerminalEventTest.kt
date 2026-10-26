package com.openai.core.handlers

import com.openai.client.OpenAIClientImpl
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.AsyncStreamResponse
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.models.ChatModel
import com.openai.models.responses.ResponseCreateParams
import com.openai.models.responses.ResponseStreamEvent
import java.io.InputStream
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class SseTerminalEventTest {
    @ParameterizedTest
    @CsvSource("false, false", "true, false", "false, true", "true, true")
    fun closesWithoutReadingPastDone(async: Boolean, raw: Boolean) {
        val prefix =
            ("data: {\"type\":\"response.output_text.delta\",\"content_index\":0," +
                    "\"delta\":\"accepted\",\"item_id\":\"item_1\",\"logprobs\":[]," +
                    "\"output_index\":0,\"sequence_number\":1}\n\ndata: [DONE]\n\n")
                .toByteArray()
        var offset = 0
        var closeCount = 0
        val input =
            object : InputStream() {
                override fun read(): Int = error("Unexpected single-byte read")

                override fun read(bytes: ByteArray, start: Int, length: Int): Int {
                    check(offset < prefix.size) { "Read after terminal event" }
                    val count = minOf(length, prefix.size - offset)
                    prefix.copyInto(bytes, start, offset, offset + count)
                    offset += count
                    return count
                }
            }
        val response =
            object : HttpResponse {
                override fun statusCode() = 200

                override fun headers() =
                    Headers.builder().put("Content-Type", "text/event-stream").build()

                override fun body(): InputStream = input

                override fun close() {
                    closeCount++
                    check(closeCount == 1) { "Response closed more than once" }
                    input.close()
                }
            }
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = response

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> = CompletableFuture.completedFuture(response)

                override fun close() {}
            }
        val client =
            OpenAIClientImpl(
                ClientOptions.builder()
                    .httpClient(transport)
                    .apiKey("test-api-key")
                    .streamHandlerExecutor(Executor(Runnable::run))
                    .build()
            )
        val params =
            ResponseCreateParams.builder().input("test").model(ChatModel.GPT_4O_MINI).build()
        val events = mutableListOf<ResponseStreamEvent>()
        try {
            if (raw) {
                val response =
                    if (async) {
                        client
                            .async()
                            .responses()
                            .withRawResponse()
                            .createStreaming(params)
                            .get(5, TimeUnit.SECONDS)
                    } else {
                        client.responses().withRawResponse().createStreaming(params)
                    }
                response.use {
                    it.parse().stream().forEach(events::add)
                    assertThat(closeCount).isEqualTo(1)
                }
            } else if (async) {
                var completed = false
                val stream = client.async().responses().createStreaming(params)
                stream.subscribe(
                    object : AsyncStreamResponse.Handler<ResponseStreamEvent> {
                        override fun onNext(value: ResponseStreamEvent) {
                            events.add(value)
                        }

                        override fun onComplete(error: Optional<Throwable>) {
                            assertThat(error).isEmpty()
                            assertThat(closeCount).isEqualTo(1)
                            completed = true
                        }
                    }
                )
                stream.onCompleteFuture().get(5, TimeUnit.SECONDS)
                assertThat(completed).isTrue()
            } else {
                client.responses().createStreaming(params).use {
                    it.stream().forEach(events::add)
                    assertThat(closeCount).isEqualTo(1)
                }
            }
            assertThat(closeCount).isEqualTo(1)
            assertThat(events.map { it.asOutputTextDelta().delta() }).containsExactly("accepted")
        } finally {
            client.close()
        }
    }
}
