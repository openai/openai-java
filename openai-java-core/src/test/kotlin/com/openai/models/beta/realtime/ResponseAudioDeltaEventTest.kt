// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseAudioDeltaEventTest {

    @Test
    fun create() {
        val responseAudioDeltaEvent =
            ResponseAudioDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        assertThat(responseAudioDeltaEvent.contentIndex()).isEqualTo(0L)
        assertThat(responseAudioDeltaEvent.delta()).isEqualTo("delta")
        assertThat(responseAudioDeltaEvent.eventId()).isEqualTo("event_id")
        assertThat(responseAudioDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(responseAudioDeltaEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseAudioDeltaEvent.responseId()).isEqualTo("response_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseAudioDeltaEvent =
            ResponseAudioDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        val roundtrippedResponseAudioDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseAudioDeltaEvent),
                jacksonTypeRef<ResponseAudioDeltaEvent>(),
            )

        assertThat(roundtrippedResponseAudioDeltaEvent).isEqualTo(responseAudioDeltaEvent)
    }
}
