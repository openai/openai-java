package com.openai.core.handlers

import com.fasterxml.jackson.databind.json.JsonMapper
import com.openai.core.http.Headers
import com.openai.core.http.HttpResponse
import com.openai.errors.OpenAIInvalidDataException
import java.io.InputStream
import kotlin.test.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

internal class JsonHandlerTest {

    @Test
    fun jsonHandler_whenBodyCannotBeRead_exposesResponseHeaders() {
        val headers = Headers.builder().put("x-request-id", "req_123").build()
        val handler = jsonHandler<Map<String, Any>>(JsonMapper.builder().build())

        val error =
            assertThrows<OpenAIInvalidDataException> {
                handler.handle(httpResponse("{".byteInputStream(), headers))
            }

        assertThat(error).hasMessage("Error reading response")
        assertThat(error.headers()).contains(headers)
    }

    private fun httpResponse(body: InputStream, headers: Headers): HttpResponse =
        object : HttpResponse {

            override fun statusCode(): Int = 200

            override fun headers(): Headers = headers

            override fun body(): InputStream = body

            override fun close() {}
        }
}
