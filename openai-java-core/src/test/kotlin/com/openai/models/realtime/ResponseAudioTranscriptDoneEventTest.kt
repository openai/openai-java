// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseAudioTranscriptDoneEventTest {

    @Test
    fun create() {
        val responseAudioTranscriptDoneEvent =
            ResponseAudioTranscriptDoneEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .transcript("transcript")
                .build()

        assertThat(responseAudioTranscriptDoneEvent.contentIndex()).isEqualTo(0L)
        assertThat(responseAudioTranscriptDoneEvent.eventId()).isEqualTo("event_id")
        assertThat(responseAudioTranscriptDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(responseAudioTranscriptDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseAudioTranscriptDoneEvent.responseId()).isEqualTo("response_id")
        assertThat(responseAudioTranscriptDoneEvent.transcript()).isEqualTo("transcript")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseAudioTranscriptDoneEvent =
            ResponseAudioTranscriptDoneEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .transcript("transcript")
                .build()

        val roundtrippedResponseAudioTranscriptDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseAudioTranscriptDoneEvent),
                jacksonTypeRef<ResponseAudioTranscriptDoneEvent>(),
            )

        assertThat(roundtrippedResponseAudioTranscriptDoneEvent)
            .isEqualTo(responseAudioTranscriptDoneEvent)
    }
}
