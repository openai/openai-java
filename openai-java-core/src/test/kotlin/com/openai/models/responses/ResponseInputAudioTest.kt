// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseInputAudioTest {

    @Test
    fun create() {
        val responseInputAudio =
            ResponseInputAudio.builder().data("data").format(ResponseInputAudio.Format.MP3).build()

        assertThat(responseInputAudio.data()).isEqualTo("data")
        assertThat(responseInputAudio.format()).isEqualTo(ResponseInputAudio.Format.MP3)
    }
}
