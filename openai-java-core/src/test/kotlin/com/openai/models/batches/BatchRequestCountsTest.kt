// File generated from our OpenAPI spec by Stainless.

package com.openai.models.batches

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchRequestCountsTest {

    @Test
    fun create() {
        val batchRequestCounts =
            BatchRequestCounts.builder().completed(0L).failed(0L).total(0L).build()

        assertThat(batchRequestCounts.completed()).isEqualTo(0L)
        assertThat(batchRequestCounts.failed()).isEqualTo(0L)
        assertThat(batchRequestCounts.total()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val batchRequestCounts =
            BatchRequestCounts.builder().completed(0L).failed(0L).total(0L).build()

        val roundtrippedBatchRequestCounts =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(batchRequestCounts),
                jacksonTypeRef<BatchRequestCounts>(),
            )

        assertThat(roundtrippedBatchRequestCounts).isEqualTo(batchRequestCounts)
    }
}
