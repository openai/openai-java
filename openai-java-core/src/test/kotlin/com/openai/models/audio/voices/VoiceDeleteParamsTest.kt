// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.audio.voices

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceDeleteParamsTest {

    @Test
    fun create() {
        VoiceDeleteParams.builder().voiceId("voice_id").build()
    }

    @Test
    fun pathParams() {
        val params = VoiceDeleteParams.builder().voiceId("voice_id").build()

        assertThat(params._pathParam(0)).isEqualTo("voice_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
