// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.audio.voices

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceDeletedTest {

    @Test
    fun createAndRoundtrip() {
        val voiceDeleted = VoiceDeleted.builder().id("voice_1234").deleted(true).build()

        assertThat(voiceDeleted.id()).isEqualTo("voice_1234")
        assertThat(voiceDeleted.deleted()).isEqualTo(true)

        val jsonMapper = jsonMapper()

        val roundtrippedVoiceDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(voiceDeleted),
                jacksonTypeRef<VoiceDeleted>(),
            )

        assertThat(roundtrippedVoiceDeleted).isEqualTo(voiceDeleted)
    }
}
