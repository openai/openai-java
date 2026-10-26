// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.audio.voiceconsents

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceConsentUpdateParamsTest {

    @Test
    fun create() {
        VoiceConsentUpdateParams.builder().consentId("consent_id").name("name").build()
    }

    @Test
    fun pathParams() {
        val params = VoiceConsentUpdateParams.builder().consentId("consent_id").name("name").build()

        assertThat(params._pathParam(0)).isEqualTo("consent_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params = VoiceConsentUpdateParams.builder().consentId("consent_id").name("name").build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("name")
    }
}
