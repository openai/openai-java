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
                    RealtimeResponseCreateParams.builder()
                        .audio(
                            RealtimeResponseCreateAudioOutput.builder()
                                .output(
                                    RealtimeResponseCreateAudioOutput.Output.builder()
                                        .format(
                                            RealtimeAudioFormats.AudioPcm.builder()
                                                .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                                .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                                .build()
                                        )
                                        .voice(RealtimeResponseCreateAudioOutput.Output.Voice.ALLOY)
                                        .build()
                                )
                                .build()
                        )
                        .conversation(RealtimeResponseCreateParams.Conversation.AUTO)
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
                            RealtimeResponseCreateParams.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .addOutputModality(RealtimeResponseCreateParams.OutputModality.TEXT)
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
                        .toolChoice(ToolChoiceOptions.NONE)
                        .addTool(
                            Models.builder()
                                .description("description")
                                .name("name")
                                .parameters(JsonValue.from(mapOf<String, Any>()))
                                .type(Models.Type.FUNCTION)
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(responseCreateEvent.eventId()).contains("event_id")
        assertThat(responseCreateEvent.response())
            .contains(
                RealtimeResponseCreateParams.builder()
                    .audio(
                        RealtimeResponseCreateAudioOutput.builder()
                            .output(
                                RealtimeResponseCreateAudioOutput.Output.builder()
                                    .format(
                                        RealtimeAudioFormats.AudioPcm.builder()
                                            .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                            .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                            .build()
                                    )
                                    .voice(RealtimeResponseCreateAudioOutput.Output.Voice.ALLOY)
                                    .build()
                            )
                            .build()
                    )
                    .conversation(RealtimeResponseCreateParams.Conversation.AUTO)
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
                        RealtimeResponseCreateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .addOutputModality(RealtimeResponseCreateParams.OutputModality.TEXT)
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
                    .toolChoice(ToolChoiceOptions.NONE)
                    .addTool(
                        Models.builder()
                            .description("description")
                            .name("name")
                            .parameters(JsonValue.from(mapOf<String, Any>()))
                            .type(Models.Type.FUNCTION)
                            .build()
                    )
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
                    RealtimeResponseCreateParams.builder()
                        .audio(
                            RealtimeResponseCreateAudioOutput.builder()
                                .output(
                                    RealtimeResponseCreateAudioOutput.Output.builder()
                                        .format(
                                            RealtimeAudioFormats.AudioPcm.builder()
                                                .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                                .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                                .build()
                                        )
                                        .voice(RealtimeResponseCreateAudioOutput.Output.Voice.ALLOY)
                                        .build()
                                )
                                .build()
                        )
                        .conversation(RealtimeResponseCreateParams.Conversation.AUTO)
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
                            RealtimeResponseCreateParams.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .addOutputModality(RealtimeResponseCreateParams.OutputModality.TEXT)
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
                        .toolChoice(ToolChoiceOptions.NONE)
                        .addTool(
                            Models.builder()
                                .description("description")
                                .name("name")
                                .parameters(JsonValue.from(mapOf<String, Any>()))
                                .type(Models.Type.FUNCTION)
                                .build()
                        )
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
