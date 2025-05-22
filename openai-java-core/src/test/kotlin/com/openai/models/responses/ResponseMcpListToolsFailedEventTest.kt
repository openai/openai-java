// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseMcpListToolsFailedEventTest {

    @Test
    fun create() {
        val responseMcpListToolsFailedEvent =
            ResponseMcpListToolsFailedEvent.builder().sequenceNumber(0L).build()

        assertThat(responseMcpListToolsFailedEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseMcpListToolsFailedEvent =
            ResponseMcpListToolsFailedEvent.builder().sequenceNumber(0L).build()

        val roundtrippedResponseMcpListToolsFailedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseMcpListToolsFailedEvent),
                jacksonTypeRef<ResponseMcpListToolsFailedEvent>(),
            )

        assertThat(roundtrippedResponseMcpListToolsFailedEvent)
            .isEqualTo(responseMcpListToolsFailedEvent)
    }
}
