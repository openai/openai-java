// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseMcpCallCompletedEventTest {

    @Test
    fun create() {
        val responseMcpCallCompletedEvent =
            ResponseMcpCallCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseMcpCallCompletedEvent.itemId()).isEqualTo("item_id")
        assertThat(responseMcpCallCompletedEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseMcpCallCompletedEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseMcpCallCompletedEvent =
            ResponseMcpCallCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val roundtrippedResponseMcpCallCompletedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseMcpCallCompletedEvent),
                jacksonTypeRef<ResponseMcpCallCompletedEvent>(),
            )

        assertThat(roundtrippedResponseMcpCallCompletedEvent)
            .isEqualTo(responseMcpCallCompletedEvent)
    }
}
