// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.alpha.graders

import com.openai.models.graders.gradermodels.StringCheckGrader
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GraderValidateParamsTest {

    @Test
    fun create() {
        GraderValidateParams.builder()
            .grader(
                StringCheckGrader.builder()
                    .input("input")
                    .name("name")
                    .operation(StringCheckGrader.Operation.EQ)
                    .reference("reference")
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            GraderValidateParams.builder()
                .grader(
                    StringCheckGrader.builder()
                        .input("input")
                        .name("name")
                        .operation(StringCheckGrader.Operation.EQ)
                        .reference("reference")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.grader())
            .isEqualTo(
                GraderValidateParams.Grader.ofStringCheck(
                    StringCheckGrader.builder()
                        .input("input")
                        .name("name")
                        .operation(StringCheckGrader.Operation.EQ)
                        .reference("reference")
                        .build()
                )
            )
    }
}
