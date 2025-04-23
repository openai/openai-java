// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseReasoningSummaryPartAddedEventTest {

    @Test
    fun create() {
        val responseReasoningSummaryPartAddedEvent =
            ResponseReasoningSummaryPartAddedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .part(ResponseReasoningSummaryPartAddedEvent.Part.builder().text("text").build())
                .summaryIndex(0L)
                .build()

        assertThat(responseReasoningSummaryPartAddedEvent.itemId()).isEqualTo("item_id")
        assertThat(responseReasoningSummaryPartAddedEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseReasoningSummaryPartAddedEvent.part())
            .isEqualTo(ResponseReasoningSummaryPartAddedEvent.Part.builder().text("text").build())
        assertThat(responseReasoningSummaryPartAddedEvent.summaryIndex()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseReasoningSummaryPartAddedEvent =
            ResponseReasoningSummaryPartAddedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .part(ResponseReasoningSummaryPartAddedEvent.Part.builder().text("text").build())
                .summaryIndex(0L)
                .build()

        val roundtrippedResponseReasoningSummaryPartAddedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseReasoningSummaryPartAddedEvent),
                jacksonTypeRef<ResponseReasoningSummaryPartAddedEvent>(),
            )

        assertThat(roundtrippedResponseReasoningSummaryPartAddedEvent)
            .isEqualTo(responseReasoningSummaryPartAddedEvent)
    }
}
