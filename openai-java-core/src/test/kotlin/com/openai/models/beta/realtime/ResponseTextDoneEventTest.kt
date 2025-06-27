// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseTextDoneEventTest {

    @Test
    fun create() {
        val responseTextDoneEvent =
            ResponseTextDoneEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .text("text")
                .build()

        assertThat(responseTextDoneEvent.contentIndex()).isEqualTo(0L)
        assertThat(responseTextDoneEvent.eventId()).isEqualTo("event_id")
        assertThat(responseTextDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(responseTextDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseTextDoneEvent.responseId()).isEqualTo("response_id")
        assertThat(responseTextDoneEvent.text()).isEqualTo("text")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseTextDoneEvent =
            ResponseTextDoneEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .text("text")
                .build()

        val roundtrippedResponseTextDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseTextDoneEvent),
                jacksonTypeRef<ResponseTextDoneEvent>(),
            )

        assertThat(roundtrippedResponseTextDoneEvent).isEqualTo(responseTextDoneEvent)
    }
}
