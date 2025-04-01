// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TextContentBlockParamTest {

    @Test
    fun create() {
        val textContentBlockParam = TextContentBlockParam.builder().text("text").build()

        assertThat(textContentBlockParam.text()).isEqualTo("text")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val textContentBlockParam = TextContentBlockParam.builder().text("text").build()

        val roundtrippedTextContentBlockParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(textContentBlockParam),
                jacksonTypeRef<TextContentBlockParam>(),
            )

        assertThat(roundtrippedTextContentBlockParam).isEqualTo(textContentBlockParam)
    }
}
