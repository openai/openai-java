// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputAudioBufferDtmfEventReceivedEventTest {

    @Test
    fun create() {
        val inputAudioBufferDtmfEventReceivedEvent =
            InputAudioBufferDtmfEventReceivedEvent.builder().event("event").receivedAt(0L).build()

        assertThat(inputAudioBufferDtmfEventReceivedEvent.event()).isEqualTo("event")
        assertThat(inputAudioBufferDtmfEventReceivedEvent.receivedAt()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inputAudioBufferDtmfEventReceivedEvent =
            InputAudioBufferDtmfEventReceivedEvent.builder().event("event").receivedAt(0L).build()

        val roundtrippedInputAudioBufferDtmfEventReceivedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inputAudioBufferDtmfEventReceivedEvent),
                jacksonTypeRef<InputAudioBufferDtmfEventReceivedEvent>(),
            )

        assertThat(roundtrippedInputAudioBufferDtmfEventReceivedEvent)
            .isEqualTo(inputAudioBufferDtmfEventReceivedEvent)
    }
}
