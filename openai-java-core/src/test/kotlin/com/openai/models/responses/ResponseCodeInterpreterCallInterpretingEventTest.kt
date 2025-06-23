// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCodeInterpreterCallInterpretingEventTest {

    @Test
    fun create() {
        val responseCodeInterpreterCallInterpretingEvent =
            ResponseCodeInterpreterCallInterpretingEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseCodeInterpreterCallInterpretingEvent.itemId()).isEqualTo("item_id")
        assertThat(responseCodeInterpreterCallInterpretingEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseCodeInterpreterCallInterpretingEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseCodeInterpreterCallInterpretingEvent =
            ResponseCodeInterpreterCallInterpretingEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val roundtrippedResponseCodeInterpreterCallInterpretingEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseCodeInterpreterCallInterpretingEvent),
                jacksonTypeRef<ResponseCodeInterpreterCallInterpretingEvent>(),
            )

        assertThat(roundtrippedResponseCodeInterpreterCallInterpretingEvent)
            .isEqualTo(responseCodeInterpreterCallInterpretingEvent)
    }
}
