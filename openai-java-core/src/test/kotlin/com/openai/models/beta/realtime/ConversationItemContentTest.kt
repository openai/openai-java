// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationItemContentTest {

    @Test
    fun create() {
        val conversationItemContent =
            ConversationItemContent.builder()
                .id("id")
                .audio("audio")
                .text("text")
                .transcript("transcript")
                .type(ConversationItemContent.Type.INPUT_TEXT)
                .build()

        assertThat(conversationItemContent.id()).contains("id")
        assertThat(conversationItemContent.audio()).contains("audio")
        assertThat(conversationItemContent.text()).contains("text")
        assertThat(conversationItemContent.transcript()).contains("transcript")
        assertThat(conversationItemContent.type()).contains(ConversationItemContent.Type.INPUT_TEXT)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItemContent =
            ConversationItemContent.builder()
                .id("id")
                .audio("audio")
                .text("text")
                .transcript("transcript")
                .type(ConversationItemContent.Type.INPUT_TEXT)
                .build()

        val roundtrippedConversationItemContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItemContent),
                jacksonTypeRef<ConversationItemContent>(),
            )

        assertThat(roundtrippedConversationItemContent).isEqualTo(conversationItemContent)
    }
}
