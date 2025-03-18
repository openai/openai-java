// File generated from our OpenAPI spec by Stainless.

package com.openai.models.uploads

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UploadCancelParamsTest {

    @Test
    fun create() {
        UploadCancelParams.builder().uploadId("upload_abc123").build()
    }

    @Test
    fun pathParams() {
        val params = UploadCancelParams.builder().uploadId("upload_abc123").build()

        assertThat(params._pathParam(0)).isEqualTo("upload_abc123")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
