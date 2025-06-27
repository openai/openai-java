// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseOutputItemAddedEventTest {

    @Test
    fun create() {
        val responseOutputItemAddedEvent =
            ResponseOutputItemAddedEvent.builder()
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
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        assertThat(responseOutputItemAddedEvent.eventId()).isEqualTo("event_id")
        assertThat(responseOutputItemAddedEvent.item())
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
        assertThat(responseOutputItemAddedEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseOutputItemAddedEvent.responseId()).isEqualTo("response_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseOutputItemAddedEvent =
            ResponseOutputItemAddedEvent.builder()
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
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        val roundtrippedResponseOutputItemAddedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseOutputItemAddedEvent),
                jacksonTypeRef<ResponseOutputItemAddedEvent>(),
            )

        assertThat(roundtrippedResponseOutputItemAddedEvent).isEqualTo(responseOutputItemAddedEvent)
    }
}
