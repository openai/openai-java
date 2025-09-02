// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseOutputItemAddedEventTest {

    @Test
    fun create() {
        val responseOutputItemAddedEvent =
            ResponseOutputItemAddedEvent.builder()
                .eventId("event_id")
                .item(
                    RealtimeConversationItemSystemMessage.builder()
                        .addContent(
                            RealtimeConversationItemSystemMessage.Content.builder()
                                .text("text")
                                .type(RealtimeConversationItemSystemMessage.Content.Type.INPUT_TEXT)
                                .build()
                        )
                        .id("id")
                        .object_(RealtimeConversationItemSystemMessage.Object.REALTIME_ITEM)
                        .status(RealtimeConversationItemSystemMessage.Status.COMPLETED)
                        .build()
                )
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        assertThat(responseOutputItemAddedEvent.eventId()).isEqualTo("event_id")
        assertThat(responseOutputItemAddedEvent.item())
            .isEqualTo(
                ConversationItem.ofRealtimeConversationItemSystemMessage(
                    RealtimeConversationItemSystemMessage.builder()
                        .addContent(
                            RealtimeConversationItemSystemMessage.Content.builder()
                                .text("text")
                                .type(RealtimeConversationItemSystemMessage.Content.Type.INPUT_TEXT)
                                .build()
                        )
                        .id("id")
                        .object_(RealtimeConversationItemSystemMessage.Object.REALTIME_ITEM)
                        .status(RealtimeConversationItemSystemMessage.Status.COMPLETED)
                        .build()
                )
            )
        assertThat(responseOutputItemAddedEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseOutputItemAddedEvent.responseId()).isEqualTo("response_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseOutputItemAddedEvent =
            ResponseOutputItemAddedEvent.builder()
                .eventId("event_id")
                .item(
                    RealtimeConversationItemSystemMessage.builder()
                        .addContent(
                            RealtimeConversationItemSystemMessage.Content.builder()
                                .text("text")
                                .type(RealtimeConversationItemSystemMessage.Content.Type.INPUT_TEXT)
                                .build()
                        )
                        .id("id")
                        .object_(RealtimeConversationItemSystemMessage.Object.REALTIME_ITEM)
                        .status(RealtimeConversationItemSystemMessage.Status.COMPLETED)
                        .build()
                )
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        val roundtrippedResponseOutputItemAddedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseOutputItemAddedEvent),
                jacksonTypeRef<ResponseOutputItemAddedEvent>(),
            )

        assertThat(roundtrippedResponseOutputItemAddedEvent).isEqualTo(responseOutputItemAddedEvent)
    }
}
