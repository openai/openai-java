// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeResponseUsageTest {

    @Test
    fun create() {
        val realtimeResponseUsage =
            RealtimeResponseUsage.builder()
                .inputTokenDetails(
                    RealtimeResponseUsageInputTokenDetails.builder()
                        .audioTokens(0L)
                        .cachedTokens(0L)
                        .cachedTokensDetails(
                            RealtimeResponseUsageInputTokenDetails.CachedTokensDetails.builder()
                                .audioTokens(0L)
                                .imageTokens(0L)
                                .textTokens(0L)
                                .build()
                        )
                        .imageTokens(0L)
                        .textTokens(0L)
                        .build()
                )
                .inputTokens(0L)
                .outputTokenDetails(
                    RealtimeResponseUsageOutputTokenDetails.builder()
                        .audioTokens(0L)
                        .textTokens(0L)
                        .build()
                )
                .outputTokens(0L)
                .totalTokens(0L)
                .build()

        assertThat(realtimeResponseUsage.inputTokenDetails())
            .contains(
                RealtimeResponseUsageInputTokenDetails.builder()
                    .audioTokens(0L)
                    .cachedTokens(0L)
                    .cachedTokensDetails(
                        RealtimeResponseUsageInputTokenDetails.CachedTokensDetails.builder()
                            .audioTokens(0L)
                            .imageTokens(0L)
                            .textTokens(0L)
                            .build()
                    )
                    .imageTokens(0L)
                    .textTokens(0L)
                    .build()
            )
        assertThat(realtimeResponseUsage.inputTokens()).contains(0L)
        assertThat(realtimeResponseUsage.outputTokenDetails())
            .contains(
                RealtimeResponseUsageOutputTokenDetails.builder()
                    .audioTokens(0L)
                    .textTokens(0L)
                    .build()
            )
        assertThat(realtimeResponseUsage.outputTokens()).contains(0L)
        assertThat(realtimeResponseUsage.totalTokens()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeResponseUsage =
            RealtimeResponseUsage.builder()
                .inputTokenDetails(
                    RealtimeResponseUsageInputTokenDetails.builder()
                        .audioTokens(0L)
                        .cachedTokens(0L)
                        .cachedTokensDetails(
                            RealtimeResponseUsageInputTokenDetails.CachedTokensDetails.builder()
                                .audioTokens(0L)
                                .imageTokens(0L)
                                .textTokens(0L)
                                .build()
                        )
                        .imageTokens(0L)
                        .textTokens(0L)
                        .build()
                )
                .inputTokens(0L)
                .outputTokenDetails(
                    RealtimeResponseUsageOutputTokenDetails.builder()
                        .audioTokens(0L)
                        .textTokens(0L)
                        .build()
                )
                .outputTokens(0L)
                .totalTokens(0L)
                .build()

        val roundtrippedRealtimeResponseUsage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeResponseUsage),
                jacksonTypeRef<RealtimeResponseUsage>(),
            )

        assertThat(roundtrippedRealtimeResponseUsage).isEqualTo(realtimeResponseUsage)
    }
}
