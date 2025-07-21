// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseMcpCallArgumentsDeltaEventTest {

    @Test
    fun create() {
        val responseMcpCallArgumentsDeltaEvent =
            ResponseMcpCallArgumentsDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseMcpCallArgumentsDeltaEvent.delta()).isEqualTo("delta")
        assertThat(responseMcpCallArgumentsDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(responseMcpCallArgumentsDeltaEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseMcpCallArgumentsDeltaEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseMcpCallArgumentsDeltaEvent =
            ResponseMcpCallArgumentsDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val roundtrippedResponseMcpCallArgumentsDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseMcpCallArgumentsDeltaEvent),
                jacksonTypeRef<ResponseMcpCallArgumentsDeltaEvent>(),
            )

        assertThat(roundtrippedResponseMcpCallArgumentsDeltaEvent)
            .isEqualTo(responseMcpCallArgumentsDeltaEvent)
    }
}
