// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseImageGenCallInProgressEventTest {

    @Test
    fun create() {
        val responseImageGenCallInProgressEvent =
            ResponseImageGenCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseImageGenCallInProgressEvent.itemId()).isEqualTo("item_id")
        assertThat(responseImageGenCallInProgressEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseImageGenCallInProgressEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseImageGenCallInProgressEvent =
            ResponseImageGenCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val roundtrippedResponseImageGenCallInProgressEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseImageGenCallInProgressEvent),
                jacksonTypeRef<ResponseImageGenCallInProgressEvent>(),
            )

        assertThat(roundtrippedResponseImageGenCallInProgressEvent)
            .isEqualTo(responseImageGenCallInProgressEvent)
    }
}
