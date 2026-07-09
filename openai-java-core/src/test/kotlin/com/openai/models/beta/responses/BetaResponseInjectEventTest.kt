// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseInjectEventTest {

    @Test
    fun create() {
        val betaResponseInjectEvent =
            BetaResponseInjectEvent.builder()
                .addInput(
                    BetaEasyInputMessage.builder()
                        .content("string")
                        .role(BetaEasyInputMessage.Role.USER)
                        .phase(BetaEasyInputMessage.Phase.COMMENTARY)
                        .type(BetaEasyInputMessage.Type.MESSAGE)
                        .build()
                )
                .responseId("response_id")
                .build()

        assertThat(betaResponseInjectEvent.input())
            .containsExactly(
                BetaResponseInputItem.ofBetaEasyInputMessage(
                    BetaEasyInputMessage.builder()
                        .content("string")
                        .role(BetaEasyInputMessage.Role.USER)
                        .phase(BetaEasyInputMessage.Phase.COMMENTARY)
                        .type(BetaEasyInputMessage.Type.MESSAGE)
                        .build()
                )
            )
        assertThat(betaResponseInjectEvent.responseId()).isEqualTo("response_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInjectEvent =
            BetaResponseInjectEvent.builder()
                .addInput(
                    BetaEasyInputMessage.builder()
                        .content("string")
                        .role(BetaEasyInputMessage.Role.USER)
                        .phase(BetaEasyInputMessage.Phase.COMMENTARY)
                        .type(BetaEasyInputMessage.Type.MESSAGE)
                        .build()
                )
                .responseId("response_id")
                .build()

        val roundtrippedBetaResponseInjectEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInjectEvent),
                jacksonTypeRef<BetaResponseInjectEvent>(),
            )

        assertThat(roundtrippedBetaResponseInjectEvent).isEqualTo(betaResponseInjectEvent)
    }
}
