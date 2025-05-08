// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.alpha.graders

import com.openai.models.graders.gradermodels.StringCheckGrader
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GraderRunParamsTest {

    @Test
    fun create() {
        GraderRunParams.builder()
            .grader(
                StringCheckGrader.builder()
                    .input("input")
                    .name("name")
                    .operation(StringCheckGrader.Operation.EQ)
                    .reference("reference")
                    .build()
            )
            .modelSample("model_sample")
            .referenceAnswer("string")
            .build()
    }

    @Test
    fun body() {
        val params =
            GraderRunParams.builder()
                .grader(
                    StringCheckGrader.builder()
                        .input("input")
                        .name("name")
                        .operation(StringCheckGrader.Operation.EQ)
                        .reference("reference")
                        .build()
                )
                .modelSample("model_sample")
                .referenceAnswer("string")
                .build()

        val body = params._body()

        assertThat(body.grader())
            .isEqualTo(
                GraderRunParams.Grader.ofStringCheck(
                    StringCheckGrader.builder()
                        .input("input")
                        .name("name")
                        .operation(StringCheckGrader.Operation.EQ)
                        .reference("reference")
                        .build()
                )
            )
        assertThat(body.modelSample()).isEqualTo("model_sample")
        assertThat(body.referenceAnswer())
            .isEqualTo(GraderRunParams.ReferenceAnswer.ofString("string"))
    }
}
