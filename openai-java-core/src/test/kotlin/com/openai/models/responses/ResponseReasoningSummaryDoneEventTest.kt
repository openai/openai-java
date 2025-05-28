// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseReasoningSummaryDoneEventTest {

    @Test
    fun create() {
        val responseReasoningSummaryDoneEvent =
            ResponseReasoningSummaryDoneEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .text("text")
                .build()

        assertThat(responseReasoningSummaryDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(responseReasoningSummaryDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseReasoningSummaryDoneEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(responseReasoningSummaryDoneEvent.summaryIndex()).isEqualTo(0L)
        assertThat(responseReasoningSummaryDoneEvent.text()).isEqualTo("text")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseReasoningSummaryDoneEvent =
            ResponseReasoningSummaryDoneEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .text("text")
                .build()

        val roundtrippedResponseReasoningSummaryDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseReasoningSummaryDoneEvent),
                jacksonTypeRef<ResponseReasoningSummaryDoneEvent>(),
            )

        assertThat(roundtrippedResponseReasoningSummaryDoneEvent)
            .isEqualTo(responseReasoningSummaryDoneEvent)
    }
}
