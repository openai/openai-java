// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseWebSearchCallSearchingEventTest {

    @Test
    fun createResponseWebSearchCallSearchingEvent() {
        val responseWebSearchCallSearchingEvent =
            ResponseWebSearchCallSearchingEvent.builder().itemId("item_id").outputIndex(0L).build()
        assertThat(responseWebSearchCallSearchingEvent).isNotNull
        assertThat(responseWebSearchCallSearchingEvent.itemId()).isEqualTo("item_id")
        assertThat(responseWebSearchCallSearchingEvent.outputIndex()).isEqualTo(0L)
    }
}
