// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseWebSearchCallCompletedEventTest {

    @Test
    fun createResponseWebSearchCallCompletedEvent() {
        val responseWebSearchCallCompletedEvent =
            ResponseWebSearchCallCompletedEvent.builder().itemId("item_id").outputIndex(0L).build()
        assertThat(responseWebSearchCallCompletedEvent).isNotNull
        assertThat(responseWebSearchCallCompletedEvent.itemId()).isEqualTo("item_id")
        assertThat(responseWebSearchCallCompletedEvent.outputIndex()).isEqualTo(0L)
    }
}
