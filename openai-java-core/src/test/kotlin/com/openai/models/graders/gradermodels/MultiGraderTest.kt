// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.graders.gradermodels

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MultiGraderTest {

    @Test
    fun createAndRoundtrip() {
        val multiGrader =
            MultiGrader.builder()
                .calculateOutput("calculate_output")
                .graders(
                    mapOf(
                        "score" to
                            MultiGrader.Graders.ofStringCheckGrader(
                                StringCheckGrader.builder()
                                    .input("input")
                                    .name("name")
                                    .operation(StringCheckGrader.Operation.EQ)
                                    .reference("reference")
                                    .build()
                            )
                    )
                )
                .name("name")
                .build()

        assertThat(multiGrader.calculateOutput()).contains("calculate_output")
        assertThat(multiGrader.graders())
            .contains(
                mapOf(
                    "score" to
                        MultiGrader.Graders.ofStringCheckGrader(
                            StringCheckGrader.builder()
                                .input("input")
                                .name("name")
                                .operation(StringCheckGrader.Operation.EQ)
                                .reference("reference")
                                .build()
                        )
                )
            )
        assertThat(multiGrader.name()).contains("name")

        val jsonMapper = jsonMapper()

        val roundtrippedMultiGrader =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(multiGrader),
                jacksonTypeRef<MultiGrader>(),
            )

        assertThat(roundtrippedMultiGrader).isEqualTo(multiGrader)
    }
}
