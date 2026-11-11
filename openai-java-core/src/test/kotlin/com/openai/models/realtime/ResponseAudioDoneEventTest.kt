// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseAudioDoneEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseAudioDoneEvent =
            ResponseAudioDoneEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        assertThat(responseAudioDoneEvent.contentIndex()).contains(0L)
        assertThat(responseAudioDoneEvent.eventId()).contains("event_id")
        assertThat(responseAudioDoneEvent.itemId()).contains("item_id")
        assertThat(responseAudioDoneEvent.outputIndex()).contains(0L)
        assertThat(responseAudioDoneEvent.responseId()).contains("response_id")

        val jsonMapper = jsonMapper()

        val roundtrippedResponseAudioDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseAudioDoneEvent),
                jacksonTypeRef<ResponseAudioDoneEvent>(),
            )

        assertThat(roundtrippedResponseAudioDoneEvent).isEqualTo(responseAudioDoneEvent)
    }
}
