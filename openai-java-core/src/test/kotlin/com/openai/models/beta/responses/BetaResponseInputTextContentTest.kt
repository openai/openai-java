// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.PromptCacheBreakpointTtl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseInputTextContentTest {

    @Test
    fun createAndRoundtrip() {
        val betaResponseInputTextContent =
            BetaResponseInputTextContent.builder()
                .text("text")
                .promptCacheBreakpoint(
                    BetaResponseInputTextContent.PromptCacheBreakpoint.builder()
                        .ttl(PromptCacheBreakpointTtl._30M)
                        .build()
                )
                .build()

        assertThat(betaResponseInputTextContent.text()).isEqualTo("text")
        assertThat(betaResponseInputTextContent.promptCacheBreakpoint())
            .contains(
                BetaResponseInputTextContent.PromptCacheBreakpoint.builder()
                    .ttl(PromptCacheBreakpointTtl._30M)
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedBetaResponseInputTextContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputTextContent),
                jacksonTypeRef<BetaResponseInputTextContent>(),
            )

        assertThat(roundtrippedBetaResponseInputTextContent).isEqualTo(betaResponseInputTextContent)
    }
}
