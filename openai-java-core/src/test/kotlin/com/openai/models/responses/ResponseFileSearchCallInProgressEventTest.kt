// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseFileSearchCallInProgressEventTest {

    @Test
    fun createResponseFileSearchCallInProgressEvent() {
        val responseFileSearchCallInProgressEvent =
            ResponseFileSearchCallInProgressEvent.builder()
                .itemId("item_id")
                .outputIndex(0L)
                .build()
        assertThat(responseFileSearchCallInProgressEvent).isNotNull
        assertThat(responseFileSearchCallInProgressEvent.itemId()).isEqualTo("item_id")
        assertThat(responseFileSearchCallInProgressEvent.outputIndex()).isEqualTo(0L)
    }
}
