// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaToolChoiceFunctionTest {

    @Test
    fun create() {
        val betaToolChoiceFunction = BetaToolChoiceFunction.builder().name("name").build()

        assertThat(betaToolChoiceFunction.name()).isEqualTo("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaToolChoiceFunction = BetaToolChoiceFunction.builder().name("name").build()

        val roundtrippedBetaToolChoiceFunction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaToolChoiceFunction),
                jacksonTypeRef<BetaToolChoiceFunction>(),
            )

        assertThat(roundtrippedBetaToolChoiceFunction).isEqualTo(betaToolChoiceFunction)
    }
}
