// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCustomToolCallInputDeltaEventTest {

    @Test
    fun create() {
        val responseCustomToolCallInputDeltaEvent =
            ResponseCustomToolCallInputDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseCustomToolCallInputDeltaEvent.delta()).isEqualTo("delta")
        assertThat(responseCustomToolCallInputDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(responseCustomToolCallInputDeltaEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseCustomToolCallInputDeltaEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseCustomToolCallInputDeltaEvent =
            ResponseCustomToolCallInputDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val roundtrippedResponseCustomToolCallInputDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseCustomToolCallInputDeltaEvent),
                jacksonTypeRef<ResponseCustomToolCallInputDeltaEvent>(),
            )

        assertThat(roundtrippedResponseCustomToolCallInputDeltaEvent)
            .isEqualTo(responseCustomToolCallInputDeltaEvent)
    }
}
