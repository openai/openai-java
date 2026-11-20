package com.openai.core.handlers

import com.openai.core.http.Headers
import com.openai.core.http.HttpResponse
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIServiceException
import com.openai.errors.SseException
import java.io.InputStream
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class RequestIdTest {
    private class Response(
        private val status: Int,
        private val responseHeaders: Headers,
        body: String,
    ) : HttpResponse {
        private val input = body.byteInputStream()
        var closed = false

        override fun statusCode(): Int = status

        override fun headers(): Headers = responseHeaders

        override fun body(): InputStream = input

        override fun close() {
            closed = true
            input.close()
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [400, 401, 403, 404, 422, 429, 500, 503, 418])
    fun httpErrorsRetainServerRequestId(status: Int) {
        val response =
            Response(
                status,
                Headers.builder()
                    .put("X-Request-ID", "req_server")
                    .put("X-Client-Request-Id", "client_id")
                    .build(),
                """{"error":{"message":"Synthetic failure","type":"test_error"}}""",
            )
        val error = catchThrowable { errorHandler(errorBodyHandler(jsonMapper())).handle(response) }
        assertThat(error).isInstanceOf(OpenAIServiceException::class.java)
        val serviceError = error as OpenAIServiceException
        assertThat(serviceError.requestId()).contains("req_server")
        assertThat(serviceError.requestId()).isEqualTo(response.requestId())
        assertThat(serviceError.statusCode()).isEqualTo(status)
        assertThat(serviceError.message).contains("Synthetic failure")
        assertThat(response.closed).isTrue()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun sseErrorUsesHttpRequestIdRatherThanEventId(hasHeader: Boolean) {
        val headers = Headers.builder().put("X-Client-Request-Id", "client_id")
        if (hasHeader) headers.put("x-request-id", "req_stream")
        val response =
            Response(
                200,
                headers.build(),
                "id: event_id\nevent: error\ndata: {\"error\":{\"message\":\"Stream failed\",\"type\":\"test_error\"}}\n\n",
            )
        val error = catchThrowable {
            sseHandler(jsonMapper()).handle(response).use { it.stream().forEach {} }
        }
        assertThat(error).isInstanceOf(SseException::class.java)
        assertThat((error as SseException).requestId()).isEqualTo(response.requestId())
        if (hasHeader) assertThat(error.requestId()).contains("req_stream")
        else assertThat(error.requestId()).isEmpty()
        assertThat(error.statusCode()).isEqualTo(200)
        assertThat(response.closed).isTrue()
    }

    @Test
    fun missingServerIdDoesNotFallBackToClientIdOrErrorBody() {
        val response =
            Response(
                400,
                Headers.builder().put("X-Client-Request-Id", "client_id").build(),
                """{"error":{"message":"failure","request_id":"body_id"}}""",
            )
        val error = catchThrowable { errorHandler(errorBodyHandler(jsonMapper())).handle(response) }
        assertThat((error as OpenAIServiceException).requestId()).isEmpty()
    }

    @Test
    fun duplicateAndEmptyValuesMatchSuccessfulResponseBehavior() {
        for (first in listOf("req_first", "")) {
            val response =
                Response(
                    500,
                    Headers.builder()
                        .put("X-Request-ID", first)
                        .put("x-request-id", "req_second")
                        .build(),
                    "not JSON",
                )
            val error = catchThrowable {
                errorHandler(errorBodyHandler(jsonMapper())).handle(response)
            }
            assertThat((error as OpenAIServiceException).requestId()).contains(first)
            assertThat(error.requestId()).isEqualTo(response.requestId())
        }
    }
}
