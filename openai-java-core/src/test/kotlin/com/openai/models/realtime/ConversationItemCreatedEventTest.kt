// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationItemCreatedEventTest {

    @Test
    fun create() {
        val conversationItemCreatedEvent =
            ConversationItemCreatedEvent.builder()
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
                .previousItemId("previous_item_id")
                .build()

        assertThat(conversationItemCreatedEvent.eventId()).isEqualTo("event_id")
        assertThat(conversationItemCreatedEvent.item())
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
        assertThat(conversationItemCreatedEvent.previousItemId()).contains("previous_item_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItemCreatedEvent =
            ConversationItemCreatedEvent.builder()
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
                .previousItemId("previous_item_id")
                .build()

        val roundtrippedConversationItemCreatedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItemCreatedEvent),
                jacksonTypeRef<ConversationItemCreatedEvent>(),
            )

        assertThat(roundtrippedConversationItemCreatedEvent).isEqualTo(conversationItemCreatedEvent)
    }
}
