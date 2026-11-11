// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.evals

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.graders.gradermodels.LabelModelGrader
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EvalListPageResponseTest {

    @Test
    fun createAndRoundtrip() {
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
                            LabelModelGrader.builder()
                                .addInput(
                                    LabelModelGrader.Input.builder()
                                        .content("string")
                                        .role(LabelModelGrader.Input.Role.USER)
                                        .type(LabelModelGrader.Input.Type.MESSAGE)
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

        assertThat(evalListPageResponse.data().getOrNull())
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
                        LabelModelGrader.builder()
                            .addInput(
                                LabelModelGrader.Input.builder()
                                    .content("string")
                                    .role(LabelModelGrader.Input.Role.USER)
                                    .type(LabelModelGrader.Input.Type.MESSAGE)
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
        assertThat(evalListPageResponse.firstId()).contains("first_id")
        assertThat(evalListPageResponse.hasMore()).contains(true)
        assertThat(evalListPageResponse.lastId()).contains("last_id")

        val jsonMapper = jsonMapper()

        val roundtrippedEvalListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evalListPageResponse),
                jacksonTypeRef<EvalListPageResponse>(),
            )

        assertThat(roundtrippedEvalListPageResponse).isEqualTo(evalListPageResponse)
    }
}
