// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.realtime.clientsecrets.RealtimeTranscriptionSessionClientSecret
import com.openai.models.realtime.clientsecrets.RealtimeTranscriptionSessionCreateResponse
import com.openai.models.realtime.clientsecrets.RealtimeTranscriptionSessionInputAudioTranscription
import com.openai.models.realtime.clientsecrets.RealtimeTranscriptionSessionTurnDetection
import com.openai.models.responses.ResponsePrompt
import com.openai.models.responses.ToolChoiceOptions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class RealtimeServerEventTest {

    @Test
    fun ofConversationCreated() {
        val conversationCreated =
            ConversationCreatedEvent.builder()
                .conversation(
                    ConversationCreatedEvent.Conversation.builder()
                        .id("id")
                        .object_(ConversationCreatedEvent.Conversation.Object.REALTIME_CONVERSATION)
                        .build()
                )
                .eventId("event_id")
                .build()

        val realtimeServerEvent = RealtimeServerEvent.ofConversationCreated(conversationCreated)

        assertThat(realtimeServerEvent.conversationCreated()).contains(conversationCreated)
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofConversationCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofConversationCreated(
                ConversationCreatedEvent.builder()
                    .conversation(
                        ConversationCreatedEvent.Conversation.builder()
                            .id("id")
                            .object_(
                                ConversationCreatedEvent.Conversation.Object.REALTIME_CONVERSATION
                            )
                            .build()
                    )
                    .eventId("event_id")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofConversationItemCreated() {
        val conversationItemCreated =
            ConversationItemCreatedEvent.builder()
                .eventId("event_id")
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
                .previousItemId("previous_item_id")
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofConversationItemCreated(conversationItemCreated)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).contains(conversationItemCreated)
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofConversationItemCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofConversationItemCreated(
                ConversationItemCreatedEvent.builder()
                    .eventId("event_id")
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
                    .previousItemId("previous_item_id")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofConversationItemDeleted() {
        val conversationItemDeleted =
            ConversationItemDeletedEvent.builder().eventId("event_id").itemId("item_id").build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofConversationItemDeleted(conversationItemDeleted)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).contains(conversationItemDeleted)
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofConversationItemDeletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofConversationItemDeleted(
                ConversationItemDeletedEvent.builder().eventId("event_id").itemId("item_id").build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofConversationItemInputAudioTranscriptionCompleted() {
        val conversationItemInputAudioTranscriptionCompleted =
            ConversationItemInputAudioTranscriptionCompletedEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .transcript("transcript")
                .usage(
                    ConversationItemInputAudioTranscriptionCompletedEvent.Usage
                        .TranscriptTextUsageTokens
                        .builder()
                        .inputTokens(0L)
                        .outputTokens(0L)
                        .totalTokens(0L)
                        .inputTokenDetails(
                            ConversationItemInputAudioTranscriptionCompletedEvent.Usage
                                .TranscriptTextUsageTokens
                                .InputTokenDetails
                                .builder()
                                .audioTokens(0L)
                                .textTokens(0L)
                                .build()
                        )
                        .build()
                )
                .addLogprob(
                    LogProbProperties.builder().token("token").addByte(0L).logprob(0.0).build()
                )
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofConversationItemInputAudioTranscriptionCompleted(
                conversationItemInputAudioTranscriptionCompleted
            )

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted())
            .contains(conversationItemInputAudioTranscriptionCompleted)
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofConversationItemInputAudioTranscriptionCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofConversationItemInputAudioTranscriptionCompleted(
                ConversationItemInputAudioTranscriptionCompletedEvent.builder()
                    .contentIndex(0L)
                    .eventId("event_id")
                    .itemId("item_id")
                    .transcript("transcript")
                    .usage(
                        ConversationItemInputAudioTranscriptionCompletedEvent.Usage
                            .TranscriptTextUsageTokens
                            .builder()
                            .inputTokens(0L)
                            .outputTokens(0L)
                            .totalTokens(0L)
                            .inputTokenDetails(
                                ConversationItemInputAudioTranscriptionCompletedEvent.Usage
                                    .TranscriptTextUsageTokens
                                    .InputTokenDetails
                                    .builder()
                                    .audioTokens(0L)
                                    .textTokens(0L)
                                    .build()
                            )
                            .build()
                    )
                    .addLogprob(
                        LogProbProperties.builder().token("token").addByte(0L).logprob(0.0).build()
                    )
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofConversationItemInputAudioTranscriptionDelta() {
        val conversationItemInputAudioTranscriptionDelta =
            ConversationItemInputAudioTranscriptionDeltaEvent.builder()
                .eventId("event_id")
                .itemId("item_id")
                .contentIndex(0L)
                .delta("delta")
                .addLogprob(
                    LogProbProperties.builder().token("token").addByte(0L).logprob(0.0).build()
                )
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofConversationItemInputAudioTranscriptionDelta(
                conversationItemInputAudioTranscriptionDelta
            )

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta())
            .contains(conversationItemInputAudioTranscriptionDelta)
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofConversationItemInputAudioTranscriptionDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofConversationItemInputAudioTranscriptionDelta(
                ConversationItemInputAudioTranscriptionDeltaEvent.builder()
                    .eventId("event_id")
                    .itemId("item_id")
                    .contentIndex(0L)
                    .delta("delta")
                    .addLogprob(
                        LogProbProperties.builder().token("token").addByte(0L).logprob(0.0).build()
                    )
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofConversationItemInputAudioTranscriptionFailed() {
        val conversationItemInputAudioTranscriptionFailed =
            ConversationItemInputAudioTranscriptionFailedEvent.builder()
                .contentIndex(0L)
                .error(
                    ConversationItemInputAudioTranscriptionFailedEvent.Error.builder()
                        .code("code")
                        .message("message")
                        .param("param")
                        .type("type")
                        .build()
                )
                .eventId("event_id")
                .itemId("item_id")
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofConversationItemInputAudioTranscriptionFailed(
                conversationItemInputAudioTranscriptionFailed
            )

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed())
            .contains(conversationItemInputAudioTranscriptionFailed)
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofConversationItemInputAudioTranscriptionFailedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofConversationItemInputAudioTranscriptionFailed(
                ConversationItemInputAudioTranscriptionFailedEvent.builder()
                    .contentIndex(0L)
                    .error(
                        ConversationItemInputAudioTranscriptionFailedEvent.Error.builder()
                            .code("code")
                            .message("message")
                            .param("param")
                            .type("type")
                            .build()
                    )
                    .eventId("event_id")
                    .itemId("item_id")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofConversationItemRetrieved() {
        val conversationItemRetrieved =
            RealtimeServerEvent.ConversationItemRetrieved.builder()
                .eventId("event_id")
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
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofConversationItemRetrieved(conversationItemRetrieved)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved())
            .contains(conversationItemRetrieved)
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofConversationItemRetrievedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofConversationItemRetrieved(
                RealtimeServerEvent.ConversationItemRetrieved.builder()
                    .eventId("event_id")
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
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofConversationItemTruncated() {
        val conversationItemTruncated =
            ConversationItemTruncatedEvent.builder()
                .audioEndMs(0L)
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofConversationItemTruncated(conversationItemTruncated)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated())
            .contains(conversationItemTruncated)
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofConversationItemTruncatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofConversationItemTruncated(
                ConversationItemTruncatedEvent.builder()
                    .audioEndMs(0L)
                    .contentIndex(0L)
                    .eventId("event_id")
                    .itemId("item_id")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofError() {
        val error =
            RealtimeErrorEvent.builder()
                .error(
                    RealtimeError.builder()
                        .message("message")
                        .type("type")
                        .code("code")
                        .eventId("event_id")
                        .param("param")
                        .build()
                )
                .eventId("event_id")
                .build()

        val realtimeServerEvent = RealtimeServerEvent.ofError(error)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).contains(error)
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofErrorRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofError(
                RealtimeErrorEvent.builder()
                    .error(
                        RealtimeError.builder()
                            .message("message")
                            .type("type")
                            .code("code")
                            .eventId("event_id")
                            .param("param")
                            .build()
                    )
                    .eventId("event_id")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofInputAudioBufferCleared() {
        val inputAudioBufferCleared =
            InputAudioBufferClearedEvent.builder().eventId("event_id").build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofInputAudioBufferCleared(inputAudioBufferCleared)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).contains(inputAudioBufferCleared)
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofInputAudioBufferClearedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofInputAudioBufferCleared(
                InputAudioBufferClearedEvent.builder().eventId("event_id").build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofInputAudioBufferCommitted() {
        val inputAudioBufferCommitted =
            InputAudioBufferCommittedEvent.builder()
                .eventId("event_id")
                .itemId("item_id")
                .previousItemId("previous_item_id")
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofInputAudioBufferCommitted(inputAudioBufferCommitted)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted())
            .contains(inputAudioBufferCommitted)
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofInputAudioBufferCommittedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofInputAudioBufferCommitted(
                InputAudioBufferCommittedEvent.builder()
                    .eventId("event_id")
                    .itemId("item_id")
                    .previousItemId("previous_item_id")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofInputAudioBufferSpeechStarted() {
        val inputAudioBufferSpeechStarted =
            InputAudioBufferSpeechStartedEvent.builder()
                .audioStartMs(0L)
                .eventId("event_id")
                .itemId("item_id")
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofInputAudioBufferSpeechStarted(inputAudioBufferSpeechStarted)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted())
            .contains(inputAudioBufferSpeechStarted)
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofInputAudioBufferSpeechStartedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofInputAudioBufferSpeechStarted(
                InputAudioBufferSpeechStartedEvent.builder()
                    .audioStartMs(0L)
                    .eventId("event_id")
                    .itemId("item_id")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofInputAudioBufferSpeechStopped() {
        val inputAudioBufferSpeechStopped =
            InputAudioBufferSpeechStoppedEvent.builder()
                .audioEndMs(0L)
                .eventId("event_id")
                .itemId("item_id")
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofInputAudioBufferSpeechStopped(inputAudioBufferSpeechStopped)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped())
            .contains(inputAudioBufferSpeechStopped)
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofInputAudioBufferSpeechStoppedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofInputAudioBufferSpeechStopped(
                InputAudioBufferSpeechStoppedEvent.builder()
                    .audioEndMs(0L)
                    .eventId("event_id")
                    .itemId("item_id")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofRateLimitsUpdated() {
        val rateLimitsUpdated =
            RateLimitsUpdatedEvent.builder()
                .eventId("event_id")
                .addRateLimit(
                    RateLimitsUpdatedEvent.RateLimit.builder()
                        .limit(0L)
                        .name(RateLimitsUpdatedEvent.RateLimit.Name.REQUESTS)
                        .remaining(0L)
                        .resetSeconds(0.0)
                        .build()
                )
                .build()

        val realtimeServerEvent = RealtimeServerEvent.ofRateLimitsUpdated(rateLimitsUpdated)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).contains(rateLimitsUpdated)
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofRateLimitsUpdatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofRateLimitsUpdated(
                RateLimitsUpdatedEvent.builder()
                    .eventId("event_id")
                    .addRateLimit(
                        RateLimitsUpdatedEvent.RateLimit.builder()
                            .limit(0L)
                            .name(RateLimitsUpdatedEvent.RateLimit.Name.REQUESTS)
                            .remaining(0L)
                            .resetSeconds(0.0)
                            .build()
                    )
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofResponseOutputAudioDelta() {
        val responseOutputAudioDelta =
            ResponseAudioDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseOutputAudioDelta(responseOutputAudioDelta)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta())
            .contains(responseOutputAudioDelta)
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofResponseOutputAudioDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseOutputAudioDelta(
                ResponseAudioDeltaEvent.builder()
                    .contentIndex(0L)
                    .delta("delta")
                    .eventId("event_id")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .responseId("response_id")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofResponseOutputAudioDone() {
        val responseOutputAudioDone =
            ResponseAudioDoneEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseOutputAudioDone(responseOutputAudioDone)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).contains(responseOutputAudioDone)
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofResponseOutputAudioDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseOutputAudioDone(
                ResponseAudioDoneEvent.builder()
                    .contentIndex(0L)
                    .eventId("event_id")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .responseId("response_id")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofResponseOutputAudioTranscriptDelta() {
        val responseOutputAudioTranscriptDelta =
            ResponseAudioTranscriptDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseOutputAudioTranscriptDelta(
                responseOutputAudioTranscriptDelta
            )

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta())
            .contains(responseOutputAudioTranscriptDelta)
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofResponseOutputAudioTranscriptDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseOutputAudioTranscriptDelta(
                ResponseAudioTranscriptDeltaEvent.builder()
                    .contentIndex(0L)
                    .delta("delta")
                    .eventId("event_id")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .responseId("response_id")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofResponseOutputAudioTranscriptDone() {
        val responseOutputAudioTranscriptDone =
            ResponseAudioTranscriptDoneEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .transcript("transcript")
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseOutputAudioTranscriptDone(
                responseOutputAudioTranscriptDone
            )

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone())
            .contains(responseOutputAudioTranscriptDone)
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofResponseOutputAudioTranscriptDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseOutputAudioTranscriptDone(
                ResponseAudioTranscriptDoneEvent.builder()
                    .contentIndex(0L)
                    .eventId("event_id")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .responseId("response_id")
                    .transcript("transcript")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofResponseContentPartAdded() {
        val responseContentPartAdded =
            ResponseContentPartAddedEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .part(
                    ResponseContentPartAddedEvent.Part.builder()
                        .audio("audio")
                        .text("text")
                        .transcript("transcript")
                        .type(ResponseContentPartAddedEvent.Part.Type.TEXT)
                        .build()
                )
                .responseId("response_id")
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseContentPartAdded(responseContentPartAdded)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded())
            .contains(responseContentPartAdded)
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofResponseContentPartAddedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseContentPartAdded(
                ResponseContentPartAddedEvent.builder()
                    .contentIndex(0L)
                    .eventId("event_id")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .part(
                        ResponseContentPartAddedEvent.Part.builder()
                            .audio("audio")
                            .text("text")
                            .transcript("transcript")
                            .type(ResponseContentPartAddedEvent.Part.Type.TEXT)
                            .build()
                    )
                    .responseId("response_id")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofResponseContentPartDone() {
        val responseContentPartDone =
            ResponseContentPartDoneEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .part(
                    ResponseContentPartDoneEvent.Part.builder()
                        .audio("audio")
                        .text("text")
                        .transcript("transcript")
                        .type(ResponseContentPartDoneEvent.Part.Type.TEXT)
                        .build()
                )
                .responseId("response_id")
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseContentPartDone(responseContentPartDone)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).contains(responseContentPartDone)
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofResponseContentPartDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseContentPartDone(
                ResponseContentPartDoneEvent.builder()
                    .contentIndex(0L)
                    .eventId("event_id")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .part(
                        ResponseContentPartDoneEvent.Part.builder()
                            .audio("audio")
                            .text("text")
                            .transcript("transcript")
                            .type(ResponseContentPartDoneEvent.Part.Type.TEXT)
                            .build()
                    )
                    .responseId("response_id")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofResponseCreated() {
        val responseCreated =
            ResponseCreatedEvent.builder()
                .eventId("event_id")
                .response(
                    RealtimeResponse.builder()
                        .id("id")
                        .audio(
                            RealtimeResponse.Audio.builder()
                                .output(
                                    RealtimeResponse.Audio.Output.builder()
                                        .format(
                                            RealtimeAudioFormats.AudioPcm.builder()
                                                .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                                .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                                .build()
                                        )
                                        .voice(RealtimeResponse.Audio.Output.Voice.ALLOY)
                                        .build()
                                )
                                .build()
                        )
                        .conversationId("conversation_id")
                        .maxOutputTokens(0L)
                        .metadata(
                            RealtimeResponse.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .object_(RealtimeResponse.Object.REALTIME_RESPONSE)
                        .addOutput(
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
                        .addOutputModality(RealtimeResponse.OutputModality.TEXT)
                        .status(RealtimeResponse.Status.COMPLETED)
                        .statusDetails(
                            RealtimeResponseStatus.builder()
                                .error(
                                    RealtimeResponseStatus.Error.builder()
                                        .code("code")
                                        .type("type")
                                        .build()
                                )
                                .reason(RealtimeResponseStatus.Reason.TURN_DETECTED)
                                .type(RealtimeResponseStatus.Type.COMPLETED)
                                .build()
                        )
                        .usage(
                            RealtimeResponseUsage.builder()
                                .inputTokenDetails(
                                    RealtimeResponseUsageInputTokenDetails.builder()
                                        .audioTokens(0L)
                                        .cachedTokens(0L)
                                        .cachedTokensDetails(
                                            RealtimeResponseUsageInputTokenDetails
                                                .CachedTokensDetails
                                                .builder()
                                                .audioTokens(0L)
                                                .imageTokens(0L)
                                                .textTokens(0L)
                                                .build()
                                        )
                                        .imageTokens(0L)
                                        .textTokens(0L)
                                        .build()
                                )
                                .inputTokens(0L)
                                .outputTokenDetails(
                                    RealtimeResponseUsageOutputTokenDetails.builder()
                                        .audioTokens(0L)
                                        .textTokens(0L)
                                        .build()
                                )
                                .outputTokens(0L)
                                .totalTokens(0L)
                                .build()
                        )
                        .build()
                )
                .build()

        val realtimeServerEvent = RealtimeServerEvent.ofResponseCreated(responseCreated)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).contains(responseCreated)
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofResponseCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseCreated(
                ResponseCreatedEvent.builder()
                    .eventId("event_id")
                    .response(
                        RealtimeResponse.builder()
                            .id("id")
                            .audio(
                                RealtimeResponse.Audio.builder()
                                    .output(
                                        RealtimeResponse.Audio.Output.builder()
                                            .format(
                                                RealtimeAudioFormats.AudioPcm.builder()
                                                    .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                                    .type(
                                                        RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM
                                                    )
                                                    .build()
                                            )
                                            .voice(RealtimeResponse.Audio.Output.Voice.ALLOY)
                                            .build()
                                    )
                                    .build()
                            )
                            .conversationId("conversation_id")
                            .maxOutputTokens(0L)
                            .metadata(
                                RealtimeResponse.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .object_(RealtimeResponse.Object.REALTIME_RESPONSE)
                            .addOutput(
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
                            .addOutputModality(RealtimeResponse.OutputModality.TEXT)
                            .status(RealtimeResponse.Status.COMPLETED)
                            .statusDetails(
                                RealtimeResponseStatus.builder()
                                    .error(
                                        RealtimeResponseStatus.Error.builder()
                                            .code("code")
                                            .type("type")
                                            .build()
                                    )
                                    .reason(RealtimeResponseStatus.Reason.TURN_DETECTED)
                                    .type(RealtimeResponseStatus.Type.COMPLETED)
                                    .build()
                            )
                            .usage(
                                RealtimeResponseUsage.builder()
                                    .inputTokenDetails(
                                        RealtimeResponseUsageInputTokenDetails.builder()
                                            .audioTokens(0L)
                                            .cachedTokens(0L)
                                            .cachedTokensDetails(
                                                RealtimeResponseUsageInputTokenDetails
                                                    .CachedTokensDetails
                                                    .builder()
                                                    .audioTokens(0L)
                                                    .imageTokens(0L)
                                                    .textTokens(0L)
                                                    .build()
                                            )
                                            .imageTokens(0L)
                                            .textTokens(0L)
                                            .build()
                                    )
                                    .inputTokens(0L)
                                    .outputTokenDetails(
                                        RealtimeResponseUsageOutputTokenDetails.builder()
                                            .audioTokens(0L)
                                            .textTokens(0L)
                                            .build()
                                    )
                                    .outputTokens(0L)
                                    .totalTokens(0L)
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofResponseDone() {
        val responseDone =
            ResponseDoneEvent.builder()
                .eventId("event_id")
                .response(
                    RealtimeResponse.builder()
                        .id("id")
                        .audio(
                            RealtimeResponse.Audio.builder()
                                .output(
                                    RealtimeResponse.Audio.Output.builder()
                                        .format(
                                            RealtimeAudioFormats.AudioPcm.builder()
                                                .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                                .type(RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM)
                                                .build()
                                        )
                                        .voice(RealtimeResponse.Audio.Output.Voice.ALLOY)
                                        .build()
                                )
                                .build()
                        )
                        .conversationId("conversation_id")
                        .maxOutputTokens(0L)
                        .metadata(
                            RealtimeResponse.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .object_(RealtimeResponse.Object.REALTIME_RESPONSE)
                        .addOutput(
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
                        .addOutputModality(RealtimeResponse.OutputModality.TEXT)
                        .status(RealtimeResponse.Status.COMPLETED)
                        .statusDetails(
                            RealtimeResponseStatus.builder()
                                .error(
                                    RealtimeResponseStatus.Error.builder()
                                        .code("code")
                                        .type("type")
                                        .build()
                                )
                                .reason(RealtimeResponseStatus.Reason.TURN_DETECTED)
                                .type(RealtimeResponseStatus.Type.COMPLETED)
                                .build()
                        )
                        .usage(
                            RealtimeResponseUsage.builder()
                                .inputTokenDetails(
                                    RealtimeResponseUsageInputTokenDetails.builder()
                                        .audioTokens(0L)
                                        .cachedTokens(0L)
                                        .cachedTokensDetails(
                                            RealtimeResponseUsageInputTokenDetails
                                                .CachedTokensDetails
                                                .builder()
                                                .audioTokens(0L)
                                                .imageTokens(0L)
                                                .textTokens(0L)
                                                .build()
                                        )
                                        .imageTokens(0L)
                                        .textTokens(0L)
                                        .build()
                                )
                                .inputTokens(0L)
                                .outputTokenDetails(
                                    RealtimeResponseUsageOutputTokenDetails.builder()
                                        .audioTokens(0L)
                                        .textTokens(0L)
                                        .build()
                                )
                                .outputTokens(0L)
                                .totalTokens(0L)
                                .build()
                        )
                        .build()
                )
                .build()

        val realtimeServerEvent = RealtimeServerEvent.ofResponseDone(responseDone)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).contains(responseDone)
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofResponseDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseDone(
                ResponseDoneEvent.builder()
                    .eventId("event_id")
                    .response(
                        RealtimeResponse.builder()
                            .id("id")
                            .audio(
                                RealtimeResponse.Audio.builder()
                                    .output(
                                        RealtimeResponse.Audio.Output.builder()
                                            .format(
                                                RealtimeAudioFormats.AudioPcm.builder()
                                                    .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                                    .type(
                                                        RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM
                                                    )
                                                    .build()
                                            )
                                            .voice(RealtimeResponse.Audio.Output.Voice.ALLOY)
                                            .build()
                                    )
                                    .build()
                            )
                            .conversationId("conversation_id")
                            .maxOutputTokens(0L)
                            .metadata(
                                RealtimeResponse.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .object_(RealtimeResponse.Object.REALTIME_RESPONSE)
                            .addOutput(
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
                            .addOutputModality(RealtimeResponse.OutputModality.TEXT)
                            .status(RealtimeResponse.Status.COMPLETED)
                            .statusDetails(
                                RealtimeResponseStatus.builder()
                                    .error(
                                        RealtimeResponseStatus.Error.builder()
                                            .code("code")
                                            .type("type")
                                            .build()
                                    )
                                    .reason(RealtimeResponseStatus.Reason.TURN_DETECTED)
                                    .type(RealtimeResponseStatus.Type.COMPLETED)
                                    .build()
                            )
                            .usage(
                                RealtimeResponseUsage.builder()
                                    .inputTokenDetails(
                                        RealtimeResponseUsageInputTokenDetails.builder()
                                            .audioTokens(0L)
                                            .cachedTokens(0L)
                                            .cachedTokensDetails(
                                                RealtimeResponseUsageInputTokenDetails
                                                    .CachedTokensDetails
                                                    .builder()
                                                    .audioTokens(0L)
                                                    .imageTokens(0L)
                                                    .textTokens(0L)
                                                    .build()
                                            )
                                            .imageTokens(0L)
                                            .textTokens(0L)
                                            .build()
                                    )
                                    .inputTokens(0L)
                                    .outputTokenDetails(
                                        RealtimeResponseUsageOutputTokenDetails.builder()
                                            .audioTokens(0L)
                                            .textTokens(0L)
                                            .build()
                                    )
                                    .outputTokens(0L)
                                    .totalTokens(0L)
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofResponseFunctionCallArgumentsDelta() {
        val responseFunctionCallArgumentsDelta =
            ResponseFunctionCallArgumentsDeltaEvent.builder()
                .callId("call_id")
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseFunctionCallArgumentsDelta(
                responseFunctionCallArgumentsDelta
            )

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta())
            .contains(responseFunctionCallArgumentsDelta)
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofResponseFunctionCallArgumentsDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseFunctionCallArgumentsDelta(
                ResponseFunctionCallArgumentsDeltaEvent.builder()
                    .callId("call_id")
                    .delta("delta")
                    .eventId("event_id")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .responseId("response_id")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofResponseFunctionCallArgumentsDone() {
        val responseFunctionCallArgumentsDone =
            ResponseFunctionCallArgumentsDoneEvent.builder()
                .arguments("arguments")
                .callId("call_id")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseFunctionCallArgumentsDone(
                responseFunctionCallArgumentsDone
            )

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone())
            .contains(responseFunctionCallArgumentsDone)
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofResponseFunctionCallArgumentsDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseFunctionCallArgumentsDone(
                ResponseFunctionCallArgumentsDoneEvent.builder()
                    .arguments("arguments")
                    .callId("call_id")
                    .eventId("event_id")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .responseId("response_id")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofResponseOutputItemAdded() {
        val responseOutputItemAdded =
            ResponseOutputItemAddedEvent.builder()
                .eventId("event_id")
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
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseOutputItemAdded(responseOutputItemAdded)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).contains(responseOutputItemAdded)
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofResponseOutputItemAddedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseOutputItemAdded(
                ResponseOutputItemAddedEvent.builder()
                    .eventId("event_id")
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
                    .outputIndex(0L)
                    .responseId("response_id")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofResponseOutputItemDone() {
        val responseOutputItemDone =
            ResponseOutputItemDoneEvent.builder()
                .eventId("event_id")
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
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseOutputItemDone(responseOutputItemDone)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).contains(responseOutputItemDone)
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofResponseOutputItemDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseOutputItemDone(
                ResponseOutputItemDoneEvent.builder()
                    .eventId("event_id")
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
                    .outputIndex(0L)
                    .responseId("response_id")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofResponseOutputTextDelta() {
        val responseOutputTextDelta =
            ResponseTextDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseOutputTextDelta(responseOutputTextDelta)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).contains(responseOutputTextDelta)
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofResponseOutputTextDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseOutputTextDelta(
                ResponseTextDeltaEvent.builder()
                    .contentIndex(0L)
                    .delta("delta")
                    .eventId("event_id")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .responseId("response_id")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofResponseOutputTextDone() {
        val responseOutputTextDone =
            ResponseTextDoneEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .text("text")
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseOutputTextDone(responseOutputTextDone)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).contains(responseOutputTextDone)
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofResponseOutputTextDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseOutputTextDone(
                ResponseTextDoneEvent.builder()
                    .contentIndex(0L)
                    .eventId("event_id")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .responseId("response_id")
                    .text("text")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofSessionCreated() {
        val sessionCreated =
            SessionCreatedEvent.builder()
                .eventId("event_id")
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
                                            RealtimeAudioInputTurnDetection.builder()
                                                .createResponse(true)
                                                .eagerness(
                                                    RealtimeAudioInputTurnDetection.Eagerness.LOW
                                                )
                                                .idleTimeoutMs(0L)
                                                .interruptResponse(true)
                                                .prefixPaddingMs(0L)
                                                .silenceDurationMs(0L)
                                                .threshold(0.0)
                                                .type(
                                                    RealtimeAudioInputTurnDetection.Type.SERVER_VAD
                                                )
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
                            Models.builder()
                                .description("description")
                                .name("name")
                                .parameters(JsonValue.from(mapOf<String, Any>()))
                                .type(Models.Type.FUNCTION)
                                .build()
                        )
                        .tracingAuto()
                        .truncation(RealtimeTruncation.RealtimeTruncationStrategy.AUTO)
                        .build()
                )
                .build()

        val realtimeServerEvent = RealtimeServerEvent.ofSessionCreated(sessionCreated)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).contains(sessionCreated)
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofSessionCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofSessionCreated(
                SessionCreatedEvent.builder()
                    .eventId("event_id")
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
                                                RealtimeAudioInputTurnDetection.builder()
                                                    .createResponse(true)
                                                    .eagerness(
                                                        RealtimeAudioInputTurnDetection.Eagerness
                                                            .LOW
                                                    )
                                                    .idleTimeoutMs(0L)
                                                    .interruptResponse(true)
                                                    .prefixPaddingMs(0L)
                                                    .silenceDurationMs(0L)
                                                    .threshold(0.0)
                                                    .type(
                                                        RealtimeAudioInputTurnDetection.Type
                                                            .SERVER_VAD
                                                    )
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
                                Models.builder()
                                    .description("description")
                                    .name("name")
                                    .parameters(JsonValue.from(mapOf<String, Any>()))
                                    .type(Models.Type.FUNCTION)
                                    .build()
                            )
                            .tracingAuto()
                            .truncation(RealtimeTruncation.RealtimeTruncationStrategy.AUTO)
                            .build()
                    )
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofSessionUpdated() {
        val sessionUpdated =
            SessionUpdatedEvent.builder()
                .eventId("event_id")
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
                                            RealtimeAudioInputTurnDetection.builder()
                                                .createResponse(true)
                                                .eagerness(
                                                    RealtimeAudioInputTurnDetection.Eagerness.LOW
                                                )
                                                .idleTimeoutMs(0L)
                                                .interruptResponse(true)
                                                .prefixPaddingMs(0L)
                                                .silenceDurationMs(0L)
                                                .threshold(0.0)
                                                .type(
                                                    RealtimeAudioInputTurnDetection.Type.SERVER_VAD
                                                )
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
                            Models.builder()
                                .description("description")
                                .name("name")
                                .parameters(JsonValue.from(mapOf<String, Any>()))
                                .type(Models.Type.FUNCTION)
                                .build()
                        )
                        .tracingAuto()
                        .truncation(RealtimeTruncation.RealtimeTruncationStrategy.AUTO)
                        .build()
                )
                .build()

        val realtimeServerEvent = RealtimeServerEvent.ofSessionUpdated(sessionUpdated)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).contains(sessionUpdated)
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofSessionUpdatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofSessionUpdated(
                SessionUpdatedEvent.builder()
                    .eventId("event_id")
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
                                                RealtimeAudioInputTurnDetection.builder()
                                                    .createResponse(true)
                                                    .eagerness(
                                                        RealtimeAudioInputTurnDetection.Eagerness
                                                            .LOW
                                                    )
                                                    .idleTimeoutMs(0L)
                                                    .interruptResponse(true)
                                                    .prefixPaddingMs(0L)
                                                    .silenceDurationMs(0L)
                                                    .threshold(0.0)
                                                    .type(
                                                        RealtimeAudioInputTurnDetection.Type
                                                            .SERVER_VAD
                                                    )
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
                                Models.builder()
                                    .description("description")
                                    .name("name")
                                    .parameters(JsonValue.from(mapOf<String, Any>()))
                                    .type(Models.Type.FUNCTION)
                                    .build()
                            )
                            .tracingAuto()
                            .truncation(RealtimeTruncation.RealtimeTruncationStrategy.AUTO)
                            .build()
                    )
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofTranscriptionSessionUpdated() {
        val transcriptionSessionUpdated =
            TranscriptionSessionUpdatedEvent.builder()
                .eventId("event_id")
                .session(
                    RealtimeTranscriptionSessionCreateResponse.builder()
                        .clientSecret(
                            RealtimeTranscriptionSessionClientSecret.builder()
                                .expiresAt(0L)
                                .value("value")
                                .build()
                        )
                        .inputAudioFormat("input_audio_format")
                        .inputAudioTranscription(
                            RealtimeTranscriptionSessionInputAudioTranscription.builder()
                                .language("language")
                                .model(
                                    RealtimeTranscriptionSessionInputAudioTranscription.Model
                                        .WHISPER_1
                                )
                                .prompt("prompt")
                                .build()
                        )
                        .addModality(RealtimeTranscriptionSessionCreateResponse.Modality.TEXT)
                        .turnDetection(
                            RealtimeTranscriptionSessionTurnDetection.builder()
                                .prefixPaddingMs(0L)
                                .silenceDurationMs(0L)
                                .threshold(0.0)
                                .type("type")
                                .build()
                        )
                        .build()
                )
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofTranscriptionSessionUpdated(transcriptionSessionUpdated)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated())
            .contains(transcriptionSessionUpdated)
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofTranscriptionSessionUpdatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofTranscriptionSessionUpdated(
                TranscriptionSessionUpdatedEvent.builder()
                    .eventId("event_id")
                    .session(
                        RealtimeTranscriptionSessionCreateResponse.builder()
                            .clientSecret(
                                RealtimeTranscriptionSessionClientSecret.builder()
                                    .expiresAt(0L)
                                    .value("value")
                                    .build()
                            )
                            .inputAudioFormat("input_audio_format")
                            .inputAudioTranscription(
                                RealtimeTranscriptionSessionInputAudioTranscription.builder()
                                    .language("language")
                                    .model(
                                        RealtimeTranscriptionSessionInputAudioTranscription.Model
                                            .WHISPER_1
                                    )
                                    .prompt("prompt")
                                    .build()
                            )
                            .addModality(RealtimeTranscriptionSessionCreateResponse.Modality.TEXT)
                            .turnDetection(
                                RealtimeTranscriptionSessionTurnDetection.builder()
                                    .prefixPaddingMs(0L)
                                    .silenceDurationMs(0L)
                                    .threshold(0.0)
                                    .type("type")
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofTranscriptionSessionCreated() {
        val transcriptionSessionCreated =
            TranscriptionSessionCreated.builder()
                .eventId("event_id")
                .session(
                    RealtimeTranscriptionSessionCreateResponse.builder()
                        .clientSecret(
                            RealtimeTranscriptionSessionClientSecret.builder()
                                .expiresAt(0L)
                                .value("value")
                                .build()
                        )
                        .inputAudioFormat("input_audio_format")
                        .inputAudioTranscription(
                            RealtimeTranscriptionSessionInputAudioTranscription.builder()
                                .language("language")
                                .model(
                                    RealtimeTranscriptionSessionInputAudioTranscription.Model
                                        .WHISPER_1
                                )
                                .prompt("prompt")
                                .build()
                        )
                        .addModality(RealtimeTranscriptionSessionCreateResponse.Modality.TEXT)
                        .turnDetection(
                            RealtimeTranscriptionSessionTurnDetection.builder()
                                .prefixPaddingMs(0L)
                                .silenceDurationMs(0L)
                                .threshold(0.0)
                                .type("type")
                                .build()
                        )
                        .build()
                )
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofTranscriptionSessionCreated(transcriptionSessionCreated)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated())
            .contains(transcriptionSessionCreated)
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofTranscriptionSessionCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofTranscriptionSessionCreated(
                TranscriptionSessionCreated.builder()
                    .eventId("event_id")
                    .session(
                        RealtimeTranscriptionSessionCreateResponse.builder()
                            .clientSecret(
                                RealtimeTranscriptionSessionClientSecret.builder()
                                    .expiresAt(0L)
                                    .value("value")
                                    .build()
                            )
                            .inputAudioFormat("input_audio_format")
                            .inputAudioTranscription(
                                RealtimeTranscriptionSessionInputAudioTranscription.builder()
                                    .language("language")
                                    .model(
                                        RealtimeTranscriptionSessionInputAudioTranscription.Model
                                            .WHISPER_1
                                    )
                                    .prompt("prompt")
                                    .build()
                            )
                            .addModality(RealtimeTranscriptionSessionCreateResponse.Modality.TEXT)
                            .turnDetection(
                                RealtimeTranscriptionSessionTurnDetection.builder()
                                    .prefixPaddingMs(0L)
                                    .silenceDurationMs(0L)
                                    .threshold(0.0)
                                    .type("type")
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofOutputAudioBufferStarted() {
        val outputAudioBufferStarted =
            RealtimeServerEvent.OutputAudioBufferStarted.builder()
                .eventId("event_id")
                .responseId("response_id")
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofOutputAudioBufferStarted(outputAudioBufferStarted)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted())
            .contains(outputAudioBufferStarted)
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofOutputAudioBufferStartedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofOutputAudioBufferStarted(
                RealtimeServerEvent.OutputAudioBufferStarted.builder()
                    .eventId("event_id")
                    .responseId("response_id")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofOutputAudioBufferStopped() {
        val outputAudioBufferStopped =
            RealtimeServerEvent.OutputAudioBufferStopped.builder()
                .eventId("event_id")
                .responseId("response_id")
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofOutputAudioBufferStopped(outputAudioBufferStopped)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped())
            .contains(outputAudioBufferStopped)
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofOutputAudioBufferStoppedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofOutputAudioBufferStopped(
                RealtimeServerEvent.OutputAudioBufferStopped.builder()
                    .eventId("event_id")
                    .responseId("response_id")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofOutputAudioBufferCleared() {
        val outputAudioBufferCleared =
            RealtimeServerEvent.OutputAudioBufferCleared.builder()
                .eventId("event_id")
                .responseId("response_id")
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofOutputAudioBufferCleared(outputAudioBufferCleared)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared())
            .contains(outputAudioBufferCleared)
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofOutputAudioBufferClearedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofOutputAudioBufferCleared(
                RealtimeServerEvent.OutputAudioBufferCleared.builder()
                    .eventId("event_id")
                    .responseId("response_id")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofConversationItemAdded() {
        val conversationItemAdded =
            ConversationItemAdded.builder()
                .eventId("event_id")
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
                .previousItemId("previous_item_id")
                .build()

        val realtimeServerEvent = RealtimeServerEvent.ofConversationItemAdded(conversationItemAdded)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).contains(conversationItemAdded)
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofConversationItemAddedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofConversationItemAdded(
                ConversationItemAdded.builder()
                    .eventId("event_id")
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
                    .previousItemId("previous_item_id")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofConversationItemDone() {
        val conversationItemDone =
            ConversationItemDone.builder()
                .eventId("event_id")
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
                .previousItemId("previous_item_id")
                .build()

        val realtimeServerEvent = RealtimeServerEvent.ofConversationItemDone(conversationItemDone)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).contains(conversationItemDone)
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofConversationItemDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofConversationItemDone(
                ConversationItemDone.builder()
                    .eventId("event_id")
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
                    .previousItemId("previous_item_id")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofInputAudioBufferTimeoutTriggered() {
        val inputAudioBufferTimeoutTriggered =
            InputAudioBufferTimeoutTriggered.builder()
                .audioEndMs(0L)
                .audioStartMs(0L)
                .eventId("event_id")
                .itemId("item_id")
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofInputAudioBufferTimeoutTriggered(inputAudioBufferTimeoutTriggered)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered())
            .contains(inputAudioBufferTimeoutTriggered)
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofInputAudioBufferTimeoutTriggeredRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofInputAudioBufferTimeoutTriggered(
                InputAudioBufferTimeoutTriggered.builder()
                    .audioEndMs(0L)
                    .audioStartMs(0L)
                    .eventId("event_id")
                    .itemId("item_id")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofConversationItemInputAudioTranscriptionSegment() {
        val conversationItemInputAudioTranscriptionSegment =
            ConversationItemInputAudioTranscriptionSegment.builder()
                .id("id")
                .contentIndex(0L)
                .end(0.0f)
                .eventId("event_id")
                .itemId("item_id")
                .speaker("speaker")
                .start(0.0f)
                .text("text")
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofConversationItemInputAudioTranscriptionSegment(
                conversationItemInputAudioTranscriptionSegment
            )

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment())
            .contains(conversationItemInputAudioTranscriptionSegment)
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofConversationItemInputAudioTranscriptionSegmentRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofConversationItemInputAudioTranscriptionSegment(
                ConversationItemInputAudioTranscriptionSegment.builder()
                    .id("id")
                    .contentIndex(0L)
                    .end(0.0f)
                    .eventId("event_id")
                    .itemId("item_id")
                    .speaker("speaker")
                    .start(0.0f)
                    .text("text")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofMcpListToolsInProgress() {
        val mcpListToolsInProgress =
            McpListToolsInProgress.builder().eventId("event_id").itemId("item_id").build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofMcpListToolsInProgress(mcpListToolsInProgress)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).contains(mcpListToolsInProgress)
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofMcpListToolsInProgressRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofMcpListToolsInProgress(
                McpListToolsInProgress.builder().eventId("event_id").itemId("item_id").build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofMcpListToolsCompleted() {
        val mcpListToolsCompleted =
            McpListToolsCompleted.builder().eventId("event_id").itemId("item_id").build()

        val realtimeServerEvent = RealtimeServerEvent.ofMcpListToolsCompleted(mcpListToolsCompleted)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).contains(mcpListToolsCompleted)
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofMcpListToolsCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofMcpListToolsCompleted(
                McpListToolsCompleted.builder().eventId("event_id").itemId("item_id").build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofMcpListToolsFailed() {
        val mcpListToolsFailed =
            McpListToolsFailed.builder().eventId("event_id").itemId("item_id").build()

        val realtimeServerEvent = RealtimeServerEvent.ofMcpListToolsFailed(mcpListToolsFailed)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).contains(mcpListToolsFailed)
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofMcpListToolsFailedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofMcpListToolsFailed(
                McpListToolsFailed.builder().eventId("event_id").itemId("item_id").build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofResponseMcpCallArgumentsDelta() {
        val responseMcpCallArgumentsDelta =
            ResponseMcpCallArgumentsDelta.builder()
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .obfuscation("obfuscation")
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseMcpCallArgumentsDelta(responseMcpCallArgumentsDelta)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta())
            .contains(responseMcpCallArgumentsDelta)
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofResponseMcpCallArgumentsDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseMcpCallArgumentsDelta(
                ResponseMcpCallArgumentsDelta.builder()
                    .delta("delta")
                    .eventId("event_id")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .responseId("response_id")
                    .obfuscation("obfuscation")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofResponseMcpCallArgumentsDone() {
        val responseMcpCallArgumentsDone =
            ResponseMcpCallArgumentsDone.builder()
                .arguments("arguments")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseMcpCallArgumentsDone(responseMcpCallArgumentsDone)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone())
            .contains(responseMcpCallArgumentsDone)
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofResponseMcpCallArgumentsDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseMcpCallArgumentsDone(
                ResponseMcpCallArgumentsDone.builder()
                    .arguments("arguments")
                    .eventId("event_id")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .responseId("response_id")
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofResponseMcpCallInProgress() {
        val responseMcpCallInProgress =
            ResponseMcpCallInProgress.builder()
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseMcpCallInProgress(responseMcpCallInProgress)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress())
            .contains(responseMcpCallInProgress)
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofResponseMcpCallInProgressRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseMcpCallInProgress(
                ResponseMcpCallInProgress.builder()
                    .eventId("event_id")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofResponseMcpCallCompleted() {
        val responseMcpCallCompleted =
            ResponseMcpCallCompleted.builder()
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseMcpCallCompleted(responseMcpCallCompleted)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted())
            .contains(responseMcpCallCompleted)
        assertThat(realtimeServerEvent.responseMcpCallFailed()).isEmpty
    }

    @Test
    fun ofResponseMcpCallCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseMcpCallCompleted(
                ResponseMcpCallCompleted.builder()
                    .eventId("event_id")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofResponseMcpCallFailed() {
        val responseMcpCallFailed =
            ResponseMcpCallFailed.builder()
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .build()

        val realtimeServerEvent = RealtimeServerEvent.ofResponseMcpCallFailed(responseMcpCallFailed)

        assertThat(realtimeServerEvent.conversationCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemCreated()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDeleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionCompleted()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionDelta()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionFailed()).isEmpty
        assertThat(realtimeServerEvent.conversationItemRetrieved()).isEmpty
        assertThat(realtimeServerEvent.conversationItemTruncated()).isEmpty
        assertThat(realtimeServerEvent.error()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferCommitted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStarted()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferSpeechStopped()).isEmpty
        assertThat(realtimeServerEvent.rateLimitsUpdated()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseOutputTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionCreated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
        assertThat(realtimeServerEvent.conversationItemAdded()).isEmpty
        assertThat(realtimeServerEvent.conversationItemDone()).isEmpty
        assertThat(realtimeServerEvent.inputAudioBufferTimeoutTriggered()).isEmpty
        assertThat(realtimeServerEvent.conversationItemInputAudioTranscriptionSegment()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsInProgress()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsCompleted()).isEmpty
        assertThat(realtimeServerEvent.mcpListToolsFailed()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallInProgress()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallCompleted()).isEmpty
        assertThat(realtimeServerEvent.responseMcpCallFailed()).contains(responseMcpCallFailed)
    }

    @Test
    fun ofResponseMcpCallFailedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseMcpCallFailed(
                ResponseMcpCallFailed.builder()
                    .eventId("event_id")
                    .itemId("item_id")
                    .outputIndex(0L)
                    .build()
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
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
        val realtimeServerEvent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<RealtimeServerEvent>())

        val e = assertThrows<OpenAIInvalidDataException> { realtimeServerEvent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
