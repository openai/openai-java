// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseTextDeltaEventTest {

    @Test
    fun create() {
        val responseTextDeltaEvent =
            ResponseTextDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        assertThat(responseTextDeltaEvent.contentIndex()).isEqualTo(0L)
        assertThat(responseTextDeltaEvent.delta()).isEqualTo("delta")
        assertThat(responseTextDeltaEvent.eventId()).isEqualTo("event_id")
        assertThat(responseTextDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(responseTextDeltaEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseTextDeltaEvent.responseId()).isEqualTo("response_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseTextDeltaEvent =
            ResponseTextDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        val roundtrippedResponseTextDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseTextDeltaEvent),
                jacksonTypeRef<ResponseTextDeltaEvent>(),
            )

        assertThat(roundtrippedResponseTextDeltaEvent).isEqualTo(responseTextDeltaEvent)
    }
}
