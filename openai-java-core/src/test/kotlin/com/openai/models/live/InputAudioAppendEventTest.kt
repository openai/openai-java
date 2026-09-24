// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputAudioAppendEventTest {

    @Test
    fun create() {
        val inputAudioAppendEvent =
            InputAudioAppendEvent.builder()
                .audio("AACAAIAAAIAAAP9/AIAAgA==")
                .eventId("event_id")
                .build()

        assertThat(inputAudioAppendEvent.audio()).isEqualTo("AACAAIAAAIAAAP9/AIAAgA==")
        assertThat(inputAudioAppendEvent.eventId()).contains("event_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inputAudioAppendEvent =
            InputAudioAppendEvent.builder()
                .audio("AACAAIAAAIAAAP9/AIAAgA==")
                .eventId("event_id")
                .build()

        val roundtrippedInputAudioAppendEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inputAudioAppendEvent),
                jacksonTypeRef<InputAudioAppendEvent>(),
            )

        assertThat(roundtrippedInputAudioAppendEvent).isEqualTo(inputAudioAppendEvent)
    }
}
