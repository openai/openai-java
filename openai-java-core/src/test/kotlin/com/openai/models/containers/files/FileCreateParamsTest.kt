// File generated from our OpenAPI spec by Stainless.

package com.openai.models.containers.files

import com.openai.core.MultipartField
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileCreateParamsTest {

    @Test
    fun create() {
        FileCreateParams.builder()
            .containerId("container_id")
            .file("some content".byteInputStream())
            .fileId("file_id")
            .build()
    }

    @Test
    fun pathParams() {
        val params = FileCreateParams.builder().containerId("container_id").build()

        assertThat(params._pathParam(0)).isEqualTo("container_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            FileCreateParams.builder()
                .containerId("container_id")
                .file("some content".byteInputStream())
                .fileId("file_id")
                .build()

        val body = params._body()

        assertThat(body.filterValues { !it.value.isNull() })
            .usingRecursiveComparison()
            // TODO(AssertJ): Replace this and the `mapValues` below with:
            // https://github.com/assertj/assertj/issues/3165
            .withEqualsForType(
                { a, b -> a.readBytes() contentEquals b.readBytes() },
                InputStream::class.java,
            )
            .isEqualTo(
                mapOf(
                        "file" to MultipartField.of("some content".byteInputStream()),
                        "file_id" to MultipartField.of("file_id"),
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = FileCreateParams.builder().containerId("container_id").build()

        val body = params._body()

        assertThat(body.filterValues { !it.value.isNull() })
            .usingRecursiveComparison()
            // TODO(AssertJ): Replace this and the `mapValues` below with:
            // https://github.com/assertj/assertj/issues/3165
            .withEqualsForType(
                { a, b -> a.readBytes() contentEquals b.readBytes() },
                InputStream::class.java,
            )
            .isEqualTo(
                mapOf<String, MultipartField<*>>()
            )
    }
}
