// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EvalDeleteResponseTest {

    @Test
    fun create() {
        val evalDeleteResponse =
            EvalDeleteResponse.builder()
                .deleted(true)
                .evalId("eval_abc123")
                .object_("eval.deleted")
                .build()

        assertThat(evalDeleteResponse.deleted()).isEqualTo(true)
        assertThat(evalDeleteResponse.evalId()).isEqualTo("eval_abc123")
        assertThat(evalDeleteResponse.object_()).isEqualTo("eval.deleted")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val evalDeleteResponse =
            EvalDeleteResponse.builder()
                .deleted(true)
                .evalId("eval_abc123")
                .object_("eval.deleted")
                .build()

        val roundtrippedEvalDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evalDeleteResponse),
                jacksonTypeRef<EvalDeleteResponse>(),
            )

        assertThat(roundtrippedEvalDeleteResponse).isEqualTo(evalDeleteResponse)
    }
}
