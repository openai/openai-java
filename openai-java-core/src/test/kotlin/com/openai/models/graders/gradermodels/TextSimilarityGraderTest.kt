// File generated from our OpenAPI spec by Stainless.

package com.openai.models.graders.gradermodels

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TextSimilarityGraderTest {

    @Test
    fun create() {
        val textSimilarityGrader =
            TextSimilarityGrader.builder()
                .evaluationMetric(TextSimilarityGrader.EvaluationMetric.FUZZY_MATCH)
                .input("input")
                .name("name")
                .reference("reference")
                .build()

        assertThat(textSimilarityGrader.evaluationMetric())
            .isEqualTo(TextSimilarityGrader.EvaluationMetric.FUZZY_MATCH)
        assertThat(textSimilarityGrader.input()).isEqualTo("input")
        assertThat(textSimilarityGrader.name()).isEqualTo("name")
        assertThat(textSimilarityGrader.reference()).isEqualTo("reference")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val textSimilarityGrader =
            TextSimilarityGrader.builder()
                .evaluationMetric(TextSimilarityGrader.EvaluationMetric.FUZZY_MATCH)
                .input("input")
                .name("name")
                .reference("reference")
                .build()

        val roundtrippedTextSimilarityGrader =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(textSimilarityGrader),
                jacksonTypeRef<TextSimilarityGrader>(),
            )

        assertThat(roundtrippedTextSimilarityGrader).isEqualTo(textSimilarityGrader)
    }
}
