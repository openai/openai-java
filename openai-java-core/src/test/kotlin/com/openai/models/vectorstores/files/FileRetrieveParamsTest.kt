// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.files

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileRetrieveParamsTest {

    @Test
    fun create() {
        FileRetrieveParams.builder().vectorStoreId("vs_abc123").fileId("file-abc123").build()
    }

    @Test
    fun pathParams() {
        val params =
            FileRetrieveParams.builder().vectorStoreId("vs_abc123").fileId("file-abc123").build()

        assertThat(params._pathParam(0)).isEqualTo("vs_abc123")
        assertThat(params._pathParam(1)).isEqualTo("file-abc123")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
