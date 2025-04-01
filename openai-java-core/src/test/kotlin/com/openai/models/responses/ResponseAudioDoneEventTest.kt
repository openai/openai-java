// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseAudioDoneEventTest {

    @Test
    fun create() {
        val responseAudioDoneEvent = ResponseAudioDoneEvent.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseAudioDoneEvent = ResponseAudioDoneEvent.builder().build()

        val roundtrippedResponseAudioDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseAudioDoneEvent),
                jacksonTypeRef<ResponseAudioDoneEvent>(),
            )

        assertThat(roundtrippedResponseAudioDoneEvent).isEqualTo(responseAudioDoneEvent)
    }
}
