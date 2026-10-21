// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.decisions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionPromptCacheBreakpointTest {

    @Test
    fun createAndRoundtrip() {
        val decisionPromptCacheBreakpoint = DecisionPromptCacheBreakpoint.builder().build()

        val jsonMapper = jsonMapper()

        val roundtrippedDecisionPromptCacheBreakpoint =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionPromptCacheBreakpoint),
                jacksonTypeRef<DecisionPromptCacheBreakpoint>(),
            )

        assertThat(roundtrippedDecisionPromptCacheBreakpoint)
            .isEqualTo(decisionPromptCacheBreakpoint)
    }
}
