// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseReasoningDoneEventTest {

    @Test
    fun create() {
        val responseReasoningDoneEvent =
            ResponseReasoningDoneEvent.builder()
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .text("text")
                .build()

        assertThat(responseReasoningDoneEvent.contentIndex()).isEqualTo(0L)
        assertThat(responseReasoningDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(responseReasoningDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseReasoningDoneEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(responseReasoningDoneEvent.text()).isEqualTo("text")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseReasoningDoneEvent =
            ResponseReasoningDoneEvent.builder()
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .text("text")
                .build()

        val roundtrippedResponseReasoningDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseReasoningDoneEvent),
                jacksonTypeRef<ResponseReasoningDoneEvent>(),
            )

        assertThat(roundtrippedResponseReasoningDoneEvent).isEqualTo(responseReasoningDoneEvent)
    }
}
