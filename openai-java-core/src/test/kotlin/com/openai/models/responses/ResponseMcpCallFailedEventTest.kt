// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseMcpCallFailedEventTest {

    @Test
    fun create() {
        val responseMcpCallFailedEvent =
            ResponseMcpCallFailedEvent.builder().sequenceNumber(0L).build()

        assertThat(responseMcpCallFailedEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseMcpCallFailedEvent =
            ResponseMcpCallFailedEvent.builder().sequenceNumber(0L).build()

        val roundtrippedResponseMcpCallFailedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseMcpCallFailedEvent),
                jacksonTypeRef<ResponseMcpCallFailedEvent>(),
            )

        assertThat(roundtrippedResponseMcpCallFailedEvent).isEqualTo(responseMcpCallFailedEvent)
    }
}
