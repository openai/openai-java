// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaToolChoiceTypesTest {

    @Test
    fun create() {
        val betaToolChoiceTypes =
            BetaToolChoiceTypes.builder().type(BetaToolChoiceTypes.Type.FILE_SEARCH).build()

        assertThat(betaToolChoiceTypes.type()).isEqualTo(BetaToolChoiceTypes.Type.FILE_SEARCH)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaToolChoiceTypes =
            BetaToolChoiceTypes.builder().type(BetaToolChoiceTypes.Type.FILE_SEARCH).build()

        val roundtrippedBetaToolChoiceTypes =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaToolChoiceTypes),
                jacksonTypeRef<BetaToolChoiceTypes>(),
            )

        assertThat(roundtrippedBetaToolChoiceTypes).isEqualTo(betaToolChoiceTypes)
    }
}
