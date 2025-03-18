// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.translations

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TranslationTest {

    @Test
    fun create() {
        val translation = Translation.builder().text("text").build()

        assertThat(translation.text()).isEqualTo("text")
    }
}
