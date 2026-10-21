// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InfoEventTest {

    @Test
    fun createAndRoundtrip() {
        val infoEvent =
            InfoEvent.builder()
                .code("data_channel_permissions")
                .eventId("evt_info_001")
                .message(
                    "The frontend data channel is configured with restricted event permissions."
                )
                .clientEventId("client_event_id")
                .build()

        assertThat(infoEvent.code()).isEqualTo("data_channel_permissions")
        assertThat(infoEvent.eventId()).isEqualTo("evt_info_001")
        assertThat(infoEvent.message())
            .isEqualTo("The frontend data channel is configured with restricted event permissions.")
        assertThat(infoEvent.clientEventId()).contains("client_event_id")

        val jsonMapper = jsonMapper()

        val roundtrippedInfoEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(infoEvent),
                jacksonTypeRef<InfoEvent>(),
            )

        assertThat(roundtrippedInfoEvent).isEqualTo(infoEvent)
    }
}
