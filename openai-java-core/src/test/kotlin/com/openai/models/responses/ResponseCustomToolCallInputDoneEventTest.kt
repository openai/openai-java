// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCustomToolCallInputDoneEventTest {

    @Test
    fun create() {
        val responseCustomToolCallInputDoneEvent =
            ResponseCustomToolCallInputDoneEvent.builder()
                .input("input")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseCustomToolCallInputDoneEvent.input()).isEqualTo("input")
        assertThat(responseCustomToolCallInputDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(responseCustomToolCallInputDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseCustomToolCallInputDoneEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseCustomToolCallInputDoneEvent =
            ResponseCustomToolCallInputDoneEvent.builder()
                .input("input")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val roundtrippedResponseCustomToolCallInputDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseCustomToolCallInputDoneEvent),
                jacksonTypeRef<ResponseCustomToolCallInputDoneEvent>(),
            )

        assertThat(roundtrippedResponseCustomToolCallInputDoneEvent)
            .isEqualTo(responseCustomToolCallInputDoneEvent)
    }
}
