// File generated from our OpenAPI spec by Stainless.

package com.openai.models.batches

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchCancelParamsTest {

    @Test
    fun create() {
        BatchCancelParams.builder().batchId("batch_id").build()
    }

    @Test
    fun getPathParam() {
        val params = BatchCancelParams.builder().batchId("batch_id").build()
        assertThat(params).isNotNull
        // path param "batchId"
        assertThat(params.getPathParam(0)).isEqualTo("batch_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
