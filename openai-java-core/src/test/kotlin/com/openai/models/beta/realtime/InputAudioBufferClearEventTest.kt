// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputAudioBufferClearEventTest {

    @Test
    fun create() {
        val inputAudioBufferClearEvent =
            InputAudioBufferClearEvent.builder().eventId("event_id").build()

        assertThat(inputAudioBufferClearEvent.eventId()).contains("event_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inputAudioBufferClearEvent =
            InputAudioBufferClearEvent.builder().eventId("event_id").build()

        val roundtrippedInputAudioBufferClearEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inputAudioBufferClearEvent),
                jacksonTypeRef<InputAudioBufferClearEvent>(),
            )

        assertThat(roundtrippedInputAudioBufferClearEvent).isEqualTo(inputAudioBufferClearEvent)
    }
}
