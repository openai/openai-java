// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseRefusalDoneEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseRefusalDoneEvent =
            ResponseRefusalDoneEvent.builder()
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .refusal("refusal")
                .sequenceNumber(0L)
                .build()

        assertThat(responseRefusalDoneEvent.contentIndex()).isEqualTo(0L)
        assertThat(responseRefusalDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(responseRefusalDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseRefusalDoneEvent.refusal()).isEqualTo("refusal")
        assertThat(responseRefusalDoneEvent.sequenceNumber()).isEqualTo(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedResponseRefusalDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseRefusalDoneEvent),
                jacksonTypeRef<ResponseRefusalDoneEvent>(),
            )

        assertThat(roundtrippedResponseRefusalDoneEvent).isEqualTo(responseRefusalDoneEvent)
    }
}
