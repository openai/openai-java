// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeTruncationRetentionRatioTest {

    @Test
    fun create() {
        val realtimeTruncationRetentionRatio =
            RealtimeTruncationRetentionRatio.builder().retentionRatio(0.0).build()

        assertThat(realtimeTruncationRetentionRatio.retentionRatio()).isEqualTo(0.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTruncationRetentionRatio =
            RealtimeTruncationRetentionRatio.builder().retentionRatio(0.0).build()

        val roundtrippedRealtimeTruncationRetentionRatio =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTruncationRetentionRatio),
                jacksonTypeRef<RealtimeTruncationRetentionRatio>(),
            )

        assertThat(roundtrippedRealtimeTruncationRetentionRatio)
            .isEqualTo(realtimeTruncationRetentionRatio)
    }
}
