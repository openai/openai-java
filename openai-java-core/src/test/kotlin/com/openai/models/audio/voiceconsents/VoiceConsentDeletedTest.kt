// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.audio.voiceconsents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceConsentDeletedTest {

    @Test
    fun createAndRoundtrip() {
        val voiceConsentDeleted =
            VoiceConsentDeleted.builder().id("cons_1234").deleted(true).build()

        assertThat(voiceConsentDeleted.id()).isEqualTo("cons_1234")
        assertThat(voiceConsentDeleted.deleted()).isEqualTo(true)

        val jsonMapper = jsonMapper()

        val roundtrippedVoiceConsentDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(voiceConsentDeleted),
                jacksonTypeRef<VoiceConsentDeleted>(),
            )

        assertThat(roundtrippedVoiceConsentDeleted).isEqualTo(voiceConsentDeleted)
    }
}
