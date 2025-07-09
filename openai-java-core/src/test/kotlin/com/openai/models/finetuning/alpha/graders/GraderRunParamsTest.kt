// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.alpha.graders

import com.openai.core.JsonValue
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
            .item(JsonValue.from(mapOf<String, Any>()))
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
                .item(JsonValue.from(mapOf<String, Any>()))
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
        assertThat(body._item()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
    }

    @Test
    fun bodyWithoutOptionalFields() {
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
    }
}
