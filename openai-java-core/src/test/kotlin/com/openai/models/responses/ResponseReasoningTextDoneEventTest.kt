// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseReasoningTextDoneEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseReasoningTextDoneEvent =
            ResponseReasoningTextDoneEvent.builder()
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .text("text")
                .build()

        assertThat(responseReasoningTextDoneEvent.contentIndex()).contains(0L)
        assertThat(responseReasoningTextDoneEvent.itemId()).contains("item_id")
        assertThat(responseReasoningTextDoneEvent.outputIndex()).contains(0L)
        assertThat(responseReasoningTextDoneEvent.sequenceNumber()).contains(0L)
        assertThat(responseReasoningTextDoneEvent.text()).contains("text")

        val jsonMapper = jsonMapper()

        val roundtrippedResponseReasoningTextDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseReasoningTextDoneEvent),
                jacksonTypeRef<ResponseReasoningTextDoneEvent>(),
            )

        assertThat(roundtrippedResponseReasoningTextDoneEvent)
            .isEqualTo(responseReasoningTextDoneEvent)
    }
}
