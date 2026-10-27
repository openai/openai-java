package com.openai.core.handlers

import com.fasterxml.jackson.core.JsonProcessingException
import com.openai.core.http.Headers
import com.openai.core.http.HttpResponse
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.errors.OpenAIIoException
import java.io.InputStream
import java.io.InterruptedIOException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

internal class ResponseHeadersTest {
    private val headers = Headers.builder().put("x-request-id", "req_test").build()

    @Test
    fun malformedJsonRetainsHeaders() {
        val response = response("{".byteInputStream())
        val error =
            assertThrows<OpenAIInvalidDataException> {
                jsonHandler<Map<String, String>>(jsonMapper()).handle(response)
            }
        assertThat(error.headers()).contains(headers)
        assertThat(error.toString()).doesNotContain("req_test")
        assertThat(error)
            .hasMessage("Error reading response")
            .hasCauseInstanceOf(JsonProcessingException::class.java)
    }

    @Test
    fun bodyReadTimeoutRetainsHeadersAndCause() {
        val timeout = InterruptedIOException("timeout")
        val response = response(failingBody(timeout))
        val error =
            assertThrows<OpenAIInvalidDataException> {
                jsonHandler<Map<String, String>>(jsonMapper()).handle(response)
            }
        assertThat(error.headers()).contains(headers)
        assertThat(error.toString()).doesNotContain("req_test")
        assertThat(error).hasMessage("Error reading response").hasCause(timeout)
    }

    @Test
    fun streamReadTimeoutRetainsHeadersAndCause() {
        val timeout = InterruptedIOException("timeout")
        val response = response(failingBody(timeout))
        val error =
            assertThrows<OpenAIIoException> {
                sseHandler(jsonMapper()).handle(response).use { it.stream().count() }
            }
        assertThat(error.headers()).contains(headers)
        assertThat(error.toString()).doesNotContain("req_test")
        assertThat(error).hasMessage("Stream failed").hasCause(timeout)
    }

    @ParameterizedTest
    @ValueSource(strings = ["{", "[]"])
    fun sseJsonFailuresRetainHeaders(data: String) {
        val response = response("data: $data\n\n".byteInputStream())
        val error =
            assertThrows<OpenAIInvalidDataException> {
                sseHandler(jsonMapper()).mapJson<Map<String, String>>().handle(response).use {
                    it.stream().count()
                }
            }
        assertThat(error.headers()).contains(headers)
        assertThat(error.toString()).doesNotContain("req_test")
        assertThat(error)
            .hasMessage("Error reading response")
            .hasCauseInstanceOf(JsonProcessingException::class.java)
    }

    @Test
    fun consumerExceptionsAreNotEnriched() {
        val expected = OpenAIInvalidDataException("consumer failed")
        val response = response("data: {}\n\n".byteInputStream())
        val error =
            assertThrows<OpenAIInvalidDataException> {
                sseHandler(jsonMapper()).mapJson<Map<String, String>>().handle(response).use {
                    it.stream().forEach { throw expected }
                }
            }
        assertThat(error).isSameAs(expected)
        assertThat(error.headers()).isEmpty()
    }

    @Test
    fun exceptionsWithoutResponsesHaveNoHeaders() {
        val cause = InterruptedIOException("timeout")
        val ioError = OpenAIIoException("Request failed", cause)
        val dataError = OpenAIInvalidDataException("Invalid local data", cause)
        assertThat(ioError.headers()).isEmpty()
        assertThat(dataError.headers()).isEmpty()
        assertThat(ioError).hasCause(cause)
        assertThat(dataError).hasCause(cause)
        assertThat(OpenAIIoException().headers()).isEmpty()
        assertThat(OpenAIInvalidDataException().headers()).isEmpty()
        assertThat(OpenAIIoException("message").headers()).isEmpty()
        assertThat(OpenAIInvalidDataException("message").headers()).isEmpty()
    }

    private fun response(body: InputStream): HttpResponse = mock {
        whenever(it.statusCode()).thenReturn(200)
        whenever(it.headers()).thenReturn(headers)
        whenever(it.body()).thenReturn(body)
    }

    private fun failingBody(failure: InterruptedIOException): InputStream = mock {
        whenever(it.read(any<ByteArray>())).thenThrow(failure)
        whenever(it.read(any<ByteArray>(), any(), any())).thenThrow(failure)
        whenever(it.read()).thenThrow(failure)
    }
}
