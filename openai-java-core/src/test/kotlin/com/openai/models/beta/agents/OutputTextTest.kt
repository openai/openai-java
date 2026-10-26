// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OutputTextTest {

    @Test
    fun createAndRoundtrip() {
        val outputText = OutputText.builder().text("text").build()

        assertThat(outputText.text()).isEqualTo("text")

        val jsonMapper = jsonMapper()

        val roundtrippedOutputText =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(outputText),
                jacksonTypeRef<OutputText>(),
            )

        assertThat(roundtrippedOutputText).isEqualTo(outputText)
    }
}
