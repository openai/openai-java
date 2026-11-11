// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.graders.gradermodels

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StringCheckGraderTest {

    @Test
    fun createAndRoundtrip() {
        val stringCheckGrader =
            StringCheckGrader.builder()
                .input("input")
                .name("name")
                .operation(StringCheckGrader.Operation.EQ)
                .reference("reference")
                .build()

        assertThat(stringCheckGrader.input()).contains("input")
        assertThat(stringCheckGrader.name()).contains("name")
        assertThat(stringCheckGrader.operation()).contains(StringCheckGrader.Operation.EQ)
        assertThat(stringCheckGrader.reference()).contains("reference")

        val jsonMapper = jsonMapper()

        val roundtrippedStringCheckGrader =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(stringCheckGrader),
                jacksonTypeRef<StringCheckGrader>(),
            )

        assertThat(roundtrippedStringCheckGrader).isEqualTo(stringCheckGrader)
    }
}
