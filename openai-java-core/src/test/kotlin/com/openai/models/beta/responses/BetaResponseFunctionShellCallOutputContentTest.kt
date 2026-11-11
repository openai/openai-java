// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseFunctionShellCallOutputContentTest {

    @Test
    fun createAndRoundtrip() {
        val betaResponseFunctionShellCallOutputContent =
            BetaResponseFunctionShellCallOutputContent.builder()
                .outcomeTimeout()
                .stderr("stderr")
                .stdout("stdout")
                .build()

        assertThat(betaResponseFunctionShellCallOutputContent.outcome())
            .contains(BetaResponseFunctionShellCallOutputContent.Outcome.ofTimeout())
        assertThat(betaResponseFunctionShellCallOutputContent.stderr()).contains("stderr")
        assertThat(betaResponseFunctionShellCallOutputContent.stdout()).contains("stdout")

        val jsonMapper = jsonMapper()

        val roundtrippedBetaResponseFunctionShellCallOutputContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseFunctionShellCallOutputContent),
                jacksonTypeRef<BetaResponseFunctionShellCallOutputContent>(),
            )

        assertThat(roundtrippedBetaResponseFunctionShellCallOutputContent)
            .isEqualTo(betaResponseFunctionShellCallOutputContent)
    }
}
