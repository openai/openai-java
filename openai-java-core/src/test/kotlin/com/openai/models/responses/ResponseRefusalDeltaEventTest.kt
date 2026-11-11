// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseRefusalDeltaEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseRefusalDeltaEvent =
            ResponseRefusalDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseRefusalDeltaEvent.contentIndex()).contains(0L)
        assertThat(responseRefusalDeltaEvent.delta()).contains("delta")
        assertThat(responseRefusalDeltaEvent.itemId()).contains("item_id")
        assertThat(responseRefusalDeltaEvent.outputIndex()).contains(0L)
        assertThat(responseRefusalDeltaEvent.sequenceNumber()).contains(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedResponseRefusalDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseRefusalDeltaEvent),
                jacksonTypeRef<ResponseRefusalDeltaEvent>(),
            )

        assertThat(roundtrippedResponseRefusalDeltaEvent).isEqualTo(responseRefusalDeltaEvent)
    }
}
