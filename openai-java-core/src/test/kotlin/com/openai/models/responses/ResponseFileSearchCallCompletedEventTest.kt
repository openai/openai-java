// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseFileSearchCallCompletedEventTest {

    @Test
    fun createResponseFileSearchCallCompletedEvent() {
        val responseFileSearchCallCompletedEvent =
            ResponseFileSearchCallCompletedEvent.builder().itemId("item_id").outputIndex(0L).build()
        assertThat(responseFileSearchCallCompletedEvent).isNotNull
        assertThat(responseFileSearchCallCompletedEvent.itemId()).isEqualTo("item_id")
        assertThat(responseFileSearchCallCompletedEvent.outputIndex()).isEqualTo(0L)
    }
}
