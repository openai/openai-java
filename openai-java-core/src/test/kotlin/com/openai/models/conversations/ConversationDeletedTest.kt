// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.conversations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationDeletedTest {

    @Test
    fun createAndRoundtrip() {
        val conversationDeleted = ConversationDeleted.builder().id("id").deleted(true).build()

        assertThat(conversationDeleted.id()).isEqualTo("id")
        assertThat(conversationDeleted.deleted()).isEqualTo(true)

        val jsonMapper = jsonMapper()

        val roundtrippedConversationDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationDeleted),
                jacksonTypeRef<ConversationDeleted>(),
            )

        assertThat(roundtrippedConversationDeleted).isEqualTo(conversationDeleted)
    }
}
