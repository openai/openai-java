// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.decisions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionInputTextTest {

    @Test
    fun create() {
        val decisionInputText = DecisionInputText.builder().text("text").build()

        assertThat(decisionInputText.text()).isEqualTo("text")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val decisionInputText = DecisionInputText.builder().text("text").build()

        val roundtrippedDecisionInputText =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionInputText),
                jacksonTypeRef<DecisionInputText>(),
            )

        assertThat(roundtrippedDecisionInputText).isEqualTo(decisionInputText)
    }
}
