// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

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

        assertThat(responseOutputItemDoneEvent.eventId()).isEqualTo("event_id")
        assertThat(responseOutputItemDoneEvent.item())
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

        val roundtrippedResponseOutputItemDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseOutputItemDoneEvent),
                jacksonTypeRef<ResponseOutputItemDoneEvent>(),
            )

        assertThat(roundtrippedResponseOutputItemDoneEvent).isEqualTo(responseOutputItemDoneEvent)
    }
}
