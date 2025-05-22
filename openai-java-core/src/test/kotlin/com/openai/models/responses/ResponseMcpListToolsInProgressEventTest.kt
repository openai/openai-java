// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseMcpListToolsInProgressEventTest {

    @Test
    fun create() {
        val responseMcpListToolsInProgressEvent =
            ResponseMcpListToolsInProgressEvent.builder().sequenceNumber(0L).build()

        assertThat(responseMcpListToolsInProgressEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseMcpListToolsInProgressEvent =
            ResponseMcpListToolsInProgressEvent.builder().sequenceNumber(0L).build()

        val roundtrippedResponseMcpListToolsInProgressEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseMcpListToolsInProgressEvent),
                jacksonTypeRef<ResponseMcpListToolsInProgressEvent>(),
            )

        assertThat(roundtrippedResponseMcpListToolsInProgressEvent)
            .isEqualTo(responseMcpListToolsInProgressEvent)
    }
}
