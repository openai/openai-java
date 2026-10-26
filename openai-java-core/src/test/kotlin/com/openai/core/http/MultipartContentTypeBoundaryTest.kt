package com.openai.core.http

import com.openai.core.MultipartField
import com.openai.core.jsonMapper
import java.io.ByteArrayOutputStream
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

internal class MultipartContentTypeBoundaryTest {
    @Test
    fun rejectsHeaderAndPartInjection() {
        listOf(
                "text/plain\rX-Test: injected",
                "text/plain\nX-Test: injected",
                "text/plain\r\n\r\nextra",
            )
            .forEach {
                assertThatIllegalArgumentException().isThrownBy {
                    MultipartField.builder<String>().value("test").contentType(it).build()
                }
            }
    }

    @Test
    fun preservesParameterizedMediaTypes() {
        val type = "text/plain; charset=utf-8; custom=\"value\""
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "file" to
                        MultipartField.builder<String>().value("test").contentType(type).build()
                ),
            )
        val output = ByteArrayOutputStream()
        body.use { it.writeTo(output) }
        assertThat(output.toString("UTF-8")).contains("Content-Type: $type\r\n")
        assertThat(body.contentLength()).isEqualTo(output.size().toLong())
    }
}
