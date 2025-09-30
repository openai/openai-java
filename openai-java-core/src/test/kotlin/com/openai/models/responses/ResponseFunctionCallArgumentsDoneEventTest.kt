// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

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
                .itemId("item_id")
                .name("name")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseFunctionCallArgumentsDoneEvent.arguments()).isEqualTo("arguments")
        assertThat(responseFunctionCallArgumentsDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(responseFunctionCallArgumentsDoneEvent.name()).isEqualTo("name")
        assertThat(responseFunctionCallArgumentsDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseFunctionCallArgumentsDoneEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseFunctionCallArgumentsDoneEvent =
            ResponseFunctionCallArgumentsDoneEvent.builder()
                .arguments("arguments")
                .itemId("item_id")
                .name("name")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val roundtrippedResponseFunctionCallArgumentsDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFunctionCallArgumentsDoneEvent),
                jacksonTypeRef<ResponseFunctionCallArgumentsDoneEvent>(),
            )

        assertThat(roundtrippedResponseFunctionCallArgumentsDoneEvent)
            .isEqualTo(responseFunctionCallArgumentsDoneEvent)
    }
}
