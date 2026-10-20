// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputAudioUnmutedEventTest {

    @Test
    fun create() {
        val inputAudioUnmutedEvent =
            InputAudioUnmutedEvent.builder()
                .eventId("evt_unmuted_001")
                .clientEventId("evt_unmute_001")
                .build()

        assertThat(inputAudioUnmutedEvent.eventId()).isEqualTo("evt_unmuted_001")
        assertThat(inputAudioUnmutedEvent.clientEventId()).contains("evt_unmute_001")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inputAudioUnmutedEvent =
            InputAudioUnmutedEvent.builder()
                .eventId("evt_unmuted_001")
                .clientEventId("evt_unmute_001")
                .build()

        val roundtrippedInputAudioUnmutedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inputAudioUnmutedEvent),
                jacksonTypeRef<InputAudioUnmutedEvent>(),
            )

        assertThat(roundtrippedInputAudioUnmutedEvent).isEqualTo(inputAudioUnmutedEvent)
    }
}
