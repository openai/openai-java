// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCreateEventTest {

    @Test
    fun create() {
        val responseCreateEvent =
            ResponseCreateEvent.builder()
                .eventId("event_id")
                .response(
                    ResponseCreateEvent.Response.builder()
                        .conversation(ResponseCreateEvent.Response.Conversation.AUTO)
                        .addInput(
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
                        )
                        .instructions("instructions")
                        .maxResponseOutputTokens(0L)
                        .metadata(
                            ResponseCreateEvent.Response.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .addModality(ResponseCreateEvent.Response.Modality.TEXT)
                        .outputAudioFormat(ResponseCreateEvent.Response.OutputAudioFormat.PCM16)
                        .temperature(0.0)
                        .toolChoice("tool_choice")
                        .addTool(
                            ResponseCreateEvent.Response.Tool.builder()
                                .description("description")
                                .name("name")
                                .parameters(JsonValue.from(mapOf<String, Any>()))
                                .type(ResponseCreateEvent.Response.Tool.Type.FUNCTION)
                                .build()
                        )
                        .voice(ResponseCreateEvent.Response.Voice.ALLOY)
                        .build()
                )
                .build()

        assertThat(responseCreateEvent.eventId()).contains("event_id")
        assertThat(responseCreateEvent.response())
            .contains(
                ResponseCreateEvent.Response.builder()
                    .conversation(ResponseCreateEvent.Response.Conversation.AUTO)
                    .addInput(
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
                    )
                    .instructions("instructions")
                    .maxResponseOutputTokens(0L)
                    .metadata(
                        ResponseCreateEvent.Response.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .addModality(ResponseCreateEvent.Response.Modality.TEXT)
                    .outputAudioFormat(ResponseCreateEvent.Response.OutputAudioFormat.PCM16)
                    .temperature(0.0)
                    .toolChoice("tool_choice")
                    .addTool(
                        ResponseCreateEvent.Response.Tool.builder()
                            .description("description")
                            .name("name")
                            .parameters(JsonValue.from(mapOf<String, Any>()))
                            .type(ResponseCreateEvent.Response.Tool.Type.FUNCTION)
                            .build()
                    )
                    .voice(ResponseCreateEvent.Response.Voice.ALLOY)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseCreateEvent =
            ResponseCreateEvent.builder()
                .eventId("event_id")
                .response(
                    ResponseCreateEvent.Response.builder()
                        .conversation(ResponseCreateEvent.Response.Conversation.AUTO)
                        .addInput(
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
                        )
                        .instructions("instructions")
                        .maxResponseOutputTokens(0L)
                        .metadata(
                            ResponseCreateEvent.Response.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .addModality(ResponseCreateEvent.Response.Modality.TEXT)
                        .outputAudioFormat(ResponseCreateEvent.Response.OutputAudioFormat.PCM16)
                        .temperature(0.0)
                        .toolChoice("tool_choice")
                        .addTool(
                            ResponseCreateEvent.Response.Tool.builder()
                                .description("description")
                                .name("name")
                                .parameters(JsonValue.from(mapOf<String, Any>()))
                                .type(ResponseCreateEvent.Response.Tool.Type.FUNCTION)
                                .build()
                        )
                        .voice(ResponseCreateEvent.Response.Voice.ALLOY)
                        .build()
                )
                .build()

        val roundtrippedResponseCreateEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseCreateEvent),
                jacksonTypeRef<ResponseCreateEvent>(),
            )

        assertThat(roundtrippedResponseCreateEvent).isEqualTo(responseCreateEvent)
    }
}
