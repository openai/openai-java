// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EvalTextSimilarityGraderTest {

    @Test
    fun create() {
        val evalTextSimilarityGrader =
            EvalTextSimilarityGrader.builder()
                .evaluationMetric(EvalTextSimilarityGrader.EvaluationMetric.FUZZY_MATCH)
                .input("input")
                .passThreshold(0.0)
                .reference("reference")
                .name("name")
                .build()

        assertThat(evalTextSimilarityGrader.evaluationMetric())
            .isEqualTo(EvalTextSimilarityGrader.EvaluationMetric.FUZZY_MATCH)
        assertThat(evalTextSimilarityGrader.input()).isEqualTo("input")
        assertThat(evalTextSimilarityGrader.passThreshold()).isEqualTo(0.0)
        assertThat(evalTextSimilarityGrader.reference()).isEqualTo("reference")
        assertThat(evalTextSimilarityGrader.name()).contains("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val evalTextSimilarityGrader =
            EvalTextSimilarityGrader.builder()
                .evaluationMetric(EvalTextSimilarityGrader.EvaluationMetric.FUZZY_MATCH)
                .input("input")
                .passThreshold(0.0)
                .reference("reference")
                .name("name")
                .build()

        val roundtrippedEvalTextSimilarityGrader =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evalTextSimilarityGrader),
                jacksonTypeRef<EvalTextSimilarityGrader>(),
            )

        assertThat(roundtrippedEvalTextSimilarityGrader).isEqualTo(evalTextSimilarityGrader)
    }
}
