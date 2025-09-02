// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeConversationItemSystemMessageTest {

    @Test
    fun create() {
        val realtimeConversationItemSystemMessage =
            RealtimeConversationItemSystemMessage.builder()
                .addContent(
                    RealtimeConversationItemSystemMessage.Content.builder()
                        .text("text")
                        .type(RealtimeConversationItemSystemMessage.Content.Type.INPUT_TEXT)
                        .build()
                )
                .id("id")
                .object_(RealtimeConversationItemSystemMessage.Object.REALTIME_ITEM)
                .status(RealtimeConversationItemSystemMessage.Status.COMPLETED)
                .build()

        assertThat(realtimeConversationItemSystemMessage.content())
            .containsExactly(
                RealtimeConversationItemSystemMessage.Content.builder()
                    .text("text")
                    .type(RealtimeConversationItemSystemMessage.Content.Type.INPUT_TEXT)
                    .build()
            )
        assertThat(realtimeConversationItemSystemMessage.id()).contains("id")
        assertThat(realtimeConversationItemSystemMessage.object_())
            .contains(RealtimeConversationItemSystemMessage.Object.REALTIME_ITEM)
        assertThat(realtimeConversationItemSystemMessage.status())
            .contains(RealtimeConversationItemSystemMessage.Status.COMPLETED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeConversationItemSystemMessage =
            RealtimeConversationItemSystemMessage.builder()
                .addContent(
                    RealtimeConversationItemSystemMessage.Content.builder()
                        .text("text")
                        .type(RealtimeConversationItemSystemMessage.Content.Type.INPUT_TEXT)
                        .build()
                )
                .id("id")
                .object_(RealtimeConversationItemSystemMessage.Object.REALTIME_ITEM)
                .status(RealtimeConversationItemSystemMessage.Status.COMPLETED)
                .build()

        val roundtrippedRealtimeConversationItemSystemMessage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeConversationItemSystemMessage),
                jacksonTypeRef<RealtimeConversationItemSystemMessage>(),
            )

        assertThat(roundtrippedRealtimeConversationItemSystemMessage)
            .isEqualTo(realtimeConversationItemSystemMessage)
    }
}
