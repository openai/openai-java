// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EvalJsonlFileIdSourceTest {

    @Test
    fun create() {
        val evalJsonlFileIdSource = EvalJsonlFileIdSource.builder().id("id").build()

        assertThat(evalJsonlFileIdSource.id()).isEqualTo("id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val evalJsonlFileIdSource = EvalJsonlFileIdSource.builder().id("id").build()

        val roundtrippedEvalJsonlFileIdSource =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evalJsonlFileIdSource),
                jacksonTypeRef<EvalJsonlFileIdSource>(),
            )

        assertThat(roundtrippedEvalJsonlFileIdSource).isEqualTo(evalJsonlFileIdSource)
    }
}
