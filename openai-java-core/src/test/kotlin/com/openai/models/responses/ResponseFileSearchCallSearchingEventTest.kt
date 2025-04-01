// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFileSearchCallSearchingEventTest {

    @Test
    fun create() {
        val responseFileSearchCallSearchingEvent =
            ResponseFileSearchCallSearchingEvent.builder().itemId("item_id").outputIndex(0L).build()

        assertThat(responseFileSearchCallSearchingEvent.itemId()).isEqualTo("item_id")
        assertThat(responseFileSearchCallSearchingEvent.outputIndex()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseFileSearchCallSearchingEvent =
            ResponseFileSearchCallSearchingEvent.builder().itemId("item_id").outputIndex(0L).build()

        val roundtrippedResponseFileSearchCallSearchingEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFileSearchCallSearchingEvent),
                jacksonTypeRef<ResponseFileSearchCallSearchingEvent>(),
            )

        assertThat(roundtrippedResponseFileSearchCallSearchingEvent)
            .isEqualTo(responseFileSearchCallSearchingEvent)
    }
}
