// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseReasoningTextDeltaEventTest {

    @Test
    fun create() {
        val responseReasoningTextDeltaEvent =
            ResponseReasoningTextDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseReasoningTextDeltaEvent.contentIndex()).isEqualTo(0L)
        assertThat(responseReasoningTextDeltaEvent.delta()).isEqualTo("delta")
        assertThat(responseReasoningTextDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(responseReasoningTextDeltaEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseReasoningTextDeltaEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseReasoningTextDeltaEvent =
            ResponseReasoningTextDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val roundtrippedResponseReasoningTextDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseReasoningTextDeltaEvent),
                jacksonTypeRef<ResponseReasoningTextDeltaEvent>(),
            )

        assertThat(roundtrippedResponseReasoningTextDeltaEvent)
            .isEqualTo(responseReasoningTextDeltaEvent)
    }
}
