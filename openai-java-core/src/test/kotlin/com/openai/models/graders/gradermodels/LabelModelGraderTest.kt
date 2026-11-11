// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.graders.gradermodels

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LabelModelGraderTest {

    @Test
    fun createAndRoundtrip() {
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

        assertThat(labelModelGrader.input().getOrNull())
            .containsExactly(
                LabelModelGrader.Input.builder()
                    .content("string")
                    .role(LabelModelGrader.Input.Role.USER)
                    .type(LabelModelGrader.Input.Type.MESSAGE)
                    .build()
            )
        assertThat(labelModelGrader.labels().getOrNull()).containsExactly("string")
        assertThat(labelModelGrader.model()).contains("model")
        assertThat(labelModelGrader.name()).contains("name")
        assertThat(labelModelGrader.passingLabels().getOrNull()).containsExactly("string")

        val jsonMapper = jsonMapper()

        val roundtrippedLabelModelGrader =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(labelModelGrader),
                jacksonTypeRef<LabelModelGrader>(),
            )

        assertThat(roundtrippedLabelModelGrader).isEqualTo(labelModelGrader)
    }
}
