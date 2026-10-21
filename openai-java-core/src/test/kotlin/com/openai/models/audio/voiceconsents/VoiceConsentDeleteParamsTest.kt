// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.audio.voiceconsents

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceConsentDeleteParamsTest {

    @Test
    fun create() {
        VoiceConsentDeleteParams.builder().consentId("consent_id").build()
    }

    @Test
    fun pathParams() {
        val params = VoiceConsentDeleteParams.builder().consentId("consent_id").build()

        assertThat(params._pathParam(0)).isEqualTo("consent_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
