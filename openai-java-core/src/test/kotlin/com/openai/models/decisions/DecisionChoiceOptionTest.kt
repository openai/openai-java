// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.decisions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionChoiceOptionTest {

    @Test
    fun create() {
        val decisionChoiceOption =
            DecisionChoiceOption.builder().value("string").description("description").build()

        assertThat(decisionChoiceOption.value())
            .isEqualTo(DecisionChoiceOption.Value.ofString("string"))
        assertThat(decisionChoiceOption.description()).contains("description")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val decisionChoiceOption =
            DecisionChoiceOption.builder().value("string").description("description").build()

        val roundtrippedDecisionChoiceOption =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionChoiceOption),
                jacksonTypeRef<DecisionChoiceOption>(),
            )

        assertThat(roundtrippedDecisionChoiceOption).isEqualTo(decisionChoiceOption)
    }
}
