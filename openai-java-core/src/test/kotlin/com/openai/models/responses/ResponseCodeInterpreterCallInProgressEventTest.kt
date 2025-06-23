// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCodeInterpreterCallInProgressEventTest {

    @Test
    fun create() {
        val responseCodeInterpreterCallInProgressEvent =
            ResponseCodeInterpreterCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseCodeInterpreterCallInProgressEvent.itemId()).isEqualTo("item_id")
        assertThat(responseCodeInterpreterCallInProgressEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseCodeInterpreterCallInProgressEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseCodeInterpreterCallInProgressEvent =
            ResponseCodeInterpreterCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val roundtrippedResponseCodeInterpreterCallInProgressEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseCodeInterpreterCallInProgressEvent),
                jacksonTypeRef<ResponseCodeInterpreterCallInProgressEvent>(),
            )

        assertThat(roundtrippedResponseCodeInterpreterCallInProgressEvent)
            .isEqualTo(responseCodeInterpreterCallInProgressEvent)
    }
}
