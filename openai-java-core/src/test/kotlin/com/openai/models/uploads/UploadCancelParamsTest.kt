// File generated from our OpenAPI spec by Stainless.

package com.openai.models.uploads

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UploadCancelParamsTest {

    @Test
    fun create() {
        UploadCancelParams.builder().uploadId("upload_abc123").build()
    }

    @Test
    fun getPathParam() {
        val params = UploadCancelParams.builder().uploadId("upload_abc123").build()
        assertThat(params).isNotNull
        // path param "uploadId"
        assertThat(params.getPathParam(0)).isEqualTo("upload_abc123")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
