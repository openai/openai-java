// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeReasoningTest {

    @Test
    fun createAndRoundtrip() {
        val realtimeReasoning =
            RealtimeReasoning.builder().effort(RealtimeReasoningEffort.MINIMAL).build()

        assertThat(realtimeReasoning.effort()).contains(RealtimeReasoningEffort.MINIMAL)

        val jsonMapper = jsonMapper()

        val roundtrippedRealtimeReasoning =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeReasoning),
                jacksonTypeRef<RealtimeReasoning>(),
            )

        assertThat(roundtrippedRealtimeReasoning).isEqualTo(realtimeReasoning)
    }
}
