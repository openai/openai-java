// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.files

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileRetrieveParamsTest {

    @Test
    fun create() {
        FileRetrieveParams.builder().vectorStoreId("vs_abc123").fileId("file-abc123").build()
    }

    @Test
    fun getPathParam() {
        val params =
            FileRetrieveParams.builder().vectorStoreId("vs_abc123").fileId("file-abc123").build()
        assertThat(params).isNotNull
        // path param "vectorStoreId"
        assertThat(params.getPathParam(0)).isEqualTo("vs_abc123")
        // path param "fileId"
        assertThat(params.getPathParam(1)).isEqualTo("file-abc123")
        // out-of-bound path param
        assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
