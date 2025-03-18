// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ReasoningTest {

    @Test
    fun create() {
        val reasoning =
            Reasoning.builder()
                .effort(ReasoningEffort.LOW)
                .generateSummary(Reasoning.GenerateSummary.CONCISE)
                .build()

        assertThat(reasoning.effort()).contains(ReasoningEffort.LOW)
        assertThat(reasoning.generateSummary()).contains(Reasoning.GenerateSummary.CONCISE)
    }
}
