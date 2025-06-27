// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

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
                .addLogprob(
                    ConversationItemInputAudioTranscriptionCompletedEvent.Logprob.builder()
                        .token("token")
                        .addByte(0L)
                        .logprob(0.0)
                        .build()
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
        assertThat(conversationItemInputAudioTranscriptionCompletedEvent.logprobs().getOrNull())
            .containsExactly(
                ConversationItemInputAudioTranscriptionCompletedEvent.Logprob.builder()
                    .token("token")
                    .addByte(0L)
                    .logprob(0.0)
                    .build()
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
                .addLogprob(
                    ConversationItemInputAudioTranscriptionCompletedEvent.Logprob.builder()
                        .token("token")
                        .addByte(0L)
                        .logprob(0.0)
                        .build()
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
