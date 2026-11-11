// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseReasoningTextDeltaEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseReasoningTextDeltaEvent =
            ResponseReasoningTextDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseReasoningTextDeltaEvent.contentIndex()).contains(0L)
        assertThat(responseReasoningTextDeltaEvent.delta()).contains("delta")
        assertThat(responseReasoningTextDeltaEvent.itemId()).contains("item_id")
        assertThat(responseReasoningTextDeltaEvent.outputIndex()).contains(0L)
        assertThat(responseReasoningTextDeltaEvent.sequenceNumber()).contains(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedResponseReasoningTextDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseReasoningTextDeltaEvent),
                jacksonTypeRef<ResponseReasoningTextDeltaEvent>(),
            )

        assertThat(roundtrippedResponseReasoningTextDeltaEvent)
            .isEqualTo(responseReasoningTextDeltaEvent)
    }
}
