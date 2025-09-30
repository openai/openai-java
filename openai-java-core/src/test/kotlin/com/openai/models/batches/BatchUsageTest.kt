// File generated from our OpenAPI spec by Stainless.

package com.openai.models.batches

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchUsageTest {

    @Test
    fun create() {
        val batchUsage =
            BatchUsage.builder()
                .inputTokens(0L)
                .inputTokensDetails(
                    BatchUsage.InputTokensDetails.builder().cachedTokens(0L).build()
                )
                .outputTokens(0L)
                .outputTokensDetails(
                    BatchUsage.OutputTokensDetails.builder().reasoningTokens(0L).build()
                )
                .totalTokens(0L)
                .build()

        assertThat(batchUsage.inputTokens()).isEqualTo(0L)
        assertThat(batchUsage.inputTokensDetails())
            .isEqualTo(BatchUsage.InputTokensDetails.builder().cachedTokens(0L).build())
        assertThat(batchUsage.outputTokens()).isEqualTo(0L)
        assertThat(batchUsage.outputTokensDetails())
            .isEqualTo(BatchUsage.OutputTokensDetails.builder().reasoningTokens(0L).build())
        assertThat(batchUsage.totalTokens()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val batchUsage =
            BatchUsage.builder()
                .inputTokens(0L)
                .inputTokensDetails(
                    BatchUsage.InputTokensDetails.builder().cachedTokens(0L).build()
                )
                .outputTokens(0L)
                .outputTokensDetails(
                    BatchUsage.OutputTokensDetails.builder().reasoningTokens(0L).build()
                )
                .totalTokens(0L)
                .build()

        val roundtrippedBatchUsage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(batchUsage),
                jacksonTypeRef<BatchUsage>(),
            )

        assertThat(roundtrippedBatchUsage).isEqualTo(batchUsage)
    }
}
