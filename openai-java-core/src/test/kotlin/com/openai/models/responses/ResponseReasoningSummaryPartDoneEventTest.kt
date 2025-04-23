// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseReasoningSummaryPartDoneEventTest {

    @Test
    fun create() {
        val responseReasoningSummaryPartDoneEvent =
            ResponseReasoningSummaryPartDoneEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .part(ResponseReasoningSummaryPartDoneEvent.Part.builder().text("text").build())
                .summaryIndex(0L)
                .build()

        assertThat(responseReasoningSummaryPartDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(responseReasoningSummaryPartDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseReasoningSummaryPartDoneEvent.part())
            .isEqualTo(ResponseReasoningSummaryPartDoneEvent.Part.builder().text("text").build())
        assertThat(responseReasoningSummaryPartDoneEvent.summaryIndex()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseReasoningSummaryPartDoneEvent =
            ResponseReasoningSummaryPartDoneEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .part(ResponseReasoningSummaryPartDoneEvent.Part.builder().text("text").build())
                .summaryIndex(0L)
                .build()

        val roundtrippedResponseReasoningSummaryPartDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseReasoningSummaryPartDoneEvent),
                jacksonTypeRef<ResponseReasoningSummaryPartDoneEvent>(),
            )

        assertThat(roundtrippedResponseReasoningSummaryPartDoneEvent)
            .isEqualTo(responseReasoningSummaryPartDoneEvent)
    }
}
