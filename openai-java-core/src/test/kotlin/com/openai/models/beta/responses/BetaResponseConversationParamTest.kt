// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseConversationParamTest {

    @Test
    fun createAndRoundtrip() {
        val betaResponseConversationParam =
            BetaResponseConversationParam.builder().id("conv_123").build()

        assertThat(betaResponseConversationParam.id()).isEqualTo("conv_123")

        val jsonMapper = jsonMapper()

        val roundtrippedBetaResponseConversationParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseConversationParam),
                jacksonTypeRef<BetaResponseConversationParam>(),
            )

        assertThat(roundtrippedBetaResponseConversationParam)
            .isEqualTo(betaResponseConversationParam)
    }
}
