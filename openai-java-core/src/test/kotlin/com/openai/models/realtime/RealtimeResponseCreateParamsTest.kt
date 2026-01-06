// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.responses.ResponsePrompt
import com.openai.models.responses.ToolChoiceOptions
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeResponseCreateParamsTest {

    @Test
    fun create() {
        val realtimeResponseCreateParams =
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
                                .voice(RealtimeResponseCreateAudioOutput.Output.Voice.ASH)
                                .build()
                        )
                        .build()
                )
                .conversation(RealtimeResponseCreateParams.Conversation.of("string"))
                .addInput(
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
                    RealtimeFunctionTool.builder()
                        .description("description")
                        .name("name")
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .type(RealtimeFunctionTool.Type.FUNCTION)
                        .build()
                )
                .build()

        assertThat(realtimeResponseCreateParams.audio())
            .contains(
                RealtimeResponseCreateAudioOutput.builder()
                    .output(
                        RealtimeResponseCreateAudioOutput.Output.builder()
                            .format(
                                RealtimeAudioFormats.AudioPcm.builder()
                                    .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                    .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                    .build()
                            )
                            .voice(RealtimeResponseCreateAudioOutput.Output.Voice.ASH)
                            .build()
                    )
                    .build()
            )
        assertThat(realtimeResponseCreateParams.conversation())
            .contains(RealtimeResponseCreateParams.Conversation.of("string"))
        assertThat(realtimeResponseCreateParams.input().getOrNull())
            .containsExactly(
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
        assertThat(realtimeResponseCreateParams.instructions()).contains("instructions")
        assertThat(realtimeResponseCreateParams.maxOutputTokens())
            .contains(RealtimeResponseCreateParams.MaxOutputTokens.ofInteger(0L))
        assertThat(realtimeResponseCreateParams.metadata())
            .contains(
                RealtimeResponseCreateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(realtimeResponseCreateParams.outputModalities().getOrNull())
            .containsExactly(RealtimeResponseCreateParams.OutputModality.TEXT)
        assertThat(realtimeResponseCreateParams.prompt())
            .contains(
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
        assertThat(realtimeResponseCreateParams.toolChoice())
            .contains(RealtimeResponseCreateParams.ToolChoice.ofOptions(ToolChoiceOptions.NONE))
        assertThat(realtimeResponseCreateParams.tools().getOrNull())
            .containsExactly(
                RealtimeResponseCreateParams.Tool.ofRealtimeFunction(
                    RealtimeFunctionTool.builder()
                        .description("description")
                        .name("name")
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .type(RealtimeFunctionTool.Type.FUNCTION)
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeResponseCreateParams =
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
                                .voice(RealtimeResponseCreateAudioOutput.Output.Voice.ASH)
                                .build()
                        )
                        .build()
                )
                .conversation(RealtimeResponseCreateParams.Conversation.of("string"))
                .addInput(
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
                    RealtimeFunctionTool.builder()
                        .description("description")
                        .name("name")
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .type(RealtimeFunctionTool.Type.FUNCTION)
                        .build()
                )
                .build()

        val roundtrippedRealtimeResponseCreateParams =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeResponseCreateParams),
                jacksonTypeRef<RealtimeResponseCreateParams>(),
            )

        assertThat(roundtrippedRealtimeResponseCreateParams).isEqualTo(realtimeResponseCreateParams)
    }
}
