// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.audio.transcriptions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranscriptionLanguageTest {

    @Test
    fun createAndRoundtrip() {
        val transcriptionLanguage = TranscriptionLanguage.builder().code("code").build()

        assertThat(transcriptionLanguage.code()).isEqualTo("code")

        val jsonMapper = jsonMapper()

        val roundtrippedTranscriptionLanguage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(transcriptionLanguage),
                jacksonTypeRef<TranscriptionLanguage>(),
            )

        assertThat(roundtrippedTranscriptionLanguage).isEqualTo(transcriptionLanguage)
    }
}
