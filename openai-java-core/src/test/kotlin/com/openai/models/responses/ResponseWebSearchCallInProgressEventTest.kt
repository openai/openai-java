// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseWebSearchCallInProgressEventTest {

    @Test
    fun create() {
        val responseWebSearchCallInProgressEvent =
            ResponseWebSearchCallInProgressEvent.builder().itemId("item_id").outputIndex(0L).build()

        assertThat(responseWebSearchCallInProgressEvent.itemId()).isEqualTo("item_id")
        assertThat(responseWebSearchCallInProgressEvent.outputIndex()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseWebSearchCallInProgressEvent =
            ResponseWebSearchCallInProgressEvent.builder().itemId("item_id").outputIndex(0L).build()

        val roundtrippedResponseWebSearchCallInProgressEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseWebSearchCallInProgressEvent),
                jacksonTypeRef<ResponseWebSearchCallInProgressEvent>(),
            )

        assertThat(roundtrippedResponseWebSearchCallInProgressEvent)
            .isEqualTo(responseWebSearchCallInProgressEvent)
    }
}
