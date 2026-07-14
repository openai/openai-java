package com.openai.services

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.ChatModel
import com.openai.models.responses.ResponseCreateParams
import com.openai.models.responses.ResponseStreamEvent
import com.openai.services.async.ResponseServiceAsyncImpl
import com.openai.services.blocking.ResponseServiceImpl
import java.io.InputStream
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import java.util.concurrent.Executor
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ResponseStreamEventValidationTest {

    @ParameterizedTest
    @EnumSource(StreamingCall::class)
    fun keepaliveDoesNotBreakValidatedStreams(streamingCall: StreamingCall) {
        val result = consume(streamingCall, responseValidation = true, middleType = "keepalive")

        assertThat(result.error).isNull()
        assertThat(result.events.map(::eventType))
            .containsExactly(
                "response.output_text.delta",
                "keepalive",
                "response.output_text.delta",
            )
        assertThat(result.outputTextDeltas()).containsExactly("before", "after")
    }

    @ParameterizedTest
    @EnumSource(StreamingCall::class)
    fun otherUnknownEventsStillFailValidation(streamingCall: StreamingCall) {
        val result = consume(streamingCall, responseValidation = true, middleType = "future.event")

        assertThat(result.error)
            .isInstanceOf(OpenAIInvalidDataException::class.java)
            .hasMessageContaining("Unknown ResponseStreamEvent")
            .hasMessageContaining("type=future.event")
        assertThat(result.events.map(::eventType)).containsExactly("response.output_text.delta")
        assertThat(result.outputTextDeltas()).containsExactly("before")
    }

    @Test
    fun validationDisabledRetainsExistingUnknownEventBehavior() {
        val result =
            consume(
                StreamingCall.ASYNC_CREATE,
                responseValidation = false,
                middleType = "future.event",
            )

        assertThat(result.error).isNull()
        assertThat(result.events.map(::eventType))
            .containsExactly(
                "response.output_text.delta",
                "future.event",
                "response.output_text.delta",
            )
        assertThat(result.outputTextDeltas()).containsExactly("before", "after")
    }

    private fun consume(
        streamingCall: StreamingCall,
        responseValidation: Boolean,
        middleType: String,
    ): ConsumeResult {
        val clientOptions =
            ClientOptions.builder()
                .httpClient(FakeSseHttpClient(sseBody(middleType)))
                .apiKey("test-api-key")
                .responseValidation(responseValidation)
                .streamHandlerExecutor(Executor(Runnable::run))
                .build()
        val events = mutableListOf<ResponseStreamEvent>()
        var error: Throwable? = null

        try {
            when (streamingCall) {
                StreamingCall.BLOCKING_CREATE ->
                    ResponseServiceImpl(clientOptions).createStreaming(CREATE_PARAMS).use {
                        it.stream().forEach(events::add)
                    }
                StreamingCall.BLOCKING_RETRIEVE ->
                    ResponseServiceImpl(clientOptions).retrieveStreaming("response_id").use {
                        it.stream().forEach(events::add)
                    }
                StreamingCall.ASYNC_CREATE -> {
                    val stream =
                        ResponseServiceAsyncImpl(clientOptions).createStreaming(CREATE_PARAMS)
                    stream.subscribe(events::add)
                    stream.onCompleteFuture().join()
                }
                StreamingCall.ASYNC_RETRIEVE -> {
                    val stream =
                        ResponseServiceAsyncImpl(clientOptions).retrieveStreaming("response_id")
                    stream.subscribe(events::add)
                    stream.onCompleteFuture().join()
                }
            }
        } catch (throwable: Throwable) {
            error = throwable.unwrapCompletionException()
        } finally {
            clientOptions.close()
        }

        return ConsumeResult(events, error)
    }

    private class FakeSseHttpClient(private val body: String) : HttpClient {

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
            response()

        override fun executeAsync(
            request: HttpRequest,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> = CompletableFuture.completedFuture(response())

        override fun close() {}

        private fun response(): HttpResponse =
            object : HttpResponse {
                override fun statusCode(): Int = 200

                override fun headers(): Headers =
                    Headers.builder().put("Content-Type", "text/event-stream").build()

                override fun body(): InputStream = body.byteInputStream()

                override fun close() {}
            }
    }

    private data class ConsumeResult(val events: List<ResponseStreamEvent>, val error: Throwable?) {
        fun outputTextDeltas(): List<String> =
            events.filter { it.isOutputTextDelta() }.map { it.asOutputTextDelta().delta() }
    }

    internal enum class StreamingCall {
        BLOCKING_CREATE,
        BLOCKING_RETRIEVE,
        ASYNC_CREATE,
        ASYNC_RETRIEVE,
    }

    private companion object {
        val CREATE_PARAMS =
            ResponseCreateParams.builder().input("test").model(ChatModel.GPT_4O_MINI).build()

        fun eventType(event: ResponseStreamEvent): String =
            event._json().get().asObject().get().getValue("type").asString().get()

        fun Throwable.unwrapCompletionException(): Throwable =
            if (this is CompletionException && cause != null) cause!! else this

        fun sseBody(middleType: String): String =
            """
            data: {"type":"response.output_text.delta","content_index":0,"delta":"before","item_id":"item_1","logprobs":[],"output_index":0,"sequence_number":1}

            data: {"type":"$middleType","sequence_number":2}

            data: {"type":"response.output_text.delta","content_index":0,"delta":"after","item_id":"item_1","logprobs":[],"output_index":0,"sequence_number":3}

            data: [DONE]

            """
                .trimIndent()
    }
}
