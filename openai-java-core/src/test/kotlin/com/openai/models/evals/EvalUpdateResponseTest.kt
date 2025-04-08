// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EvalUpdateResponseTest {

    @Test
    fun create() {
        val evalUpdateResponse =
            EvalUpdateResponse.builder()
                .id("id")
                .createdAt(0L)
                .customDataSourceConfig(
                    EvalCustomDataSourceConfig.Schema.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .metadata(
                    EvalUpdateResponse.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .name("Chatbot effectiveness Evaluation")
                .shareWithOpenAI(true)
                .addTestingCriterion(
                    EvalLabelModelGrader.builder()
                        .addInput(
                            EvalLabelModelGrader.Input.InputMessage.builder()
                                .content(
                                    EvalLabelModelGrader.Input.InputMessage.Content.builder()
                                        .text("text")
                                        .type(
                                            EvalLabelModelGrader.Input.InputMessage.Content.Type
                                                .INPUT_TEXT
                                        )
                                        .build()
                                )
                                .role(EvalLabelModelGrader.Input.InputMessage.Role.USER)
                                .type(EvalLabelModelGrader.Input.InputMessage.Type.MESSAGE)
                                .build()
                        )
                        .addLabel("string")
                        .model("model")
                        .name("name")
                        .addPassingLabel("string")
                        .build()
                )
                .build()

        assertThat(evalUpdateResponse.id()).isEqualTo("id")
        assertThat(evalUpdateResponse.createdAt()).isEqualTo(0L)
        assertThat(evalUpdateResponse.dataSourceConfig())
            .isEqualTo(
                EvalUpdateResponse.DataSourceConfig.ofCustom(
                    EvalCustomDataSourceConfig.builder()
                        .schema(
                            EvalCustomDataSourceConfig.Schema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
            )
        assertThat(evalUpdateResponse.metadata())
            .contains(
                EvalUpdateResponse.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(evalUpdateResponse.name()).isEqualTo("Chatbot effectiveness Evaluation")
        assertThat(evalUpdateResponse.shareWithOpenAI()).isEqualTo(true)
        assertThat(evalUpdateResponse.testingCriteria())
            .containsExactly(
                EvalUpdateResponse.TestingCriterion.ofLabelModel(
                    EvalLabelModelGrader.builder()
                        .addInput(
                            EvalLabelModelGrader.Input.InputMessage.builder()
                                .content(
                                    EvalLabelModelGrader.Input.InputMessage.Content.builder()
                                        .text("text")
                                        .type(
                                            EvalLabelModelGrader.Input.InputMessage.Content.Type
                                                .INPUT_TEXT
                                        )
                                        .build()
                                )
                                .role(EvalLabelModelGrader.Input.InputMessage.Role.USER)
                                .type(EvalLabelModelGrader.Input.InputMessage.Type.MESSAGE)
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
        val evalUpdateResponse =
            EvalUpdateResponse.builder()
                .id("id")
                .createdAt(0L)
                .customDataSourceConfig(
                    EvalCustomDataSourceConfig.Schema.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .metadata(
                    EvalUpdateResponse.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .name("Chatbot effectiveness Evaluation")
                .shareWithOpenAI(true)
                .addTestingCriterion(
                    EvalLabelModelGrader.builder()
                        .addInput(
                            EvalLabelModelGrader.Input.InputMessage.builder()
                                .content(
                                    EvalLabelModelGrader.Input.InputMessage.Content.builder()
                                        .text("text")
                                        .type(
                                            EvalLabelModelGrader.Input.InputMessage.Content.Type
                                                .INPUT_TEXT
                                        )
                                        .build()
                                )
                                .role(EvalLabelModelGrader.Input.InputMessage.Role.USER)
                                .type(EvalLabelModelGrader.Input.InputMessage.Type.MESSAGE)
                                .build()
                        )
                        .addLabel("string")
                        .model("model")
                        .name("name")
                        .addPassingLabel("string")
                        .build()
                )
                .build()

        val roundtrippedEvalUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evalUpdateResponse),
                jacksonTypeRef<EvalUpdateResponse>(),
            )

        assertThat(roundtrippedEvalUpdateResponse).isEqualTo(evalUpdateResponse)
    }
}
