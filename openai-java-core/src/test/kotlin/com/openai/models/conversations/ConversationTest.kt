// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.conversations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationTest {

    @Test
    fun createAndRoundtrip() {
        val conversation =
            Conversation.builder()
                .id("id")
                .createdAt(0L)
                .metadata(
                    Conversation.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()

        assertThat(conversation.id()).contains("id")
        assertThat(conversation.createdAt()).contains(0L)
        assertThat(conversation.metadata())
            .contains(
                Conversation.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedConversation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversation),
                jacksonTypeRef<Conversation>(),
            )

        assertThat(roundtrippedConversation).isEqualTo(conversation)
    }
}
