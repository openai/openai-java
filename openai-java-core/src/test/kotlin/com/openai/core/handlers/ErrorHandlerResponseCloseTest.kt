package com.openai.core.handlers

import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.http.Headers
import com.openai.core.http.HttpResponse
import com.openai.errors.OpenAIException
import com.openai.models.ErrorObject
import java.io.ByteArrayInputStream
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class ErrorHandlerResponseCloseTest {

    @ParameterizedTest
    @ValueSource(ints = [400, 401, 403, 404, 418, 422, 429, 500])
    fun closesEveryNonSuccessResponse(statusCode: Int) {
        val response = RecordingResponse(statusCode)
        val handler =
            errorHandler(
                object : HttpResponse.Handler<JsonField<ErrorObject>> {
                    override fun handle(response: HttpResponse): JsonField<ErrorObject> =
                        JsonMissing.of()
                }
            )

        assertThrows<OpenAIException> { handler.handle(response) }

        assertThat(response.closed).isTrue()
    }

    @Test
    fun closesResponseWhenErrorBodyHandlerThrows() {
        val failure = IllegalStateException("error body failed")
        val response = RecordingResponse(400)
        val handler =
            errorHandler(
                object : HttpResponse.Handler<JsonField<ErrorObject>> {
                    override fun handle(response: HttpResponse): JsonField<ErrorObject> {
                        throw failure
                    }
                }
            )

        val thrown = assertThrows<IllegalStateException> { handler.handle(response) }

        assertThat(thrown).isSameAs(failure)
        assertThat(response.closed).isTrue()
    }

    @Test
    fun leavesSuccessfulResponseOpenForCaller() {
        val response = RecordingResponse(200)
        val handler =
            errorHandler(
                object : HttpResponse.Handler<JsonField<ErrorObject>> {
                    override fun handle(response: HttpResponse): JsonField<ErrorObject> =
                        error("error body handler must not run for successful responses")
                }
            )

        assertThat(handler.handle(response)).isSameAs(response)
        assertThat(response.closed).isFalse()
    }

    private class RecordingResponse(private val statusCode: Int) : HttpResponse {
        var closed = false
            private set

        override fun statusCode(): Int = statusCode

        override fun headers(): Headers = Headers.builder().build()

        override fun body(): InputStream = ByteArrayInputStream(ByteArray(0))

        override fun close() {
            closed = true
        }
    }
}
