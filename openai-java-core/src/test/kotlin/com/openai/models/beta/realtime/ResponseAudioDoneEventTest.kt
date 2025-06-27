// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseAudioDoneEventTest {

    @Test
    fun create() {
        val responseAudioDoneEvent =
            ResponseAudioDoneEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        assertThat(responseAudioDoneEvent.contentIndex()).isEqualTo(0L)
        assertThat(responseAudioDoneEvent.eventId()).isEqualTo("event_id")
        assertThat(responseAudioDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(responseAudioDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseAudioDoneEvent.responseId()).isEqualTo("response_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseAudioDoneEvent =
            ResponseAudioDoneEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        val roundtrippedResponseAudioDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseAudioDoneEvent),
                jacksonTypeRef<ResponseAudioDoneEvent>(),
            )

        assertThat(roundtrippedResponseAudioDoneEvent).isEqualTo(responseAudioDoneEvent)
    }
}
