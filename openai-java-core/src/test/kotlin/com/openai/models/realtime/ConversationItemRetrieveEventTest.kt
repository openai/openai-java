// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationItemRetrieveEventTest {

    @Test
    fun create() {
        val conversationItemRetrieveEvent =
            ConversationItemRetrieveEvent.builder().itemId("item_id").eventId("event_id").build()

        assertThat(conversationItemRetrieveEvent.itemId()).isEqualTo("item_id")
        assertThat(conversationItemRetrieveEvent.eventId()).contains("event_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItemRetrieveEvent =
            ConversationItemRetrieveEvent.builder().itemId("item_id").eventId("event_id").build()

        val roundtrippedConversationItemRetrieveEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItemRetrieveEvent),
                jacksonTypeRef<ConversationItemRetrieveEvent>(),
            )

        assertThat(roundtrippedConversationItemRetrieveEvent)
            .isEqualTo(conversationItemRetrieveEvent)
    }
}
