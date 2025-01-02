// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UploadCompleteParamsTest {

    @Test
    fun createUploadCompleteParams() {
        UploadCompleteParams.builder()
            .uploadId("upload_abc123")
            .partIds(listOf("string"))
            .md5("md5")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            UploadCompleteParams.builder()
                .uploadId("upload_abc123")
                .partIds(listOf("string"))
                .md5("md5")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.partIds()).isEqualTo(listOf("string"))
        assertThat(body.md5()).contains("md5")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            UploadCompleteParams.builder()
                .uploadId("upload_abc123")
                .partIds(listOf("string"))
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.partIds()).isEqualTo(listOf("string"))
    }

    @Test
    fun getPathParam() {
        val params =
            UploadCompleteParams.builder()
                .uploadId("upload_abc123")
                .partIds(listOf("string"))
                .build()
        assertThat(params).isNotNull
        // path param "uploadId"
        assertThat(params.getPathParam(0)).isEqualTo("upload_abc123")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
