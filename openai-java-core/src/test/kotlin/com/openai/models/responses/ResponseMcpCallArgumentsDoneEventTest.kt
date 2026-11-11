// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseMcpCallArgumentsDoneEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseMcpCallArgumentsDoneEvent =
            ResponseMcpCallArgumentsDoneEvent.builder()
                .arguments("arguments")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseMcpCallArgumentsDoneEvent.arguments()).contains("arguments")
        assertThat(responseMcpCallArgumentsDoneEvent.itemId()).contains("item_id")
        assertThat(responseMcpCallArgumentsDoneEvent.outputIndex()).contains(0L)
        assertThat(responseMcpCallArgumentsDoneEvent.sequenceNumber()).contains(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedResponseMcpCallArgumentsDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseMcpCallArgumentsDoneEvent),
                jacksonTypeRef<ResponseMcpCallArgumentsDoneEvent>(),
            )

        assertThat(roundtrippedResponseMcpCallArgumentsDoneEvent)
            .isEqualTo(responseMcpCallArgumentsDoneEvent)
    }
}
