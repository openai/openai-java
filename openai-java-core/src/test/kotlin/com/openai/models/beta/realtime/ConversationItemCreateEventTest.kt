// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationItemCreateEventTest {

    @Test
    fun create() {
        val conversationItemCreateEvent =
            ConversationItemCreateEvent.builder()
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
                .eventId("event_id")
                .previousItemId("previous_item_id")
                .build()

        assertThat(conversationItemCreateEvent.item())
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
        assertThat(conversationItemCreateEvent.eventId()).contains("event_id")
        assertThat(conversationItemCreateEvent.previousItemId()).contains("previous_item_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItemCreateEvent =
            ConversationItemCreateEvent.builder()
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
                .eventId("event_id")
                .previousItemId("previous_item_id")
                .build()

        val roundtrippedConversationItemCreateEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItemCreateEvent),
                jacksonTypeRef<ConversationItemCreateEvent>(),
            )

        assertThat(roundtrippedConversationItemCreateEvent).isEqualTo(conversationItemCreateEvent)
    }
}
