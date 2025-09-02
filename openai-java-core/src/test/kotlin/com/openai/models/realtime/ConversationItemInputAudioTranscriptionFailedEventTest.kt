// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationItemInputAudioTranscriptionFailedEventTest {

    @Test
    fun create() {
        val conversationItemInputAudioTranscriptionFailedEvent =
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

        assertThat(conversationItemInputAudioTranscriptionFailedEvent.contentIndex()).isEqualTo(0L)
        assertThat(conversationItemInputAudioTranscriptionFailedEvent.error())
            .isEqualTo(
                ConversationItemInputAudioTranscriptionFailedEvent.Error.builder()
                    .code("code")
                    .message("message")
                    .param("param")
                    .type("type")
                    .build()
            )
        assertThat(conversationItemInputAudioTranscriptionFailedEvent.eventId())
            .isEqualTo("event_id")
        assertThat(conversationItemInputAudioTranscriptionFailedEvent.itemId()).isEqualTo("item_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItemInputAudioTranscriptionFailedEvent =
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

        val roundtrippedConversationItemInputAudioTranscriptionFailedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItemInputAudioTranscriptionFailedEvent),
                jacksonTypeRef<ConversationItemInputAudioTranscriptionFailedEvent>(),
            )

        assertThat(roundtrippedConversationItemInputAudioTranscriptionFailedEvent)
            .isEqualTo(conversationItemInputAudioTranscriptionFailedEvent)
    }
}
