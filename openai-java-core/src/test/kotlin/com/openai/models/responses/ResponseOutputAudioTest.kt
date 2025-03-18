// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseOutputAudioTest {

    @Test
    fun create() {
        val responseOutputAudio =
            ResponseOutputAudio.builder().data("data").transcript("transcript").build()

        assertThat(responseOutputAudio.data()).isEqualTo("data")
        assertThat(responseOutputAudio.transcript()).isEqualTo("transcript")
    }
}
