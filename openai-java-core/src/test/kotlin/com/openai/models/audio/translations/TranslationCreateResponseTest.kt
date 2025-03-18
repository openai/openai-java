// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.translations

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranslationCreateResponseTest {

    @Test
    fun ofTranslation() {
        val translation = Translation.builder().text("text").build()

        val translationCreateResponse = TranslationCreateResponse.ofTranslation(translation)

        assertThat(translationCreateResponse.translation()).contains(translation)
        assertThat(translationCreateResponse.verbose()).isEmpty
    }

    @Test
    fun ofVerbose() {
        val verbose =
            TranslationVerbose.builder().duration(0.0).language("language").text("text").build()

        val translationCreateResponse = TranslationCreateResponse.ofVerbose(verbose)

        assertThat(translationCreateResponse.translation()).isEmpty
        assertThat(translationCreateResponse.verbose()).contains(verbose)
    }
}
