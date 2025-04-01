// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.translations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranslationTest {

    @Test
    fun create() {
        val translation = Translation.builder().text("text").build()

        assertThat(translation.text()).isEqualTo("text")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val translation = Translation.builder().text("text").build()

        val roundtrippedTranslation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(translation),
                jacksonTypeRef<Translation>(),
            )

        assertThat(roundtrippedTranslation).isEqualTo(translation)
    }
}
