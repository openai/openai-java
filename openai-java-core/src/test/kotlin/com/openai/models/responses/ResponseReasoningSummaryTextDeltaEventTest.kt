// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseReasoningSummaryTextDeltaEventTest {

    @Test
    fun create() {
        val responseReasoningSummaryTextDeltaEvent =
            ResponseReasoningSummaryTextDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .summaryIndex(0L)
                .build()

        assertThat(responseReasoningSummaryTextDeltaEvent.delta()).isEqualTo("delta")
        assertThat(responseReasoningSummaryTextDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(responseReasoningSummaryTextDeltaEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseReasoningSummaryTextDeltaEvent.summaryIndex()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseReasoningSummaryTextDeltaEvent =
            ResponseReasoningSummaryTextDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .summaryIndex(0L)
                .build()

        val roundtrippedResponseReasoningSummaryTextDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseReasoningSummaryTextDeltaEvent),
                jacksonTypeRef<ResponseReasoningSummaryTextDeltaEvent>(),
            )

        assertThat(roundtrippedResponseReasoningSummaryTextDeltaEvent)
            .isEqualTo(responseReasoningSummaryTextDeltaEvent)
    }
}
