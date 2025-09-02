// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeConversationItemUserMessageTest {

    @Test
    fun create() {
        val realtimeConversationItemUserMessage =
            RealtimeConversationItemUserMessage.builder()
                .addContent(
                    RealtimeConversationItemUserMessage.Content.builder()
                        .audio("audio")
                        .text("text")
                        .transcript("transcript")
                        .type(RealtimeConversationItemUserMessage.Content.Type.INPUT_TEXT)
                        .build()
                )
                .id("id")
                .object_(RealtimeConversationItemUserMessage.Object.REALTIME_ITEM)
                .status(RealtimeConversationItemUserMessage.Status.COMPLETED)
                .build()

        assertThat(realtimeConversationItemUserMessage.content())
            .containsExactly(
                RealtimeConversationItemUserMessage.Content.builder()
                    .audio("audio")
                    .text("text")
                    .transcript("transcript")
                    .type(RealtimeConversationItemUserMessage.Content.Type.INPUT_TEXT)
                    .build()
            )
        assertThat(realtimeConversationItemUserMessage.id()).contains("id")
        assertThat(realtimeConversationItemUserMessage.object_())
            .contains(RealtimeConversationItemUserMessage.Object.REALTIME_ITEM)
        assertThat(realtimeConversationItemUserMessage.status())
            .contains(RealtimeConversationItemUserMessage.Status.COMPLETED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeConversationItemUserMessage =
            RealtimeConversationItemUserMessage.builder()
                .addContent(
                    RealtimeConversationItemUserMessage.Content.builder()
                        .audio("audio")
                        .text("text")
                        .transcript("transcript")
                        .type(RealtimeConversationItemUserMessage.Content.Type.INPUT_TEXT)
                        .build()
                )
                .id("id")
                .object_(RealtimeConversationItemUserMessage.Object.REALTIME_ITEM)
                .status(RealtimeConversationItemUserMessage.Status.COMPLETED)
                .build()

        val roundtrippedRealtimeConversationItemUserMessage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeConversationItemUserMessage),
                jacksonTypeRef<RealtimeConversationItemUserMessage>(),
            )

        assertThat(roundtrippedRealtimeConversationItemUserMessage)
            .isEqualTo(realtimeConversationItemUserMessage)
    }
}
