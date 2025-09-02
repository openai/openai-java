// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationCreatedEventTest {

    @Test
    fun create() {
        val conversationCreatedEvent =
            ConversationCreatedEvent.builder()
                .conversation(
                    ConversationCreatedEvent.Conversation.builder()
                        .id("id")
                        .object_(ConversationCreatedEvent.Conversation.Object.REALTIME_CONVERSATION)
                        .build()
                )
                .eventId("event_id")
                .build()

        assertThat(conversationCreatedEvent.conversation())
            .isEqualTo(
                ConversationCreatedEvent.Conversation.builder()
                    .id("id")
                    .object_(ConversationCreatedEvent.Conversation.Object.REALTIME_CONVERSATION)
                    .build()
            )
        assertThat(conversationCreatedEvent.eventId()).isEqualTo("event_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val conversationCreatedEvent =
            ConversationCreatedEvent.builder()
                .conversation(
                    ConversationCreatedEvent.Conversation.builder()
                        .id("id")
                        .object_(ConversationCreatedEvent.Conversation.Object.REALTIME_CONVERSATION)
                        .build()
                )
                .eventId("event_id")
                .build()

        val roundtrippedConversationCreatedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationCreatedEvent),
                jacksonTypeRef<ConversationCreatedEvent>(),
            )

        assertThat(roundtrippedConversationCreatedEvent).isEqualTo(conversationCreatedEvent)
    }
}
