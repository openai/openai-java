// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationItemInputAudioTranscriptionDeltaEventTest {

    @Test
    fun create() {
        val conversationItemInputAudioTranscriptionDeltaEvent =
            ConversationItemInputAudioTranscriptionDeltaEvent.builder()
                .eventId("event_id")
                .itemId("item_id")
                .contentIndex(0L)
                .delta("delta")
                .addLogprob(
                    LogProbProperties.builder().token("token").addByte(0L).logprob(0.0).build()
                )
                .build()

        assertThat(conversationItemInputAudioTranscriptionDeltaEvent.eventId())
            .isEqualTo("event_id")
        assertThat(conversationItemInputAudioTranscriptionDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(conversationItemInputAudioTranscriptionDeltaEvent.contentIndex()).contains(0L)
        assertThat(conversationItemInputAudioTranscriptionDeltaEvent.delta()).contains("delta")
        assertThat(conversationItemInputAudioTranscriptionDeltaEvent.logprobs().getOrNull())
            .containsExactly(
                LogProbProperties.builder().token("token").addByte(0L).logprob(0.0).build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val conversationItemInputAudioTranscriptionDeltaEvent =
            ConversationItemInputAudioTranscriptionDeltaEvent.builder()
                .eventId("event_id")
                .itemId("item_id")
                .contentIndex(0L)
                .delta("delta")
                .addLogprob(
                    LogProbProperties.builder().token("token").addByte(0L).logprob(0.0).build()
                )
                .build()

        val roundtrippedConversationItemInputAudioTranscriptionDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationItemInputAudioTranscriptionDeltaEvent),
                jacksonTypeRef<ConversationItemInputAudioTranscriptionDeltaEvent>(),
            )

        assertThat(roundtrippedConversationItemInputAudioTranscriptionDeltaEvent)
            .isEqualTo(conversationItemInputAudioTranscriptionDeltaEvent)
    }
}
