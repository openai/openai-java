// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseWebSearchCallSearchingEventTest {

    @Test
    fun create() {
        val responseWebSearchCallSearchingEvent =
            ResponseWebSearchCallSearchingEvent.builder().itemId("item_id").outputIndex(0L).build()

        assertThat(responseWebSearchCallSearchingEvent.itemId()).isEqualTo("item_id")
        assertThat(responseWebSearchCallSearchingEvent.outputIndex()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseWebSearchCallSearchingEvent =
            ResponseWebSearchCallSearchingEvent.builder().itemId("item_id").outputIndex(0L).build()

        val roundtrippedResponseWebSearchCallSearchingEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseWebSearchCallSearchingEvent),
                jacksonTypeRef<ResponseWebSearchCallSearchingEvent>(),
            )

        assertThat(roundtrippedResponseWebSearchCallSearchingEvent)
            .isEqualTo(responseWebSearchCallSearchingEvent)
    }
}
