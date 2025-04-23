// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EvalListPageResponseTest {

    @Test
    fun create() {
        val evalListPageResponse =
            EvalListPageResponse.builder()
                .addData(
                    EvalListResponse.builder()
                        .id("id")
                        .createdAt(0L)
                        .customDataSourceConfig(
                            EvalCustomDataSourceConfig.Schema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .metadata(
                            EvalListResponse.Metadata.builder()
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
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(evalListPageResponse.data())
            .containsExactly(
                EvalListResponse.builder()
                    .id("id")
                    .createdAt(0L)
                    .customDataSourceConfig(
                        EvalCustomDataSourceConfig.Schema.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .metadata(
                        EvalListResponse.Metadata.builder()
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
            )
        assertThat(evalListPageResponse.firstId()).isEqualTo("first_id")
        assertThat(evalListPageResponse.hasMore()).isEqualTo(true)
        assertThat(evalListPageResponse.lastId()).isEqualTo("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val evalListPageResponse =
            EvalListPageResponse.builder()
                .addData(
                    EvalListResponse.builder()
                        .id("id")
                        .createdAt(0L)
                        .customDataSourceConfig(
                            EvalCustomDataSourceConfig.Schema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .metadata(
                            EvalListResponse.Metadata.builder()
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
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedEvalListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evalListPageResponse),
                jacksonTypeRef<EvalListPageResponse>(),
            )

        assertThat(roundtrippedEvalListPageResponse).isEqualTo(evalListPageResponse)
    }
}
