// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ReasoningTest {

    @Test
    fun createAndRoundtrip() {
        val reasoning =
            Reasoning.builder()
                .context(Reasoning.Context.AUTO)
                .effort(ReasoningEffort.NONE)
                .generateSummary(Reasoning.GenerateSummary.AUTO)
                .mode(Reasoning.Mode.STANDARD)
                .summary(Reasoning.Summary.AUTO)
                .build()

        assertThat(reasoning.context()).contains(Reasoning.Context.AUTO)
        assertThat(reasoning.effort()).contains(ReasoningEffort.NONE)
        assertThat(reasoning.generateSummary()).contains(Reasoning.GenerateSummary.AUTO)
        assertThat(reasoning.mode()).contains(Reasoning.Mode.STANDARD)
        assertThat(reasoning.summary()).contains(Reasoning.Summary.AUTO)

        val jsonMapper = jsonMapper()

        val roundtrippedReasoning =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(reasoning),
                jacksonTypeRef<Reasoning>(),
            )

        assertThat(roundtrippedReasoning).isEqualTo(reasoning)
    }
}
