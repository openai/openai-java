// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseMcpCallInProgressEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseMcpCallInProgressEvent =
            ResponseMcpCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseMcpCallInProgressEvent.itemId()).contains("item_id")
        assertThat(responseMcpCallInProgressEvent.outputIndex()).contains(0L)
        assertThat(responseMcpCallInProgressEvent.sequenceNumber()).contains(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedResponseMcpCallInProgressEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseMcpCallInProgressEvent),
                jacksonTypeRef<ResponseMcpCallInProgressEvent>(),
            )

        assertThat(roundtrippedResponseMcpCallInProgressEvent)
            .isEqualTo(responseMcpCallInProgressEvent)
    }
}
