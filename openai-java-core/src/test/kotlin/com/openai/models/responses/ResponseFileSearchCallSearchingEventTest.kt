// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseFileSearchCallSearchingEventTest {

    @Test
    fun createResponseFileSearchCallSearchingEvent() {
        val responseFileSearchCallSearchingEvent =
            ResponseFileSearchCallSearchingEvent.builder().itemId("item_id").outputIndex(0L).build()
        assertThat(responseFileSearchCallSearchingEvent).isNotNull
        assertThat(responseFileSearchCallSearchingEvent.itemId()).isEqualTo("item_id")
        assertThat(responseFileSearchCallSearchingEvent.outputIndex()).isEqualTo(0L)
    }
}
