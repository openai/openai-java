// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OutputAudioBufferClearEventTest {

    @Test
    fun createAndRoundtrip() {
        val outputAudioBufferClearEvent =
            OutputAudioBufferClearEvent.builder().eventId("event_id").build()

        assertThat(outputAudioBufferClearEvent.eventId()).contains("event_id")

        val jsonMapper = jsonMapper()

        val roundtrippedOutputAudioBufferClearEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(outputAudioBufferClearEvent),
                jacksonTypeRef<OutputAudioBufferClearEvent>(),
            )

        assertThat(roundtrippedOutputAudioBufferClearEvent).isEqualTo(outputAudioBufferClearEvent)
    }
}
