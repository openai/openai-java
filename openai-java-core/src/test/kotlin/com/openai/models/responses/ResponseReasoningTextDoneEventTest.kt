// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseReasoningTextDoneEventTest {

    @Test
    fun create() {
        val responseReasoningTextDoneEvent =
            ResponseReasoningTextDoneEvent.builder()
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .text("text")
                .build()

        assertThat(responseReasoningTextDoneEvent.contentIndex()).isEqualTo(0L)
        assertThat(responseReasoningTextDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(responseReasoningTextDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseReasoningTextDoneEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(responseReasoningTextDoneEvent.text()).isEqualTo("text")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseReasoningTextDoneEvent =
            ResponseReasoningTextDoneEvent.builder()
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .text("text")
                .build()

        val roundtrippedResponseReasoningTextDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseReasoningTextDoneEvent),
                jacksonTypeRef<ResponseReasoningTextDoneEvent>(),
            )

        assertThat(roundtrippedResponseReasoningTextDoneEvent)
            .isEqualTo(responseReasoningTextDoneEvent)
    }
}
