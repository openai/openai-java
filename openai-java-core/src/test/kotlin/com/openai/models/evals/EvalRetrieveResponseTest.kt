// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.evals

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.graders.gradermodels.LabelModelGrader
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EvalRetrieveResponseTest {

    @Test
    fun createAndRoundtrip() {
        val evalRetrieveResponse =
            EvalRetrieveResponse.builder()
                .id("id")
                .createdAt(0L)
                .customDataSourceConfig(
                    EvalCustomDataSourceConfig.Schema.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .metadata(
                    EvalRetrieveResponse.Metadata.builder()
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

        assertThat(evalRetrieveResponse.id()).contains("id")
        assertThat(evalRetrieveResponse.createdAt()).contains(0L)
        assertThat(evalRetrieveResponse.dataSourceConfig())
            .contains(
                EvalRetrieveResponse.DataSourceConfig.ofCustom(
                    EvalCustomDataSourceConfig.builder()
                        .schema(
                            EvalCustomDataSourceConfig.Schema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
            )
        assertThat(evalRetrieveResponse.metadata())
            .contains(
                EvalRetrieveResponse.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(evalRetrieveResponse.name()).contains("Chatbot effectiveness Evaluation")
        assertThat(evalRetrieveResponse.testingCriteria().getOrNull())
            .containsExactly(
                EvalRetrieveResponse.TestingCriterion.ofLabelModelGrader(
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
            )

        val jsonMapper = jsonMapper()

        val roundtrippedEvalRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evalRetrieveResponse),
                jacksonTypeRef<EvalRetrieveResponse>(),
            )

        assertThat(roundtrippedEvalRetrieveResponse).isEqualTo(evalRetrieveResponse)
    }
}
