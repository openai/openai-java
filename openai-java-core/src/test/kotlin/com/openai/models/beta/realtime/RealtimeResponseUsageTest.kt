// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

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
                    RealtimeResponseUsage.InputTokenDetails.builder()
                        .audioTokens(0L)
                        .cachedTokens(0L)
                        .textTokens(0L)
                        .build()
                )
                .inputTokens(0L)
                .outputTokenDetails(
                    RealtimeResponseUsage.OutputTokenDetails.builder()
                        .audioTokens(0L)
                        .textTokens(0L)
                        .build()
                )
                .outputTokens(0L)
                .totalTokens(0L)
                .build()

        assertThat(realtimeResponseUsage.inputTokenDetails())
            .contains(
                RealtimeResponseUsage.InputTokenDetails.builder()
                    .audioTokens(0L)
                    .cachedTokens(0L)
                    .textTokens(0L)
                    .build()
            )
        assertThat(realtimeResponseUsage.inputTokens()).contains(0L)
        assertThat(realtimeResponseUsage.outputTokenDetails())
            .contains(
                RealtimeResponseUsage.OutputTokenDetails.builder()
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
                    RealtimeResponseUsage.InputTokenDetails.builder()
                        .audioTokens(0L)
                        .cachedTokens(0L)
                        .textTokens(0L)
                        .build()
                )
                .inputTokens(0L)
                .outputTokenDetails(
                    RealtimeResponseUsage.OutputTokenDetails.builder()
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
