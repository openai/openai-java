// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationItemTest {

    @Test
    fun create() {
        val conversationItem =
            ConversationItem.builder()
                .id("id")
                .arguments("arguments")
                .callId("call_id")
                .addContent(
                    ConversationItemContent.builder()
                        .id("id")
                        .audio("audio")
                        .text("text")
                        .transcript("transcript")
                        .type(ConversationItemContent.Type.INPUT_TEXT)
                        .build()
                )
                .name("name")
                .object_(ConversationItem.Object.REALTIME_ITEM)
                .output("output")
                .role(ConversationItem.Role.USER)
                .status(ConversationItem.Status.COMPLETED)
                .type(ConversationItem.Type.MESSAGE)
                .build()

        assertThat(conversationItem.id()).contains("id")
        assertThat(conversationItem.arguments()).contains("arguments")
        assertThat(conversationItem.callId()).contains("call_id")
        assertThat(conversationItem.content().getOrNull())
            .containsExactly(
                ConversationItemContent.builder()
                    .id("id")
                    .audio("audio")
                    .text("text")
                    .transcript("transcript")
                    .type(ConversationItemContent.Type.INPUT_TEXT)
                    .build()
            )
        assertThat(conversationItem.name()).contains("name")
        assertThat(conversationItem.object_()).contains(ConversationItem.Object.REALTIME_ITEM)
        assertThat(conversationItem.output()).contains("output")
        assertThat(conversationItem.role()).contains(ConversationItem.Role.USER)
        assertThat(conversationItem.status()).contains(ConversationItem.Status.COMPLETED)
        assertThat(conversationItem.type()).contains(ConversationItem.Type.MESSAGE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItem =
            ConversationItem.builder()
                .id("id")
                .arguments("arguments")
                .callId("call_id")
                .addContent(
                    ConversationItemContent.builder()
                        .id("id")
                        .audio("audio")
                        .text("text")
                        .transcript("transcript")
                        .type(ConversationItemContent.Type.INPUT_TEXT)
                        .build()
                )
                .name("name")
                .object_(ConversationItem.Object.REALTIME_ITEM)
                .output("output")
                .role(ConversationItem.Role.USER)
                .status(ConversationItem.Status.COMPLETED)
                .type(ConversationItem.Type.MESSAGE)
                .build()

        val roundtrippedConversationItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItem),
                jacksonTypeRef<ConversationItem>(),
            )

        assertThat(roundtrippedConversationItem).isEqualTo(conversationItem)
    }
}
