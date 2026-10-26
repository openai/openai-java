// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaToolChoiceCustomTest {

    @Test
    fun createAndRoundtrip() {
        val betaToolChoiceCustom = BetaToolChoiceCustom.builder().name("name").build()

        assertThat(betaToolChoiceCustom.name()).isEqualTo("name")

        val jsonMapper = jsonMapper()

        val roundtrippedBetaToolChoiceCustom =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaToolChoiceCustom),
                jacksonTypeRef<BetaToolChoiceCustom>(),
            )

        assertThat(roundtrippedBetaToolChoiceCustom).isEqualTo(betaToolChoiceCustom)
    }
}
