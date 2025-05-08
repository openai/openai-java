// File generated from our OpenAPI spec by Stainless.

package com.openai.models.graders.gradermodels

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
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
                .samplingParams(JsonValue.from(mapOf<String, Any>()))
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
        assertThat(scoreModelGrader._samplingParams())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
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
                .samplingParams(JsonValue.from(mapOf<String, Any>()))
                .build()

        val roundtrippedScoreModelGrader =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(scoreModelGrader),
                jacksonTypeRef<ScoreModelGrader>(),
            )

        assertThat(roundtrippedScoreModelGrader).isEqualTo(scoreModelGrader)
    }
}
