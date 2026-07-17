// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseInputTextContentTest {

    @Test
    fun create() {
        val betaResponseInputTextContent =
            BetaResponseInputTextContent.builder()
                .text("text")
                .promptCacheBreakpoint(
                    BetaResponseInputTextContent.PromptCacheBreakpoint.builder().build()
                )
                .build()

        assertThat(betaResponseInputTextContent.text()).isEqualTo("text")
        assertThat(betaResponseInputTextContent.promptCacheBreakpoint())
            .contains(BetaResponseInputTextContent.PromptCacheBreakpoint.builder().build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputTextContent =
            BetaResponseInputTextContent.builder()
                .text("text")
                .promptCacheBreakpoint(
                    BetaResponseInputTextContent.PromptCacheBreakpoint.builder().build()
                )
                .build()

        val roundtrippedBetaResponseInputTextContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputTextContent),
                jacksonTypeRef<BetaResponseInputTextContent>(),
            )

        assertThat(roundtrippedBetaResponseInputTextContent).isEqualTo(betaResponseInputTextContent)
    }
}
