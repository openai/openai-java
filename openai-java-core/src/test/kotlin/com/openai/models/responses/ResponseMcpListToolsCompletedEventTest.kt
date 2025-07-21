// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseMcpListToolsCompletedEventTest {

    @Test
    fun create() {
        val responseMcpListToolsCompletedEvent =
            ResponseMcpListToolsCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseMcpListToolsCompletedEvent.itemId()).isEqualTo("item_id")
        assertThat(responseMcpListToolsCompletedEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseMcpListToolsCompletedEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseMcpListToolsCompletedEvent =
            ResponseMcpListToolsCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val roundtrippedResponseMcpListToolsCompletedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseMcpListToolsCompletedEvent),
                jacksonTypeRef<ResponseMcpListToolsCompletedEvent>(),
            )

        assertThat(roundtrippedResponseMcpListToolsCompletedEvent)
            .isEqualTo(responseMcpListToolsCompletedEvent)
    }
}
