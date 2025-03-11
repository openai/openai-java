// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseAudioDeltaEventTest {

    @Test
    fun createResponseAudioDeltaEvent() {
        val responseAudioDeltaEvent = ResponseAudioDeltaEvent.builder().delta("delta").build()
        assertThat(responseAudioDeltaEvent).isNotNull
        assertThat(responseAudioDeltaEvent.delta()).isEqualTo("delta")
    }
}
