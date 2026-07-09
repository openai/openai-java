// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaToolChoiceShellTest {

    @Test
    fun create() {
        val betaToolChoiceShell = BetaToolChoiceShell.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaToolChoiceShell = BetaToolChoiceShell.builder().build()

        val roundtrippedBetaToolChoiceShell =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaToolChoiceShell),
                jacksonTypeRef<BetaToolChoiceShell>(),
            )

        assertThat(roundtrippedBetaToolChoiceShell).isEqualTo(betaToolChoiceShell)
    }
}
