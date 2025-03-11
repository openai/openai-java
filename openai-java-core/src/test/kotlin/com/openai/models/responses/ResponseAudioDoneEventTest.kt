// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseAudioDoneEventTest {

    @Test
    fun createResponseAudioDoneEvent() {
        val responseAudioDoneEvent = ResponseAudioDoneEvent.builder().build()
        assertThat(responseAudioDoneEvent).isNotNull
    }
}
