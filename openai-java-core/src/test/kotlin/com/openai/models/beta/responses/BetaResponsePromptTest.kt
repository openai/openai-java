// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponsePromptTest {

    @Test
    fun create() {
        val betaResponsePrompt =
            BetaResponsePrompt.builder()
                .id("id")
                .variables(
                    BetaResponsePrompt.Variables.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .version("version")
                .build()

        assertThat(betaResponsePrompt.id()).isEqualTo("id")
        assertThat(betaResponsePrompt.variables())
            .contains(
                BetaResponsePrompt.Variables.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(betaResponsePrompt.version()).contains("version")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponsePrompt =
            BetaResponsePrompt.builder()
                .id("id")
                .variables(
                    BetaResponsePrompt.Variables.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .version("version")
                .build()

        val roundtrippedBetaResponsePrompt =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponsePrompt),
                jacksonTypeRef<BetaResponsePrompt>(),
            )

        assertThat(roundtrippedBetaResponsePrompt).isEqualTo(betaResponsePrompt)
    }
}
