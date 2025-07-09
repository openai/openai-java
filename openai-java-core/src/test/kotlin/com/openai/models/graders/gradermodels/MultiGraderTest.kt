// File generated from our OpenAPI spec by Stainless.

package com.openai.models.graders.gradermodels

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MultiGraderTest {

    @Test
    fun create() {
        val multiGrader =
            MultiGrader.builder()
                .calculateOutput("calculate_output")
                .graders(
                    StringCheckGrader.builder()
                        .input("input")
                        .name("name")
                        .operation(StringCheckGrader.Operation.EQ)
                        .reference("reference")
                        .build()
                )
                .name("name")
                .build()

        assertThat(multiGrader.calculateOutput()).isEqualTo("calculate_output")
        assertThat(multiGrader.graders())
            .isEqualTo(
                MultiGrader.Graders.ofStringCheckGrader(
                    StringCheckGrader.builder()
                        .input("input")
                        .name("name")
                        .operation(StringCheckGrader.Operation.EQ)
                        .reference("reference")
                        .build()
                )
            )
        assertThat(multiGrader.name()).isEqualTo("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val multiGrader =
            MultiGrader.builder()
                .calculateOutput("calculate_output")
                .graders(
                    StringCheckGrader.builder()
                        .input("input")
                        .name("name")
                        .operation(StringCheckGrader.Operation.EQ)
                        .reference("reference")
                        .build()
                )
                .name("name")
                .build()

        val roundtrippedMultiGrader =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(multiGrader),
                jacksonTypeRef<MultiGrader>(),
            )

        assertThat(roundtrippedMultiGrader).isEqualTo(multiGrader)
    }
}
