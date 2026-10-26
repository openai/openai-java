// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputAudioBufferClearEventTest {

    @Test
    fun createAndRoundtrip() {
        val inputAudioBufferClearEvent =
            InputAudioBufferClearEvent.builder().eventId("event_id").build()

        assertThat(inputAudioBufferClearEvent.eventId()).contains("event_id")

        val jsonMapper = jsonMapper()

        val roundtrippedInputAudioBufferClearEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inputAudioBufferClearEvent),
                jacksonTypeRef<InputAudioBufferClearEvent>(),
            )

        assertThat(roundtrippedInputAudioBufferClearEvent).isEqualTo(inputAudioBufferClearEvent)
    }
}
