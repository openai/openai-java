// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseReasoningSummaryTextDoneEventTest {

    @Test
    fun create() {
        val responseReasoningSummaryTextDoneEvent =
            ResponseReasoningSummaryTextDoneEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .summaryIndex(0L)
                .text("text")
                .build()

        assertThat(responseReasoningSummaryTextDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(responseReasoningSummaryTextDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseReasoningSummaryTextDoneEvent.summaryIndex()).isEqualTo(0L)
        assertThat(responseReasoningSummaryTextDoneEvent.text()).isEqualTo("text")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseReasoningSummaryTextDoneEvent =
            ResponseReasoningSummaryTextDoneEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .summaryIndex(0L)
                .text("text")
                .build()

        val roundtrippedResponseReasoningSummaryTextDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseReasoningSummaryTextDoneEvent),
                jacksonTypeRef<ResponseReasoningSummaryTextDoneEvent>(),
            )

        assertThat(roundtrippedResponseReasoningSummaryTextDoneEvent)
            .isEqualTo(responseReasoningSummaryTextDoneEvent)
    }
}
