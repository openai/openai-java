// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseWebSearchCallInProgressEventTest {

    @Test
    fun createResponseWebSearchCallInProgressEvent() {
        val responseWebSearchCallInProgressEvent =
            ResponseWebSearchCallInProgressEvent.builder().itemId("item_id").outputIndex(0L).build()
        assertThat(responseWebSearchCallInProgressEvent).isNotNull
        assertThat(responseWebSearchCallInProgressEvent.itemId()).isEqualTo("item_id")
        assertThat(responseWebSearchCallInProgressEvent.outputIndex()).isEqualTo(0L)
    }
}
