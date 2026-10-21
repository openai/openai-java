// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.audio.voiceconsents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceConsentTest {

    @Test
    fun create() {
        val voiceConsent =
            VoiceConsent.builder()
                .id("cons_1234")
                .createdAt(0L)
                .language("language")
                .name("name")
                .build()

        assertThat(voiceConsent.id()).isEqualTo("cons_1234")
        assertThat(voiceConsent.createdAt()).isEqualTo(0L)
        assertThat(voiceConsent.language()).isEqualTo("language")
        assertThat(voiceConsent.name()).isEqualTo("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val voiceConsent =
            VoiceConsent.builder()
                .id("cons_1234")
                .createdAt(0L)
                .language("language")
                .name("name")
                .build()

        val roundtrippedVoiceConsent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(voiceConsent),
                jacksonTypeRef<VoiceConsent>(),
            )

        assertThat(roundtrippedVoiceConsent).isEqualTo(voiceConsent)
    }
}
