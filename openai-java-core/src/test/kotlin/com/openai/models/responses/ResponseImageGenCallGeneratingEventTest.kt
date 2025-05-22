// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseImageGenCallGeneratingEventTest {

    @Test
    fun create() {
        val responseImageGenCallGeneratingEvent =
            ResponseImageGenCallGeneratingEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseImageGenCallGeneratingEvent.itemId()).isEqualTo("item_id")
        assertThat(responseImageGenCallGeneratingEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseImageGenCallGeneratingEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseImageGenCallGeneratingEvent =
            ResponseImageGenCallGeneratingEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val roundtrippedResponseImageGenCallGeneratingEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseImageGenCallGeneratingEvent),
                jacksonTypeRef<ResponseImageGenCallGeneratingEvent>(),
            )

        assertThat(roundtrippedResponseImageGenCallGeneratingEvent)
            .isEqualTo(responseImageGenCallGeneratingEvent)
    }
}
