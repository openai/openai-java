// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFileSearchCallCompletedEventTest {

    @Test
    fun create() {
        val responseFileSearchCallCompletedEvent =
            ResponseFileSearchCallCompletedEvent.builder().itemId("item_id").outputIndex(0L).build()

        assertThat(responseFileSearchCallCompletedEvent.itemId()).isEqualTo("item_id")
        assertThat(responseFileSearchCallCompletedEvent.outputIndex()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseFileSearchCallCompletedEvent =
            ResponseFileSearchCallCompletedEvent.builder().itemId("item_id").outputIndex(0L).build()

        val roundtrippedResponseFileSearchCallCompletedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFileSearchCallCompletedEvent),
                jacksonTypeRef<ResponseFileSearchCallCompletedEvent>(),
            )

        assertThat(roundtrippedResponseFileSearchCallCompletedEvent)
            .isEqualTo(responseFileSearchCallCompletedEvent)
    }
}
