// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.filebatches

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileBatchCancelParamsTest {

    @Test
    fun create() {
        FileBatchCancelParams.builder().vectorStoreId("vector_store_id").batchId("batch_id").build()
    }

    @Test
    fun pathParams() {
        val params =
            FileBatchCancelParams.builder()
                .vectorStoreId("vector_store_id")
                .batchId("batch_id")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("vector_store_id")
        assertThat(params._pathParam(1)).isEqualTo("batch_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
