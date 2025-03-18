// File generated from our OpenAPI spec by Stainless.

package com.openai.models.uploads.parts

import com.openai.core.MultipartField
import java.io.InputStream
import kotlin.test.assertNotNull
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

        assertNotNull(body)
        assertThat(
                body
                    .filterValues { !it.value.isNull() }
                    .mapValues { (_, field) ->
                        field.map { if (it is InputStream) it.readBytes() else it }
                    }
            )
            .isEqualTo(mapOf("data" to MultipartField.of("some content".toByteArray())))
    }
}
