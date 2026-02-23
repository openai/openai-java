// File generated from our OpenAPI spec by Stainless.

package com.openai.core.http

import com.openai.core.MultipartField
import com.openai.core.jsonMapper
import java.io.ByteArrayOutputStream
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class HttpRequestBodiesTest {

    @Test
    fun multipartFormData_serializesFieldWithFilename() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "file" to
                        MultipartField.builder<String>()
                            .value("hello")
                            .filename("hello.txt")
                            .contentType("text/plain")
                            .build()
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(output.size().toLong()).isEqualTo(body.contentLength())
        val boundary = body.contentType()!!.substringAfter("multipart/form-data; boundary=")
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="file"; filename="hello.txt"
                |Content-Type: text/plain
                |
                |hello
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_serializesFieldWithoutFilename() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "field" to
                        MultipartField.builder<String>()
                            .value("value")
                            .contentType("text/plain")
                            .build()
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(output.size().toLong()).isEqualTo(body.contentLength())
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="field"
                |Content-Type: text/plain
                |
                |value
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_serializesInputStream() {
        // Use `.buffered()` to get a non-ByteArrayInputStream, which hits the non-repeatable code
        // path.
        val inputStream = "stream content".byteInputStream().buffered()
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "data" to
                        MultipartField.builder<InputStream>()
                            .value(inputStream)
                            .contentType("application/octet-stream")
                            .build()
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isFalse()
        assertThat(body.contentLength()).isEqualTo(-1L)
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="data"
                |Content-Type: application/octet-stream
                |
                |stream content
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_serializesByteArray() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "binary" to
                        MultipartField.builder<ByteArray>()
                            .value("abc".toByteArray())
                            .contentType("application/octet-stream")
                            .build()
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(body.contentLength()).isEqualTo(output.size().toLong())
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="binary"
                |Content-Type: application/octet-stream
                |
                |abc
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_serializesBooleanValue() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "flag" to
                        MultipartField.builder<Boolean>()
                            .value(true)
                            .contentType("text/plain")
                            .build()
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(body.contentLength()).isEqualTo(output.size().toLong())
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="flag"
                |Content-Type: text/plain
                |
                |true
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_serializesNumberValue() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "count" to
                        MultipartField.builder<Int>().value(42).contentType("text/plain").build()
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(body.contentLength()).isEqualTo(output.size().toLong())
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="count"
                |Content-Type: text/plain
                |
                |42
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_serializesNullValueAsNoParts() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "present" to
                        MultipartField.builder<String>()
                            .value("yes")
                            .contentType("text/plain")
                            .build(),
                    "absent" to
                        MultipartField.builder<String>()
                            .value(null as String?)
                            .contentType("text/plain")
                            .build(),
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(body.contentLength()).isEqualTo(output.size().toLong())
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="present"
                |Content-Type: text/plain
                |
                |yes
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_serializesArray() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "items" to
                        MultipartField.builder<List<String>>()
                            .value(listOf("alpha", "beta", "gamma"))
                            .contentType("text/plain")
                            .build()
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(body.contentLength()).isEqualTo(output.size().toLong())
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="items[]"
                |Content-Type: text/plain
                |
                |alpha
                |--$boundary
                |Content-Disposition: form-data; name="items[]"
                |Content-Type: text/plain
                |
                |beta
                |--$boundary
                |Content-Disposition: form-data; name="items[]"
                |Content-Type: text/plain
                |
                |gamma
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_serializesObjectAsNestedParts() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "meta" to
                        MultipartField.builder<Map<String, String>>()
                            .value(mapOf("key1" to "val1", "key2" to "val2"))
                            .contentType("text/plain")
                            .build()
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(body.contentLength()).isEqualTo(output.size().toLong())
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="meta[key1]"
                |Content-Type: text/plain
                |
                |val1
                |--$boundary
                |Content-Disposition: form-data; name="meta[key2]"
                |Content-Type: text/plain
                |
                |val2
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_serializesMultipleFields() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "name" to
                        MultipartField.builder<String>()
                            .value("Alice")
                            .contentType("text/plain")
                            .build(),
                    "age" to
                        MultipartField.builder<Int>().value(30).contentType("text/plain").build(),
                    "file" to
                        MultipartField.builder<String>()
                            .value("file contents")
                            .filename("doc.txt")
                            .contentType("text/plain")
                            .build(),
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(body.contentLength()).isEqualTo(output.size().toLong())
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="name"
                |Content-Type: text/plain
                |
                |Alice
                |--$boundary
                |Content-Disposition: form-data; name="age"
                |Content-Type: text/plain
                |
                |30
                |--$boundary
                |Content-Disposition: form-data; name="file"; filename="doc.txt"
                |Content-Type: text/plain
                |
                |file contents
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_quotesSpecialCharactersInNameAndFilename() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "field\nname" to
                        MultipartField.builder<String>()
                            .value("value")
                            .filename("file\r\"name.txt")
                            .contentType("text/plain")
                            .build()
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(body.contentLength()).isEqualTo(output.size().toLong())
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="field%0Aname"; filename="file%0D%22name.txt"
                |Content-Type: text/plain
                |
                |value
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_writeIsRepeatable() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "field" to
                        MultipartField.builder<String>()
                            .value("repeatable")
                            .contentType("text/plain")
                            .build()
                ),
            )

        val output1 = ByteArrayOutputStream()
        body.writeTo(output1)
        val output2 = ByteArrayOutputStream()
        body.writeTo(output2)

        assertThat(body.repeatable()).isTrue()
        assertThat(body.contentLength()).isEqualTo(output1.size().toLong())
        val boundary = boundary(body)
        val expected =
            """
            |--$boundary
            |Content-Disposition: form-data; name="field"
            |Content-Type: text/plain
            |
            |repeatable
            |--$boundary--
            |
            """
                .trimMargin()
                .replace("\n", "\r\n")
        assertThat(output1.toString("UTF-8")).isEqualTo(expected)
        assertThat(output2.toString("UTF-8")).isEqualTo(expected)
    }

    @Test
    fun multipartFormData_serializesByteArrayInputStream() {
        // ByteArrayInputStream is specifically handled as repeatable with known content length.
        val inputStream = "byte array stream".byteInputStream()
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "data" to
                        MultipartField.builder<InputStream>()
                            .value(inputStream)
                            .contentType("application/octet-stream")
                            .build()
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(body.contentLength()).isEqualTo(output.size().toLong())
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="data"
                |Content-Type: application/octet-stream
                |
                |byte array stream
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_serializesInputStreamWithFilename() {
        // Use `.buffered()` to get a non-ByteArrayInputStream, which hits the non-repeatable code
        // path.
        val inputStream = "file data".byteInputStream().buffered()
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "upload" to
                        MultipartField.builder<InputStream>()
                            .value(inputStream)
                            .filename("upload.bin")
                            .contentType("application/octet-stream")
                            .build()
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isFalse()
        assertThat(body.contentLength()).isEqualTo(-1L)
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="upload"; filename="upload.bin"
                |Content-Type: application/octet-stream
                |
                |file data
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_serializesNestedArrayInObject() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "data" to
                        MultipartField.builder<Map<String, List<String>>>()
                            .value(mapOf("tags" to listOf("a", "b")))
                            .contentType("text/plain")
                            .build()
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(body.contentLength()).isEqualTo(output.size().toLong())
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="data[tags][]"
                |Content-Type: text/plain
                |
                |a
                |--$boundary
                |Content-Disposition: form-data; name="data[tags][]"
                |Content-Type: text/plain
                |
                |b
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_contentLengthIsUnknownWhenInputStreamPresent() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "text" to
                        MultipartField.builder<String>()
                            .value("hello")
                            .contentType("text/plain")
                            .build(),
                    "stream" to
                        MultipartField.builder<InputStream>()
                            // Use `.buffered()` to get a non-ByteArrayInputStream, which hits the
                            // non-repeatable code path.
                            .value("data".byteInputStream().buffered())
                            .contentType("application/octet-stream")
                            .build(),
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isFalse()
        assertThat(body.contentLength()).isEqualTo(-1L)
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="text"
                |Content-Type: text/plain
                |
                |hello
                |--$boundary
                |Content-Disposition: form-data; name="stream"
                |Content-Type: application/octet-stream
                |
                |data
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_serializesEmptyArray() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "required" to
                        MultipartField.builder<String>()
                            .value("present")
                            .contentType("text/plain")
                            .build(),
                    "items" to
                        MultipartField.builder<List<String>>()
                            .value(emptyList())
                            .contentType("text/plain")
                            .build(),
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(body.contentLength()).isEqualTo(output.size().toLong())
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="required"
                |Content-Type: text/plain
                |
                |present
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    @Test
    fun multipartFormData_serializesEmptyObject() {
        val body =
            multipartFormData(
                jsonMapper(),
                mapOf(
                    "required" to
                        MultipartField.builder<String>()
                            .value("present")
                            .contentType("text/plain")
                            .build(),
                    "meta" to
                        MultipartField.builder<Map<String, String>>()
                            .value(emptyMap())
                            .contentType("text/plain")
                            .build(),
                ),
            )

        val output = ByteArrayOutputStream()
        body.writeTo(output)

        assertThat(body.repeatable()).isTrue()
        assertThat(body.contentLength()).isEqualTo(output.size().toLong())
        val boundary = boundary(body)
        assertThat(output.toString("UTF-8"))
            .isEqualTo(
                """
                |--$boundary
                |Content-Disposition: form-data; name="required"
                |Content-Type: text/plain
                |
                |present
                |--$boundary--
                |
                """
                    .trimMargin()
                    .replace("\n", "\r\n")
            )
    }

    private fun boundary(body: HttpRequestBody): String =
        body.contentType()!!.substringAfter("multipart/form-data; boundary=")
}
