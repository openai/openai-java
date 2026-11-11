// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFunctionCallArgumentsDeltaEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseFunctionCallArgumentsDeltaEvent =
            ResponseFunctionCallArgumentsDeltaEvent.builder()
                .callId("call_id")
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        assertThat(responseFunctionCallArgumentsDeltaEvent.callId()).contains("call_id")
        assertThat(responseFunctionCallArgumentsDeltaEvent.delta()).contains("delta")
        assertThat(responseFunctionCallArgumentsDeltaEvent.eventId()).contains("event_id")
        assertThat(responseFunctionCallArgumentsDeltaEvent.itemId()).contains("item_id")
        assertThat(responseFunctionCallArgumentsDeltaEvent.outputIndex()).contains(0L)
        assertThat(responseFunctionCallArgumentsDeltaEvent.responseId()).contains("response_id")

        val jsonMapper = jsonMapper()

        val roundtrippedResponseFunctionCallArgumentsDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFunctionCallArgumentsDeltaEvent),
                jacksonTypeRef<ResponseFunctionCallArgumentsDeltaEvent>(),
            )

        assertThat(roundtrippedResponseFunctionCallArgumentsDeltaEvent)
            .isEqualTo(responseFunctionCallArgumentsDeltaEvent)
    }
}
