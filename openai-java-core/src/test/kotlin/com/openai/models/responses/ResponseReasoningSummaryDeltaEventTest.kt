// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseReasoningSummaryDeltaEventTest {

    @Test
    fun create() {
        val responseReasoningSummaryDeltaEvent =
            ResponseReasoningSummaryDeltaEvent.builder()
                .delta(JsonValue.from(mapOf<String, Any>()))
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .build()

        assertThat(responseReasoningSummaryDeltaEvent._delta())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(responseReasoningSummaryDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(responseReasoningSummaryDeltaEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseReasoningSummaryDeltaEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(responseReasoningSummaryDeltaEvent.summaryIndex()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseReasoningSummaryDeltaEvent =
            ResponseReasoningSummaryDeltaEvent.builder()
                .delta(JsonValue.from(mapOf<String, Any>()))
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .summaryIndex(0L)
                .build()

        val roundtrippedResponseReasoningSummaryDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseReasoningSummaryDeltaEvent),
                jacksonTypeRef<ResponseReasoningSummaryDeltaEvent>(),
            )

        assertThat(roundtrippedResponseReasoningSummaryDeltaEvent)
            .isEqualTo(responseReasoningSummaryDeltaEvent)
    }
}
