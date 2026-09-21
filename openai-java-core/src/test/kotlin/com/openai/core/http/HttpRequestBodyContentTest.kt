package com.openai.core.http

import com.openai.core.MultipartField
import com.openai.core.jsonMapper
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class HttpRequestBodyContentTest {

    @Test
    fun content_defaultsToWriteTo() {
        val body =
            object : HttpRequestBody {
                override fun writeTo(outputStream: OutputStream) {
                    outputStream.write("body".toByteArray())
                }

                override fun contentType(): String = "text/plain"

                override fun contentLength(): Long = 4L

                override fun repeatable(): Boolean = true

                override fun close() {}
            }

        body.content().use { content -> assertThat(content.readBytes()).isEqualTo("body".toByteArray()) }
    }

    @Test
    fun multipartContent_matchesWriteTo() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "field" to
                        MultipartField.builder<String>()
                            .value("value")
                            .contentType("text/plain")
                            .build(),
                    "binary" to
                        MultipartField.builder<ByteArray>()
                            .value("abc".toByteArray())
                            .contentType("application/octet-stream")
                            .build(),
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        body.content().use { content -> assertThat(content.readBytes()).isEqualTo(output.toByteArray()) }
    }

    @Test
    fun multipartContent_streamsInputStreamParts() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "data" to
                        MultipartField.builder<java.io.InputStream>()
                            .value("stream content".byteInputStream().buffered())
                            .contentType("application/octet-stream")
                            .build()
                ),
            )

        val content = body.content().use { it.readBytes().toString(Charsets.UTF_8) }

        assertThat(body.repeatable()).isFalse()
        assertThat(content).contains("Content-Disposition: form-data; name=\"data\"")
        assertThat(content).contains("Content-Type: application/octet-stream")
        assertThat(content).contains("stream content")
    }
}
