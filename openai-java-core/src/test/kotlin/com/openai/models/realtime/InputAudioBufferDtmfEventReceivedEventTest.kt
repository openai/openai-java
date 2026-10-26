// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputAudioBufferDtmfEventReceivedEventTest {

    @Test
    fun createAndRoundtrip() {
        val inputAudioBufferDtmfEventReceivedEvent =
            InputAudioBufferDtmfEventReceivedEvent.builder().event("event").receivedAt(0L).build()

        assertThat(inputAudioBufferDtmfEventReceivedEvent.event()).isEqualTo("event")
        assertThat(inputAudioBufferDtmfEventReceivedEvent.receivedAt()).isEqualTo(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedInputAudioBufferDtmfEventReceivedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inputAudioBufferDtmfEventReceivedEvent),
                jacksonTypeRef<InputAudioBufferDtmfEventReceivedEvent>(),
            )

        assertThat(roundtrippedInputAudioBufferDtmfEventReceivedEvent)
            .isEqualTo(inputAudioBufferDtmfEventReceivedEvent)
    }
}
