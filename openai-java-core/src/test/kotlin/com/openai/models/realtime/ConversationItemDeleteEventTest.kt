// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationItemDeleteEventTest {

    @Test
    fun createAndRoundtrip() {
        val conversationItemDeleteEvent =
            ConversationItemDeleteEvent.builder().itemId("item_id").eventId("event_id").build()

        assertThat(conversationItemDeleteEvent.itemId()).isEqualTo("item_id")
        assertThat(conversationItemDeleteEvent.eventId()).contains("event_id")

        val jsonMapper = jsonMapper()

        val roundtrippedConversationItemDeleteEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItemDeleteEvent),
                jacksonTypeRef<ConversationItemDeleteEvent>(),
            )

        assertThat(roundtrippedConversationItemDeleteEvent).isEqualTo(conversationItemDeleteEvent)
    }
}
