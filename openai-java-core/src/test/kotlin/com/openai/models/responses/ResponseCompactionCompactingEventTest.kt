// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCompactionCompactingEventTest {

    @Test
    fun create() {
        val responseCompactionCompactingEvent =
            ResponseCompactionCompactingEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseCompactionCompactingEvent.itemId()).isEqualTo("item_id")
        assertThat(responseCompactionCompactingEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseCompactionCompactingEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseCompactionCompactingEvent =
            ResponseCompactionCompactingEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val roundtrippedResponseCompactionCompactingEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseCompactionCompactingEvent),
                jacksonTypeRef<ResponseCompactionCompactingEvent>(),
            )

        assertThat(roundtrippedResponseCompactionCompactingEvent)
            .isEqualTo(responseCompactionCompactingEvent)
    }
}
