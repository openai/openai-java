// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationItemInputAudioTranscriptionSegmentTest {

    @Test
    fun create() {
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

        assertThat(conversationItemInputAudioTranscriptionSegment.id()).isEqualTo("id")
        assertThat(conversationItemInputAudioTranscriptionSegment.contentIndex()).isEqualTo(0L)
        assertThat(conversationItemInputAudioTranscriptionSegment.end()).isEqualTo(0.0f)
        assertThat(conversationItemInputAudioTranscriptionSegment.eventId()).isEqualTo("event_id")
        assertThat(conversationItemInputAudioTranscriptionSegment.itemId()).isEqualTo("item_id")
        assertThat(conversationItemInputAudioTranscriptionSegment.speaker()).isEqualTo("speaker")
        assertThat(conversationItemInputAudioTranscriptionSegment.start()).isEqualTo(0.0f)
        assertThat(conversationItemInputAudioTranscriptionSegment.text()).isEqualTo("text")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
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

        val roundtrippedConversationItemInputAudioTranscriptionSegment =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItemInputAudioTranscriptionSegment),
                jacksonTypeRef<ConversationItemInputAudioTranscriptionSegment>(),
            )

        assertThat(roundtrippedConversationItemInputAudioTranscriptionSegment)
            .isEqualTo(conversationItemInputAudioTranscriptionSegment)
    }
}
