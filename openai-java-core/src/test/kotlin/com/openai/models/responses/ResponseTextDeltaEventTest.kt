// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseTextDeltaEventTest {

    @Test
    fun create() {
        val responseTextDeltaEvent =
            ResponseTextDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .build()

        assertThat(responseTextDeltaEvent.contentIndex()).isEqualTo(0L)
        assertThat(responseTextDeltaEvent.delta()).isEqualTo("delta")
        assertThat(responseTextDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(responseTextDeltaEvent.outputIndex()).isEqualTo(0L)
    }
}
