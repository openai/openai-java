// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationItemTruncateEventTest {

    @Test
    fun create() {
        val conversationItemTruncateEvent =
            ConversationItemTruncateEvent.builder()
                .audioEndMs(0L)
                .contentIndex(0L)
                .itemId("item_id")
                .eventId("event_id")
                .build()

        assertThat(conversationItemTruncateEvent.audioEndMs()).isEqualTo(0L)
        assertThat(conversationItemTruncateEvent.contentIndex()).isEqualTo(0L)
        assertThat(conversationItemTruncateEvent.itemId()).isEqualTo("item_id")
        assertThat(conversationItemTruncateEvent.eventId()).contains("event_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItemTruncateEvent =
            ConversationItemTruncateEvent.builder()
                .audioEndMs(0L)
                .contentIndex(0L)
                .itemId("item_id")
                .eventId("event_id")
                .build()

        val roundtrippedConversationItemTruncateEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItemTruncateEvent),
                jacksonTypeRef<ConversationItemTruncateEvent>(),
            )

        assertThat(roundtrippedConversationItemTruncateEvent)
            .isEqualTo(conversationItemTruncateEvent)
    }
}
