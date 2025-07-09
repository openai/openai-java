// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseContentPartAddedEventTest {

    @Test
    fun create() {
        val responseContentPartAddedEvent =
            ResponseContentPartAddedEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .part(
                    ResponseContentPartAddedEvent.Part.builder()
                        .audio("audio")
                        .text("text")
                        .transcript("transcript")
                        .type(ResponseContentPartAddedEvent.Part.Type.TEXT)
                        .build()
                )
                .responseId("response_id")
                .build()

        assertThat(responseContentPartAddedEvent.contentIndex()).isEqualTo(0L)
        assertThat(responseContentPartAddedEvent.eventId()).isEqualTo("event_id")
        assertThat(responseContentPartAddedEvent.itemId()).isEqualTo("item_id")
        assertThat(responseContentPartAddedEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseContentPartAddedEvent.part())
            .isEqualTo(
                ResponseContentPartAddedEvent.Part.builder()
                    .audio("audio")
                    .text("text")
                    .transcript("transcript")
                    .type(ResponseContentPartAddedEvent.Part.Type.TEXT)
                    .build()
            )
        assertThat(responseContentPartAddedEvent.responseId()).isEqualTo("response_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseContentPartAddedEvent =
            ResponseContentPartAddedEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .part(
                    ResponseContentPartAddedEvent.Part.builder()
                        .audio("audio")
                        .text("text")
                        .transcript("transcript")
                        .type(ResponseContentPartAddedEvent.Part.Type.TEXT)
                        .build()
                )
                .responseId("response_id")
                .build()

        val roundtrippedResponseContentPartAddedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseContentPartAddedEvent),
                jacksonTypeRef<ResponseContentPartAddedEvent>(),
            )

        assertThat(roundtrippedResponseContentPartAddedEvent)
            .isEqualTo(responseContentPartAddedEvent)
    }
}
