// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TextContentTest {

    @Test
    fun create() {
        val textContent = TextContent.builder().text("text").build()

        assertThat(textContent.text()).isEqualTo("text")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val textContent = TextContent.builder().text("text").build()

        val roundtrippedTextContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(textContent),
                jacksonTypeRef<TextContent>(),
            )

        assertThat(roundtrippedTextContent).isEqualTo(textContent)
    }
}
