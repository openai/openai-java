// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseTextConfigTest {

    @Test
    fun create() {
        val betaResponseTextConfig =
            BetaResponseTextConfig.builder()
                .formatText()
                .verbosity(BetaResponseTextConfig.Verbosity.LOW)
                .build()

        assertThat(betaResponseTextConfig.format()).contains(BetaResponseFormatTextConfig.ofText())
        assertThat(betaResponseTextConfig.verbosity())
            .contains(BetaResponseTextConfig.Verbosity.LOW)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseTextConfig =
            BetaResponseTextConfig.builder()
                .formatText()
                .verbosity(BetaResponseTextConfig.Verbosity.LOW)
                .build()

        val roundtrippedBetaResponseTextConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseTextConfig),
                jacksonTypeRef<BetaResponseTextConfig>(),
            )

        assertThat(roundtrippedBetaResponseTextConfig).isEqualTo(betaResponseTextConfig)
    }
}
