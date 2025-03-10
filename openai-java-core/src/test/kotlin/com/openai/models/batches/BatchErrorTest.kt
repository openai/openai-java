// File generated from our OpenAPI spec by Stainless.

package com.openai.models.batches

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BatchErrorTest {

    @Test
    fun createBatchError() {
        val batchError =
            BatchError.builder().code("code").line(0L).message("message").param("param").build()
        assertThat(batchError).isNotNull
        assertThat(batchError.code()).contains("code")
        assertThat(batchError.line()).contains(0L)
        assertThat(batchError.message()).contains("message")
        assertThat(batchError.param()).contains("param")
    }
}
