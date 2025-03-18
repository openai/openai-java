// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.filebatches

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileBatchRetrieveParamsTest {

    @Test
    fun create() {
        FileBatchRetrieveParams.builder().vectorStoreId("vs_abc123").batchId("vsfb_abc123").build()
    }

    @Test
    fun pathParams() {
        val params =
            FileBatchRetrieveParams.builder()
                .vectorStoreId("vs_abc123")
                .batchId("vsfb_abc123")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("vs_abc123")
        assertThat(params._pathParam(1)).isEqualTo("vsfb_abc123")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
