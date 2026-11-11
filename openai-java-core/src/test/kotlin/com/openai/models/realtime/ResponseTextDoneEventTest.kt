// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseTextDoneEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseTextDoneEvent =
            ResponseTextDoneEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .text("text")
                .build()

        assertThat(responseTextDoneEvent.contentIndex()).contains(0L)
        assertThat(responseTextDoneEvent.eventId()).contains("event_id")
        assertThat(responseTextDoneEvent.itemId()).contains("item_id")
        assertThat(responseTextDoneEvent.outputIndex()).contains(0L)
        assertThat(responseTextDoneEvent.responseId()).contains("response_id")
        assertThat(responseTextDoneEvent.text()).contains("text")

        val jsonMapper = jsonMapper()

        val roundtrippedResponseTextDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseTextDoneEvent),
                jacksonTypeRef<ResponseTextDoneEvent>(),
            )

        assertThat(roundtrippedResponseTextDoneEvent).isEqualTo(responseTextDoneEvent)
    }
}
