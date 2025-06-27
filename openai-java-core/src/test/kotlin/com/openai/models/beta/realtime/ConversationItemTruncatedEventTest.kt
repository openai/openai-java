// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationItemTruncatedEventTest {

    @Test
    fun create() {
        val conversationItemTruncatedEvent =
            ConversationItemTruncatedEvent.builder()
                .audioEndMs(0L)
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .build()

        assertThat(conversationItemTruncatedEvent.audioEndMs()).isEqualTo(0L)
        assertThat(conversationItemTruncatedEvent.contentIndex()).isEqualTo(0L)
        assertThat(conversationItemTruncatedEvent.eventId()).isEqualTo("event_id")
        assertThat(conversationItemTruncatedEvent.itemId()).isEqualTo("item_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItemTruncatedEvent =
            ConversationItemTruncatedEvent.builder()
                .audioEndMs(0L)
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .build()

        val roundtrippedConversationItemTruncatedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItemTruncatedEvent),
                jacksonTypeRef<ConversationItemTruncatedEvent>(),
            )

        assertThat(roundtrippedConversationItemTruncatedEvent)
            .isEqualTo(conversationItemTruncatedEvent)
    }
}
