// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputAudioBufferTimeoutTriggeredTest {

    @Test
    fun create() {
        val inputAudioBufferTimeoutTriggered =
            InputAudioBufferTimeoutTriggered.builder()
                .audioEndMs(0L)
                .audioStartMs(0L)
                .eventId("event_id")
                .itemId("item_id")
                .build()

        assertThat(inputAudioBufferTimeoutTriggered.audioEndMs()).isEqualTo(0L)
        assertThat(inputAudioBufferTimeoutTriggered.audioStartMs()).isEqualTo(0L)
        assertThat(inputAudioBufferTimeoutTriggered.eventId()).isEqualTo("event_id")
        assertThat(inputAudioBufferTimeoutTriggered.itemId()).isEqualTo("item_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inputAudioBufferTimeoutTriggered =
            InputAudioBufferTimeoutTriggered.builder()
                .audioEndMs(0L)
                .audioStartMs(0L)
                .eventId("event_id")
                .itemId("item_id")
                .build()

        val roundtrippedInputAudioBufferTimeoutTriggered =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inputAudioBufferTimeoutTriggered),
                jacksonTypeRef<InputAudioBufferTimeoutTriggered>(),
            )

        assertThat(roundtrippedInputAudioBufferTimeoutTriggered)
            .isEqualTo(inputAudioBufferTimeoutTriggered)
    }
}
