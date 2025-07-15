// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
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
            RealtimeClientEvent.OutputAudioBufferClear.builder().eventId("event_id").build()

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
                RealtimeClientEvent.OutputAudioBufferClear.builder().eventId("event_id").build()
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
                                            .type(
                                                ConversationItemWithReference.Content.Type
                                                    .INPUT_TEXT
                                            )
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
                    SessionUpdateEvent.Session.builder()
                        .clientSecret(
                            SessionUpdateEvent.Session.ClientSecret.builder()
                                .expiresAfter(
                                    SessionUpdateEvent.Session.ClientSecret.ExpiresAfter.builder()
                                        .anchor(
                                            SessionUpdateEvent.Session.ClientSecret.ExpiresAfter
                                                .Anchor
                                                .CREATED_AT
                                        )
                                        .seconds(0L)
                                        .build()
                                )
                                .build()
                        )
                        .inputAudioFormat(SessionUpdateEvent.Session.InputAudioFormat.PCM16)
                        .inputAudioNoiseReduction(
                            SessionUpdateEvent.Session.InputAudioNoiseReduction.builder()
                                .type(
                                    SessionUpdateEvent.Session.InputAudioNoiseReduction.Type
                                        .NEAR_FIELD
                                )
                                .build()
                        )
                        .inputAudioTranscription(
                            SessionUpdateEvent.Session.InputAudioTranscription.builder()
                                .language("language")
                                .model("model")
                                .prompt("prompt")
                                .build()
                        )
                        .instructions("instructions")
                        .maxResponseOutputTokens(0L)
                        .addModality(SessionUpdateEvent.Session.Modality.TEXT)
                        .model(SessionUpdateEvent.Session.Model.GPT_4O_REALTIME_PREVIEW)
                        .outputAudioFormat(SessionUpdateEvent.Session.OutputAudioFormat.PCM16)
                        .speed(0.25)
                        .temperature(0.0)
                        .toolChoice("tool_choice")
                        .addTool(
                            SessionUpdateEvent.Session.Tool.builder()
                                .description("description")
                                .name("name")
                                .parameters(JsonValue.from(mapOf<String, Any>()))
                                .type(SessionUpdateEvent.Session.Tool.Type.FUNCTION)
                                .build()
                        )
                        .tracingAuto()
                        .turnDetection(
                            SessionUpdateEvent.Session.TurnDetection.builder()
                                .createResponse(true)
                                .eagerness(SessionUpdateEvent.Session.TurnDetection.Eagerness.LOW)
                                .interruptResponse(true)
                                .prefixPaddingMs(0L)
                                .silenceDurationMs(0L)
                                .threshold(0.0)
                                .type(SessionUpdateEvent.Session.TurnDetection.Type.SERVER_VAD)
                                .build()
                        )
                        .voice(SessionUpdateEvent.Session.Voice.ALLOY)
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
                        SessionUpdateEvent.Session.builder()
                            .clientSecret(
                                SessionUpdateEvent.Session.ClientSecret.builder()
                                    .expiresAfter(
                                        SessionUpdateEvent.Session.ClientSecret.ExpiresAfter
                                            .builder()
                                            .anchor(
                                                SessionUpdateEvent.Session.ClientSecret.ExpiresAfter
                                                    .Anchor
                                                    .CREATED_AT
                                            )
                                            .seconds(0L)
                                            .build()
                                    )
                                    .build()
                            )
                            .inputAudioFormat(SessionUpdateEvent.Session.InputAudioFormat.PCM16)
                            .inputAudioNoiseReduction(
                                SessionUpdateEvent.Session.InputAudioNoiseReduction.builder()
                                    .type(
                                        SessionUpdateEvent.Session.InputAudioNoiseReduction.Type
                                            .NEAR_FIELD
                                    )
                                    .build()
                            )
                            .inputAudioTranscription(
                                SessionUpdateEvent.Session.InputAudioTranscription.builder()
                                    .language("language")
                                    .model("model")
                                    .prompt("prompt")
                                    .build()
                            )
                            .instructions("instructions")
                            .maxResponseOutputTokens(0L)
                            .addModality(SessionUpdateEvent.Session.Modality.TEXT)
                            .model(SessionUpdateEvent.Session.Model.GPT_4O_REALTIME_PREVIEW)
                            .outputAudioFormat(SessionUpdateEvent.Session.OutputAudioFormat.PCM16)
                            .speed(0.25)
                            .temperature(0.0)
                            .toolChoice("tool_choice")
                            .addTool(
                                SessionUpdateEvent.Session.Tool.builder()
                                    .description("description")
                                    .name("name")
                                    .parameters(JsonValue.from(mapOf<String, Any>()))
                                    .type(SessionUpdateEvent.Session.Tool.Type.FUNCTION)
                                    .build()
                            )
                            .tracingAuto()
                            .turnDetection(
                                SessionUpdateEvent.Session.TurnDetection.builder()
                                    .createResponse(true)
                                    .eagerness(
                                        SessionUpdateEvent.Session.TurnDetection.Eagerness.LOW
                                    )
                                    .interruptResponse(true)
                                    .prefixPaddingMs(0L)
                                    .silenceDurationMs(0L)
                                    .threshold(0.0)
                                    .type(SessionUpdateEvent.Session.TurnDetection.Type.SERVER_VAD)
                                    .build()
                            )
                            .voice(SessionUpdateEvent.Session.Voice.ALLOY)
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
                    TranscriptionSessionUpdate.Session.builder()
                        .clientSecret(
                            TranscriptionSessionUpdate.Session.ClientSecret.builder()
                                .expiresAt(
                                    TranscriptionSessionUpdate.Session.ClientSecret.ExpiresAt
                                        .builder()
                                        .anchor(
                                            TranscriptionSessionUpdate.Session.ClientSecret
                                                .ExpiresAt
                                                .Anchor
                                                .CREATED_AT
                                        )
                                        .seconds(0L)
                                        .build()
                                )
                                .build()
                        )
                        .addInclude("string")
                        .inputAudioFormat(TranscriptionSessionUpdate.Session.InputAudioFormat.PCM16)
                        .inputAudioNoiseReduction(
                            TranscriptionSessionUpdate.Session.InputAudioNoiseReduction.builder()
                                .type(
                                    TranscriptionSessionUpdate.Session.InputAudioNoiseReduction.Type
                                        .NEAR_FIELD
                                )
                                .build()
                        )
                        .inputAudioTranscription(
                            TranscriptionSessionUpdate.Session.InputAudioTranscription.builder()
                                .language("language")
                                .model(
                                    TranscriptionSessionUpdate.Session.InputAudioTranscription.Model
                                        .GPT_4O_TRANSCRIBE
                                )
                                .prompt("prompt")
                                .build()
                        )
                        .addModality(TranscriptionSessionUpdate.Session.Modality.TEXT)
                        .turnDetection(
                            TranscriptionSessionUpdate.Session.TurnDetection.builder()
                                .createResponse(true)
                                .eagerness(
                                    TranscriptionSessionUpdate.Session.TurnDetection.Eagerness.LOW
                                )
                                .interruptResponse(true)
                                .prefixPaddingMs(0L)
                                .silenceDurationMs(0L)
                                .threshold(0.0)
                                .type(
                                    TranscriptionSessionUpdate.Session.TurnDetection.Type.SERVER_VAD
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
                        TranscriptionSessionUpdate.Session.builder()
                            .clientSecret(
                                TranscriptionSessionUpdate.Session.ClientSecret.builder()
                                    .expiresAt(
                                        TranscriptionSessionUpdate.Session.ClientSecret.ExpiresAt
                                            .builder()
                                            .anchor(
                                                TranscriptionSessionUpdate.Session.ClientSecret
                                                    .ExpiresAt
                                                    .Anchor
                                                    .CREATED_AT
                                            )
                                            .seconds(0L)
                                            .build()
                                    )
                                    .build()
                            )
                            .addInclude("string")
                            .inputAudioFormat(
                                TranscriptionSessionUpdate.Session.InputAudioFormat.PCM16
                            )
                            .inputAudioNoiseReduction(
                                TranscriptionSessionUpdate.Session.InputAudioNoiseReduction
                                    .builder()
                                    .type(
                                        TranscriptionSessionUpdate.Session.InputAudioNoiseReduction
                                            .Type
                                            .NEAR_FIELD
                                    )
                                    .build()
                            )
                            .inputAudioTranscription(
                                TranscriptionSessionUpdate.Session.InputAudioTranscription.builder()
                                    .language("language")
                                    .model(
                                        TranscriptionSessionUpdate.Session.InputAudioTranscription
                                            .Model
                                            .GPT_4O_TRANSCRIBE
                                    )
                                    .prompt("prompt")
                                    .build()
                            )
                            .addModality(TranscriptionSessionUpdate.Session.Modality.TEXT)
                            .turnDetection(
                                TranscriptionSessionUpdate.Session.TurnDetection.builder()
                                    .createResponse(true)
                                    .eagerness(
                                        TranscriptionSessionUpdate.Session.TurnDetection.Eagerness
                                            .LOW
                                    )
                                    .interruptResponse(true)
                                    .prefixPaddingMs(0L)
                                    .silenceDurationMs(0L)
                                    .threshold(0.0)
                                    .type(
                                        TranscriptionSessionUpdate.Session.TurnDetection.Type
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
