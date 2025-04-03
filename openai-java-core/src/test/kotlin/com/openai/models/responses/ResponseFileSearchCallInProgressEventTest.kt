// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFileSearchCallInProgressEventTest {

    @Test
    fun create() {
        val responseFileSearchCallInProgressEvent =
            ResponseFileSearchCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .build()

        assertThat(responseFileSearchCallInProgressEvent.itemId()).isEqualTo("item_id")
        assertThat(responseFileSearchCallInProgressEvent.outputIndex()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseFileSearchCallInProgressEvent =
            ResponseFileSearchCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .build()

        val roundtrippedResponseFileSearchCallInProgressEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFileSearchCallInProgressEvent),
                jacksonTypeRef<ResponseFileSearchCallInProgressEvent>(),
            )

        assertThat(roundtrippedResponseFileSearchCallInProgressEvent)
            .isEqualTo(responseFileSearchCallInProgressEvent)
    }
}
