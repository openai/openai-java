// File generated from our OpenAPI spec by Stainless.

package com.openai.models.uploads

import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UploadCompleteParamsTest {

    @Test
    fun create() {
        UploadCompleteParams.builder()
            .uploadId("upload_abc123")
            .addPartId("string")
            .md5("md5")
            .build()
    }

    @Test
    fun body() {
        val params =
            UploadCompleteParams.builder()
                .uploadId("upload_abc123")
                .addPartId("string")
                .md5("md5")
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.partIds()).isEqualTo(listOf("string"))
        assertThat(body.md5()).contains("md5")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            UploadCompleteParams.builder().uploadId("upload_abc123").addPartId("string").build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.partIds()).isEqualTo(listOf("string"))
    }

    @Test
    fun getPathParam() {
        val params =
            UploadCompleteParams.builder().uploadId("upload_abc123").addPartId("string").build()
        assertThat(params).isNotNull
        // path param "uploadId"
        assertThat(params.getPathParam(0)).isEqualTo("upload_abc123")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
