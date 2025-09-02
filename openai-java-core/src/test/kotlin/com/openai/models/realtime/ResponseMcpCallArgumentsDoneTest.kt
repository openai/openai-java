// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseMcpCallArgumentsDoneTest {

    @Test
    fun create() {
        val responseMcpCallArgumentsDone =
            ResponseMcpCallArgumentsDone.builder()
                .arguments("arguments")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        assertThat(responseMcpCallArgumentsDone.arguments()).isEqualTo("arguments")
        assertThat(responseMcpCallArgumentsDone.eventId()).isEqualTo("event_id")
        assertThat(responseMcpCallArgumentsDone.itemId()).isEqualTo("item_id")
        assertThat(responseMcpCallArgumentsDone.outputIndex()).isEqualTo(0L)
        assertThat(responseMcpCallArgumentsDone.responseId()).isEqualTo("response_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseMcpCallArgumentsDone =
            ResponseMcpCallArgumentsDone.builder()
                .arguments("arguments")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        val roundtrippedResponseMcpCallArgumentsDone =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseMcpCallArgumentsDone),
                jacksonTypeRef<ResponseMcpCallArgumentsDone>(),
            )

        assertThat(roundtrippedResponseMcpCallArgumentsDone).isEqualTo(responseMcpCallArgumentsDone)
    }
}
