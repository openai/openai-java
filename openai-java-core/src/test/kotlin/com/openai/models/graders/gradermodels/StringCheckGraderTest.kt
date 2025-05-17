// File generated from our OpenAPI spec by Stainless.

package com.openai.models.graders.gradermodels

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StringCheckGraderTest {

    @Test
    fun create() {
        val stringCheckGrader =
            StringCheckGrader.builder()
                .input("input")
                .name("name")
                .operation(StringCheckGrader.Operation.EQ)
                .reference("reference")
                .build()

        assertThat(stringCheckGrader.input()).isEqualTo("input")
        assertThat(stringCheckGrader.name()).isEqualTo("name")
        assertThat(stringCheckGrader.operation()).isEqualTo(StringCheckGrader.Operation.EQ)
        assertThat(stringCheckGrader.reference()).isEqualTo("reference")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val stringCheckGrader =
            StringCheckGrader.builder()
                .input("input")
                .name("name")
                .operation(StringCheckGrader.Operation.EQ)
                .reference("reference")
                .build()

        val roundtrippedStringCheckGrader =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(stringCheckGrader),
                jacksonTypeRef<StringCheckGrader>(),
            )

        assertThat(roundtrippedStringCheckGrader).isEqualTo(stringCheckGrader)
    }
}
