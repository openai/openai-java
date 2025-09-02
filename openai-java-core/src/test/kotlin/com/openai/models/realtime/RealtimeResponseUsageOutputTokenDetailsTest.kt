// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeResponseUsageOutputTokenDetailsTest {

    @Test
    fun create() {
        val realtimeResponseUsageOutputTokenDetails =
            RealtimeResponseUsageOutputTokenDetails.builder().audioTokens(0L).textTokens(0L).build()

        assertThat(realtimeResponseUsageOutputTokenDetails.audioTokens()).contains(0L)
        assertThat(realtimeResponseUsageOutputTokenDetails.textTokens()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeResponseUsageOutputTokenDetails =
            RealtimeResponseUsageOutputTokenDetails.builder().audioTokens(0L).textTokens(0L).build()

        val roundtrippedRealtimeResponseUsageOutputTokenDetails =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeResponseUsageOutputTokenDetails),
                jacksonTypeRef<RealtimeResponseUsageOutputTokenDetails>(),
            )

        assertThat(roundtrippedRealtimeResponseUsageOutputTokenDetails)
            .isEqualTo(realtimeResponseUsageOutputTokenDetails)
    }
}
