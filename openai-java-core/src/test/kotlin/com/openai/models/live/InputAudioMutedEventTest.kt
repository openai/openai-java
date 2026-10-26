// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputAudioMutedEventTest {

    @Test
    fun createAndRoundtrip() {
        val inputAudioMutedEvent =
            InputAudioMutedEvent.builder()
                .eventId("evt_muted_001")
                .clientEventId("evt_mute_001")
                .build()

        assertThat(inputAudioMutedEvent.eventId()).isEqualTo("evt_muted_001")
        assertThat(inputAudioMutedEvent.clientEventId()).contains("evt_mute_001")

        val jsonMapper = jsonMapper()

        val roundtrippedInputAudioMutedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inputAudioMutedEvent),
                jacksonTypeRef<InputAudioMutedEvent>(),
            )

        assertThat(roundtrippedInputAudioMutedEvent).isEqualTo(inputAudioMutedEvent)
    }
}
