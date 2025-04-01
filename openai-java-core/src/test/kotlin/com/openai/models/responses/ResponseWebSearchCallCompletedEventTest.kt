// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
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

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseWebSearchCallCompletedEvent =
            ResponseWebSearchCallCompletedEvent.builder().itemId("item_id").outputIndex(0L).build()

        val roundtrippedResponseWebSearchCallCompletedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseWebSearchCallCompletedEvent),
                jacksonTypeRef<ResponseWebSearchCallCompletedEvent>(),
            )

        assertThat(roundtrippedResponseWebSearchCallCompletedEvent)
            .isEqualTo(responseWebSearchCallCompletedEvent)
    }
}
