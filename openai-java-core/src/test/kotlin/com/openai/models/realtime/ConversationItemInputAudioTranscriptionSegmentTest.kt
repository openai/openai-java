// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationItemInputAudioTranscriptionSegmentTest {

    @Test
    fun createAndRoundtrip() {
        val conversationItemInputAudioTranscriptionSegment =
            ConversationItemInputAudioTranscriptionSegment.builder()
                .id("id")
                .contentIndex(0L)
                .end(0.0)
                .eventId("event_id")
                .itemId("item_id")
                .speaker("speaker")
                .start(0.0)
                .text("text")
                .build()

        assertThat(conversationItemInputAudioTranscriptionSegment.id()).contains("id")
        assertThat(conversationItemInputAudioTranscriptionSegment.contentIndex()).contains(0L)
        assertThat(conversationItemInputAudioTranscriptionSegment.end()).contains(0.0)
        assertThat(conversationItemInputAudioTranscriptionSegment.eventId()).contains("event_id")
        assertThat(conversationItemInputAudioTranscriptionSegment.itemId()).contains("item_id")
        assertThat(conversationItemInputAudioTranscriptionSegment.speaker()).contains("speaker")
        assertThat(conversationItemInputAudioTranscriptionSegment.start()).contains(0.0)
        assertThat(conversationItemInputAudioTranscriptionSegment.text()).contains("text")

        val jsonMapper = jsonMapper()

        val roundtrippedConversationItemInputAudioTranscriptionSegment =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItemInputAudioTranscriptionSegment),
                jacksonTypeRef<ConversationItemInputAudioTranscriptionSegment>(),
            )

        assertThat(roundtrippedConversationItemInputAudioTranscriptionSegment)
            .isEqualTo(conversationItemInputAudioTranscriptionSegment)
    }
}
