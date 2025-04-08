// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EvalApiErrorTest {

    @Test
    fun create() {
        val evalApiError = EvalApiError.builder().code("code").message("message").build()

        assertThat(evalApiError.code()).isEqualTo("code")
        assertThat(evalApiError.message()).isEqualTo("message")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val evalApiError = EvalApiError.builder().code("code").message("message").build()

        val roundtrippedEvalApiError =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evalApiError),
                jacksonTypeRef<EvalApiError>(),
            )

        assertThat(roundtrippedEvalApiError).isEqualTo(evalApiError)
    }
}
