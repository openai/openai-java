// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseImageGenCallCompletedEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseImageGenCallCompletedEvent =
            ResponseImageGenCallCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseImageGenCallCompletedEvent.itemId()).isEqualTo("item_id")
        assertThat(responseImageGenCallCompletedEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseImageGenCallCompletedEvent.sequenceNumber()).isEqualTo(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedResponseImageGenCallCompletedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseImageGenCallCompletedEvent),
                jacksonTypeRef<ResponseImageGenCallCompletedEvent>(),
            )

        assertThat(roundtrippedResponseImageGenCallCompletedEvent)
            .isEqualTo(responseImageGenCallCompletedEvent)
    }
}
