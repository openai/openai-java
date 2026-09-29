package com.openai.core.handlers

import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.core.http.Headers
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.jsonMapper
import com.openai.errors.BadRequestException
import com.openai.errors.InternalServerException
import com.openai.errors.NotFoundException
import com.openai.errors.OpenAIServiceException
import com.openai.errors.PermissionDeniedException
import com.openai.errors.RateLimitException
import com.openai.errors.UnauthorizedException
import com.openai.errors.UnexpectedStatusCodeException
import com.openai.errors.UnprocessableEntityException
import com.openai.models.ErrorObject
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class ErrorHandlerTest {

    @ParameterizedTest
    @ValueSource(ints = [200, 204, 299])
    fun `successful responses remain open for the caller`(statusCode: Int) {
        val response = RecordingResponse(statusCode)
        val handler = errorHandler(failingBodyHandler(AssertionError("Must not parse success")))

        assertThat(handler.handle(response)).isSameAs(response)
        assertThat(response.closeCount).isZero()
    }

    @ParameterizedTest
    @CsvSource(
        "199, UnexpectedStatusCodeException",
        "300, UnexpectedStatusCodeException",
        "400, BadRequestException",
        "401, UnauthorizedException",
        "403, PermissionDeniedException",
        "404, NotFoundException",
        "418, UnexpectedStatusCodeException",
        "422, UnprocessableEntityException",
        "429, RateLimitException",
        "500, InternalServerException",
        "503, InternalServerException",
        "599, InternalServerException",
        "600, UnexpectedStatusCodeException",
    )
    fun `error responses close and preserve exception details`(
        statusCode: Int,
        exceptionName: String,
    ) {
        val response = RecordingResponse(statusCode)
        val expectedType =
            when (exceptionName) {
                "BadRequestException" -> BadRequestException::class.java
                "UnauthorizedException" -> UnauthorizedException::class.java
                "PermissionDeniedException" -> PermissionDeniedException::class.java
                "NotFoundException" -> NotFoundException::class.java
                "UnprocessableEntityException" -> UnprocessableEntityException::class.java
                "RateLimitException" -> RateLimitException::class.java
                "InternalServerException" -> InternalServerException::class.java
                else -> UnexpectedStatusCodeException::class.java
            }

        val failure = assertThrows<OpenAIServiceException> { defaultHandler().handle(response) }

        assertThat(response.closeCount).isEqualTo(1)
        assertThat(failure).isExactlyInstanceOf(expectedType)
        assertThat(failure.statusCode()).isEqualTo(statusCode)
        assertThat(failure.headers().values("Error-Header")).containsExactly("42")
        assertThat(failure.body()).isEqualTo(ERROR_BODY)
    }

    @Test
    fun `malformed error body still closes response and preserves typed exception`() {
        val response = RecordingResponse(400, bodyText = "{invalid json")

        val failure = assertThrows<BadRequestException> { defaultHandler().handle(response) }

        assertThat(response.closeCount).isEqualTo(1)
        assertThat(failure.statusCode()).isEqualTo(400)
        assertThat(failure.headers().values("Error-Header")).containsExactly("42")
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `body handler failure is preserved even if cleanup fails`(closeFails: Boolean) {
        val primary = IllegalStateException("Error body failed")
        val cleanup = IllegalStateException("Close failed")
        val response = RecordingResponse(400, closeFailure = if (closeFails) cleanup else null)

        val failure =
            assertThrows<IllegalStateException> {
                errorHandler(failingBodyHandler(primary)).handle(response)
            }

        assertThat(response.closeCount).isEqualTo(1)
        assertThat(failure).isSameAs(primary)
        if (closeFails) {
            assertThat(failure.suppressed).containsExactly(cleanup)
        } else {
            assertThat(failure.suppressed).isEmpty()
        }
    }

    @Test
    fun `cleanup failure does not replace typed service exception`() {
        val cleanup = IllegalStateException("Close failed")
        val response = RecordingResponse(400, closeFailure = cleanup)

        val failure = assertThrows<BadRequestException> { defaultHandler().handle(response) }

        assertThat(response.closeCount).isEqualTo(1)
        assertThat(failure.suppressed).containsExactly(cleanup)
        assertThat(failure.body()).isEqualTo(ERROR_BODY)
    }

    private fun defaultHandler(): Handler<HttpResponse> =
        errorHandler(errorBodyHandler(jsonMapper()))

    private fun failingBodyHandler(failure: Throwable): Handler<JsonField<ErrorObject>> =
        object : Handler<JsonField<ErrorObject>> {
            override fun handle(response: HttpResponse): JsonField<ErrorObject> = throw failure
        }

    private class RecordingResponse(
        private val status: Int,
        bodyText: String = ERROR_JSON,
        private val closeFailure: RuntimeException? = null,
    ) : HttpResponse {
        private val stream = bodyText.byteInputStream()
        var closeCount = 0
            private set

        override fun statusCode(): Int = status

        override fun headers(): Headers {
            check(closeCount == 0) { "Headers accessed after response close" }
            return Headers.builder().put("Error-Header", "42").build()
        }

        override fun body(): InputStream {
            check(closeCount == 0) { "Body accessed after response close" }
            return stream
        }

        override fun close() {
            closeCount++
            stream.close()
            closeFailure?.let { throw it }
        }
    }

    companion object {
        private const val ERROR_JSON =
            """{"error":{"code":"code","message":"message","param":"param","type":"type"}}"""

        private val ERROR_BODY =
            JsonValue.from(
                mapOf(
                    "code" to "code",
                    "message" to "message",
                    "param" to "param",
                    "type" to "type",
                )
            )
    }
}
