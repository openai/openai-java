// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseSteerFailedEventTest {

    @Test
    fun create() {
        val responseSteerFailedEvent =
            ResponseSteerFailedEvent.builder()
                .error(
                    ResponseSteerFailedEvent.Error.builder()
                        .code(ResponseSteerErrorCode.RESPONSE_NOT_FOUND)
                        .message("message")
                        .build()
                )
                .sequenceNumber(0L)
                .steer(
                    ResponseSteerFailedEvent.Steer.builder()
                        .input("string")
                        .previousResponseId("previous_response_id")
                        .id("id")
                        .build()
                )
                .streamId("stream_id")
                .build()

        assertThat(responseSteerFailedEvent.error())
            .isEqualTo(
                ResponseSteerFailedEvent.Error.builder()
                    .code(ResponseSteerErrorCode.RESPONSE_NOT_FOUND)
                    .message("message")
                    .build()
            )
        assertThat(responseSteerFailedEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(responseSteerFailedEvent.steer())
            .isEqualTo(
                ResponseSteerFailedEvent.Steer.builder()
                    .input("string")
                    .previousResponseId("previous_response_id")
                    .id("id")
                    .build()
            )
        assertThat(responseSteerFailedEvent.streamId()).contains("stream_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseSteerFailedEvent =
            ResponseSteerFailedEvent.builder()
                .error(
                    ResponseSteerFailedEvent.Error.builder()
                        .code(ResponseSteerErrorCode.RESPONSE_NOT_FOUND)
                        .message("message")
                        .build()
                )
                .sequenceNumber(0L)
                .steer(
                    ResponseSteerFailedEvent.Steer.builder()
                        .input("string")
                        .previousResponseId("previous_response_id")
                        .id("id")
                        .build()
                )
                .streamId("stream_id")
                .build()

        val roundtrippedResponseSteerFailedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseSteerFailedEvent),
                jacksonTypeRef<ResponseSteerFailedEvent>(),
            )

        assertThat(roundtrippedResponseSteerFailedEvent).isEqualTo(responseSteerFailedEvent)
    }
}
