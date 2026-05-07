// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeReasoningTest {

    @Test
    fun create() {
        val realtimeReasoning =
            RealtimeReasoning.builder().effort(RealtimeReasoningEffort.MINIMAL).build()

        assertThat(realtimeReasoning.effort()).contains(RealtimeReasoningEffort.MINIMAL)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeReasoning =
            RealtimeReasoning.builder().effort(RealtimeReasoningEffort.MINIMAL).build()

        val roundtrippedRealtimeReasoning =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeReasoning),
                jacksonTypeRef<RealtimeReasoning>(),
            )

        assertThat(roundtrippedRealtimeReasoning).isEqualTo(realtimeReasoning)
    }
}
