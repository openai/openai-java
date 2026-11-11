// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseReasoningSummaryPartAddedEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseReasoningSummaryPartAddedEvent =
            ResponseReasoningSummaryPartAddedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .part(ResponseReasoningSummaryPartAddedEvent.Part.builder().text("text").build())
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .build()

        assertThat(responseReasoningSummaryPartAddedEvent.itemId()).contains("item_id")
        assertThat(responseReasoningSummaryPartAddedEvent.outputIndex()).contains(0L)
        assertThat(responseReasoningSummaryPartAddedEvent.part())
            .contains(ResponseReasoningSummaryPartAddedEvent.Part.builder().text("text").build())
        assertThat(responseReasoningSummaryPartAddedEvent.sequenceNumber()).contains(0L)
        assertThat(responseReasoningSummaryPartAddedEvent.summaryIndex()).contains(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedResponseReasoningSummaryPartAddedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseReasoningSummaryPartAddedEvent),
                jacksonTypeRef<ResponseReasoningSummaryPartAddedEvent>(),
            )

        assertThat(roundtrippedResponseReasoningSummaryPartAddedEvent)
            .isEqualTo(responseReasoningSummaryPartAddedEvent)
    }
}
