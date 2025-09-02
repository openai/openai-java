// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationItemWithReferenceTest {

    @Test
    fun create() {
        val conversationItemWithReference =
            ConversationItemWithReference.builder()
                .id("id")
                .arguments("arguments")
                .callId("call_id")
                .addContent(
                    ConversationItemWithReference.Content.builder()
                        .id("id")
                        .audio("audio")
                        .text("text")
                        .transcript("transcript")
                        .type(ConversationItemWithReference.Content.Type.INPUT_TEXT)
                        .build()
                )
                .name("name")
                .object_(ConversationItemWithReference.Object.REALTIME_ITEM)
                .output("output")
                .role(ConversationItemWithReference.Role.USER)
                .status(ConversationItemWithReference.Status.COMPLETED)
                .type(ConversationItemWithReference.Type.MESSAGE)
                .build()

        assertThat(conversationItemWithReference.id()).contains("id")
        assertThat(conversationItemWithReference.arguments()).contains("arguments")
        assertThat(conversationItemWithReference.callId()).contains("call_id")
        assertThat(conversationItemWithReference.content().getOrNull())
            .containsExactly(
                ConversationItemWithReference.Content.builder()
                    .id("id")
                    .audio("audio")
                    .text("text")
                    .transcript("transcript")
                    .type(ConversationItemWithReference.Content.Type.INPUT_TEXT)
                    .build()
            )
        assertThat(conversationItemWithReference.name()).contains("name")
        assertThat(conversationItemWithReference.object_())
            .contains(ConversationItemWithReference.Object.REALTIME_ITEM)
        assertThat(conversationItemWithReference.output()).contains("output")
        assertThat(conversationItemWithReference.role())
            .contains(ConversationItemWithReference.Role.USER)
        assertThat(conversationItemWithReference.status())
            .contains(ConversationItemWithReference.Status.COMPLETED)
        assertThat(conversationItemWithReference.type())
            .contains(ConversationItemWithReference.Type.MESSAGE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItemWithReference =
            ConversationItemWithReference.builder()
                .id("id")
                .arguments("arguments")
                .callId("call_id")
                .addContent(
                    ConversationItemWithReference.Content.builder()
                        .id("id")
                        .audio("audio")
                        .text("text")
                        .transcript("transcript")
                        .type(ConversationItemWithReference.Content.Type.INPUT_TEXT)
                        .build()
                )
                .name("name")
                .object_(ConversationItemWithReference.Object.REALTIME_ITEM)
                .output("output")
                .role(ConversationItemWithReference.Role.USER)
                .status(ConversationItemWithReference.Status.COMPLETED)
                .type(ConversationItemWithReference.Type.MESSAGE)
                .build()

        val roundtrippedConversationItemWithReference =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItemWithReference),
                jacksonTypeRef<ConversationItemWithReference>(),
            )

        assertThat(roundtrippedConversationItemWithReference)
            .isEqualTo(conversationItemWithReference)
    }
}
