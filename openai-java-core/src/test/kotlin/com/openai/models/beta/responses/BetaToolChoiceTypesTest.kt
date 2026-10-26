// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaToolChoiceTypesTest {

    @Test
    fun createAndRoundtrip() {
        val betaToolChoiceTypes =
            BetaToolChoiceTypes.builder().type(BetaToolChoiceTypes.Type.FILE_SEARCH).build()

        assertThat(betaToolChoiceTypes.type()).isEqualTo(BetaToolChoiceTypes.Type.FILE_SEARCH)

        val jsonMapper = jsonMapper()

        val roundtrippedBetaToolChoiceTypes =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaToolChoiceTypes),
                jacksonTypeRef<BetaToolChoiceTypes>(),
            )

        assertThat(roundtrippedBetaToolChoiceTypes).isEqualTo(betaToolChoiceTypes)
    }
}
