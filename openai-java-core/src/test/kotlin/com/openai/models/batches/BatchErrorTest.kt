// File generated from our OpenAPI spec by Stainless.

package com.openai.models.batches

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchErrorTest {

    @Test
    fun create() {
        val batchError =
            BatchError.builder().code("code").line(0L).message("message").param("param").build()

        assertThat(batchError.code()).contains("code")
        assertThat(batchError.line()).contains(0L)
        assertThat(batchError.message()).contains("message")
        assertThat(batchError.param()).contains("param")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val batchError =
            BatchError.builder().code("code").line(0L).message("message").param("param").build()

        val roundtrippedBatchError =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(batchError),
                jacksonTypeRef<BatchError>(),
            )

        assertThat(roundtrippedBatchError).isEqualTo(batchError)
    }
}
