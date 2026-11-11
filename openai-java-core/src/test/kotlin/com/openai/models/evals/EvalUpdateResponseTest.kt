// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.evals

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.graders.gradermodels.LabelModelGrader
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EvalUpdateResponseTest {

    @Test
    fun createAndRoundtrip() {
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

        assertThat(evalUpdateResponse.id()).contains("id")
        assertThat(evalUpdateResponse.createdAt()).contains(0L)
        assertThat(evalUpdateResponse.dataSourceConfig())
            .contains(
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
        assertThat(evalUpdateResponse.name()).contains("Chatbot effectiveness Evaluation")
        assertThat(evalUpdateResponse.testingCriteria().getOrNull())
            .containsExactly(
                EvalUpdateResponse.TestingCriterion.ofLabelModelGrader(
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

        val roundtrippedEvalUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evalUpdateResponse),
                jacksonTypeRef<EvalUpdateResponse>(),
            )

        assertThat(roundtrippedEvalUpdateResponse).isEqualTo(evalUpdateResponse)
    }
}
