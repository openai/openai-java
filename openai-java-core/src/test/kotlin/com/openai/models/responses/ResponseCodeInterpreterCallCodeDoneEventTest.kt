// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCodeInterpreterCallCodeDoneEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseCodeInterpreterCallCodeDoneEvent =
            ResponseCodeInterpreterCallCodeDoneEvent.builder()
                .code("code")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseCodeInterpreterCallCodeDoneEvent.code()).contains("code")
        assertThat(responseCodeInterpreterCallCodeDoneEvent.itemId()).contains("item_id")
        assertThat(responseCodeInterpreterCallCodeDoneEvent.outputIndex()).contains(0L)
        assertThat(responseCodeInterpreterCallCodeDoneEvent.sequenceNumber()).contains(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedResponseCodeInterpreterCallCodeDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseCodeInterpreterCallCodeDoneEvent),
                jacksonTypeRef<ResponseCodeInterpreterCallCodeDoneEvent>(),
            )

        assertThat(roundtrippedResponseCodeInterpreterCallCodeDoneEvent)
            .isEqualTo(responseCodeInterpreterCallCodeDoneEvent)
    }
}
