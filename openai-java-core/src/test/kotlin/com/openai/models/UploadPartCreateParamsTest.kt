// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.MultipartField
import java.io.InputStream
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UploadPartCreateParamsTest {

    @Test
    fun create() {
        UploadPartCreateParams.builder()
            .uploadId("upload_abc123")
            .data("some content".toByteArray())
            .build()
    }

    @Test
    fun body() {
        val params =
            UploadPartCreateParams.builder()
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

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            UploadPartCreateParams.builder()
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

    @Test
    fun getPathParam() {
        val params =
            UploadPartCreateParams.builder()
                .uploadId("upload_abc123")
                .data("some content".toByteArray())
                .build()
        assertThat(params).isNotNull
        // path param "uploadId"
        assertThat(params.getPathParam(0)).isEqualTo("upload_abc123")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
