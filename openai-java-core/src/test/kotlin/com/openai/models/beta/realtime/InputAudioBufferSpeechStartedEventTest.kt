// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputAudioBufferSpeechStartedEventTest {

    @Test
    fun create() {
        val inputAudioBufferSpeechStartedEvent =
            InputAudioBufferSpeechStartedEvent.builder()
                .audioStartMs(0L)
                .eventId("event_id")
                .itemId("item_id")
                .build()

        assertThat(inputAudioBufferSpeechStartedEvent.audioStartMs()).isEqualTo(0L)
        assertThat(inputAudioBufferSpeechStartedEvent.eventId()).isEqualTo("event_id")
        assertThat(inputAudioBufferSpeechStartedEvent.itemId()).isEqualTo("item_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inputAudioBufferSpeechStartedEvent =
            InputAudioBufferSpeechStartedEvent.builder()
                .audioStartMs(0L)
                .eventId("event_id")
                .itemId("item_id")
                .build()

        val roundtrippedInputAudioBufferSpeechStartedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inputAudioBufferSpeechStartedEvent),
                jacksonTypeRef<InputAudioBufferSpeechStartedEvent>(),
            )

        assertThat(roundtrippedInputAudioBufferSpeechStartedEvent)
            .isEqualTo(inputAudioBufferSpeechStartedEvent)
    }
}
