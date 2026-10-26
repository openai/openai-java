// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputAudioBufferCommittedEventTest {

    @Test
    fun createAndRoundtrip() {
        val inputAudioBufferCommittedEvent =
            InputAudioBufferCommittedEvent.builder()
                .eventId("event_id")
                .itemId("item_id")
                .previousItemId("previous_item_id")
                .build()

        assertThat(inputAudioBufferCommittedEvent.eventId()).isEqualTo("event_id")
        assertThat(inputAudioBufferCommittedEvent.itemId()).isEqualTo("item_id")
        assertThat(inputAudioBufferCommittedEvent.previousItemId()).contains("previous_item_id")

        val jsonMapper = jsonMapper()

        val roundtrippedInputAudioBufferCommittedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inputAudioBufferCommittedEvent),
                jacksonTypeRef<InputAudioBufferCommittedEvent>(),
            )

        assertThat(roundtrippedInputAudioBufferCommittedEvent)
            .isEqualTo(inputAudioBufferCommittedEvent)
    }
}
