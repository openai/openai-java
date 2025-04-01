// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseRefusalDeltaEventTest {

    @Test
    fun create() {
        val responseRefusalDeltaEvent =
            ResponseRefusalDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .build()

        assertThat(responseRefusalDeltaEvent.contentIndex()).isEqualTo(0L)
        assertThat(responseRefusalDeltaEvent.delta()).isEqualTo("delta")
        assertThat(responseRefusalDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(responseRefusalDeltaEvent.outputIndex()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseRefusalDeltaEvent =
            ResponseRefusalDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .build()

        val roundtrippedResponseRefusalDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseRefusalDeltaEvent),
                jacksonTypeRef<ResponseRefusalDeltaEvent>(),
            )

        assertThat(roundtrippedResponseRefusalDeltaEvent).isEqualTo(responseRefusalDeltaEvent)
    }
}
