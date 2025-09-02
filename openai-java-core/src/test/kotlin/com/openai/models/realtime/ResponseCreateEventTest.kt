// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.responses.ResponsePrompt
import com.openai.models.responses.ToolChoiceOptions
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
                            RealtimeConversationItemSystemMessage.builder()
                                .addContent(
                                    RealtimeConversationItemSystemMessage.Content.builder()
                                        .text("text")
                                        .type(
                                            RealtimeConversationItemSystemMessage.Content.Type
                                                .INPUT_TEXT
                                        )
                                        .build()
                                )
                                .id("id")
                                .object_(RealtimeConversationItemSystemMessage.Object.REALTIME_ITEM)
                                .status(RealtimeConversationItemSystemMessage.Status.COMPLETED)
                                .build()
                        )
                        .instructions("instructions")
                        .maxOutputTokens(0L)
                        .metadata(
                            ResponseCreateEvent.Response.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .addModality(ResponseCreateEvent.Response.Modality.TEXT)
                        .outputAudioFormat(ResponseCreateEvent.Response.OutputAudioFormat.PCM16)
                        .prompt(
                            ResponsePrompt.builder()
                                .id("id")
                                .variables(
                                    ResponsePrompt.Variables.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("string"))
                                        .build()
                                )
                                .version("version")
                                .build()
                        )
                        .temperature(0.0)
                        .toolChoice(ToolChoiceOptions.NONE)
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
                        RealtimeConversationItemSystemMessage.builder()
                            .addContent(
                                RealtimeConversationItemSystemMessage.Content.builder()
                                    .text("text")
                                    .type(
                                        RealtimeConversationItemSystemMessage.Content.Type
                                            .INPUT_TEXT
                                    )
                                    .build()
                            )
                            .id("id")
                            .object_(RealtimeConversationItemSystemMessage.Object.REALTIME_ITEM)
                            .status(RealtimeConversationItemSystemMessage.Status.COMPLETED)
                            .build()
                    )
                    .instructions("instructions")
                    .maxOutputTokens(0L)
                    .metadata(
                        ResponseCreateEvent.Response.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .addModality(ResponseCreateEvent.Response.Modality.TEXT)
                    .outputAudioFormat(ResponseCreateEvent.Response.OutputAudioFormat.PCM16)
                    .prompt(
                        ResponsePrompt.builder()
                            .id("id")
                            .variables(
                                ResponsePrompt.Variables.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .version("version")
                            .build()
                    )
                    .temperature(0.0)
                    .toolChoice(ToolChoiceOptions.NONE)
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
                            RealtimeConversationItemSystemMessage.builder()
                                .addContent(
                                    RealtimeConversationItemSystemMessage.Content.builder()
                                        .text("text")
                                        .type(
                                            RealtimeConversationItemSystemMessage.Content.Type
                                                .INPUT_TEXT
                                        )
                                        .build()
                                )
                                .id("id")
                                .object_(RealtimeConversationItemSystemMessage.Object.REALTIME_ITEM)
                                .status(RealtimeConversationItemSystemMessage.Status.COMPLETED)
                                .build()
                        )
                        .instructions("instructions")
                        .maxOutputTokens(0L)
                        .metadata(
                            ResponseCreateEvent.Response.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .addModality(ResponseCreateEvent.Response.Modality.TEXT)
                        .outputAudioFormat(ResponseCreateEvent.Response.OutputAudioFormat.PCM16)
                        .prompt(
                            ResponsePrompt.builder()
                                .id("id")
                                .variables(
                                    ResponsePrompt.Variables.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("string"))
                                        .build()
                                )
                                .version("version")
                                .build()
                        )
                        .temperature(0.0)
                        .toolChoice(ToolChoiceOptions.NONE)
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
