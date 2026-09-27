// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCreateEventTest {

    @Test
    fun create() {
        val responseCreateEvent = ResponseCreateEvent.builder().eventId("evt_response_001").build()

        assertThat(responseCreateEvent.eventId()).contains("evt_response_001")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseCreateEvent = ResponseCreateEvent.builder().eventId("evt_response_001").build()

        val roundtrippedResponseCreateEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseCreateEvent),
                jacksonTypeRef<ResponseCreateEvent>(),
            )

        assertThat(roundtrippedResponseCreateEvent).isEqualTo(responseCreateEvent)
    }
}
