// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputTextContentTest {

    @Test
    fun create() {
        val inputTextContent = InputTextContent.builder().text("text").build()

        assertThat(inputTextContent.text()).isEqualTo("text")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inputTextContent = InputTextContent.builder().text("text").build()

        val roundtrippedInputTextContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inputTextContent),
                jacksonTypeRef<InputTextContent>(),
            )

        assertThat(roundtrippedInputTextContent).isEqualTo(inputTextContent)
    }
}
