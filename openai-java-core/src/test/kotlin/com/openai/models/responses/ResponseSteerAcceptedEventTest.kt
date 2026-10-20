// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseSteerAcceptedEventTest {

    @Test
    fun create() {
        val responseSteerAcceptedEvent =
            ResponseSteerAcceptedEvent.builder()
                .sequenceNumber(0L)
                .steer(
                    ResponseSteerAcceptedEvent.Steer.builder()
                        .id("id")
                        .previousResponseId("previous_response_id")
                        .build()
                )
                .streamId("stream_id")
                .build()

        assertThat(responseSteerAcceptedEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(responseSteerAcceptedEvent.steer())
            .isEqualTo(
                ResponseSteerAcceptedEvent.Steer.builder()
                    .id("id")
                    .previousResponseId("previous_response_id")
                    .build()
            )
        assertThat(responseSteerAcceptedEvent.streamId()).contains("stream_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseSteerAcceptedEvent =
            ResponseSteerAcceptedEvent.builder()
                .sequenceNumber(0L)
                .steer(
                    ResponseSteerAcceptedEvent.Steer.builder()
                        .id("id")
                        .previousResponseId("previous_response_id")
                        .build()
                )
                .streamId("stream_id")
                .build()

        val roundtrippedResponseSteerAcceptedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseSteerAcceptedEvent),
                jacksonTypeRef<ResponseSteerAcceptedEvent>(),
            )

        assertThat(roundtrippedResponseSteerAcceptedEvent).isEqualTo(responseSteerAcceptedEvent)
    }
}
