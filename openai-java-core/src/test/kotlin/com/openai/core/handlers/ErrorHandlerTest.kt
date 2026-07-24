// File generated from our OpenAPI spec by Stainless.

package com.openai.core.handlers

import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.core.http.Headers
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.jsonMapper
import com.openai.errors.BadRequestException
import com.openai.errors.InternalServerException
import com.openai.errors.UnexpectedStatusCodeException
import com.openai.models.ErrorObject
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class ErrorHandlerTest {

    @Test
    fun `should not close response if status is successful`() {
        val response = RecordingHttpResponse(statusCode = 204)
        val handler =
            errorHandler(
                object : Handler<JsonField<ErrorObject>> {
                    override fun handle(response: HttpResponse): JsonField<ErrorObject> {
                        error("Error body handler should not be called for successful responses")
                    }
                }
            )

        assertThat(handler.handle(response)).isSameAs(response)
        assertThat(response.closed).isFalse()
    }

    @Test
    fun `should close response if bad request exception is thrown`() {
        val response = RecordingHttpResponse(statusCode = 400)

        val e = assertThrows<BadRequestException> { defaultErrorHandler().handle(response) }

        assertThat(response.closed).isTrue()
        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().values(HEADER_NAME)).containsExactly(HEADER_VALUE)
        assertThat(e.body()).isEqualTo(ERROR_BODY)
    }

    @Test
    fun `should close response if internal server exception is thrown`() {
        val response = RecordingHttpResponse(statusCode = 503)

        val e = assertThrows<InternalServerException> { defaultErrorHandler().handle(response) }

        assertThat(response.closed).isTrue()
        assertThat(e.statusCode()).isEqualTo(503)
        assertThat(e.headers().values(HEADER_NAME)).containsExactly(HEADER_VALUE)
        assertThat(e.body()).isEqualTo(ERROR_BODY)
    }

    @Test
    fun `should close response if unexpected status exception is thrown`() {
        val response = RecordingHttpResponse(statusCode = 999)

        val e =
            assertThrows<UnexpectedStatusCodeException> { defaultErrorHandler().handle(response) }

        assertThat(response.closed).isTrue()
        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().values(HEADER_NAME)).containsExactly(HEADER_VALUE)
        assertThat(e.body()).isEqualTo(ERROR_BODY)
    }

    @Test
    fun `should close response if error body handler throws`() {
        val response = RecordingHttpResponse(statusCode = 400)
        val expected = IllegalStateException("boom")
        val handler =
            errorHandler(
                object : Handler<JsonField<ErrorObject>> {
                    override fun handle(response: HttpResponse): JsonField<ErrorObject> {
                        throw expected
                    }
                }
            )

        val e = assertThrows<IllegalStateException> { handler.handle(response) }

        assertThat(response.closed).isTrue()
        assertThat(e).isSameAs(expected)
    }

    private fun defaultErrorHandler(): Handler<HttpResponse> =
        errorHandler(errorBodyHandler(jsonMapper()))

    private class RecordingHttpResponse(
        private val statusCode: Int,
        private val bodyBytes: ByteArray = ERROR_JSON_BYTES,
        private val headers: Headers = Headers.builder().put(HEADER_NAME, HEADER_VALUE).build(),
    ) : HttpResponse {

        var closed: Boolean = false
            private set

        override fun statusCode(): Int = statusCode

        override fun headers(): Headers = headers

        override fun body(): InputStream = bodyBytes.inputStream()

        override fun close() {
            closed = true
        }
    }

    companion object {

        private const val HEADER_NAME = "Error-Header"

        private const val HEADER_VALUE = "42"

        private val ERROR_BODY: JsonValue =
            JsonValue.from(
                mapOf(
                    "code" to "code",
                    "message" to "message",
                    "param" to "param",
                    "type" to "type",
                )
            )

        private val ERROR_JSON_BYTES: ByteArray =
            jsonMapper()
                .writeValueAsBytes(
                    JsonValue.from(
                        mapOf(
                            "error" to
                                mapOf(
                                    "code" to "code",
                                    "message" to "message",
                                    "param" to "param",
                                    "type" to "type",
                                )
                        )
                    )
                )
    }
}
