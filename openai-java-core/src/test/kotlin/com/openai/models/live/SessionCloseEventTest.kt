// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionCloseEventTest {

    @Test
    fun create() {
        val sessionCloseEvent = SessionCloseEvent.builder().eventId("evt_close_001").build()

        assertThat(sessionCloseEvent.eventId()).contains("evt_close_001")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sessionCloseEvent = SessionCloseEvent.builder().eventId("evt_close_001").build()

        val roundtrippedSessionCloseEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sessionCloseEvent),
                jacksonTypeRef<SessionCloseEvent>(),
            )

        assertThat(roundtrippedSessionCloseEvent).isEqualTo(sessionCloseEvent)
    }
}
