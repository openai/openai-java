// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileContentParamsTest {

    @Test
    fun createFileContentParams() {
        FileContentParams.builder().fileId("file_id").build()
    }

    @Test
    fun getPathParam() {
        val params = FileContentParams.builder().fileId("file_id").build()
        assertThat(params).isNotNull
        // path param "fileId"
        assertThat(params.getPathParam(0)).isEqualTo("file_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
