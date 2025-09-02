// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class RealtimeTruncationTest {

    @Test
    fun ofStrategy() {
        val strategy = RealtimeTruncation.RealtimeTruncationStrategy.AUTO

        val realtimeTruncation = RealtimeTruncation.ofStrategy(strategy)

        assertThat(realtimeTruncation.strategy()).contains(strategy)
        assertThat(realtimeTruncation.retentionRatio()).isEmpty
    }

    @Test
    fun ofStrategyRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTruncation =
            RealtimeTruncation.ofStrategy(RealtimeTruncation.RealtimeTruncationStrategy.AUTO)

        val roundtrippedRealtimeTruncation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTruncation),
                jacksonTypeRef<RealtimeTruncation>(),
            )

        assertThat(roundtrippedRealtimeTruncation).isEqualTo(realtimeTruncation)
    }

    @Test
    fun ofRetentionRatio() {
        val retentionRatio =
            RealtimeTruncation.RetentionRatioTruncation.builder()
                .retentionRatio(0.0)
                .postInstructionsTokenLimit(0L)
                .build()

        val realtimeTruncation = RealtimeTruncation.ofRetentionRatio(retentionRatio)

        assertThat(realtimeTruncation.strategy()).isEmpty
        assertThat(realtimeTruncation.retentionRatio()).contains(retentionRatio)
    }

    @Test
    fun ofRetentionRatioRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTruncation =
            RealtimeTruncation.ofRetentionRatio(
                RealtimeTruncation.RetentionRatioTruncation.builder()
                    .retentionRatio(0.0)
                    .postInstructionsTokenLimit(0L)
                    .build()
            )

        val roundtrippedRealtimeTruncation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTruncation),
                jacksonTypeRef<RealtimeTruncation>(),
            )

        assertThat(roundtrippedRealtimeTruncation).isEqualTo(realtimeTruncation)
    }

    @Test
    fun incompatibleJsonShapeDeserializesToUnknown() {
        val value = JsonValue.from(listOf("invalid", "array"))
        val realtimeTruncation =
            jsonMapper().convertValue(value, jacksonTypeRef<RealtimeTruncation>())

        val e = assertThrows<OpenAIInvalidDataException> { realtimeTruncation.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
