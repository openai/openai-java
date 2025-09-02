// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OutputAudioBufferClearEventTest {

    @Test
    fun create() {
        val outputAudioBufferClearEvent =
            OutputAudioBufferClearEvent.builder().eventId("event_id").build()

        assertThat(outputAudioBufferClearEvent.eventId()).contains("event_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val outputAudioBufferClearEvent =
            OutputAudioBufferClearEvent.builder().eventId("event_id").build()

        val roundtrippedOutputAudioBufferClearEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(outputAudioBufferClearEvent),
                jacksonTypeRef<OutputAudioBufferClearEvent>(),
            )

        assertThat(roundtrippedOutputAudioBufferClearEvent).isEqualTo(outputAudioBufferClearEvent)
    }
}
