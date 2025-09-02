// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationItemInputAudioTranscriptionCompletedEventTest {

    @Test
    fun create() {
        val conversationItemInputAudioTranscriptionCompletedEvent =
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

        assertThat(conversationItemInputAudioTranscriptionCompletedEvent.contentIndex())
            .isEqualTo(0L)
        assertThat(conversationItemInputAudioTranscriptionCompletedEvent.eventId())
            .isEqualTo("event_id")
        assertThat(conversationItemInputAudioTranscriptionCompletedEvent.itemId())
            .isEqualTo("item_id")
        assertThat(conversationItemInputAudioTranscriptionCompletedEvent.transcript())
            .isEqualTo("transcript")
        assertThat(conversationItemInputAudioTranscriptionCompletedEvent.usage())
            .isEqualTo(
                ConversationItemInputAudioTranscriptionCompletedEvent.Usage
                    .ofTranscriptTextUsageTokens(
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
            )
        assertThat(conversationItemInputAudioTranscriptionCompletedEvent.logprobs().getOrNull())
            .containsExactly(
                LogProbProperties.builder().token("token").addByte(0L).logprob(0.0).build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItemInputAudioTranscriptionCompletedEvent =
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

        val roundtrippedConversationItemInputAudioTranscriptionCompletedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(
                    conversationItemInputAudioTranscriptionCompletedEvent
                ),
                jacksonTypeRef<ConversationItemInputAudioTranscriptionCompletedEvent>(),
            )

        assertThat(roundtrippedConversationItemInputAudioTranscriptionCompletedEvent)
            .isEqualTo(conversationItemInputAudioTranscriptionCompletedEvent)
    }
}
