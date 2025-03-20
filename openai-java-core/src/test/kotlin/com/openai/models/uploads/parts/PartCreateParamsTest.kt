// File generated from our OpenAPI spec by Stainless.

package com.openai.models.uploads.parts

import com.openai.core.MultipartField
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PartCreateParamsTest {

    @Test
    fun create() {
        PartCreateParams.builder()
            .uploadId("upload_abc123")
            .data("some content".toByteArray())
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            PartCreateParams.builder()
                .uploadId("upload_abc123")
                .data("some content".toByteArray())
                .build()

        assertThat(params._pathParam(0)).isEqualTo("upload_abc123")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            PartCreateParams.builder()
                .uploadId("upload_abc123")
                .data("some content".toByteArray())
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
                mapOf("data" to MultipartField.of("some content".toByteArray())).mapValues {
                    (_, field) ->
                    field.map { (it as? ByteArray)?.inputStream() ?: it }
                }
            )
    }
}
