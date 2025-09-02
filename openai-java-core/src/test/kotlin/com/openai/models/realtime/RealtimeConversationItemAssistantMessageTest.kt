// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeConversationItemAssistantMessageTest {

    @Test
    fun create() {
        val realtimeConversationItemAssistantMessage =
            RealtimeConversationItemAssistantMessage.builder()
                .addContent(
                    RealtimeConversationItemAssistantMessage.Content.builder()
                        .text("text")
                        .type(RealtimeConversationItemAssistantMessage.Content.Type.TEXT)
                        .build()
                )
                .id("id")
                .object_(RealtimeConversationItemAssistantMessage.Object.REALTIME_ITEM)
                .status(RealtimeConversationItemAssistantMessage.Status.COMPLETED)
                .build()

        assertThat(realtimeConversationItemAssistantMessage.content())
            .containsExactly(
                RealtimeConversationItemAssistantMessage.Content.builder()
                    .text("text")
                    .type(RealtimeConversationItemAssistantMessage.Content.Type.TEXT)
                    .build()
            )
        assertThat(realtimeConversationItemAssistantMessage.id()).contains("id")
        assertThat(realtimeConversationItemAssistantMessage.object_())
            .contains(RealtimeConversationItemAssistantMessage.Object.REALTIME_ITEM)
        assertThat(realtimeConversationItemAssistantMessage.status())
            .contains(RealtimeConversationItemAssistantMessage.Status.COMPLETED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeConversationItemAssistantMessage =
            RealtimeConversationItemAssistantMessage.builder()
                .addContent(
                    RealtimeConversationItemAssistantMessage.Content.builder()
                        .text("text")
                        .type(RealtimeConversationItemAssistantMessage.Content.Type.TEXT)
                        .build()
                )
                .id("id")
                .object_(RealtimeConversationItemAssistantMessage.Object.REALTIME_ITEM)
                .status(RealtimeConversationItemAssistantMessage.Status.COMPLETED)
                .build()

        val roundtrippedRealtimeConversationItemAssistantMessage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeConversationItemAssistantMessage),
                jacksonTypeRef<RealtimeConversationItemAssistantMessage>(),
            )

        assertThat(roundtrippedRealtimeConversationItemAssistantMessage)
            .isEqualTo(realtimeConversationItemAssistantMessage)
    }
}
