// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputAudioBufferCommitEventTest {

    @Test
    fun create() {
        val inputAudioBufferCommitEvent =
            InputAudioBufferCommitEvent.builder().eventId("event_id").build()

        assertThat(inputAudioBufferCommitEvent.eventId()).contains("event_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inputAudioBufferCommitEvent =
            InputAudioBufferCommitEvent.builder().eventId("event_id").build()

        val roundtrippedInputAudioBufferCommitEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inputAudioBufferCommitEvent),
                jacksonTypeRef<InputAudioBufferCommitEvent>(),
            )

        assertThat(roundtrippedInputAudioBufferCommitEvent).isEqualTo(inputAudioBufferCommitEvent)
    }
}
