// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseConversationParamTest {

    @Test
    fun create() {
        val betaResponseConversationParam =
            BetaResponseConversationParam.builder().id("conv_123").build()

        assertThat(betaResponseConversationParam.id()).isEqualTo("conv_123")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseConversationParam =
            BetaResponseConversationParam.builder().id("conv_123").build()

        val roundtrippedBetaResponseConversationParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseConversationParam),
                jacksonTypeRef<BetaResponseConversationParam>(),
            )

        assertThat(roundtrippedBetaResponseConversationParam)
            .isEqualTo(betaResponseConversationParam)
    }
}
