// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputAudioBufferSpeechStoppedEventTest {

    @Test
    fun createAndRoundtrip() {
        val inputAudioBufferSpeechStoppedEvent =
            InputAudioBufferSpeechStoppedEvent.builder()
                .audioEndMs(0L)
                .eventId("event_id")
                .itemId("item_id")
                .build()

        assertThat(inputAudioBufferSpeechStoppedEvent.audioEndMs()).contains(0L)
        assertThat(inputAudioBufferSpeechStoppedEvent.eventId()).contains("event_id")
        assertThat(inputAudioBufferSpeechStoppedEvent.itemId()).contains("item_id")

        val jsonMapper = jsonMapper()

        val roundtrippedInputAudioBufferSpeechStoppedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inputAudioBufferSpeechStoppedEvent),
                jacksonTypeRef<InputAudioBufferSpeechStoppedEvent>(),
            )

        assertThat(roundtrippedInputAudioBufferSpeechStoppedEvent)
            .isEqualTo(inputAudioBufferSpeechStoppedEvent)
    }
}
