// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.conversations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationDeletedResourceTest {

    @Test
    fun createAndRoundtrip() {
        val conversationDeletedResource =
            ConversationDeletedResource.builder().id("id").deleted(true).build()

        assertThat(conversationDeletedResource.id()).isEqualTo("id")
        assertThat(conversationDeletedResource.deleted()).isEqualTo(true)

        val jsonMapper = jsonMapper()

        val roundtrippedConversationDeletedResource =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationDeletedResource),
                jacksonTypeRef<ConversationDeletedResource>(),
            )

        assertThat(roundtrippedConversationDeletedResource).isEqualTo(conversationDeletedResource)
    }
}
