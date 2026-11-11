// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseReasoningSummaryTextDoneEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseReasoningSummaryTextDoneEvent =
            ResponseReasoningSummaryTextDoneEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .text("text")
                .build()

        assertThat(responseReasoningSummaryTextDoneEvent.itemId()).contains("item_id")
        assertThat(responseReasoningSummaryTextDoneEvent.outputIndex()).contains(0L)
        assertThat(responseReasoningSummaryTextDoneEvent.sequenceNumber()).contains(0L)
        assertThat(responseReasoningSummaryTextDoneEvent.summaryIndex()).contains(0L)
        assertThat(responseReasoningSummaryTextDoneEvent.text()).contains("text")

        val jsonMapper = jsonMapper()

        val roundtrippedResponseReasoningSummaryTextDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseReasoningSummaryTextDoneEvent),
                jacksonTypeRef<ResponseReasoningSummaryTextDoneEvent>(),
            )

        assertThat(roundtrippedResponseReasoningSummaryTextDoneEvent)
            .isEqualTo(responseReasoningSummaryTextDoneEvent)
    }
}
