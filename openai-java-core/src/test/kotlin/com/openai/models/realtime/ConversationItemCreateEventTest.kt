// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationItemCreateEventTest {

    @Test
    fun create() {
        val conversationItemCreateEvent =
            ConversationItemCreateEvent.builder()
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
                .eventId("event_id")
                .previousItemId("previous_item_id")
                .build()

        assertThat(conversationItemCreateEvent.item())
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
        assertThat(conversationItemCreateEvent.eventId()).contains("event_id")
        assertThat(conversationItemCreateEvent.previousItemId()).contains("previous_item_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItemCreateEvent =
            ConversationItemCreateEvent.builder()
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
                .eventId("event_id")
                .previousItemId("previous_item_id")
                .build()

        val roundtrippedConversationItemCreateEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItemCreateEvent),
                jacksonTypeRef<ConversationItemCreateEvent>(),
            )

        assertThat(roundtrippedConversationItemCreateEvent).isEqualTo(conversationItemCreateEvent)
    }
}
