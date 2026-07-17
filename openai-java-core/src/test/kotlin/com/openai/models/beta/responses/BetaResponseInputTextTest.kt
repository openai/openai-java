// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseInputTextTest {

    @Test
    fun create() {
        val betaResponseInputText =
            BetaResponseInputText.builder()
                .text("text")
                .promptCacheBreakpoint(
                    BetaResponseInputText.PromptCacheBreakpoint.builder().build()
                )
                .build()

        assertThat(betaResponseInputText.text()).isEqualTo("text")
        assertThat(betaResponseInputText.promptCacheBreakpoint())
            .contains(BetaResponseInputText.PromptCacheBreakpoint.builder().build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputText =
            BetaResponseInputText.builder()
                .text("text")
                .promptCacheBreakpoint(
                    BetaResponseInputText.PromptCacheBreakpoint.builder().build()
                )
                .build()

        val roundtrippedBetaResponseInputText =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputText),
                jacksonTypeRef<BetaResponseInputText>(),
            )

        assertThat(roundtrippedBetaResponseInputText).isEqualTo(betaResponseInputText)
    }
}
