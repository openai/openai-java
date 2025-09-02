// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationItemAddedTest {

    @Test
    fun create() {
        val conversationItemAdded =
            ConversationItemAdded.builder()
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

        assertThat(conversationItemAdded.eventId()).isEqualTo("event_id")
        assertThat(conversationItemAdded.item())
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
        assertThat(conversationItemAdded.previousItemId()).contains("previous_item_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItemAdded =
            ConversationItemAdded.builder()
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

        val roundtrippedConversationItemAdded =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItemAdded),
                jacksonTypeRef<ConversationItemAdded>(),
            )

        assertThat(roundtrippedConversationItemAdded).isEqualTo(conversationItemAdded)
    }
}
