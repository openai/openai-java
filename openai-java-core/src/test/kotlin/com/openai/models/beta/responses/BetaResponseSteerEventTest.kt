// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseSteerEventTest {

    @Test
    fun create() {
        val betaResponseSteerEvent =
            BetaResponseSteerEvent.builder()
                .input("string")
                .previousResponseId("previous_response_id")
                .build()

        assertThat(betaResponseSteerEvent.input())
            .isEqualTo(BetaResponseSteerInput.ofText("string"))
        assertThat(betaResponseSteerEvent.previousResponseId()).isEqualTo("previous_response_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseSteerEvent =
            BetaResponseSteerEvent.builder()
                .input("string")
                .previousResponseId("previous_response_id")
                .build()

        val roundtrippedBetaResponseSteerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseSteerEvent),
                jacksonTypeRef<BetaResponseSteerEvent>(),
            )

        assertThat(roundtrippedBetaResponseSteerEvent).isEqualTo(betaResponseSteerEvent)
    }
}
