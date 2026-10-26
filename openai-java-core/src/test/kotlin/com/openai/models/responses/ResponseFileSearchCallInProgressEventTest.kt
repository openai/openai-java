// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFileSearchCallInProgressEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseFileSearchCallInProgressEvent =
            ResponseFileSearchCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseFileSearchCallInProgressEvent.itemId()).isEqualTo("item_id")
        assertThat(responseFileSearchCallInProgressEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseFileSearchCallInProgressEvent.sequenceNumber()).isEqualTo(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedResponseFileSearchCallInProgressEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFileSearchCallInProgressEvent),
                jacksonTypeRef<ResponseFileSearchCallInProgressEvent>(),
            )

        assertThat(roundtrippedResponseFileSearchCallInProgressEvent)
            .isEqualTo(responseFileSearchCallInProgressEvent)
    }
}
