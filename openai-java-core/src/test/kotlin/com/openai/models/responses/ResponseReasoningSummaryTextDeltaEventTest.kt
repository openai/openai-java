// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseReasoningSummaryTextDeltaEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseReasoningSummaryTextDeltaEvent =
            ResponseReasoningSummaryTextDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .build()

        assertThat(responseReasoningSummaryTextDeltaEvent.delta()).contains("delta")
        assertThat(responseReasoningSummaryTextDeltaEvent.itemId()).contains("item_id")
        assertThat(responseReasoningSummaryTextDeltaEvent.outputIndex()).contains(0L)
        assertThat(responseReasoningSummaryTextDeltaEvent.sequenceNumber()).contains(0L)
        assertThat(responseReasoningSummaryTextDeltaEvent.summaryIndex()).contains(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedResponseReasoningSummaryTextDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseReasoningSummaryTextDeltaEvent),
                jacksonTypeRef<ResponseReasoningSummaryTextDeltaEvent>(),
            )

        assertThat(roundtrippedResponseReasoningSummaryTextDeltaEvent)
            .isEqualTo(responseReasoningSummaryTextDeltaEvent)
    }
}
