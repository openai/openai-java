// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputAudioMuteEventTest {

    @Test
    fun createAndRoundtrip() {
        val inputAudioMuteEvent = InputAudioMuteEvent.builder().eventId("evt_mute_001").build()

        assertThat(inputAudioMuteEvent.eventId()).contains("evt_mute_001")

        val jsonMapper = jsonMapper()

        val roundtrippedInputAudioMuteEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inputAudioMuteEvent),
                jacksonTypeRef<InputAudioMuteEvent>(),
            )

        assertThat(roundtrippedInputAudioMuteEvent).isEqualTo(inputAudioMuteEvent)
    }
}
