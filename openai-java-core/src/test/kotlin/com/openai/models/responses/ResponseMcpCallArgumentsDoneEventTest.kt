// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseMcpCallArgumentsDoneEventTest {

    @Test
    fun create() {
        val responseMcpCallArgumentsDoneEvent =
            ResponseMcpCallArgumentsDoneEvent.builder()
                .arguments("arguments")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseMcpCallArgumentsDoneEvent.arguments()).isEqualTo("arguments")
        assertThat(responseMcpCallArgumentsDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(responseMcpCallArgumentsDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseMcpCallArgumentsDoneEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseMcpCallArgumentsDoneEvent =
            ResponseMcpCallArgumentsDoneEvent.builder()
                .arguments("arguments")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val roundtrippedResponseMcpCallArgumentsDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseMcpCallArgumentsDoneEvent),
                jacksonTypeRef<ResponseMcpCallArgumentsDoneEvent>(),
            )

        assertThat(roundtrippedResponseMcpCallArgumentsDoneEvent)
            .isEqualTo(responseMcpCallArgumentsDoneEvent)
    }
}
