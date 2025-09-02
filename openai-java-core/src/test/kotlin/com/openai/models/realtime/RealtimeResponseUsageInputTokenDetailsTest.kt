// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeResponseUsageInputTokenDetailsTest {

    @Test
    fun create() {
        val realtimeResponseUsageInputTokenDetails =
            RealtimeResponseUsageInputTokenDetails.builder()
                .audioTokens(0L)
                .cachedTokens(0L)
                .textTokens(0L)
                .build()

        assertThat(realtimeResponseUsageInputTokenDetails.audioTokens()).contains(0L)
        assertThat(realtimeResponseUsageInputTokenDetails.cachedTokens()).contains(0L)
        assertThat(realtimeResponseUsageInputTokenDetails.textTokens()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeResponseUsageInputTokenDetails =
            RealtimeResponseUsageInputTokenDetails.builder()
                .audioTokens(0L)
                .cachedTokens(0L)
                .textTokens(0L)
                .build()

        val roundtrippedRealtimeResponseUsageInputTokenDetails =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeResponseUsageInputTokenDetails),
                jacksonTypeRef<RealtimeResponseUsageInputTokenDetails>(),
            )

        assertThat(roundtrippedRealtimeResponseUsageInputTokenDetails)
            .isEqualTo(realtimeResponseUsageInputTokenDetails)
    }
}
