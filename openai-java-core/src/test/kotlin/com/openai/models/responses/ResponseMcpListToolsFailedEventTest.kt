// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseMcpListToolsFailedEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseMcpListToolsFailedEvent =
            ResponseMcpListToolsFailedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseMcpListToolsFailedEvent.itemId()).isEqualTo("item_id")
        assertThat(responseMcpListToolsFailedEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseMcpListToolsFailedEvent.sequenceNumber()).isEqualTo(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedResponseMcpListToolsFailedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseMcpListToolsFailedEvent),
                jacksonTypeRef<ResponseMcpListToolsFailedEvent>(),
            )

        assertThat(roundtrippedResponseMcpListToolsFailedEvent)
            .isEqualTo(responseMcpListToolsFailedEvent)
    }
}
