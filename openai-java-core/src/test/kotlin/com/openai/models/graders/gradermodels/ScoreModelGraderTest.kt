// File generated from our OpenAPI spec by Stainless.

package com.openai.models.graders.gradermodels

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.ReasoningEffort
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ScoreModelGraderTest {

    @Test
    fun create() {
        val scoreModelGrader =
            ScoreModelGrader.builder()
                .addInput(
                    ScoreModelGrader.Input.builder()
                        .content("string")
                        .role(ScoreModelGrader.Input.Role.USER)
                        .type(ScoreModelGrader.Input.Type.MESSAGE)
                        .build()
                )
                .model("model")
                .name("name")
                .addRange(0.0)
                .samplingParams(
                    ScoreModelGrader.SamplingParams.builder()
                        .maxCompletionsTokens(1L)
                        .reasoningEffort(ReasoningEffort.MINIMAL)
                        .seed(0L)
                        .temperature(0.0)
                        .topP(1.0)
                        .build()
                )
                .build()

        assertThat(scoreModelGrader.input())
            .containsExactly(
                ScoreModelGrader.Input.builder()
                    .content("string")
                    .role(ScoreModelGrader.Input.Role.USER)
                    .type(ScoreModelGrader.Input.Type.MESSAGE)
                    .build()
            )
        assertThat(scoreModelGrader.model()).isEqualTo("model")
        assertThat(scoreModelGrader.name()).isEqualTo("name")
        assertThat(scoreModelGrader.range().getOrNull()).containsExactly(0.0)
        assertThat(scoreModelGrader.samplingParams())
            .contains(
                ScoreModelGrader.SamplingParams.builder()
                    .maxCompletionsTokens(1L)
                    .reasoningEffort(ReasoningEffort.MINIMAL)
                    .seed(0L)
                    .temperature(0.0)
                    .topP(1.0)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val scoreModelGrader =
            ScoreModelGrader.builder()
                .addInput(
                    ScoreModelGrader.Input.builder()
                        .content("string")
                        .role(ScoreModelGrader.Input.Role.USER)
                        .type(ScoreModelGrader.Input.Type.MESSAGE)
                        .build()
                )
                .model("model")
                .name("name")
                .addRange(0.0)
                .samplingParams(
                    ScoreModelGrader.SamplingParams.builder()
                        .maxCompletionsTokens(1L)
                        .reasoningEffort(ReasoningEffort.MINIMAL)
                        .seed(0L)
                        .temperature(0.0)
                        .topP(1.0)
                        .build()
                )
                .build()

        val roundtrippedScoreModelGrader =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(scoreModelGrader),
                jacksonTypeRef<ScoreModelGrader>(),
            )

        assertThat(roundtrippedScoreModelGrader).isEqualTo(scoreModelGrader)
    }
}
