// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputAudioBufferCommitEventTest {

    @Test
    fun createAndRoundtrip() {
        val inputAudioBufferCommitEvent =
            InputAudioBufferCommitEvent.builder().eventId("event_id").build()

        assertThat(inputAudioBufferCommitEvent.eventId()).contains("event_id")

        val jsonMapper = jsonMapper()

        val roundtrippedInputAudioBufferCommitEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inputAudioBufferCommitEvent),
                jacksonTypeRef<InputAudioBufferCommitEvent>(),
            )

        assertThat(roundtrippedInputAudioBufferCommitEvent).isEqualTo(inputAudioBufferCommitEvent)
    }
}
