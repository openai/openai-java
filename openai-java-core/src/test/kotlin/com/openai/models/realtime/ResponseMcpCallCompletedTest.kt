// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseMcpCallCompletedTest {

    @Test
    fun create() {
        val responseMcpCallCompleted =
            ResponseMcpCallCompleted.builder()
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .build()

        assertThat(responseMcpCallCompleted.eventId()).isEqualTo("event_id")
        assertThat(responseMcpCallCompleted.itemId()).isEqualTo("item_id")
        assertThat(responseMcpCallCompleted.outputIndex()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseMcpCallCompleted =
            ResponseMcpCallCompleted.builder()
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .build()

        val roundtrippedResponseMcpCallCompleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseMcpCallCompleted),
                jacksonTypeRef<ResponseMcpCallCompleted>(),
            )

        assertThat(roundtrippedResponseMcpCallCompleted).isEqualTo(responseMcpCallCompleted)
    }
}
