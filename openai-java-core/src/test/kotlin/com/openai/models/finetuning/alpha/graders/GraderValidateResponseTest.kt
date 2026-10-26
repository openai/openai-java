// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.finetuning.alpha.graders

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.graders.gradermodels.StringCheckGrader
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GraderValidateResponseTest {

    @Test
    fun createAndRoundtrip() {
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

        val jsonMapper = jsonMapper()

        val roundtrippedGraderValidateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(graderValidateResponse),
                jacksonTypeRef<GraderValidateResponse>(),
            )

        assertThat(roundtrippedGraderValidateResponse).isEqualTo(graderValidateResponse)
    }
}
