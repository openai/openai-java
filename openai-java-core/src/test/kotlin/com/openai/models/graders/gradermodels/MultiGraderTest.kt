// File generated from our OpenAPI spec by Stainless.

package com.openai.models.graders.gradermodels

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
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
                    MultiGrader.Graders.builder()
                        .putAdditionalProperty(
                            "foo",
                            JsonValue.from(
                                mapOf(
                                    "input" to "input",
                                    "name" to "name",
                                    "operation" to "eq",
                                    "reference" to "reference",
                                    "type" to "string_check",
                                )
                            ),
                        )
                        .build()
                )
                .name("name")
                .build()

        assertThat(multiGrader.calculateOutput()).isEqualTo("calculate_output")
        assertThat(multiGrader.graders())
            .isEqualTo(
                MultiGrader.Graders.builder()
                    .putAdditionalProperty(
                        "foo",
                        JsonValue.from(
                            mapOf(
                                "input" to "input",
                                "name" to "name",
                                "operation" to "eq",
                                "reference" to "reference",
                                "type" to "string_check",
                            )
                        ),
                    )
                    .build()
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
                    MultiGrader.Graders.builder()
                        .putAdditionalProperty(
                            "foo",
                            JsonValue.from(
                                mapOf(
                                    "input" to "input",
                                    "name" to "name",
                                    "operation" to "eq",
                                    "reference" to "reference",
                                    "type" to "string_check",
                                )
                            ),
                        )
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
