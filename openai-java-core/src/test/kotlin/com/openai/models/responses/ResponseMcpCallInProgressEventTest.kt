// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseMcpCallInProgressEventTest {

    @Test
    fun create() {
        val responseMcpCallInProgressEvent =
            ResponseMcpCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseMcpCallInProgressEvent.itemId()).isEqualTo("item_id")
        assertThat(responseMcpCallInProgressEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseMcpCallInProgressEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseMcpCallInProgressEvent =
            ResponseMcpCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val roundtrippedResponseMcpCallInProgressEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseMcpCallInProgressEvent),
                jacksonTypeRef<ResponseMcpCallInProgressEvent>(),
            )

        assertThat(roundtrippedResponseMcpCallInProgressEvent)
            .isEqualTo(responseMcpCallInProgressEvent)
    }
}
