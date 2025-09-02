// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseOutputItemDoneEventTest {

    @Test
    fun create() {
        val responseOutputItemDoneEvent =
            ResponseOutputItemDoneEvent.builder()
                .eventId("event_id")
                .item(
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
                )
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        assertThat(responseOutputItemDoneEvent.eventId()).isEqualTo("event_id")
        assertThat(responseOutputItemDoneEvent.item())
            .isEqualTo(
                ConversationItem.ofRealtimeConversationItemSystemMessage(
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
                )
            )
        assertThat(responseOutputItemDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseOutputItemDoneEvent.responseId()).isEqualTo("response_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseOutputItemDoneEvent =
            ResponseOutputItemDoneEvent.builder()
                .eventId("event_id")
                .item(
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
                )
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        val roundtrippedResponseOutputItemDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseOutputItemDoneEvent),
                jacksonTypeRef<ResponseOutputItemDoneEvent>(),
            )

        assertThat(roundtrippedResponseOutputItemDoneEvent).isEqualTo(responseOutputItemDoneEvent)
    }
}
