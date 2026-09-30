// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseSteerAcceptedEventTest {

    @Test
    fun create() {
        val betaResponseSteerAcceptedEvent =
            BetaResponseSteerAcceptedEvent.builder()
                .sequenceNumber(0L)
                .steer(
                    BetaResponseSteerAcceptedEvent.Steer.builder()
                        .id("id")
                        .previousResponseId("previous_response_id")
                        .build()
                )
                .streamId("stream_id")
                .build()

        assertThat(betaResponseSteerAcceptedEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseSteerAcceptedEvent.steer())
            .isEqualTo(
                BetaResponseSteerAcceptedEvent.Steer.builder()
                    .id("id")
                    .previousResponseId("previous_response_id")
                    .build()
            )
        assertThat(betaResponseSteerAcceptedEvent.streamId()).contains("stream_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseSteerAcceptedEvent =
            BetaResponseSteerAcceptedEvent.builder()
                .sequenceNumber(0L)
                .steer(
                    BetaResponseSteerAcceptedEvent.Steer.builder()
                        .id("id")
                        .previousResponseId("previous_response_id")
                        .build()
                )
                .streamId("stream_id")
                .build()

        val roundtrippedBetaResponseSteerAcceptedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseSteerAcceptedEvent),
                jacksonTypeRef<BetaResponseSteerAcceptedEvent>(),
            )

        assertThat(roundtrippedBetaResponseSteerAcceptedEvent)
            .isEqualTo(betaResponseSteerAcceptedEvent)
    }
}
