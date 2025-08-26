// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SummaryTextContentTest {

    @Test
    fun create() {
        val summaryTextContent = SummaryTextContent.builder().text("text").build()

        assertThat(summaryTextContent.text()).isEqualTo("text")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val summaryTextContent = SummaryTextContent.builder().text("text").build()

        val roundtrippedSummaryTextContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(summaryTextContent),
                jacksonTypeRef<SummaryTextContent>(),
            )

        assertThat(roundtrippedSummaryTextContent).isEqualTo(summaryTextContent)
    }
}
