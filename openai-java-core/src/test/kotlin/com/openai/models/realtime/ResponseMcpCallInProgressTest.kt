// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseMcpCallInProgressTest {

    @Test
    fun create() {
        val responseMcpCallInProgress =
            ResponseMcpCallInProgress.builder()
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .build()

        assertThat(responseMcpCallInProgress.eventId()).isEqualTo("event_id")
        assertThat(responseMcpCallInProgress.itemId()).isEqualTo("item_id")
        assertThat(responseMcpCallInProgress.outputIndex()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseMcpCallInProgress =
            ResponseMcpCallInProgress.builder()
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .build()

        val roundtrippedResponseMcpCallInProgress =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseMcpCallInProgress),
                jacksonTypeRef<ResponseMcpCallInProgress>(),
            )

        assertThat(roundtrippedResponseMcpCallInProgress).isEqualTo(responseMcpCallInProgress)
    }
}
