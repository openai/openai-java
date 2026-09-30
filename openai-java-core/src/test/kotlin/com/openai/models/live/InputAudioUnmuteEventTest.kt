// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputAudioUnmuteEventTest {

    @Test
    fun create() {
        val inputAudioUnmuteEvent =
            InputAudioUnmuteEvent.builder().eventId("evt_unmute_001").build()

        assertThat(inputAudioUnmuteEvent.eventId()).contains("evt_unmute_001")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inputAudioUnmuteEvent =
            InputAudioUnmuteEvent.builder().eventId("evt_unmute_001").build()

        val roundtrippedInputAudioUnmuteEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inputAudioUnmuteEvent),
                jacksonTypeRef<InputAudioUnmuteEvent>(),
            )

        assertThat(roundtrippedInputAudioUnmuteEvent).isEqualTo(inputAudioUnmuteEvent)
    }
}
