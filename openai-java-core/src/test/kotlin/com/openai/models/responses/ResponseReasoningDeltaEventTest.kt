// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseReasoningDeltaEventTest {

    @Test
    fun create() {
        val responseReasoningDeltaEvent =
            ResponseReasoningDeltaEvent.builder()
                .contentIndex(0L)
                .delta(JsonValue.from(mapOf<String, Any>()))
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseReasoningDeltaEvent.contentIndex()).isEqualTo(0L)
        assertThat(responseReasoningDeltaEvent._delta())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(responseReasoningDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(responseReasoningDeltaEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseReasoningDeltaEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseReasoningDeltaEvent =
            ResponseReasoningDeltaEvent.builder()
                .contentIndex(0L)
                .delta(JsonValue.from(mapOf<String, Any>()))
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val roundtrippedResponseReasoningDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseReasoningDeltaEvent),
                jacksonTypeRef<ResponseReasoningDeltaEvent>(),
            )

        assertThat(roundtrippedResponseReasoningDeltaEvent).isEqualTo(responseReasoningDeltaEvent)
    }
}
