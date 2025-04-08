// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EvalStringCheckGraderTest {

    @Test
    fun create() {
        val evalStringCheckGrader =
            EvalStringCheckGrader.builder()
                .input("input")
                .name("name")
                .operation(EvalStringCheckGrader.Operation.EQ)
                .reference("reference")
                .build()

        assertThat(evalStringCheckGrader.input()).isEqualTo("input")
        assertThat(evalStringCheckGrader.name()).isEqualTo("name")
        assertThat(evalStringCheckGrader.operation()).isEqualTo(EvalStringCheckGrader.Operation.EQ)
        assertThat(evalStringCheckGrader.reference()).isEqualTo("reference")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val evalStringCheckGrader =
            EvalStringCheckGrader.builder()
                .input("input")
                .name("name")
                .operation(EvalStringCheckGrader.Operation.EQ)
                .reference("reference")
                .build()

        val roundtrippedEvalStringCheckGrader =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evalStringCheckGrader),
                jacksonTypeRef<EvalStringCheckGrader>(),
            )

        assertThat(roundtrippedEvalStringCheckGrader).isEqualTo(evalStringCheckGrader)
    }
}
