// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputAudioBufferAppendEventTest {

    @Test
    fun create() {
        val inputAudioBufferAppendEvent =
            InputAudioBufferAppendEvent.builder().audio("audio").eventId("event_id").build()

        assertThat(inputAudioBufferAppendEvent.audio()).isEqualTo("audio")
        assertThat(inputAudioBufferAppendEvent.eventId()).contains("event_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inputAudioBufferAppendEvent =
            InputAudioBufferAppendEvent.builder().audio("audio").eventId("event_id").build()

        val roundtrippedInputAudioBufferAppendEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inputAudioBufferAppendEvent),
                jacksonTypeRef<InputAudioBufferAppendEvent>(),
            )

        assertThat(roundtrippedInputAudioBufferAppendEvent).isEqualTo(inputAudioBufferAppendEvent)
    }
}
