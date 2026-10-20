// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ErrorEventTest {

    @Test
    fun create() {
        val errorEvent =
            ErrorEvent.builder()
                .error(
                    Error.builder()
                        .code("unknown_parameter")
                        .message("Unknown parameter: 'session.voice'.")
                        .type("invalid_request_error")
                        .clientEventId("evt_invalid_001")
                        .param("session.voice")
                        .build()
                )
                .eventId("evt_error_001")
                .clientEventId("client_event_id")
                .build()

        assertThat(errorEvent.error())
            .isEqualTo(
                Error.builder()
                    .code("unknown_parameter")
                    .message("Unknown parameter: 'session.voice'.")
                    .type("invalid_request_error")
                    .clientEventId("evt_invalid_001")
                    .param("session.voice")
                    .build()
            )
        assertThat(errorEvent.eventId()).isEqualTo("evt_error_001")
        assertThat(errorEvent.clientEventId()).contains("client_event_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val errorEvent =
            ErrorEvent.builder()
                .error(
                    Error.builder()
                        .code("unknown_parameter")
                        .message("Unknown parameter: 'session.voice'.")
                        .type("invalid_request_error")
                        .clientEventId("evt_invalid_001")
                        .param("session.voice")
                        .build()
                )
                .eventId("evt_error_001")
                .clientEventId("client_event_id")
                .build()

        val roundtrippedErrorEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(errorEvent),
                jacksonTypeRef<ErrorEvent>(),
            )

        assertThat(roundtrippedErrorEvent).isEqualTo(errorEvent)
    }
}
