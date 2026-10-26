// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaToolChoiceShellTest {

    @Test
    fun createAndRoundtrip() {
        val betaToolChoiceShell = BetaToolChoiceShell.builder().build()

        val jsonMapper = jsonMapper()

        val roundtrippedBetaToolChoiceShell =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaToolChoiceShell),
                jacksonTypeRef<BetaToolChoiceShell>(),
            )

        assertThat(roundtrippedBetaToolChoiceShell).isEqualTo(betaToolChoiceShell)
    }
}
