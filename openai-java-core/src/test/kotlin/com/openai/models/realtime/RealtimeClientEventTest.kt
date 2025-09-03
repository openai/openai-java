// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.responses.ResponsePrompt
import com.openai.models.responses.ToolChoiceOptions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class RealtimeClientEventTest {

    @Test
    fun ofConversationItemCreate() {
        val conversationItemCreate =
            ConversationItemCreateEvent.builder()
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
                .eventId("event_id")
                .previousItemId("previous_item_id")
                .build()

        val realtimeClientEvent =
            RealtimeClientEvent.ofConversationItemCreate(conversationItemCreate)

        assertThat(realtimeClientEvent.conversationItemCreate()).contains(conversationItemCreate)
        assertThat(realtimeClientEvent.conversationItemDelete()).isEmpty
        assertThat(realtimeClientEvent.conversationItemRetrieve()).isEmpty
        assertThat(realtimeClientEvent.conversationItemTruncate()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferAppend()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferClear()).isEmpty
        assertThat(realtimeClientEvent.outputAudioBufferClear()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferCommit()).isEmpty
        assertThat(realtimeClientEvent.responseCancel()).isEmpty
        assertThat(realtimeClientEvent.responseCreate()).isEmpty
        assertThat(realtimeClientEvent.sessionUpdate()).isEmpty
        assertThat(realtimeClientEvent.transcriptionSessionUpdate()).isEmpty
    }

    @Test
    fun ofConversationItemCreateRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeClientEvent =
            RealtimeClientEvent.ofConversationItemCreate(
                ConversationItemCreateEvent.builder()
                    .item(
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
                    .eventId("event_id")
                    .previousItemId("previous_item_id")
                    .build()
            )

        val roundtrippedRealtimeClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeClientEvent),
                jacksonTypeRef<RealtimeClientEvent>(),
            )

        assertThat(roundtrippedRealtimeClientEvent).isEqualTo(realtimeClientEvent)
    }

    @Test
    fun ofConversationItemDelete() {
        val conversationItemDelete =
            ConversationItemDeleteEvent.builder().itemId("item_id").eventId("event_id").build()

        val realtimeClientEvent =
            RealtimeClientEvent.ofConversationItemDelete(conversationItemDelete)

        assertThat(realtimeClientEvent.conversationItemCreate()).isEmpty
        assertThat(realtimeClientEvent.conversationItemDelete()).contains(conversationItemDelete)
        assertThat(realtimeClientEvent.conversationItemRetrieve()).isEmpty
        assertThat(realtimeClientEvent.conversationItemTruncate()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferAppend()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferClear()).isEmpty
        assertThat(realtimeClientEvent.outputAudioBufferClear()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferCommit()).isEmpty
        assertThat(realtimeClientEvent.responseCancel()).isEmpty
        assertThat(realtimeClientEvent.responseCreate()).isEmpty
        assertThat(realtimeClientEvent.sessionUpdate()).isEmpty
        assertThat(realtimeClientEvent.transcriptionSessionUpdate()).isEmpty
    }

    @Test
    fun ofConversationItemDeleteRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeClientEvent =
            RealtimeClientEvent.ofConversationItemDelete(
                ConversationItemDeleteEvent.builder().itemId("item_id").eventId("event_id").build()
            )

        val roundtrippedRealtimeClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeClientEvent),
                jacksonTypeRef<RealtimeClientEvent>(),
            )

        assertThat(roundtrippedRealtimeClientEvent).isEqualTo(realtimeClientEvent)
    }

    @Test
    fun ofConversationItemRetrieve() {
        val conversationItemRetrieve =
            ConversationItemRetrieveEvent.builder().itemId("item_id").eventId("event_id").build()

        val realtimeClientEvent =
            RealtimeClientEvent.ofConversationItemRetrieve(conversationItemRetrieve)

        assertThat(realtimeClientEvent.conversationItemCreate()).isEmpty
        assertThat(realtimeClientEvent.conversationItemDelete()).isEmpty
        assertThat(realtimeClientEvent.conversationItemRetrieve())
            .contains(conversationItemRetrieve)
        assertThat(realtimeClientEvent.conversationItemTruncate()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferAppend()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferClear()).isEmpty
        assertThat(realtimeClientEvent.outputAudioBufferClear()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferCommit()).isEmpty
        assertThat(realtimeClientEvent.responseCancel()).isEmpty
        assertThat(realtimeClientEvent.responseCreate()).isEmpty
        assertThat(realtimeClientEvent.sessionUpdate()).isEmpty
        assertThat(realtimeClientEvent.transcriptionSessionUpdate()).isEmpty
    }

    @Test
    fun ofConversationItemRetrieveRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeClientEvent =
            RealtimeClientEvent.ofConversationItemRetrieve(
                ConversationItemRetrieveEvent.builder()
                    .itemId("item_id")
                    .eventId("event_id")
                    .build()
            )

        val roundtrippedRealtimeClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeClientEvent),
                jacksonTypeRef<RealtimeClientEvent>(),
            )

        assertThat(roundtrippedRealtimeClientEvent).isEqualTo(realtimeClientEvent)
    }

    @Test
    fun ofConversationItemTruncate() {
        val conversationItemTruncate =
            ConversationItemTruncateEvent.builder()
                .audioEndMs(0L)
                .contentIndex(0L)
                .itemId("item_id")
                .eventId("event_id")
                .build()

        val realtimeClientEvent =
            RealtimeClientEvent.ofConversationItemTruncate(conversationItemTruncate)

        assertThat(realtimeClientEvent.conversationItemCreate()).isEmpty
        assertThat(realtimeClientEvent.conversationItemDelete()).isEmpty
        assertThat(realtimeClientEvent.conversationItemRetrieve()).isEmpty
        assertThat(realtimeClientEvent.conversationItemTruncate())
            .contains(conversationItemTruncate)
        assertThat(realtimeClientEvent.inputAudioBufferAppend()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferClear()).isEmpty
        assertThat(realtimeClientEvent.outputAudioBufferClear()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferCommit()).isEmpty
        assertThat(realtimeClientEvent.responseCancel()).isEmpty
        assertThat(realtimeClientEvent.responseCreate()).isEmpty
        assertThat(realtimeClientEvent.sessionUpdate()).isEmpty
        assertThat(realtimeClientEvent.transcriptionSessionUpdate()).isEmpty
    }

    @Test
    fun ofConversationItemTruncateRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeClientEvent =
            RealtimeClientEvent.ofConversationItemTruncate(
                ConversationItemTruncateEvent.builder()
                    .audioEndMs(0L)
                    .contentIndex(0L)
                    .itemId("item_id")
                    .eventId("event_id")
                    .build()
            )

        val roundtrippedRealtimeClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeClientEvent),
                jacksonTypeRef<RealtimeClientEvent>(),
            )

        assertThat(roundtrippedRealtimeClientEvent).isEqualTo(realtimeClientEvent)
    }

    @Test
    fun ofInputAudioBufferAppend() {
        val inputAudioBufferAppend =
            InputAudioBufferAppendEvent.builder().audio("audio").eventId("event_id").build()

        val realtimeClientEvent =
            RealtimeClientEvent.ofInputAudioBufferAppend(inputAudioBufferAppend)

        assertThat(realtimeClientEvent.conversationItemCreate()).isEmpty
        assertThat(realtimeClientEvent.conversationItemDelete()).isEmpty
        assertThat(realtimeClientEvent.conversationItemRetrieve()).isEmpty
        assertThat(realtimeClientEvent.conversationItemTruncate()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferAppend()).contains(inputAudioBufferAppend)
        assertThat(realtimeClientEvent.inputAudioBufferClear()).isEmpty
        assertThat(realtimeClientEvent.outputAudioBufferClear()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferCommit()).isEmpty
        assertThat(realtimeClientEvent.responseCancel()).isEmpty
        assertThat(realtimeClientEvent.responseCreate()).isEmpty
        assertThat(realtimeClientEvent.sessionUpdate()).isEmpty
        assertThat(realtimeClientEvent.transcriptionSessionUpdate()).isEmpty
    }

    @Test
    fun ofInputAudioBufferAppendRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeClientEvent =
            RealtimeClientEvent.ofInputAudioBufferAppend(
                InputAudioBufferAppendEvent.builder().audio("audio").eventId("event_id").build()
            )

        val roundtrippedRealtimeClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeClientEvent),
                jacksonTypeRef<RealtimeClientEvent>(),
            )

        assertThat(roundtrippedRealtimeClientEvent).isEqualTo(realtimeClientEvent)
    }

    @Test
    fun ofInputAudioBufferClear() {
        val inputAudioBufferClear = InputAudioBufferClearEvent.builder().eventId("event_id").build()

        val realtimeClientEvent = RealtimeClientEvent.ofInputAudioBufferClear(inputAudioBufferClear)

        assertThat(realtimeClientEvent.conversationItemCreate()).isEmpty
        assertThat(realtimeClientEvent.conversationItemDelete()).isEmpty
        assertThat(realtimeClientEvent.conversationItemRetrieve()).isEmpty
        assertThat(realtimeClientEvent.conversationItemTruncate()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferAppend()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferClear()).contains(inputAudioBufferClear)
        assertThat(realtimeClientEvent.outputAudioBufferClear()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferCommit()).isEmpty
        assertThat(realtimeClientEvent.responseCancel()).isEmpty
        assertThat(realtimeClientEvent.responseCreate()).isEmpty
        assertThat(realtimeClientEvent.sessionUpdate()).isEmpty
        assertThat(realtimeClientEvent.transcriptionSessionUpdate()).isEmpty
    }

    @Test
    fun ofInputAudioBufferClearRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeClientEvent =
            RealtimeClientEvent.ofInputAudioBufferClear(
                InputAudioBufferClearEvent.builder().eventId("event_id").build()
            )

        val roundtrippedRealtimeClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeClientEvent),
                jacksonTypeRef<RealtimeClientEvent>(),
            )

        assertThat(roundtrippedRealtimeClientEvent).isEqualTo(realtimeClientEvent)
    }

    @Test
    fun ofOutputAudioBufferClear() {
        val outputAudioBufferClear =
            OutputAudioBufferClearEvent.builder().eventId("event_id").build()

        val realtimeClientEvent =
            RealtimeClientEvent.ofOutputAudioBufferClear(outputAudioBufferClear)

        assertThat(realtimeClientEvent.conversationItemCreate()).isEmpty
        assertThat(realtimeClientEvent.conversationItemDelete()).isEmpty
        assertThat(realtimeClientEvent.conversationItemRetrieve()).isEmpty
        assertThat(realtimeClientEvent.conversationItemTruncate()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferAppend()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferClear()).isEmpty
        assertThat(realtimeClientEvent.outputAudioBufferClear()).contains(outputAudioBufferClear)
        assertThat(realtimeClientEvent.inputAudioBufferCommit()).isEmpty
        assertThat(realtimeClientEvent.responseCancel()).isEmpty
        assertThat(realtimeClientEvent.responseCreate()).isEmpty
        assertThat(realtimeClientEvent.sessionUpdate()).isEmpty
        assertThat(realtimeClientEvent.transcriptionSessionUpdate()).isEmpty
    }

    @Test
    fun ofOutputAudioBufferClearRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeClientEvent =
            RealtimeClientEvent.ofOutputAudioBufferClear(
                OutputAudioBufferClearEvent.builder().eventId("event_id").build()
            )

        val roundtrippedRealtimeClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeClientEvent),
                jacksonTypeRef<RealtimeClientEvent>(),
            )

        assertThat(roundtrippedRealtimeClientEvent).isEqualTo(realtimeClientEvent)
    }

    @Test
    fun ofInputAudioBufferCommit() {
        val inputAudioBufferCommit =
            InputAudioBufferCommitEvent.builder().eventId("event_id").build()

        val realtimeClientEvent =
            RealtimeClientEvent.ofInputAudioBufferCommit(inputAudioBufferCommit)

        assertThat(realtimeClientEvent.conversationItemCreate()).isEmpty
        assertThat(realtimeClientEvent.conversationItemDelete()).isEmpty
        assertThat(realtimeClientEvent.conversationItemRetrieve()).isEmpty
        assertThat(realtimeClientEvent.conversationItemTruncate()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferAppend()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferClear()).isEmpty
        assertThat(realtimeClientEvent.outputAudioBufferClear()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferCommit()).contains(inputAudioBufferCommit)
        assertThat(realtimeClientEvent.responseCancel()).isEmpty
        assertThat(realtimeClientEvent.responseCreate()).isEmpty
        assertThat(realtimeClientEvent.sessionUpdate()).isEmpty
        assertThat(realtimeClientEvent.transcriptionSessionUpdate()).isEmpty
    }

    @Test
    fun ofInputAudioBufferCommitRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeClientEvent =
            RealtimeClientEvent.ofInputAudioBufferCommit(
                InputAudioBufferCommitEvent.builder().eventId("event_id").build()
            )

        val roundtrippedRealtimeClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeClientEvent),
                jacksonTypeRef<RealtimeClientEvent>(),
            )

        assertThat(roundtrippedRealtimeClientEvent).isEqualTo(realtimeClientEvent)
    }

    @Test
    fun ofResponseCancel() {
        val responseCancel =
            ResponseCancelEvent.builder().eventId("event_id").responseId("response_id").build()

        val realtimeClientEvent = RealtimeClientEvent.ofResponseCancel(responseCancel)

        assertThat(realtimeClientEvent.conversationItemCreate()).isEmpty
        assertThat(realtimeClientEvent.conversationItemDelete()).isEmpty
        assertThat(realtimeClientEvent.conversationItemRetrieve()).isEmpty
        assertThat(realtimeClientEvent.conversationItemTruncate()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferAppend()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferClear()).isEmpty
        assertThat(realtimeClientEvent.outputAudioBufferClear()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferCommit()).isEmpty
        assertThat(realtimeClientEvent.responseCancel()).contains(responseCancel)
        assertThat(realtimeClientEvent.responseCreate()).isEmpty
        assertThat(realtimeClientEvent.sessionUpdate()).isEmpty
        assertThat(realtimeClientEvent.transcriptionSessionUpdate()).isEmpty
    }

    @Test
    fun ofResponseCancelRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeClientEvent =
            RealtimeClientEvent.ofResponseCancel(
                ResponseCancelEvent.builder().eventId("event_id").responseId("response_id").build()
            )

        val roundtrippedRealtimeClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeClientEvent),
                jacksonTypeRef<RealtimeClientEvent>(),
            )

        assertThat(roundtrippedRealtimeClientEvent).isEqualTo(realtimeClientEvent)
    }

    @Test
    fun ofResponseCreate() {
        val responseCreate =
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

        val realtimeClientEvent = RealtimeClientEvent.ofResponseCreate(responseCreate)

        assertThat(realtimeClientEvent.conversationItemCreate()).isEmpty
        assertThat(realtimeClientEvent.conversationItemDelete()).isEmpty
        assertThat(realtimeClientEvent.conversationItemRetrieve()).isEmpty
        assertThat(realtimeClientEvent.conversationItemTruncate()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferAppend()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferClear()).isEmpty
        assertThat(realtimeClientEvent.outputAudioBufferClear()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferCommit()).isEmpty
        assertThat(realtimeClientEvent.responseCancel()).isEmpty
        assertThat(realtimeClientEvent.responseCreate()).contains(responseCreate)
        assertThat(realtimeClientEvent.sessionUpdate()).isEmpty
        assertThat(realtimeClientEvent.transcriptionSessionUpdate()).isEmpty
    }

    @Test
    fun ofResponseCreateRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeClientEvent =
            RealtimeClientEvent.ofResponseCreate(
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
                                    .object_(
                                        RealtimeConversationItemSystemMessage.Object.REALTIME_ITEM
                                    )
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
            )

        val roundtrippedRealtimeClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeClientEvent),
                jacksonTypeRef<RealtimeClientEvent>(),
            )

        assertThat(roundtrippedRealtimeClientEvent).isEqualTo(realtimeClientEvent)
    }

    @Test
    fun ofSessionUpdate() {
        val sessionUpdate =
            SessionUpdateEvent.builder()
                .session(
                    RealtimeSessionCreateRequest.builder()
                        .model(RealtimeSessionCreateRequest.Model.GPT_REALTIME)
                        .audio(
                            RealtimeAudioConfig.builder()
                                .input(
                                    RealtimeAudioConfig.Input.builder()
                                        .format(RealtimeAudioConfig.Input.Format.PCM16)
                                        .noiseReduction(
                                            RealtimeAudioConfig.Input.NoiseReduction.builder()
                                                .type(
                                                    RealtimeAudioConfig.Input.NoiseReduction.Type
                                                        .NEAR_FIELD
                                                )
                                                .build()
                                        )
                                        .transcription(
                                            RealtimeAudioConfig.Input.Transcription.builder()
                                                .language("language")
                                                .model(
                                                    RealtimeAudioConfig.Input.Transcription.Model
                                                        .WHISPER_1
                                                )
                                                .prompt("prompt")
                                                .build()
                                        )
                                        .turnDetection(
                                            RealtimeAudioConfig.Input.TurnDetection.builder()
                                                .createResponse(true)
                                                .eagerness(
                                                    RealtimeAudioConfig.Input.TurnDetection
                                                        .Eagerness
                                                        .LOW
                                                )
                                                .idleTimeoutMs(0L)
                                                .interruptResponse(true)
                                                .prefixPaddingMs(0L)
                                                .silenceDurationMs(0L)
                                                .threshold(0.0)
                                                .type(
                                                    RealtimeAudioConfig.Input.TurnDetection.Type
                                                        .SERVER_VAD
                                                )
                                                .build()
                                        )
                                        .build()
                                )
                                .output(
                                    RealtimeAudioConfig.Output.builder()
                                        .format(RealtimeAudioConfig.Output.Format.PCM16)
                                        .speed(0.25)
                                        .voice(RealtimeAudioConfig.Output.Voice.ALLOY)
                                        .build()
                                )
                                .build()
                        )
                        .clientSecret(
                            RealtimeClientSecretConfig.builder()
                                .expiresAfter(
                                    RealtimeClientSecretConfig.ExpiresAfter.builder()
                                        .anchor(
                                            RealtimeClientSecretConfig.ExpiresAfter.Anchor
                                                .CREATED_AT
                                        )
                                        .seconds(0L)
                                        .build()
                                )
                                .build()
                        )
                        .addInclude(
                            RealtimeSessionCreateRequest.Include
                                .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                        )
                        .instructions("instructions")
                        .maxOutputTokens(0L)
                        .addOutputModality(RealtimeSessionCreateRequest.OutputModality.TEXT)
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
                            RealtimeToolsConfigUnion.Function.builder()
                                .description("description")
                                .name("name")
                                .parameters(JsonValue.from(mapOf<String, Any>()))
                                .type(RealtimeToolsConfigUnion.Function.Type.FUNCTION)
                                .build()
                        )
                        .tracingAuto()
                        .truncation(RealtimeTruncation.RealtimeTruncationStrategy.AUTO)
                        .build()
                )
                .eventId("event_id")
                .build()

        val realtimeClientEvent = RealtimeClientEvent.ofSessionUpdate(sessionUpdate)

        assertThat(realtimeClientEvent.conversationItemCreate()).isEmpty
        assertThat(realtimeClientEvent.conversationItemDelete()).isEmpty
        assertThat(realtimeClientEvent.conversationItemRetrieve()).isEmpty
        assertThat(realtimeClientEvent.conversationItemTruncate()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferAppend()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferClear()).isEmpty
        assertThat(realtimeClientEvent.outputAudioBufferClear()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferCommit()).isEmpty
        assertThat(realtimeClientEvent.responseCancel()).isEmpty
        assertThat(realtimeClientEvent.responseCreate()).isEmpty
        assertThat(realtimeClientEvent.sessionUpdate()).contains(sessionUpdate)
        assertThat(realtimeClientEvent.transcriptionSessionUpdate()).isEmpty
    }

    @Test
    fun ofSessionUpdateRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeClientEvent =
            RealtimeClientEvent.ofSessionUpdate(
                SessionUpdateEvent.builder()
                    .session(
                        RealtimeSessionCreateRequest.builder()
                            .model(RealtimeSessionCreateRequest.Model.GPT_REALTIME)
                            .audio(
                                RealtimeAudioConfig.builder()
                                    .input(
                                        RealtimeAudioConfig.Input.builder()
                                            .format(RealtimeAudioConfig.Input.Format.PCM16)
                                            .noiseReduction(
                                                RealtimeAudioConfig.Input.NoiseReduction.builder()
                                                    .type(
                                                        RealtimeAudioConfig.Input.NoiseReduction
                                                            .Type
                                                            .NEAR_FIELD
                                                    )
                                                    .build()
                                            )
                                            .transcription(
                                                RealtimeAudioConfig.Input.Transcription.builder()
                                                    .language("language")
                                                    .model(
                                                        RealtimeAudioConfig.Input.Transcription
                                                            .Model
                                                            .WHISPER_1
                                                    )
                                                    .prompt("prompt")
                                                    .build()
                                            )
                                            .turnDetection(
                                                RealtimeAudioConfig.Input.TurnDetection.builder()
                                                    .createResponse(true)
                                                    .eagerness(
                                                        RealtimeAudioConfig.Input.TurnDetection
                                                            .Eagerness
                                                            .LOW
                                                    )
                                                    .idleTimeoutMs(0L)
                                                    .interruptResponse(true)
                                                    .prefixPaddingMs(0L)
                                                    .silenceDurationMs(0L)
                                                    .threshold(0.0)
                                                    .type(
                                                        RealtimeAudioConfig.Input.TurnDetection.Type
                                                            .SERVER_VAD
                                                    )
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .output(
                                        RealtimeAudioConfig.Output.builder()
                                            .format(RealtimeAudioConfig.Output.Format.PCM16)
                                            .speed(0.25)
                                            .voice(RealtimeAudioConfig.Output.Voice.ALLOY)
                                            .build()
                                    )
                                    .build()
                            )
                            .clientSecret(
                                RealtimeClientSecretConfig.builder()
                                    .expiresAfter(
                                        RealtimeClientSecretConfig.ExpiresAfter.builder()
                                            .anchor(
                                                RealtimeClientSecretConfig.ExpiresAfter.Anchor
                                                    .CREATED_AT
                                            )
                                            .seconds(0L)
                                            .build()
                                    )
                                    .build()
                            )
                            .addInclude(
                                RealtimeSessionCreateRequest.Include
                                    .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                            )
                            .instructions("instructions")
                            .maxOutputTokens(0L)
                            .addOutputModality(RealtimeSessionCreateRequest.OutputModality.TEXT)
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
                                RealtimeToolsConfigUnion.Function.builder()
                                    .description("description")
                                    .name("name")
                                    .parameters(JsonValue.from(mapOf<String, Any>()))
                                    .type(RealtimeToolsConfigUnion.Function.Type.FUNCTION)
                                    .build()
                            )
                            .tracingAuto()
                            .truncation(RealtimeTruncation.RealtimeTruncationStrategy.AUTO)
                            .build()
                    )
                    .eventId("event_id")
                    .build()
            )

        val roundtrippedRealtimeClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeClientEvent),
                jacksonTypeRef<RealtimeClientEvent>(),
            )

        assertThat(roundtrippedRealtimeClientEvent).isEqualTo(realtimeClientEvent)
    }

    @Test
    fun ofTranscriptionSessionUpdate() {
        val transcriptionSessionUpdate =
            TranscriptionSessionUpdate.builder()
                .session(
                    RealtimeTranscriptionSessionCreateRequest.builder()
                        .model(RealtimeTranscriptionSessionCreateRequest.Model.WHISPER_1)
                        .addInclude(
                            RealtimeTranscriptionSessionCreateRequest.Include
                                .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                        )
                        .inputAudioFormat(
                            RealtimeTranscriptionSessionCreateRequest.InputAudioFormat.PCM16
                        )
                        .inputAudioNoiseReduction(
                            RealtimeTranscriptionSessionCreateRequest.InputAudioNoiseReduction
                                .builder()
                                .type(
                                    RealtimeTranscriptionSessionCreateRequest
                                        .InputAudioNoiseReduction
                                        .Type
                                        .NEAR_FIELD
                                )
                                .build()
                        )
                        .inputAudioTranscription(
                            RealtimeTranscriptionSessionCreateRequest.InputAudioTranscription
                                .builder()
                                .language("language")
                                .model(
                                    RealtimeTranscriptionSessionCreateRequest
                                        .InputAudioTranscription
                                        .Model
                                        .GPT_4O_TRANSCRIBE
                                )
                                .prompt("prompt")
                                .build()
                        )
                        .turnDetection(
                            RealtimeTranscriptionSessionCreateRequest.TurnDetection.builder()
                                .prefixPaddingMs(0L)
                                .silenceDurationMs(0L)
                                .threshold(0.0)
                                .type(
                                    RealtimeTranscriptionSessionCreateRequest.TurnDetection.Type
                                        .SERVER_VAD
                                )
                                .build()
                        )
                        .build()
                )
                .eventId("event_id")
                .build()

        val realtimeClientEvent =
            RealtimeClientEvent.ofTranscriptionSessionUpdate(transcriptionSessionUpdate)

        assertThat(realtimeClientEvent.conversationItemCreate()).isEmpty
        assertThat(realtimeClientEvent.conversationItemDelete()).isEmpty
        assertThat(realtimeClientEvent.conversationItemRetrieve()).isEmpty
        assertThat(realtimeClientEvent.conversationItemTruncate()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferAppend()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferClear()).isEmpty
        assertThat(realtimeClientEvent.outputAudioBufferClear()).isEmpty
        assertThat(realtimeClientEvent.inputAudioBufferCommit()).isEmpty
        assertThat(realtimeClientEvent.responseCancel()).isEmpty
        assertThat(realtimeClientEvent.responseCreate()).isEmpty
        assertThat(realtimeClientEvent.sessionUpdate()).isEmpty
        assertThat(realtimeClientEvent.transcriptionSessionUpdate())
            .contains(transcriptionSessionUpdate)
    }

    @Test
    fun ofTranscriptionSessionUpdateRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeClientEvent =
            RealtimeClientEvent.ofTranscriptionSessionUpdate(
                TranscriptionSessionUpdate.builder()
                    .session(
                        RealtimeTranscriptionSessionCreateRequest.builder()
                            .model(RealtimeTranscriptionSessionCreateRequest.Model.WHISPER_1)
                            .addInclude(
                                RealtimeTranscriptionSessionCreateRequest.Include
                                    .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                            )
                            .inputAudioFormat(
                                RealtimeTranscriptionSessionCreateRequest.InputAudioFormat.PCM16
                            )
                            .inputAudioNoiseReduction(
                                RealtimeTranscriptionSessionCreateRequest.InputAudioNoiseReduction
                                    .builder()
                                    .type(
                                        RealtimeTranscriptionSessionCreateRequest
                                            .InputAudioNoiseReduction
                                            .Type
                                            .NEAR_FIELD
                                    )
                                    .build()
                            )
                            .inputAudioTranscription(
                                RealtimeTranscriptionSessionCreateRequest.InputAudioTranscription
                                    .builder()
                                    .language("language")
                                    .model(
                                        RealtimeTranscriptionSessionCreateRequest
                                            .InputAudioTranscription
                                            .Model
                                            .GPT_4O_TRANSCRIBE
                                    )
                                    .prompt("prompt")
                                    .build()
                            )
                            .turnDetection(
                                RealtimeTranscriptionSessionCreateRequest.TurnDetection.builder()
                                    .prefixPaddingMs(0L)
                                    .silenceDurationMs(0L)
                                    .threshold(0.0)
                                    .type(
                                        RealtimeTranscriptionSessionCreateRequest.TurnDetection.Type
                                            .SERVER_VAD
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .eventId("event_id")
                    .build()
            )

        val roundtrippedRealtimeClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeClientEvent),
                jacksonTypeRef<RealtimeClientEvent>(),
            )

        assertThat(roundtrippedRealtimeClientEvent).isEqualTo(realtimeClientEvent)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val realtimeClientEvent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<RealtimeClientEvent>())

        val e = assertThrows<OpenAIInvalidDataException> { realtimeClientEvent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
