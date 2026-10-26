// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SummaryTextTest {

    @Test
    fun createAndRoundtrip() {
        val summaryText = SummaryText.builder().text("text").build()

        assertThat(summaryText.text()).isEqualTo("text")

        val jsonMapper = jsonMapper()

        val roundtrippedSummaryText =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(summaryText),
                jacksonTypeRef<SummaryText>(),
            )

        assertThat(roundtrippedSummaryText).isEqualTo(summaryText)
    }
}
