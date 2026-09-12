package com.openai.core.handlers

import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.http.Headers
import com.openai.core.http.HttpResponse
import com.openai.core.jsonMapper
import com.openai.errors.BadRequestException
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class ErrorHandlerTest {

    @Test
    fun handle_whenSuccessful_doesNotCloseResponse() {
        val response = TestHttpResponse(statusCode = 200, body = "")

        val handledResponse = errorHandler(errorBodyHandler(jsonMapper())).handle(response)

        assertThat(handledResponse).isSameAs(response)
        assertThat(response.closed).isFalse()
    }

    @Test
    fun handle_whenStatus400_closesResponseAndThrowsBadRequestException() {
        val response =
            TestHttpResponse(
                statusCode = 400,
                body =
                    """
                    {"error":{"code":"code","message":"message","param":"param","type":"type"}}
                    """
                        .trimIndent(),
            )

        val e =
            assertThrows<BadRequestException> {
                errorHandler(errorBodyHandler(jsonMapper())).handle(response)
            }

        assertThat(response.closed).isTrue()
        assertThat(e.body())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "code" to "code",
                        "message" to "message",
                        "param" to "param",
                        "type" to "type",
                    )
                )
            )
    }

    @Test
    fun handle_whenStatus400WithUnreadableBody_closesResponseAndThrowsBadRequestException() {
        val response = TestHttpResponse(statusCode = 400, body = "{not-json")

        val e =
            assertThrows<BadRequestException> {
                errorHandler(errorBodyHandler(jsonMapper())).handle(response)
            }

        assertThat(response.closed).isTrue()
        assertThat(e.body()).isEqualTo(JsonMissing.of())
    }
}

private class TestHttpResponse(private val statusCode: Int, private val body: String) :
    HttpResponse {

    var closed: Boolean = false

    override fun statusCode(): Int = statusCode

    override fun headers(): Headers = Headers.builder().build()

    override fun body(): InputStream = body.byteInputStream()

    override fun close() {
        closed = true
    }
}
