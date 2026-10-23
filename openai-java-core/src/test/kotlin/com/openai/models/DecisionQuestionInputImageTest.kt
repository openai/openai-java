// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionQuestionInputImageTest {

    @Test
    fun createAndRoundtrip() {
        val decisionQuestionInputImage =
            DecisionQuestionInputImage.builder()
                .imageUrl("https://")
                .detail(DecisionQuestionInputImage.Detail.LOW)
                .build()

        assertThat(decisionQuestionInputImage.imageUrl()).isEqualTo("https://")
        assertThat(decisionQuestionInputImage.detail())
            .contains(DecisionQuestionInputImage.Detail.LOW)

        val jsonMapper = jsonMapper()

        val roundtrippedDecisionQuestionInputImage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionQuestionInputImage),
                jacksonTypeRef<DecisionQuestionInputImage>(),
            )

        assertThat(roundtrippedDecisionQuestionInputImage).isEqualTo(decisionQuestionInputImage)
    }
}
