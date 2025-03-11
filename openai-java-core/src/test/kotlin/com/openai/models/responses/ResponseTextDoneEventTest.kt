// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseTextDoneEventTest {

    @Test
    fun createResponseTextDoneEvent() {
        val responseTextDoneEvent =
            ResponseTextDoneEvent.builder()
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .text("text")
                .build()
        assertThat(responseTextDoneEvent).isNotNull
        assertThat(responseTextDoneEvent.contentIndex()).isEqualTo(0L)
        assertThat(responseTextDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(responseTextDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseTextDoneEvent.text()).isEqualTo("text")
    }
}
