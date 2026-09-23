// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseSteerPendingEventTest {

    @Test
    fun create() {
        val responseSteerPendingEvent =
            ResponseSteerPendingEvent.builder()
                .reason(ResponseSteerPendingReason.WAITING_FOR_REQUIRED_INPUT)
                .addRequiredInput(
                    ResponseSteerRequiredInput.FunctionCallOutput.builder()
                        .callId("call_id")
                        .name("name")
                        .build()
                )
                .sequenceNumber(0L)
                .steer(
                    ResponseSteerPendingEvent.Steer.builder()
                        .id("id")
                        .previousResponseId("previous_response_id")
                        .build()
                )
                .streamId("stream_id")
                .build()

        assertThat(responseSteerPendingEvent.reason())
            .isEqualTo(ResponseSteerPendingReason.WAITING_FOR_REQUIRED_INPUT)
        assertThat(responseSteerPendingEvent.requiredInput())
            .containsExactly(
                ResponseSteerRequiredInput.ofFunctionCallOutput(
                    ResponseSteerRequiredInput.FunctionCallOutput.builder()
                        .callId("call_id")
                        .name("name")
                        .build()
                )
            )
        assertThat(responseSteerPendingEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(responseSteerPendingEvent.steer())
            .isEqualTo(
                ResponseSteerPendingEvent.Steer.builder()
                    .id("id")
                    .previousResponseId("previous_response_id")
                    .build()
            )
        assertThat(responseSteerPendingEvent.streamId()).contains("stream_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseSteerPendingEvent =
            ResponseSteerPendingEvent.builder()
                .reason(ResponseSteerPendingReason.WAITING_FOR_REQUIRED_INPUT)
                .addRequiredInput(
                    ResponseSteerRequiredInput.FunctionCallOutput.builder()
                        .callId("call_id")
                        .name("name")
                        .build()
                )
                .sequenceNumber(0L)
                .steer(
                    ResponseSteerPendingEvent.Steer.builder()
                        .id("id")
                        .previousResponseId("previous_response_id")
                        .build()
                )
                .streamId("stream_id")
                .build()

        val roundtrippedResponseSteerPendingEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseSteerPendingEvent),
                jacksonTypeRef<ResponseSteerPendingEvent>(),
            )

        assertThat(roundtrippedResponseSteerPendingEvent).isEqualTo(responseSteerPendingEvent)
    }
}
