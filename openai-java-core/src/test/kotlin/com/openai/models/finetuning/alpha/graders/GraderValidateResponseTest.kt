// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.alpha.graders

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.graders.gradermodels.StringCheckGrader
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GraderValidateResponseTest {

    @Test
    fun create() {
        val graderValidateResponse =
            GraderValidateResponse.builder()
                .grader(
                    StringCheckGrader.builder()
                        .input("input")
                        .name("name")
                        .operation(StringCheckGrader.Operation.EQ)
                        .reference("reference")
                        .build()
                )
                .build()

        assertThat(graderValidateResponse.grader())
            .contains(
                GraderValidateResponse.Grader.ofStringCheck(
                    StringCheckGrader.builder()
                        .input("input")
                        .name("name")
                        .operation(StringCheckGrader.Operation.EQ)
                        .reference("reference")
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val graderValidateResponse =
            GraderValidateResponse.builder()
                .grader(
                    StringCheckGrader.builder()
                        .input("input")
                        .name("name")
                        .operation(StringCheckGrader.Operation.EQ)
                        .reference("reference")
                        .build()
                )
                .build()

        val roundtrippedGraderValidateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(graderValidateResponse),
                jacksonTypeRef<GraderValidateResponse>(),
            )

        assertThat(roundtrippedGraderValidateResponse).isEqualTo(graderValidateResponse)
    }
}
