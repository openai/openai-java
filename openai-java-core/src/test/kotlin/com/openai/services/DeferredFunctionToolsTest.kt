package com.openai.services

import com.fasterxml.jackson.annotation.JsonClassDescription
import com.fasterxml.jackson.databind.JsonNode
import com.openai.client.OpenAIClientImpl
import com.openai.core.ClientOptions
import com.openai.core.JsonSchemaLocalValidation
import com.openai.core.RequestOptions
import com.openai.core.http.*
import com.openai.core.jsonMapper
import com.openai.helpers.ResponseAccumulator
import com.openai.helpers.beta.agents.AgentFunctionTool
import com.openai.models.beta.agents.sessions.SessionCreateParams
import com.openai.models.responses.*
import com.openai.services.blocking.ResponseServiceImpl
import java.io.ByteArrayOutputStream
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class DeferredFunctionToolsTest {
    @JsonClassDescription("Look up a catalog item.") class LookupItem(val itemId: String)

    class Answer(val summary: String)

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun typedToolsKeepDeferredLoadingAndArgumentParsing(streaming: Boolean) {
        for (structured in listOf(false, true)) {
            for (deferred in listOf(null, false, true)) {
                val transport = Transport()
                val options =
                    ClientOptions.builder().apiKey("test-key").httpClient(transport).build()
                try {
                    val service = ResponseServiceImpl(options)
                    val builder =
                        ResponseCreateParams.builder()
                            .model("test-model")
                            .input("Look up A123.")
                            .addTool(ToolSearchTool.builder().build())
                    val customize = Consumer<FunctionTool.Builder> { it.deferLoading(deferred!!) }
                    val accumulator = ResponseAccumulator.create()
                    val response =
                        if (structured) {
                            val typed = builder.text(Answer::class.java)
                            if (deferred == null) typed.addTool(LookupItem::class.java)
                            else
                                typed.addTool(
                                    LookupItem::class.java,
                                    JsonSchemaLocalValidation.YES,
                                    customize,
                                )
                            if (streaming) {
                                service.createStreaming(typed.build()).use {
                                    it.stream().forEach(accumulator::accumulate)
                                }
                                accumulator.response()
                            } else service.create(typed.build()).rawResponse
                        } else {
                            if (deferred == null) builder.addTool(LookupItem::class.java)
                            else builder.addTool(LookupItem::class.java, customize = customize)
                            if (streaming) {
                                service.createStreaming(builder.build()).use {
                                    it.stream().forEach(accumulator::accumulate)
                                }
                                accumulator.response()
                            } else service.create(builder.build())
                        }
                    assertThat(
                            response
                                .output()
                                .single()
                                .asFunctionCall()
                                .arguments(LookupItem::class.java)
                                .itemId
                        )
                        .isEqualTo("A123")
                    val function = transport.body.path("tools")[1]
                    assertThat(function.path("name").asText()).isEqualTo("LookupItem")
                    assertThat(function.path("description").asText())
                        .isEqualTo("Look up a catalog item.")
                    assertThat(function.path("strict").asBoolean()).isTrue()
                    assertThat(function.path("parameters").path("required").map { it.asText() })
                        .containsExactly("itemId")
                    if (deferred == null) assertThat(function.has("defer_loading")).isFalse()
                    else {
                        assertThat(function.has("defer_loading")).isTrue()
                        assertThat(function.path("defer_loading").booleanValue())
                            .isEqualTo(deferred)
                    }
                    assertThat(transport.body.path("stream").asBoolean()).isEqualTo(streaming)
                } finally {
                    options.close()
                }
            }
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun agentRequestsPreserveDeferredDefinitions(asyncHandler: Boolean) {
        val original =
            if (asyncHandler)
                AgentFunctionTool.ofAsync(LookupItem::class.java) {
                    CompletableFuture.completedFuture(it.itemId)
                }
            else AgentFunctionTool.of(LookupItem::class.java) { it.itemId }
        for (deferred in listOf(null, false, true)) {
            val tool = deferred?.let { original.withDeferLoading(it) } ?: original
            val transport = Transport()
            val client =
                OpenAIClientImpl(
                    ClientOptions.builder().apiKey("test-key").httpClient(transport).build()
                )
            try {
                client
                    .beta()
                    .agents()
                    .sessions()
                    .create(
                        SessionCreateParams.builder()
                            .agent(
                                SessionCreateParams.Agent.builder()
                                    .model("test-model")
                                    .addTool(tool.definition())
                                    .build()
                            )
                            .environmentNone()
                            .input("Look up A123.")
                            .build()
                    )
                val definition = transport.body.path("agent").path("tools")[0]
                assertThat(definition.has("defer_loading")).isTrue()
                assertThat(definition.path("defer_loading").booleanValue())
                    .isEqualTo(deferred ?: false)
            } finally {
                client.close()
            }
        }
    }

    private class Transport : HttpClient {
        lateinit var body: JsonNode

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
            val bytes = ByteArrayOutputStream()
            request.body!!.writeTo(bytes)
            body = jsonMapper().readTree(bytes.toByteArray())
            val response =
                if (body.has("agent")) """{"id":"session_test","status":"idle"}"""
                else
                    """{"id":"resp_test","output":[{"type":"function_call","name":"LookupItem","call_id":"call_test","arguments":"{\"itemId\":\"A123\"}"}]}"""
            val streaming = body.path("stream").asBoolean()
            return object : HttpResponse {
                override fun statusCode() = 200

                override fun headers() =
                    Headers.builder()
                        .put(
                            "Content-Type",
                            if (streaming) "text/event-stream" else "application/json",
                        )
                        .build()

                override fun body() =
                    (if (streaming)
                            "data: {\"type\":\"response.completed\",\"response\":$response}\n\n"
                        else response)
                        .byteInputStream()

                override fun close() {}
            }
        }

        override fun executeAsync(request: HttpRequest, requestOptions: RequestOptions) =
            CompletableFuture.completedFuture(execute(request, requestOptions))

        override fun close() {}
    }
}
