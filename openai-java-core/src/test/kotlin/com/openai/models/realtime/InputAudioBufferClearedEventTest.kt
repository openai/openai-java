// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputAudioBufferClearedEventTest {

    @Test
    fun create() {
        val inputAudioBufferClearedEvent =
            InputAudioBufferClearedEvent.builder().eventId("event_id").build()

        assertThat(inputAudioBufferClearedEvent.eventId()).isEqualTo("event_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inputAudioBufferClearedEvent =
            InputAudioBufferClearedEvent.builder().eventId("event_id").build()

        val roundtrippedInputAudioBufferClearedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inputAudioBufferClearedEvent),
                jacksonTypeRef<InputAudioBufferClearedEvent>(),
            )

        assertThat(roundtrippedInputAudioBufferClearedEvent).isEqualTo(inputAudioBufferClearedEvent)
    }
}
