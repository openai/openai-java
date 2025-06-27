// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

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
                    ErrorEvent.Error.builder()
                        .message("message")
                        .type("type")
                        .code("code")
                        .eventId("event_id")
                        .param("param")
                        .build()
                )
                .eventId("event_id")
                .build()

        assertThat(errorEvent.error())
            .isEqualTo(
                ErrorEvent.Error.builder()
                    .message("message")
                    .type("type")
                    .code("code")
                    .eventId("event_id")
                    .param("param")
                    .build()
            )
        assertThat(errorEvent.eventId()).isEqualTo("event_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val errorEvent =
            ErrorEvent.builder()
                .error(
                    ErrorEvent.Error.builder()
                        .message("message")
                        .type("type")
                        .code("code")
                        .eventId("event_id")
                        .param("param")
                        .build()
                )
                .eventId("event_id")
                .build()

        val roundtrippedErrorEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(errorEvent),
                jacksonTypeRef<ErrorEvent>(),
            )

        assertThat(roundtrippedErrorEvent).isEqualTo(errorEvent)
    }
}
