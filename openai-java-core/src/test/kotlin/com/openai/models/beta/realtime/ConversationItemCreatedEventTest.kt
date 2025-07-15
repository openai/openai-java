// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationItemCreatedEventTest {

    @Test
    fun create() {
        val conversationItemCreatedEvent =
            ConversationItemCreatedEvent.builder()
                .eventId("event_id")
                .item(
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
                )
                .previousItemId("previous_item_id")
                .build()

        assertThat(conversationItemCreatedEvent.eventId()).isEqualTo("event_id")
        assertThat(conversationItemCreatedEvent.item())
            .isEqualTo(
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
            )
        assertThat(conversationItemCreatedEvent.previousItemId()).contains("previous_item_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItemCreatedEvent =
            ConversationItemCreatedEvent.builder()
                .eventId("event_id")
                .item(
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
                )
                .previousItemId("previous_item_id")
                .build()

        val roundtrippedConversationItemCreatedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItemCreatedEvent),
                jacksonTypeRef<ConversationItemCreatedEvent>(),
            )

        assertThat(roundtrippedConversationItemCreatedEvent).isEqualTo(conversationItemCreatedEvent)
    }
}
