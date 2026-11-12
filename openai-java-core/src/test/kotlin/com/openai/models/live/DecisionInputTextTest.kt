// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionInputTextTest {

    @Test
    fun createAndRoundtrip() {
        val decisionInputText = DecisionInputText.builder().text("text").build()

        assertThat(decisionInputText.text()).contains("text")

        val jsonMapper = jsonMapper()

        val roundtrippedDecisionInputText =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionInputText),
                jacksonTypeRef<DecisionInputText>(),
            )

        assertThat(roundtrippedDecisionInputText).isEqualTo(decisionInputText)
    }
}
