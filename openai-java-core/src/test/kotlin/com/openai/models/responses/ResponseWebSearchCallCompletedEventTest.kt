// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseWebSearchCallCompletedEventTest {

    @Test
    fun create() {
        val responseWebSearchCallCompletedEvent =
            ResponseWebSearchCallCompletedEvent.builder().itemId("item_id").outputIndex(0L).build()

        assertThat(responseWebSearchCallCompletedEvent.itemId()).isEqualTo("item_id")
        assertThat(responseWebSearchCallCompletedEvent.outputIndex()).isEqualTo(0L)
    }
}
