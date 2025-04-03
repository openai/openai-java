// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseTextDeltaEventTest {

    @Test
    fun create() {
        val responseTextDeltaEvent =
            ResponseTextDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .build()

        assertThat(responseTextDeltaEvent.contentIndex()).isEqualTo(0L)
        assertThat(responseTextDeltaEvent.delta()).isEqualTo("delta")
        assertThat(responseTextDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(responseTextDeltaEvent.outputIndex()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseTextDeltaEvent =
            ResponseTextDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .build()

        val roundtrippedResponseTextDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseTextDeltaEvent),
                jacksonTypeRef<ResponseTextDeltaEvent>(),
            )

        assertThat(roundtrippedResponseTextDeltaEvent).isEqualTo(responseTextDeltaEvent)
    }
}
