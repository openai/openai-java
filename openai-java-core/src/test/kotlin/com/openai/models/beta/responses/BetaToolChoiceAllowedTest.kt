// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaToolChoiceAllowedTest {

    @Test
    fun createAndRoundtrip() {
        val betaToolChoiceAllowed =
            BetaToolChoiceAllowed.builder()
                .mode(BetaToolChoiceAllowed.Mode.AUTO)
                .addTool(
                    BetaToolChoiceAllowed.Tool.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        assertThat(betaToolChoiceAllowed.mode()).isEqualTo(BetaToolChoiceAllowed.Mode.AUTO)
        assertThat(betaToolChoiceAllowed.tools())
            .containsExactly(
                BetaToolChoiceAllowed.Tool.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedBetaToolChoiceAllowed =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaToolChoiceAllowed),
                jacksonTypeRef<BetaToolChoiceAllowed>(),
            )

        assertThat(roundtrippedBetaToolChoiceAllowed).isEqualTo(betaToolChoiceAllowed)
    }
}
