// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFunctionCallArgumentsDeltaEventTest {

    @Test
    fun create() {
        val responseFunctionCallArgumentsDeltaEvent =
            ResponseFunctionCallArgumentsDeltaEvent.builder()
                .callId("call_id")
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        assertThat(responseFunctionCallArgumentsDeltaEvent.callId()).isEqualTo("call_id")
        assertThat(responseFunctionCallArgumentsDeltaEvent.delta()).isEqualTo("delta")
        assertThat(responseFunctionCallArgumentsDeltaEvent.eventId()).isEqualTo("event_id")
        assertThat(responseFunctionCallArgumentsDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(responseFunctionCallArgumentsDeltaEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseFunctionCallArgumentsDeltaEvent.responseId()).isEqualTo("response_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseFunctionCallArgumentsDeltaEvent =
            ResponseFunctionCallArgumentsDeltaEvent.builder()
                .callId("call_id")
                .delta("delta")
                .eventId("event_id")
                .itemId("item_id")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        val roundtrippedResponseFunctionCallArgumentsDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFunctionCallArgumentsDeltaEvent),
                jacksonTypeRef<ResponseFunctionCallArgumentsDeltaEvent>(),
            )

        assertThat(roundtrippedResponseFunctionCallArgumentsDeltaEvent)
            .isEqualTo(responseFunctionCallArgumentsDeltaEvent)
    }
}
