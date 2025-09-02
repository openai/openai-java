// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationItemDeletedEventTest {

    @Test
    fun create() {
        val conversationItemDeletedEvent =
            ConversationItemDeletedEvent.builder().eventId("event_id").itemId("item_id").build()

        assertThat(conversationItemDeletedEvent.eventId()).isEqualTo("event_id")
        assertThat(conversationItemDeletedEvent.itemId()).isEqualTo("item_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItemDeletedEvent =
            ConversationItemDeletedEvent.builder().eventId("event_id").itemId("item_id").build()

        val roundtrippedConversationItemDeletedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItemDeletedEvent),
                jacksonTypeRef<ConversationItemDeletedEvent>(),
            )

        assertThat(roundtrippedConversationItemDeletedEvent).isEqualTo(conversationItemDeletedEvent)
    }
}
