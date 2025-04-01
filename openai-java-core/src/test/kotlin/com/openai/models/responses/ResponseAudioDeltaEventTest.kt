// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseAudioDeltaEventTest {

    @Test
    fun create() {
        val responseAudioDeltaEvent = ResponseAudioDeltaEvent.builder().delta("delta").build()

        assertThat(responseAudioDeltaEvent.delta()).isEqualTo("delta")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseAudioDeltaEvent = ResponseAudioDeltaEvent.builder().delta("delta").build()

        val roundtrippedResponseAudioDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseAudioDeltaEvent),
                jacksonTypeRef<ResponseAudioDeltaEvent>(),
            )

        assertThat(roundtrippedResponseAudioDeltaEvent).isEqualTo(responseAudioDeltaEvent)
    }
}
