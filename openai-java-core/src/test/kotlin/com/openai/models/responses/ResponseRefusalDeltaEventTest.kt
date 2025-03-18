// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseRefusalDeltaEventTest {

    @Test
    fun create() {
        val responseRefusalDeltaEvent =
            ResponseRefusalDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .build()

        assertThat(responseRefusalDeltaEvent.contentIndex()).isEqualTo(0L)
        assertThat(responseRefusalDeltaEvent.delta()).isEqualTo("delta")
        assertThat(responseRefusalDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(responseRefusalDeltaEvent.outputIndex()).isEqualTo(0L)
    }
}
