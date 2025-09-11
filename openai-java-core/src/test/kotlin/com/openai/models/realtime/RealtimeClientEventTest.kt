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
                            RealtimeFunctionTool.builder()
                                .description("description")
                                .name("name")
                                .parameters(JsonValue.from(mapOf<String, Any>()))
                                .type(RealtimeFunctionTool.Type.FUNCTION)
                                .build()
                        )
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
    }

    @Test
    fun ofResponseCreateRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeClientEvent =
            RealtimeClientEvent.ofResponseCreate(
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
                                                    .type(
                                                        RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM
                                                    )
                                                    .build()
                                            )
                                            .voice(
                                                RealtimeResponseCreateAudioOutput.Output.Voice.ALLOY
                                            )
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
                                    .object_(
                                        RealtimeConversationItemSystemMessage.Object.REALTIME_ITEM
                                    )
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
                        .audio(
                            RealtimeAudioConfig.builder()
                                .input(
                                    RealtimeAudioConfigInput.builder()
                                        .format(
                                            RealtimeAudioFormats.AudioPcm.builder()
                                                .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                                .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                                .build()
                                        )
                                        .noiseReduction(
                                            RealtimeAudioConfigInput.NoiseReduction.builder()
                                                .type(NoiseReductionType.NEAR_FIELD)
                                                .build()
                                        )
                                        .transcription(
                                            AudioTranscription.builder()
                                                .language("language")
                                                .model(AudioTranscription.Model.WHISPER_1)
                                                .prompt("prompt")
                                                .build()
                                        )
                                        .turnDetection(
                                            RealtimeAudioInputTurnDetection.ServerVad.builder()
                                                .createResponse(true)
                                                .idleTimeoutMs(5000L)
                                                .interruptResponse(true)
                                                .prefixPaddingMs(0L)
                                                .silenceDurationMs(0L)
                                                .threshold(0.0)
                                                .build()
                                        )
                                        .build()
                                )
                                .output(
                                    RealtimeAudioConfigOutput.builder()
                                        .format(
                                            RealtimeAudioFormats.AudioPcm.builder()
                                                .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                                .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                                .build()
                                        )
                                        .speed(0.25)
                                        .voice(RealtimeAudioConfigOutput.Voice.ALLOY)
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
                        .model(RealtimeSessionCreateRequest.Model.GPT_REALTIME)
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
                        .toolChoice(ToolChoiceOptions.NONE)
                        .addTool(
                            RealtimeFunctionTool.builder()
                                .description("description")
                                .name("name")
                                .parameters(JsonValue.from(mapOf<String, Any>()))
                                .type(RealtimeFunctionTool.Type.FUNCTION)
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
    }

    @Test
    fun ofSessionUpdateRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeClientEvent =
            RealtimeClientEvent.ofSessionUpdate(
                SessionUpdateEvent.builder()
                    .session(
                        RealtimeSessionCreateRequest.builder()
                            .audio(
                                RealtimeAudioConfig.builder()
                                    .input(
                                        RealtimeAudioConfigInput.builder()
                                            .format(
                                                RealtimeAudioFormats.AudioPcm.builder()
                                                    .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                                    .type(
                                                        RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM
                                                    )
                                                    .build()
                                            )
                                            .noiseReduction(
                                                RealtimeAudioConfigInput.NoiseReduction.builder()
                                                    .type(NoiseReductionType.NEAR_FIELD)
                                                    .build()
                                            )
                                            .transcription(
                                                AudioTranscription.builder()
                                                    .language("language")
                                                    .model(AudioTranscription.Model.WHISPER_1)
                                                    .prompt("prompt")
                                                    .build()
                                            )
                                            .turnDetection(
                                                RealtimeAudioInputTurnDetection.ServerVad.builder()
                                                    .createResponse(true)
                                                    .idleTimeoutMs(5000L)
                                                    .interruptResponse(true)
                                                    .prefixPaddingMs(0L)
                                                    .silenceDurationMs(0L)
                                                    .threshold(0.0)
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .output(
                                        RealtimeAudioConfigOutput.builder()
                                            .format(
                                                RealtimeAudioFormats.AudioPcm.builder()
                                                    .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                                    .type(
                                                        RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM
                                                    )
                                                    .build()
                                            )
                                            .speed(0.25)
                                            .voice(RealtimeAudioConfigOutput.Voice.ALLOY)
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
                            .model(RealtimeSessionCreateRequest.Model.GPT_REALTIME)
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
                            .toolChoice(ToolChoiceOptions.NONE)
                            .addTool(
                                RealtimeFunctionTool.builder()
                                    .description("description")
                                    .name("name")
                                    .parameters(JsonValue.from(mapOf<String, Any>()))
                                    .type(RealtimeFunctionTool.Type.FUNCTION)
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
