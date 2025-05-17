// File generated from our OpenAPI spec by Stainless.

package com.openai.models.graders.gradermodels

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LabelModelGraderTest {

    @Test
    fun create() {
        val labelModelGrader =
            LabelModelGrader.builder()
                .addInput(
                    LabelModelGrader.Input.builder()
                        .content("string")
                        .role(LabelModelGrader.Input.Role.USER)
                        .type(LabelModelGrader.Input.Type.MESSAGE)
                        .build()
                )
                .addLabel("string")
                .model("model")
                .name("name")
                .addPassingLabel("string")
                .build()

        assertThat(labelModelGrader.input())
            .containsExactly(
                LabelModelGrader.Input.builder()
                    .content("string")
                    .role(LabelModelGrader.Input.Role.USER)
                    .type(LabelModelGrader.Input.Type.MESSAGE)
                    .build()
            )
        assertThat(labelModelGrader.labels()).containsExactly("string")
        assertThat(labelModelGrader.model()).isEqualTo("model")
        assertThat(labelModelGrader.name()).isEqualTo("name")
        assertThat(labelModelGrader.passingLabels()).containsExactly("string")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val labelModelGrader =
            LabelModelGrader.builder()
                .addInput(
                    LabelModelGrader.Input.builder()
                        .content("string")
                        .role(LabelModelGrader.Input.Role.USER)
                        .type(LabelModelGrader.Input.Type.MESSAGE)
                        .build()
                )
                .addLabel("string")
                .model("model")
                .name("name")
                .addPassingLabel("string")
                .build()

        val roundtrippedLabelModelGrader =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(labelModelGrader),
                jacksonTypeRef<LabelModelGrader>(),
            )

        assertThat(roundtrippedLabelModelGrader).isEqualTo(labelModelGrader)
    }
}
