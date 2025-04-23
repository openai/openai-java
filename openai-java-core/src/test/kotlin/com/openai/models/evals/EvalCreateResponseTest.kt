// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EvalCreateResponseTest {

    @Test
    fun create() {
        val evalCreateResponse =
            EvalCreateResponse.builder()
                .id("id")
                .createdAt(0L)
                .customDataSourceConfig(
                    EvalCustomDataSourceConfig.Schema.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .metadata(
                    EvalCreateResponse.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .name("Chatbot effectiveness Evaluation")
                .addTestingCriterion(
                    EvalLabelModelGrader.builder()
                        .addInput(
                            EvalLabelModelGrader.Input.builder()
                                .content("string")
                                .role(EvalLabelModelGrader.Input.Role.USER)
                                .type(EvalLabelModelGrader.Input.Type.MESSAGE)
                                .build()
                        )
                        .addLabel("string")
                        .model("model")
                        .name("name")
                        .addPassingLabel("string")
                        .build()
                )
                .build()

        assertThat(evalCreateResponse.id()).isEqualTo("id")
        assertThat(evalCreateResponse.createdAt()).isEqualTo(0L)
        assertThat(evalCreateResponse.dataSourceConfig())
            .isEqualTo(
                EvalCreateResponse.DataSourceConfig.ofCustom(
                    EvalCustomDataSourceConfig.builder()
                        .schema(
                            EvalCustomDataSourceConfig.Schema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
            )
        assertThat(evalCreateResponse.metadata())
            .contains(
                EvalCreateResponse.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(evalCreateResponse.name()).isEqualTo("Chatbot effectiveness Evaluation")
        assertThat(evalCreateResponse.testingCriteria())
            .containsExactly(
                EvalCreateResponse.TestingCriterion.ofLabelModel(
                    EvalLabelModelGrader.builder()
                        .addInput(
                            EvalLabelModelGrader.Input.builder()
                                .content("string")
                                .role(EvalLabelModelGrader.Input.Role.USER)
                                .type(EvalLabelModelGrader.Input.Type.MESSAGE)
                                .build()
                        )
                        .addLabel("string")
                        .model("model")
                        .name("name")
                        .addPassingLabel("string")
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val evalCreateResponse =
            EvalCreateResponse.builder()
                .id("id")
                .createdAt(0L)
                .customDataSourceConfig(
                    EvalCustomDataSourceConfig.Schema.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .metadata(
                    EvalCreateResponse.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .name("Chatbot effectiveness Evaluation")
                .addTestingCriterion(
                    EvalLabelModelGrader.builder()
                        .addInput(
                            EvalLabelModelGrader.Input.builder()
                                .content("string")
                                .role(EvalLabelModelGrader.Input.Role.USER)
                                .type(EvalLabelModelGrader.Input.Type.MESSAGE)
                                .build()
                        )
                        .addLabel("string")
                        .model("model")
                        .name("name")
                        .addPassingLabel("string")
                        .build()
                )
                .build()

        val roundtrippedEvalCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evalCreateResponse),
                jacksonTypeRef<EvalCreateResponse>(),
            )

        assertThat(roundtrippedEvalCreateResponse).isEqualTo(evalCreateResponse)
    }
}
