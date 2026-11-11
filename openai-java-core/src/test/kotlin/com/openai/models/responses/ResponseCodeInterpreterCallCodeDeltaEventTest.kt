// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCodeInterpreterCallCodeDeltaEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseCodeInterpreterCallCodeDeltaEvent =
            ResponseCodeInterpreterCallCodeDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseCodeInterpreterCallCodeDeltaEvent.delta()).contains("delta")
        assertThat(responseCodeInterpreterCallCodeDeltaEvent.itemId()).contains("item_id")
        assertThat(responseCodeInterpreterCallCodeDeltaEvent.outputIndex()).contains(0L)
        assertThat(responseCodeInterpreterCallCodeDeltaEvent.sequenceNumber()).contains(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedResponseCodeInterpreterCallCodeDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseCodeInterpreterCallCodeDeltaEvent),
                jacksonTypeRef<ResponseCodeInterpreterCallCodeDeltaEvent>(),
            )

        assertThat(roundtrippedResponseCodeInterpreterCallCodeDeltaEvent)
            .isEqualTo(responseCodeInterpreterCallCodeDeltaEvent)
    }
}
