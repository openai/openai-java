// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFunctionCallArgumentsDeltaEventTest {

    @Test
    fun create() {
        val responseFunctionCallArgumentsDeltaEvent =
            ResponseFunctionCallArgumentsDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .build()

        assertThat(responseFunctionCallArgumentsDeltaEvent.delta()).isEqualTo("delta")
        assertThat(responseFunctionCallArgumentsDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(responseFunctionCallArgumentsDeltaEvent.outputIndex()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseFunctionCallArgumentsDeltaEvent =
            ResponseFunctionCallArgumentsDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
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
