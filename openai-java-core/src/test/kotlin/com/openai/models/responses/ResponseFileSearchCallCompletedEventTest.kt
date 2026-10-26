// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFileSearchCallCompletedEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseFileSearchCallCompletedEvent =
            ResponseFileSearchCallCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseFileSearchCallCompletedEvent.itemId()).isEqualTo("item_id")
        assertThat(responseFileSearchCallCompletedEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseFileSearchCallCompletedEvent.sequenceNumber()).isEqualTo(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedResponseFileSearchCallCompletedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFileSearchCallCompletedEvent),
                jacksonTypeRef<ResponseFileSearchCallCompletedEvent>(),
            )

        assertThat(roundtrippedResponseFileSearchCallCompletedEvent)
            .isEqualTo(responseFileSearchCallCompletedEvent)
    }
}
