// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseSteerFailedEventTest {

    @Test
    fun create() {
        val betaResponseSteerFailedEvent =
            BetaResponseSteerFailedEvent.builder()
                .error(
                    BetaResponseSteerFailedEvent.Error.builder()
                        .code(BetaResponseSteerErrorCode.RESPONSE_NOT_FOUND)
                        .message("message")
                        .build()
                )
                .sequenceNumber(0L)
                .steer(
                    BetaResponseSteerFailedEvent.Steer.builder()
                        .input("string")
                        .previousResponseId("previous_response_id")
                        .id("id")
                        .build()
                )
                .streamId("stream_id")
                .build()

        assertThat(betaResponseSteerFailedEvent.error())
            .isEqualTo(
                BetaResponseSteerFailedEvent.Error.builder()
                    .code(BetaResponseSteerErrorCode.RESPONSE_NOT_FOUND)
                    .message("message")
                    .build()
            )
        assertThat(betaResponseSteerFailedEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseSteerFailedEvent.steer())
            .isEqualTo(
                BetaResponseSteerFailedEvent.Steer.builder()
                    .input("string")
                    .previousResponseId("previous_response_id")
                    .id("id")
                    .build()
            )
        assertThat(betaResponseSteerFailedEvent.streamId()).contains("stream_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseSteerFailedEvent =
            BetaResponseSteerFailedEvent.builder()
                .error(
                    BetaResponseSteerFailedEvent.Error.builder()
                        .code(BetaResponseSteerErrorCode.RESPONSE_NOT_FOUND)
                        .message("message")
                        .build()
                )
                .sequenceNumber(0L)
                .steer(
                    BetaResponseSteerFailedEvent.Steer.builder()
                        .input("string")
                        .previousResponseId("previous_response_id")
                        .id("id")
                        .build()
                )
                .streamId("stream_id")
                .build()

        val roundtrippedBetaResponseSteerFailedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseSteerFailedEvent),
                jacksonTypeRef<BetaResponseSteerFailedEvent>(),
            )

        assertThat(roundtrippedBetaResponseSteerFailedEvent).isEqualTo(betaResponseSteerFailedEvent)
    }
}
