// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseMcpCallArgumentsDoneTest {

    @Test
    fun createAndRoundtrip() {
        val responseMcpCallArgumentsDone =
            ResponseMcpCallArgumentsDone.builder()
                .arguments("arguments")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        assertThat(responseMcpCallArgumentsDone.arguments()).contains("arguments")
        assertThat(responseMcpCallArgumentsDone.eventId()).contains("event_id")
        assertThat(responseMcpCallArgumentsDone.itemId()).contains("item_id")
        assertThat(responseMcpCallArgumentsDone.outputIndex()).contains(0L)
        assertThat(responseMcpCallArgumentsDone.responseId()).contains("response_id")

        val jsonMapper = jsonMapper()

        val roundtrippedResponseMcpCallArgumentsDone =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseMcpCallArgumentsDone),
                jacksonTypeRef<ResponseMcpCallArgumentsDone>(),
            )

        assertThat(roundtrippedResponseMcpCallArgumentsDone).isEqualTo(responseMcpCallArgumentsDone)
    }
}
