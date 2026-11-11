// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseReasoningSummaryPartDoneEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseReasoningSummaryPartDoneEvent =
            ResponseReasoningSummaryPartDoneEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .part(ResponseReasoningSummaryPartDoneEvent.Part.builder().text("text").build())
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .status(ResponseReasoningSummaryPartDoneEvent.Status.INCOMPLETE)
                .build()

        assertThat(responseReasoningSummaryPartDoneEvent.itemId()).contains("item_id")
        assertThat(responseReasoningSummaryPartDoneEvent.outputIndex()).contains(0L)
        assertThat(responseReasoningSummaryPartDoneEvent.part())
            .contains(ResponseReasoningSummaryPartDoneEvent.Part.builder().text("text").build())
        assertThat(responseReasoningSummaryPartDoneEvent.sequenceNumber()).contains(0L)
        assertThat(responseReasoningSummaryPartDoneEvent.summaryIndex()).contains(0L)
        assertThat(responseReasoningSummaryPartDoneEvent.status())
            .contains(ResponseReasoningSummaryPartDoneEvent.Status.INCOMPLETE)

        val jsonMapper = jsonMapper()

        val roundtrippedResponseReasoningSummaryPartDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseReasoningSummaryPartDoneEvent),
                jacksonTypeRef<ResponseReasoningSummaryPartDoneEvent>(),
            )

        assertThat(roundtrippedResponseReasoningSummaryPartDoneEvent)
            .isEqualTo(responseReasoningSummaryPartDoneEvent)
    }
}
