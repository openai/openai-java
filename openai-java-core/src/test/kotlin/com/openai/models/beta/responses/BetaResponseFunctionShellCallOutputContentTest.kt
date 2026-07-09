// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseFunctionShellCallOutputContentTest {

    @Test
    fun create() {
        val betaResponseFunctionShellCallOutputContent =
            BetaResponseFunctionShellCallOutputContent.builder()
                .outcomeTimeout()
                .stderr("stderr")
                .stdout("stdout")
                .build()

        assertThat(betaResponseFunctionShellCallOutputContent.outcome())
            .isEqualTo(BetaResponseFunctionShellCallOutputContent.Outcome.ofTimeout())
        assertThat(betaResponseFunctionShellCallOutputContent.stderr()).isEqualTo("stderr")
        assertThat(betaResponseFunctionShellCallOutputContent.stdout()).isEqualTo("stdout")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseFunctionShellCallOutputContent =
            BetaResponseFunctionShellCallOutputContent.builder()
                .outcomeTimeout()
                .stderr("stderr")
                .stdout("stdout")
                .build()

        val roundtrippedBetaResponseFunctionShellCallOutputContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseFunctionShellCallOutputContent),
                jacksonTypeRef<BetaResponseFunctionShellCallOutputContent>(),
            )

        assertThat(roundtrippedBetaResponseFunctionShellCallOutputContent)
            .isEqualTo(betaResponseFunctionShellCallOutputContent)
    }
}
