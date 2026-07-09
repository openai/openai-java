// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseInjectCreatedEventTest {

    @Test
    fun create() {
        val betaResponseInjectCreatedEvent =
            BetaResponseInjectCreatedEvent.builder()
                .responseId("response_id")
                .sequenceNumber(0L)
                .streamId("stream_id")
                .build()

        assertThat(betaResponseInjectCreatedEvent.responseId()).isEqualTo("response_id")
        assertThat(betaResponseInjectCreatedEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseInjectCreatedEvent.streamId()).contains("stream_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInjectCreatedEvent =
            BetaResponseInjectCreatedEvent.builder()
                .responseId("response_id")
                .sequenceNumber(0L)
                .streamId("stream_id")
                .build()

        val roundtrippedBetaResponseInjectCreatedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInjectCreatedEvent),
                jacksonTypeRef<BetaResponseInjectCreatedEvent>(),
            )

        assertThat(roundtrippedBetaResponseInjectCreatedEvent)
            .isEqualTo(betaResponseInjectCreatedEvent)
    }
}
