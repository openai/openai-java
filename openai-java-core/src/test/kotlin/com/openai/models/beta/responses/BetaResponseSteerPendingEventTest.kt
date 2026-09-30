// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseSteerPendingEventTest {

    @Test
    fun create() {
        val betaResponseSteerPendingEvent =
            BetaResponseSteerPendingEvent.builder()
                .reason(BetaResponseSteerPendingReason.WAITING_FOR_REQUIRED_INPUT)
                .addRequiredInput(
                    BetaResponseSteerRequiredInput.FunctionCallOutput.builder()
                        .callId("call_id")
                        .name("name")
                        .build()
                )
                .sequenceNumber(0L)
                .steer(
                    BetaResponseSteerPendingEvent.Steer.builder()
                        .id("id")
                        .previousResponseId("previous_response_id")
                        .build()
                )
                .streamId("stream_id")
                .build()

        assertThat(betaResponseSteerPendingEvent.reason())
            .isEqualTo(BetaResponseSteerPendingReason.WAITING_FOR_REQUIRED_INPUT)
        assertThat(betaResponseSteerPendingEvent.requiredInput())
            .containsExactly(
                BetaResponseSteerRequiredInput.ofFunctionCallOutput(
                    BetaResponseSteerRequiredInput.FunctionCallOutput.builder()
                        .callId("call_id")
                        .name("name")
                        .build()
                )
            )
        assertThat(betaResponseSteerPendingEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseSteerPendingEvent.steer())
            .isEqualTo(
                BetaResponseSteerPendingEvent.Steer.builder()
                    .id("id")
                    .previousResponseId("previous_response_id")
                    .build()
            )
        assertThat(betaResponseSteerPendingEvent.streamId()).contains("stream_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseSteerPendingEvent =
            BetaResponseSteerPendingEvent.builder()
                .reason(BetaResponseSteerPendingReason.WAITING_FOR_REQUIRED_INPUT)
                .addRequiredInput(
                    BetaResponseSteerRequiredInput.FunctionCallOutput.builder()
                        .callId("call_id")
                        .name("name")
                        .build()
                )
                .sequenceNumber(0L)
                .steer(
                    BetaResponseSteerPendingEvent.Steer.builder()
                        .id("id")
                        .previousResponseId("previous_response_id")
                        .build()
                )
                .streamId("stream_id")
                .build()

        val roundtrippedBetaResponseSteerPendingEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseSteerPendingEvent),
                jacksonTypeRef<BetaResponseSteerPendingEvent>(),
            )

        assertThat(roundtrippedBetaResponseSteerPendingEvent)
            .isEqualTo(betaResponseSteerPendingEvent)
    }
}
