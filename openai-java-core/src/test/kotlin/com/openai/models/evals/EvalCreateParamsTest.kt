// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EvalCreateParamsTest {

    @Test
    fun create() {
        EvalCreateParams.builder()
            .dataSourceConfig(
                EvalCreateParams.DataSourceConfig.Custom.builder()
                    .itemSchema(
                        EvalCreateParams.DataSourceConfig.Custom.ItemSchema.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .includeSampleSchema(true)
                    .build()
            )
            .addTestingCriterion(
                EvalCreateParams.TestingCriterion.LabelModel.builder()
                    .addInput(
                        EvalCreateParams.TestingCriterion.LabelModel.Input.SimpleInputMessage
                            .builder()
                            .content("content")
                            .role("role")
                            .build()
                    )
                    .addLabel("string")
                    .model("model")
                    .name("name")
                    .addPassingLabel("string")
                    .build()
            )
            .metadata(
                EvalCreateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .name("name")
            .shareWithOpenAI(true)
            .build()
    }

    @Test
    fun body() {
        val params =
            EvalCreateParams.builder()
                .dataSourceConfig(
                    EvalCreateParams.DataSourceConfig.Custom.builder()
                        .itemSchema(
                            EvalCreateParams.DataSourceConfig.Custom.ItemSchema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .includeSampleSchema(true)
                        .build()
                )
                .addTestingCriterion(
                    EvalCreateParams.TestingCriterion.LabelModel.builder()
                        .addInput(
                            EvalCreateParams.TestingCriterion.LabelModel.Input.SimpleInputMessage
                                .builder()
                                .content("content")
                                .role("role")
                                .build()
                        )
                        .addLabel("string")
                        .model("model")
                        .name("name")
                        .addPassingLabel("string")
                        .build()
                )
                .metadata(
                    EvalCreateParams.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .name("name")
                .shareWithOpenAI(true)
                .build()

        val body = params._body()

        assertThat(body.dataSourceConfig())
            .isEqualTo(
                EvalCreateParams.DataSourceConfig.ofCustom(
                    EvalCreateParams.DataSourceConfig.Custom.builder()
                        .itemSchema(
                            EvalCreateParams.DataSourceConfig.Custom.ItemSchema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .includeSampleSchema(true)
                        .build()
                )
            )
        assertThat(body.testingCriteria())
            .containsExactly(
                EvalCreateParams.TestingCriterion.ofLabelModel(
                    EvalCreateParams.TestingCriterion.LabelModel.builder()
                        .addInput(
                            EvalCreateParams.TestingCriterion.LabelModel.Input.SimpleInputMessage
                                .builder()
                                .content("content")
                                .role("role")
                                .build()
                        )
                        .addLabel("string")
                        .model("model")
                        .name("name")
                        .addPassingLabel("string")
                        .build()
                )
            )
        assertThat(body.metadata())
            .contains(
                EvalCreateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.name()).contains("name")
        assertThat(body.shareWithOpenAI()).contains(true)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            EvalCreateParams.builder()
                .customDataSourceConfig(
                    EvalCreateParams.DataSourceConfig.Custom.ItemSchema.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addTestingCriterion(
                    EvalCreateParams.TestingCriterion.LabelModel.builder()
                        .addInput(
                            EvalCreateParams.TestingCriterion.LabelModel.Input.SimpleInputMessage
                                .builder()
                                .content("content")
                                .role("role")
                                .build()
                        )
                        .addLabel("string")
                        .model("model")
                        .name("name")
                        .addPassingLabel("string")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.dataSourceConfig())
            .isEqualTo(
                EvalCreateParams.DataSourceConfig.ofCustom(
                    EvalCreateParams.DataSourceConfig.Custom.builder()
                        .itemSchema(
                            EvalCreateParams.DataSourceConfig.Custom.ItemSchema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
            )
        assertThat(body.testingCriteria())
            .containsExactly(
                EvalCreateParams.TestingCriterion.ofLabelModel(
                    EvalCreateParams.TestingCriterion.LabelModel.builder()
                        .addInput(
                            EvalCreateParams.TestingCriterion.LabelModel.Input.SimpleInputMessage
                                .builder()
                                .content("content")
                                .role("role")
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
}
