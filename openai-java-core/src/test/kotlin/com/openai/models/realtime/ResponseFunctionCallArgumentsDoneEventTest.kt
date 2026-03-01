// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFunctionCallArgumentsDoneEventTest {

    @Test
    fun create() {
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

        assertThat(responseFunctionCallArgumentsDoneEvent.arguments()).isEqualTo("arguments")
        assertThat(responseFunctionCallArgumentsDoneEvent.callId()).isEqualTo("call_id")
        assertThat(responseFunctionCallArgumentsDoneEvent.eventId()).isEqualTo("event_id")
        assertThat(responseFunctionCallArgumentsDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(responseFunctionCallArgumentsDoneEvent.name()).contains("name")
        assertThat(responseFunctionCallArgumentsDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseFunctionCallArgumentsDoneEvent.responseId()).isEqualTo("response_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
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

        val roundtrippedResponseFunctionCallArgumentsDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFunctionCallArgumentsDoneEvent),
                jacksonTypeRef<ResponseFunctionCallArgumentsDoneEvent>(),
            )

        assertThat(roundtrippedResponseFunctionCallArgumentsDoneEvent)
            .isEqualTo(responseFunctionCallArgumentsDoneEvent)
    }

    @Test
    fun missingName() {
        val jsonMapper = jsonMapper()
        val responseFunctionCallArgumentsDoneEvent =
            jsonMapper.readValue(
                """
                {
                  "arguments": "arguments",
                  "call_id": "call_id",
                  "event_id": "event_id",
                  "item_id": "item_id",
                  "output_index": 0,
                  "response_id": "response_id",
                  "type": "response.function_call_arguments.done"
                }
                """
                    .trimIndent(),
                jacksonTypeRef<ResponseFunctionCallArgumentsDoneEvent>(),
            )

        assertThat(responseFunctionCallArgumentsDoneEvent.arguments()).isEqualTo("arguments")
        assertThat(responseFunctionCallArgumentsDoneEvent.callId()).isEqualTo("call_id")
        assertThat(responseFunctionCallArgumentsDoneEvent.eventId()).isEqualTo("event_id")
        assertThat(responseFunctionCallArgumentsDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(responseFunctionCallArgumentsDoneEvent.name()).isEmpty()
        assertThat(responseFunctionCallArgumentsDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseFunctionCallArgumentsDoneEvent.responseId()).isEqualTo("response_id")
    }
}
