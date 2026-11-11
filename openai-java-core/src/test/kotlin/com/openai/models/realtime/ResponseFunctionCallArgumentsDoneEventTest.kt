// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFunctionCallArgumentsDoneEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseFunctionCallArgumentsDoneEvent =
            ResponseFunctionCallArgumentsDoneEvent.builder()
                .arguments("arguments")
                .callId("call_id")
                .eventId("event_id")
                .itemId("item_id")
                .name("name")
                .outputIndex(0L)
                .responseId("response_id")
                .build()

        assertThat(responseFunctionCallArgumentsDoneEvent.arguments()).contains("arguments")
        assertThat(responseFunctionCallArgumentsDoneEvent.callId()).contains("call_id")
        assertThat(responseFunctionCallArgumentsDoneEvent.eventId()).contains("event_id")
        assertThat(responseFunctionCallArgumentsDoneEvent.itemId()).contains("item_id")
        assertThat(responseFunctionCallArgumentsDoneEvent.name()).contains("name")
        assertThat(responseFunctionCallArgumentsDoneEvent.outputIndex()).contains(0L)
        assertThat(responseFunctionCallArgumentsDoneEvent.responseId()).contains("response_id")

        val jsonMapper = jsonMapper()

        val roundtrippedResponseFunctionCallArgumentsDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFunctionCallArgumentsDoneEvent),
                jacksonTypeRef<ResponseFunctionCallArgumentsDoneEvent>(),
            )

        assertThat(roundtrippedResponseFunctionCallArgumentsDoneEvent)
            .isEqualTo(responseFunctionCallArgumentsDoneEvent)
    }
}
