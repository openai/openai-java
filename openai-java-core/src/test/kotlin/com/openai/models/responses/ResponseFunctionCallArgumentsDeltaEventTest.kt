// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

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
}
