// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseAudioDoneEventTest {

    @Test
    fun create() {
        val responseAudioDoneEvent = ResponseAudioDoneEvent.builder().sequenceNumber(0L).build()

        assertThat(responseAudioDoneEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseAudioDoneEvent = ResponseAudioDoneEvent.builder().sequenceNumber(0L).build()

        val roundtrippedResponseAudioDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseAudioDoneEvent),
                jacksonTypeRef<ResponseAudioDoneEvent>(),
            )

        assertThat(roundtrippedResponseAudioDoneEvent).isEqualTo(responseAudioDoneEvent)
    }
}
