// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.beta.realtime.sessions.Session
import com.openai.models.beta.realtime.transcriptionsessions.TranscriptionSession
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
    }

    @Test
    fun ofConversationItemCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofConversationItemCreated(
                ConversationItemCreatedEvent.builder()
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
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
                    ConversationItemInputAudioTranscriptionCompletedEvent.Logprob.builder()
                        .token("token")
                        .addByte(0L)
                        .logprob(0.0)
                        .build()
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
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
                        ConversationItemInputAudioTranscriptionCompletedEvent.Logprob.builder()
                            .token("token")
                            .addByte(0L)
                            .logprob(0.0)
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
    fun ofConversationItemInputAudioTranscriptionDelta() {
        val conversationItemInputAudioTranscriptionDelta =
            ConversationItemInputAudioTranscriptionDeltaEvent.builder()
                .eventId("event_id")
                .itemId("item_id")
                .contentIndex(0L)
                .delta("delta")
                .addLogprob(
                    ConversationItemInputAudioTranscriptionDeltaEvent.Logprob.builder()
                        .token("token")
                        .addByte(0L)
                        .logprob(0.0)
                        .build()
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
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
                        ConversationItemInputAudioTranscriptionDeltaEvent.Logprob.builder()
                            .token("token")
                            .addByte(0L)
                            .logprob(0.0)
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
    }

    @Test
    fun ofConversationItemRetrievedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofConversationItemRetrieved(
                RealtimeServerEvent.ConversationItemRetrieved.builder()
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
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
            ErrorEvent.builder()
                .error(
                    ErrorEvent.Error.builder()
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
    }

    @Test
    fun ofErrorRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofError(
                ErrorEvent.builder()
                    .error(
                        ErrorEvent.Error.builder()
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
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
    fun ofResponseAudioDelta() {
        val responseAudioDelta =
            ResponseAudioDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        val realtimeServerEvent = RealtimeServerEvent.ofResponseAudioDelta(responseAudioDelta)

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
        assertThat(realtimeServerEvent.responseAudioDelta()).contains(responseAudioDelta)
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
    }

    @Test
    fun ofResponseAudioDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseAudioDelta(
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
    fun ofResponseAudioDone() {
        val responseAudioDone =
            ResponseAudioDoneEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        val realtimeServerEvent = RealtimeServerEvent.ofResponseAudioDone(responseAudioDone)

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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).contains(responseAudioDone)
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
    }

    @Test
    fun ofResponseAudioDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseAudioDone(
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
    fun ofResponseAudioTranscriptDelta() {
        val responseAudioTranscriptDelta =
            ResponseAudioTranscriptDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseAudioTranscriptDelta(responseAudioTranscriptDelta)

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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta())
            .contains(responseAudioTranscriptDelta)
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
    }

    @Test
    fun ofResponseAudioTranscriptDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseAudioTranscriptDelta(
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
    fun ofResponseAudioTranscriptDone() {
        val responseAudioTranscriptDone =
            ResponseAudioTranscriptDoneEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .transcript("transcript")
                .build()

        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseAudioTranscriptDone(responseAudioTranscriptDone)

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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone())
            .contains(responseAudioTranscriptDone)
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
    }

    @Test
    fun ofResponseAudioTranscriptDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseAudioTranscriptDone(
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded())
            .contains(responseContentPartAdded)
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).contains(responseContentPartDone)
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
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
                        .conversationId("conversation_id")
                        .maxOutputTokens(0L)
                        .metadata(
                            RealtimeResponse.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .addModality(RealtimeResponse.Modality.TEXT)
                        .object_(RealtimeResponse.Object.REALTIME_RESPONSE)
                        .addOutput(
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
                        .outputAudioFormat(RealtimeResponse.OutputAudioFormat.PCM16)
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
                        .temperature(0.0)
                        .usage(
                            RealtimeResponseUsage.builder()
                                .inputTokenDetails(
                                    RealtimeResponseUsage.InputTokenDetails.builder()
                                        .audioTokens(0L)
                                        .cachedTokens(0L)
                                        .textTokens(0L)
                                        .build()
                                )
                                .inputTokens(0L)
                                .outputTokenDetails(
                                    RealtimeResponseUsage.OutputTokenDetails.builder()
                                        .audioTokens(0L)
                                        .textTokens(0L)
                                        .build()
                                )
                                .outputTokens(0L)
                                .totalTokens(0L)
                                .build()
                        )
                        .voice(RealtimeResponse.Voice.ALLOY)
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).contains(responseCreated)
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
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
                            .conversationId("conversation_id")
                            .maxOutputTokens(0L)
                            .metadata(
                                RealtimeResponse.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .addModality(RealtimeResponse.Modality.TEXT)
                            .object_(RealtimeResponse.Object.REALTIME_RESPONSE)
                            .addOutput(
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
                            .outputAudioFormat(RealtimeResponse.OutputAudioFormat.PCM16)
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
                            .temperature(0.0)
                            .usage(
                                RealtimeResponseUsage.builder()
                                    .inputTokenDetails(
                                        RealtimeResponseUsage.InputTokenDetails.builder()
                                            .audioTokens(0L)
                                            .cachedTokens(0L)
                                            .textTokens(0L)
                                            .build()
                                    )
                                    .inputTokens(0L)
                                    .outputTokenDetails(
                                        RealtimeResponseUsage.OutputTokenDetails.builder()
                                            .audioTokens(0L)
                                            .textTokens(0L)
                                            .build()
                                    )
                                    .outputTokens(0L)
                                    .totalTokens(0L)
                                    .build()
                            )
                            .voice(RealtimeResponse.Voice.ALLOY)
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
                        .conversationId("conversation_id")
                        .maxOutputTokens(0L)
                        .metadata(
                            RealtimeResponse.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .addModality(RealtimeResponse.Modality.TEXT)
                        .object_(RealtimeResponse.Object.REALTIME_RESPONSE)
                        .addOutput(
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
                        .outputAudioFormat(RealtimeResponse.OutputAudioFormat.PCM16)
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
                        .temperature(0.0)
                        .usage(
                            RealtimeResponseUsage.builder()
                                .inputTokenDetails(
                                    RealtimeResponseUsage.InputTokenDetails.builder()
                                        .audioTokens(0L)
                                        .cachedTokens(0L)
                                        .textTokens(0L)
                                        .build()
                                )
                                .inputTokens(0L)
                                .outputTokenDetails(
                                    RealtimeResponseUsage.OutputTokenDetails.builder()
                                        .audioTokens(0L)
                                        .textTokens(0L)
                                        .build()
                                )
                                .outputTokens(0L)
                                .totalTokens(0L)
                                .build()
                        )
                        .voice(RealtimeResponse.Voice.ALLOY)
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).contains(responseDone)
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
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
                            .conversationId("conversation_id")
                            .maxOutputTokens(0L)
                            .metadata(
                                RealtimeResponse.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .addModality(RealtimeResponse.Modality.TEXT)
                            .object_(RealtimeResponse.Object.REALTIME_RESPONSE)
                            .addOutput(
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
                            .outputAudioFormat(RealtimeResponse.OutputAudioFormat.PCM16)
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
                            .temperature(0.0)
                            .usage(
                                RealtimeResponseUsage.builder()
                                    .inputTokenDetails(
                                        RealtimeResponseUsage.InputTokenDetails.builder()
                                            .audioTokens(0L)
                                            .cachedTokens(0L)
                                            .textTokens(0L)
                                            .build()
                                    )
                                    .inputTokens(0L)
                                    .outputTokenDetails(
                                        RealtimeResponseUsage.OutputTokenDetails.builder()
                                            .audioTokens(0L)
                                            .textTokens(0L)
                                            .build()
                                    )
                                    .outputTokens(0L)
                                    .totalTokens(0L)
                                    .build()
                            )
                            .voice(RealtimeResponse.Voice.ALLOY)
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta())
            .contains(responseFunctionCallArgumentsDelta)
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone())
            .contains(responseFunctionCallArgumentsDone)
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).contains(responseOutputItemAdded)
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
    }

    @Test
    fun ofResponseOutputItemAddedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseOutputItemAdded(
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).contains(responseOutputItemDone)
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
    }

    @Test
    fun ofResponseOutputItemDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseOutputItemDone(
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
            )

        val roundtrippedRealtimeServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeServerEvent),
                jacksonTypeRef<RealtimeServerEvent>(),
            )

        assertThat(roundtrippedRealtimeServerEvent).isEqualTo(realtimeServerEvent)
    }

    @Test
    fun ofResponseTextDelta() {
        val responseTextDelta =
            ResponseTextDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        val realtimeServerEvent = RealtimeServerEvent.ofResponseTextDelta(responseTextDelta)

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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).contains(responseTextDelta)
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
    }

    @Test
    fun ofResponseTextDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseTextDelta(
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
    fun ofResponseTextDone() {
        val responseTextDone =
            ResponseTextDoneEvent.builder()
                .contentIndex(0L)
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .text("text")
                .build()

        val realtimeServerEvent = RealtimeServerEvent.ofResponseTextDone(responseTextDone)

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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).contains(responseTextDone)
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
    }

    @Test
    fun ofResponseTextDoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofResponseTextDone(
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
                    Session.builder()
                        .id("id")
                        .inputAudioFormat(Session.InputAudioFormat.PCM16)
                        .inputAudioNoiseReduction(
                            Session.InputAudioNoiseReduction.builder()
                                .type(Session.InputAudioNoiseReduction.Type.NEAR_FIELD)
                                .build()
                        )
                        .inputAudioTranscription(
                            Session.InputAudioTranscription.builder()
                                .language("language")
                                .model("model")
                                .prompt("prompt")
                                .build()
                        )
                        .instructions("instructions")
                        .maxResponseOutputTokens(0L)
                        .addModality(Session.Modality.TEXT)
                        .model(Session.Model.GPT_4O_REALTIME_PREVIEW)
                        .outputAudioFormat(Session.OutputAudioFormat.PCM16)
                        .speed(0.25)
                        .temperature(0.0)
                        .toolChoice("tool_choice")
                        .addTool(
                            Session.Tool.builder()
                                .description("description")
                                .name("name")
                                .parameters(JsonValue.from(mapOf<String, Any>()))
                                .type(Session.Tool.Type.FUNCTION)
                                .build()
                        )
                        .tracingAuto()
                        .turnDetection(
                            Session.TurnDetection.builder()
                                .createResponse(true)
                                .eagerness(Session.TurnDetection.Eagerness.LOW)
                                .interruptResponse(true)
                                .prefixPaddingMs(0L)
                                .silenceDurationMs(0L)
                                .threshold(0.0)
                                .type(Session.TurnDetection.Type.SERVER_VAD)
                                .build()
                        )
                        .voice(Session.Voice.ALLOY)
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).contains(sessionCreated)
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
    }

    @Test
    fun ofSessionCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofSessionCreated(
                SessionCreatedEvent.builder()
                    .eventId("event_id")
                    .session(
                        Session.builder()
                            .id("id")
                            .inputAudioFormat(Session.InputAudioFormat.PCM16)
                            .inputAudioNoiseReduction(
                                Session.InputAudioNoiseReduction.builder()
                                    .type(Session.InputAudioNoiseReduction.Type.NEAR_FIELD)
                                    .build()
                            )
                            .inputAudioTranscription(
                                Session.InputAudioTranscription.builder()
                                    .language("language")
                                    .model("model")
                                    .prompt("prompt")
                                    .build()
                            )
                            .instructions("instructions")
                            .maxResponseOutputTokens(0L)
                            .addModality(Session.Modality.TEXT)
                            .model(Session.Model.GPT_4O_REALTIME_PREVIEW)
                            .outputAudioFormat(Session.OutputAudioFormat.PCM16)
                            .speed(0.25)
                            .temperature(0.0)
                            .toolChoice("tool_choice")
                            .addTool(
                                Session.Tool.builder()
                                    .description("description")
                                    .name("name")
                                    .parameters(JsonValue.from(mapOf<String, Any>()))
                                    .type(Session.Tool.Type.FUNCTION)
                                    .build()
                            )
                            .tracingAuto()
                            .turnDetection(
                                Session.TurnDetection.builder()
                                    .createResponse(true)
                                    .eagerness(Session.TurnDetection.Eagerness.LOW)
                                    .interruptResponse(true)
                                    .prefixPaddingMs(0L)
                                    .silenceDurationMs(0L)
                                    .threshold(0.0)
                                    .type(Session.TurnDetection.Type.SERVER_VAD)
                                    .build()
                            )
                            .voice(Session.Voice.ALLOY)
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
                    Session.builder()
                        .id("id")
                        .inputAudioFormat(Session.InputAudioFormat.PCM16)
                        .inputAudioNoiseReduction(
                            Session.InputAudioNoiseReduction.builder()
                                .type(Session.InputAudioNoiseReduction.Type.NEAR_FIELD)
                                .build()
                        )
                        .inputAudioTranscription(
                            Session.InputAudioTranscription.builder()
                                .language("language")
                                .model("model")
                                .prompt("prompt")
                                .build()
                        )
                        .instructions("instructions")
                        .maxResponseOutputTokens(0L)
                        .addModality(Session.Modality.TEXT)
                        .model(Session.Model.GPT_4O_REALTIME_PREVIEW)
                        .outputAudioFormat(Session.OutputAudioFormat.PCM16)
                        .speed(0.25)
                        .temperature(0.0)
                        .toolChoice("tool_choice")
                        .addTool(
                            Session.Tool.builder()
                                .description("description")
                                .name("name")
                                .parameters(JsonValue.from(mapOf<String, Any>()))
                                .type(Session.Tool.Type.FUNCTION)
                                .build()
                        )
                        .tracingAuto()
                        .turnDetection(
                            Session.TurnDetection.builder()
                                .createResponse(true)
                                .eagerness(Session.TurnDetection.Eagerness.LOW)
                                .interruptResponse(true)
                                .prefixPaddingMs(0L)
                                .silenceDurationMs(0L)
                                .threshold(0.0)
                                .type(Session.TurnDetection.Type.SERVER_VAD)
                                .build()
                        )
                        .voice(Session.Voice.ALLOY)
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).contains(sessionUpdated)
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
    }

    @Test
    fun ofSessionUpdatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofSessionUpdated(
                SessionUpdatedEvent.builder()
                    .eventId("event_id")
                    .session(
                        Session.builder()
                            .id("id")
                            .inputAudioFormat(Session.InputAudioFormat.PCM16)
                            .inputAudioNoiseReduction(
                                Session.InputAudioNoiseReduction.builder()
                                    .type(Session.InputAudioNoiseReduction.Type.NEAR_FIELD)
                                    .build()
                            )
                            .inputAudioTranscription(
                                Session.InputAudioTranscription.builder()
                                    .language("language")
                                    .model("model")
                                    .prompt("prompt")
                                    .build()
                            )
                            .instructions("instructions")
                            .maxResponseOutputTokens(0L)
                            .addModality(Session.Modality.TEXT)
                            .model(Session.Model.GPT_4O_REALTIME_PREVIEW)
                            .outputAudioFormat(Session.OutputAudioFormat.PCM16)
                            .speed(0.25)
                            .temperature(0.0)
                            .toolChoice("tool_choice")
                            .addTool(
                                Session.Tool.builder()
                                    .description("description")
                                    .name("name")
                                    .parameters(JsonValue.from(mapOf<String, Any>()))
                                    .type(Session.Tool.Type.FUNCTION)
                                    .build()
                            )
                            .tracingAuto()
                            .turnDetection(
                                Session.TurnDetection.builder()
                                    .createResponse(true)
                                    .eagerness(Session.TurnDetection.Eagerness.LOW)
                                    .interruptResponse(true)
                                    .prefixPaddingMs(0L)
                                    .silenceDurationMs(0L)
                                    .threshold(0.0)
                                    .type(Session.TurnDetection.Type.SERVER_VAD)
                                    .build()
                            )
                            .voice(Session.Voice.ALLOY)
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
                    TranscriptionSession.builder()
                        .clientSecret(
                            TranscriptionSession.ClientSecret.builder()
                                .expiresAt(0L)
                                .value("value")
                                .build()
                        )
                        .inputAudioFormat("input_audio_format")
                        .inputAudioTranscription(
                            TranscriptionSession.InputAudioTranscription.builder()
                                .language("language")
                                .model(
                                    TranscriptionSession.InputAudioTranscription.Model
                                        .GPT_4O_TRANSCRIBE
                                )
                                .prompt("prompt")
                                .build()
                        )
                        .addModality(TranscriptionSession.Modality.TEXT)
                        .turnDetection(
                            TranscriptionSession.TurnDetection.builder()
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated())
            .contains(transcriptionSessionUpdated)
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
    }

    @Test
    fun ofTranscriptionSessionUpdatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeServerEvent =
            RealtimeServerEvent.ofTranscriptionSessionUpdated(
                TranscriptionSessionUpdatedEvent.builder()
                    .eventId("event_id")
                    .session(
                        TranscriptionSession.builder()
                            .clientSecret(
                                TranscriptionSession.ClientSecret.builder()
                                    .expiresAt(0L)
                                    .value("value")
                                    .build()
                            )
                            .inputAudioFormat("input_audio_format")
                            .inputAudioTranscription(
                                TranscriptionSession.InputAudioTranscription.builder()
                                    .language("language")
                                    .model(
                                        TranscriptionSession.InputAudioTranscription.Model
                                            .GPT_4O_TRANSCRIBE
                                    )
                                    .prompt("prompt")
                                    .build()
                            )
                            .addModality(TranscriptionSession.Modality.TEXT)
                            .turnDetection(
                                TranscriptionSession.TurnDetection.builder()
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted())
            .contains(outputAudioBufferStarted)
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped())
            .contains(outputAudioBufferStopped)
        assertThat(realtimeServerEvent.outputAudioBufferCleared()).isEmpty
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
        assertThat(realtimeServerEvent.responseAudioDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioDone()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDelta()).isEmpty
        assertThat(realtimeServerEvent.responseAudioTranscriptDone()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartAdded()).isEmpty
        assertThat(realtimeServerEvent.responseContentPartDone()).isEmpty
        assertThat(realtimeServerEvent.responseCreated()).isEmpty
        assertThat(realtimeServerEvent.responseDone()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDelta()).isEmpty
        assertThat(realtimeServerEvent.responseFunctionCallArgumentsDone()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemAdded()).isEmpty
        assertThat(realtimeServerEvent.responseOutputItemDone()).isEmpty
        assertThat(realtimeServerEvent.responseTextDelta()).isEmpty
        assertThat(realtimeServerEvent.responseTextDone()).isEmpty
        assertThat(realtimeServerEvent.sessionCreated()).isEmpty
        assertThat(realtimeServerEvent.sessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.transcriptionSessionUpdated()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStarted()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferStopped()).isEmpty
        assertThat(realtimeServerEvent.outputAudioBufferCleared())
            .contains(outputAudioBufferCleared)
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
