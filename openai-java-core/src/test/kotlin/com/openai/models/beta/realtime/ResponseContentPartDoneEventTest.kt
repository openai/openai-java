// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseContentPartDoneEventTest {

    @Test
    fun create() {
        val responseContentPartDoneEvent =
            ResponseContentPartDoneEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .part(
                    ResponseContentPartDoneEvent.Part.builder()
                        .audio("audio")
                        .text("text")
                        .transcript("transcript")
                        .type(ResponseContentPartDoneEvent.Part.Type.TEXT)
                        .build()
                )
                .responseId("response_id")
                .build()

        assertThat(responseContentPartDoneEvent.contentIndex()).isEqualTo(0L)
        assertThat(responseContentPartDoneEvent.eventId()).isEqualTo("event_id")
        assertThat(responseContentPartDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(responseContentPartDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseContentPartDoneEvent.part())
            .isEqualTo(
                ResponseContentPartDoneEvent.Part.builder()
                    .audio("audio")
                    .text("text")
                    .transcript("transcript")
                    .type(ResponseContentPartDoneEvent.Part.Type.TEXT)
                    .build()
            )
        assertThat(responseContentPartDoneEvent.responseId()).isEqualTo("response_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseContentPartDoneEvent =
            ResponseContentPartDoneEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .part(
                    ResponseContentPartDoneEvent.Part.builder()
                        .audio("audio")
                        .text("text")
                        .transcript("transcript")
                        .type(ResponseContentPartDoneEvent.Part.Type.TEXT)
                        .build()
                )
                .responseId("response_id")
                .build()

        val roundtrippedResponseContentPartDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseContentPartDoneEvent),
                jacksonTypeRef<ResponseContentPartDoneEvent>(),
            )

        assertThat(roundtrippedResponseContentPartDoneEvent).isEqualTo(responseContentPartDoneEvent)
    }
}
