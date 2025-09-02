// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseMcpCallFailedTest {

    @Test
    fun create() {
        val responseMcpCallFailed =
            ResponseMcpCallFailed.builder()
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .build()

        assertThat(responseMcpCallFailed.eventId()).isEqualTo("event_id")
        assertThat(responseMcpCallFailed.itemId()).isEqualTo("item_id")
        assertThat(responseMcpCallFailed.outputIndex()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseMcpCallFailed =
            ResponseMcpCallFailed.builder()
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .build()

        val roundtrippedResponseMcpCallFailed =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseMcpCallFailed),
                jacksonTypeRef<ResponseMcpCallFailed>(),
            )

        assertThat(roundtrippedResponseMcpCallFailed).isEqualTo(responseMcpCallFailed)
    }
}
