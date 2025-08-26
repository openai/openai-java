// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationTest {

    @Test
    fun create() {
        val conversation =
            Conversation.builder()
                .id("id")
                .createdAt(0L)
                .metadata(JsonValue.from(mapOf<String, Any>()))
                .build()

        assertThat(conversation.id()).isEqualTo("id")
        assertThat(conversation.createdAt()).isEqualTo(0L)
        assertThat(conversation._metadata()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val conversation =
            Conversation.builder()
                .id("id")
                .createdAt(0L)
                .metadata(JsonValue.from(mapOf<String, Any>()))
                .build()

        val roundtrippedConversation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversation),
                jacksonTypeRef<Conversation>(),
            )

        assertThat(roundtrippedConversation).isEqualTo(conversation)
    }
}
