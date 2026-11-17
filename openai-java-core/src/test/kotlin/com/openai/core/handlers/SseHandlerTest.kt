package com.openai.core.handlers

import com.openai.core.http.Headers
import com.openai.core.http.HttpResponse
import com.openai.core.http.SseMessage
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.errors.SseException
import com.openai.models.ErrorObject
import com.openai.models.beta.agents.AgentSessionEvent
import java.io.IOException
import java.io.InputStream
import java.util.stream.Collectors.toList
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import org.junit.jupiter.params.provider.ValueSource

internal class SseHandlerTest {

    enum class TestCase(
        internal val body: String,
        internal val expectedMessages: List<SseMessage>? = null,
        internal val expectedException: Exception? = null,
    ) {
        DATA_MISSING_EVENT(
            buildString {
                append("data: {\"foo\":true}\n")
                append("\n")
            },
            listOf(sseMessageBuilder().data("{\"foo\":true}").build()),
        ),
        MULTIPLE_DATA_MISSING_EVENT(
            buildString {
                append("data: {\"foo\":true}\n")
                append("\n")
                append("data: {\"bar\":false}\n")
                append("\n")
            },
            listOf(
                sseMessageBuilder().data("{\"foo\":true}").build(),
                sseMessageBuilder().data("{\"bar\":false}").build(),
            ),
        ),
        RETRY_MISSING_DATA(
            buildString {
                append("retry: 10000\n")
                append("\n")
                append("data: {\"foo\":true}\n")
                append("\n")
            },
            listOf(sseMessageBuilder().data("{\"foo\":true}").build()),
        ),
        EVENT_MISSING_DATA(
            buildString {
                append("event: ignored\n")
                append("\n")
                append("data: {\"foo\":true}\n")
                append("\n")
                append("data: {\"bar\":false}\n")
                append("\n")
            },
            listOf(
                sseMessageBuilder().data("{\"foo\":true}").build(),
                sseMessageBuilder().data("{\"bar\":false}").build(),
            ),
        ),
        ID_MISSING_DATA(
            buildString {
                append("id: 1\n")
                append("\n")
                append("data: {\"foo\":true}\n")
                append("\n")
            },
            listOf(sseMessageBuilder().data("{\"foo\":true}").id("1").build()),
        ),
        EMPTY_DATA(
            buildString {
                append("data:\n")
                append("\n")
            },
            listOf(sseMessageBuilder().data("").build()),
        ),
        DATA_JSON_ESCAPED_DOUBLE_NEW_LINE(
            buildString {
                append("data: {\n")
                append("data: \"foo\":\n")
                append("data: true}\n")
                append("\n\n")
            },
            listOf(sseMessageBuilder().data("{\n\"foo\":\ntrue}").build()),
        ),
        MULTIPLE_DATA_LINES(
            buildString {
                append("data: {\n")
                append("data: \"foo\":\n")
                append("data: true}\n")
                append("\n\n")
            },
            listOf(sseMessageBuilder().data("{\n\"foo\":\ntrue}").build()),
        ),
        SPECIAL_NEW_LINE_CHARACTER(
            buildString {
                append("data: {\"content\":\" culpa\"}\n")
                append("\n")
                append("data: {\"content\":\" \u2028\"}\n")
                append("\n")
                append("data: {\"content\":\"foo\"}\n")
                append("\n")
            },
            listOf(
                sseMessageBuilder().data("{\"content\":\" culpa\"}").build(),
                sseMessageBuilder().data("{\"content\":\" \u2028\"}").build(),
                sseMessageBuilder().data("{\"content\":\"foo\"}").build(),
            ),
        ),
        MULTI_BYTE_CHARACTER(
            buildString {
                append("data: {\"content\":\"\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u0438\"}\n")
                append("\n")
            },
            listOf(sseMessageBuilder().data("{\"content\":\"известни\"}").build()),
        ),
        ERROR_PROPERTY(
            buildString {
                append(
                    "data: {\"error\":{\"code\":\"code\",\"message\":\"message\",\"param\":\"param\",\"type\":\"type\"}}\n"
                )
                append("\n")
            },
            expectedException =
                SseException.builder()
                    .statusCode(0)
                    .headers(Headers.builder().build())
                    .error(
                        ErrorObject.builder()
                            .code("code")
                            .message("message")
                            .param("param")
                            .type("type")
                            .build()
                    )
                    .build(),
        ),
    }

    @ParameterizedTest
    @EnumSource
    fun handle(testCase: TestCase) {
        val response = httpResponse(testCase.body)
        var messages: List<SseMessage>? = null
        var exception: Exception? = null

        try {
            messages =
                sseHandler(jsonMapper()).handle(response).use { it.stream().collect(toList()) }
        } catch (e: Exception) {
            exception = e
        }

        if (testCase.expectedMessages != null) {
            assertThat(messages).containsExactlyElementsOf(testCase.expectedMessages)
        }
        if (testCase.expectedException != null) {
            assertThat(exception).isInstanceOf(testCase.expectedException.javaClass)
            assertThat(exception).hasMessage(testCase.expectedException.message)
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `events mode delivers typed errors and continues to the idle event`(named: Boolean) {
        val error =
            """{"type":"error","event_id":"error","session_id":"s","error":{"type":"server_error","message":"Session error."}}"""
        val idle =
            """{"type":"agent.session.idle","event_id":"idle","session":{"id":"s","status":"idle"}}"""
        val body = buildString {
            if (named) append("event: error\n")
            append("data: $error\n\n")
            if (named) append("event: agent.session.idle\n")
            append("data: $idle\n\n")
        }
        val events =
            sseHandler(jsonMapper(), SseErrorDeliveryMode.EVENTS)
                .mapJson<AgentSessionEvent>()
                .handle(httpResponse(body))
                .use { it.stream().collect(toList()) }

        assertThat(events).hasSize(2)
        assertThat(events[0].isError()).isTrue()
        assertThat(events[0].asError().error().message()).isEqualTo("Session error.")
        assertThat(events[1].isIdle()).isTrue()
    }

    @Test
    fun `explicit legacy mode still throws on an error envelope`() {
        assertThat(
                catchThrowable {
                    sseHandler(jsonMapper(), SseErrorDeliveryMode.LEGACY)
                        .handle(httpResponse(TestCase.ERROR_PROPERTY.body))
                        .use { it.stream().collect(toList()) }
                }
            )
            .isInstanceOf(SseException::class.java)
            .hasMessage(TestCase.ERROR_PROPERTY.expectedException!!.message)
    }

    @ParameterizedTest
    @EnumSource(SseErrorDeliveryMode::class)
    fun `delivery mode retains malformed JSON failures`(mode: SseErrorDeliveryMode) {
        assertThat(
                catchThrowable {
                    sseHandler(jsonMapper(), mode)
                        .mapJson<AgentSessionEvent>()
                        .handle(httpResponse("data: {invalid\n\n"))
                        .use { it.stream().collect(toList()) }
                }
            )
            .isInstanceOf(OpenAIInvalidDataException::class.java)
    }

    @ParameterizedTest
    @EnumSource(SseErrorDeliveryMode::class)
    fun `delivery mode retains transport failures`(mode: SseErrorDeliveryMode) {
        val cause = IOException("synthetic disconnect")
        val response =
            object : HttpResponse {
                override fun statusCode(): Int = 200

                override fun headers(): Headers = Headers.builder().build()

                override fun body(): InputStream =
                    object : InputStream() {
                        override fun read(): Int = throw cause
                    }

                override fun close() {}
            }

        assertThat(
                catchThrowable {
                    sseHandler(jsonMapper(), mode).handle(response).use {
                        it.stream().collect(toList())
                    }
                }
            )
            .hasRootCause(cause)
    }

    @ParameterizedTest
    @EnumSource(SseErrorDeliveryMode::class)
    fun `delivery mode retains done boundary`(mode: SseErrorDeliveryMode) {
        val messages =
            sseHandler(jsonMapper(), mode)
                .handle(httpResponse("data: {\"ok\":true}\n\ndata: [DONE]\n\ndata: ignored\n\n"))
                .use { it.stream().collect(toList()) }

        assertThat(messages).hasSize(1)
        assertThat(messages[0].data).isEqualTo("{\"ok\":true}")
    }

    @Test
    fun cannotReuseStream() {
        val response = httpResponse("body")
        val streamResponse = sseHandler(jsonMapper()).handle(response)

        val throwable =
            streamResponse.use {
                it.stream().collect(toList())
                catchThrowable { it.stream().collect(toList()) }
            }

        assertThat(throwable).isInstanceOf(IllegalStateException::class.java)
    }
}

private fun httpResponse(body: String): HttpResponse =
    object : HttpResponse {
        override fun statusCode(): Int = 0

        override fun headers(): Headers = Headers.builder().build()

        override fun body(): InputStream = body.toByteArray().inputStream()

        override fun close() {}
    }

private fun sseMessageBuilder() = SseMessage.builder().jsonMapper(jsonMapper())
