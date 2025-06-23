// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCodeInterpreterCallCompletedEventTest {

    @Test
    fun create() {
        val responseCodeInterpreterCallCompletedEvent =
            ResponseCodeInterpreterCallCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseCodeInterpreterCallCompletedEvent.itemId()).isEqualTo("item_id")
        assertThat(responseCodeInterpreterCallCompletedEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseCodeInterpreterCallCompletedEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseCodeInterpreterCallCompletedEvent =
            ResponseCodeInterpreterCallCompletedEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val roundtrippedResponseCodeInterpreterCallCompletedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseCodeInterpreterCallCompletedEvent),
                jacksonTypeRef<ResponseCodeInterpreterCallCompletedEvent>(),
            )

        assertThat(roundtrippedResponseCodeInterpreterCallCompletedEvent)
            .isEqualTo(responseCodeInterpreterCallCompletedEvent)
    }
}
