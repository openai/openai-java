// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionQuestionInputTextTest {

    @Test
    fun createAndRoundtrip() {
        val decisionQuestionInputText = DecisionQuestionInputText.builder().text("text").build()

        assertThat(decisionQuestionInputText.text()).isEqualTo("text")

        val jsonMapper = jsonMapper()

        val roundtrippedDecisionQuestionInputText =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionQuestionInputText),
                jacksonTypeRef<DecisionQuestionInputText>(),
            )

        assertThat(roundtrippedDecisionQuestionInputText).isEqualTo(decisionQuestionInputText)
    }
}
