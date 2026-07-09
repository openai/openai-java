// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaEasyInputMessageTest {

    @Test
    fun create() {
        val betaEasyInputMessage =
            BetaEasyInputMessage.builder()
                .content("string")
                .role(BetaEasyInputMessage.Role.USER)
                .phase(BetaEasyInputMessage.Phase.COMMENTARY)
                .type(BetaEasyInputMessage.Type.MESSAGE)
                .build()

        assertThat(betaEasyInputMessage.content())
            .isEqualTo(BetaEasyInputMessage.Content.ofTextInput("string"))
        assertThat(betaEasyInputMessage.role()).isEqualTo(BetaEasyInputMessage.Role.USER)
        assertThat(betaEasyInputMessage.phase()).contains(BetaEasyInputMessage.Phase.COMMENTARY)
        assertThat(betaEasyInputMessage.type()).contains(BetaEasyInputMessage.Type.MESSAGE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaEasyInputMessage =
            BetaEasyInputMessage.builder()
                .content("string")
                .role(BetaEasyInputMessage.Role.USER)
                .phase(BetaEasyInputMessage.Phase.COMMENTARY)
                .type(BetaEasyInputMessage.Type.MESSAGE)
                .build()

        val roundtrippedBetaEasyInputMessage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaEasyInputMessage),
                jacksonTypeRef<BetaEasyInputMessage>(),
            )

        assertThat(roundtrippedBetaEasyInputMessage).isEqualTo(betaEasyInputMessage)
    }
}
