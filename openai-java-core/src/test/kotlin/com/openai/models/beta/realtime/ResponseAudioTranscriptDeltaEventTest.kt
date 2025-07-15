// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseAudioTranscriptDeltaEventTest {

    @Test
    fun create() {
        val responseAudioTranscriptDeltaEvent =
            ResponseAudioTranscriptDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        assertThat(responseAudioTranscriptDeltaEvent.contentIndex()).isEqualTo(0L)
        assertThat(responseAudioTranscriptDeltaEvent.delta()).isEqualTo("delta")
        assertThat(responseAudioTranscriptDeltaEvent.eventId()).isEqualTo("event_id")
        assertThat(responseAudioTranscriptDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(responseAudioTranscriptDeltaEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseAudioTranscriptDeltaEvent.responseId()).isEqualTo("response_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseAudioTranscriptDeltaEvent =
            ResponseAudioTranscriptDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        val roundtrippedResponseAudioTranscriptDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseAudioTranscriptDeltaEvent),
                jacksonTypeRef<ResponseAudioTranscriptDeltaEvent>(),
            )

        assertThat(roundtrippedResponseAudioTranscriptDeltaEvent)
            .isEqualTo(responseAudioTranscriptDeltaEvent)
    }
}
