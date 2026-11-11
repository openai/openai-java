// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFileSearchCallSearchingEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseFileSearchCallSearchingEvent =
            ResponseFileSearchCallSearchingEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseFileSearchCallSearchingEvent.itemId()).contains("item_id")
        assertThat(responseFileSearchCallSearchingEvent.outputIndex()).contains(0L)
        assertThat(responseFileSearchCallSearchingEvent.sequenceNumber()).contains(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedResponseFileSearchCallSearchingEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFileSearchCallSearchingEvent),
                jacksonTypeRef<ResponseFileSearchCallSearchingEvent>(),
            )

        assertThat(roundtrippedResponseFileSearchCallSearchingEvent)
            .isEqualTo(responseFileSearchCallSearchingEvent)
    }
}
