// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputAudioBufferSpeechStoppedEventTest {

    @Test
    fun create() {
        val inputAudioBufferSpeechStoppedEvent =
            InputAudioBufferSpeechStoppedEvent.builder()
                .audioEndMs(0L)
                .eventId("event_id")
                .itemId("item_id")
                .build()

        assertThat(inputAudioBufferSpeechStoppedEvent.audioEndMs()).isEqualTo(0L)
        assertThat(inputAudioBufferSpeechStoppedEvent.eventId()).isEqualTo("event_id")
        assertThat(inputAudioBufferSpeechStoppedEvent.itemId()).isEqualTo("item_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inputAudioBufferSpeechStoppedEvent =
            InputAudioBufferSpeechStoppedEvent.builder()
                .audioEndMs(0L)
                .eventId("event_id")
                .itemId("item_id")
                .build()

        val roundtrippedInputAudioBufferSpeechStoppedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inputAudioBufferSpeechStoppedEvent),
                jacksonTypeRef<InputAudioBufferSpeechStoppedEvent>(),
            )

        assertThat(roundtrippedInputAudioBufferSpeechStoppedEvent)
            .isEqualTo(inputAudioBufferSpeechStoppedEvent)
    }
}
