// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.audio.voiceconsents

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceConsentRetrieveParamsTest {

    @Test
    fun create() {
        VoiceConsentRetrieveParams.builder().consentId("consent_id").build()
    }

    @Test
    fun pathParams() {
        val params = VoiceConsentRetrieveParams.builder().consentId("consent_id").build()

        assertThat(params._pathParam(0)).isEqualTo("consent_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
