// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.alpha.graders

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GraderRunResponseTest {

    @Test
    fun create() {
        val graderRunResponse =
            GraderRunResponse.builder()
                .metadata(
                    GraderRunResponse.Metadata.builder()
                        .errors(
                            GraderRunResponse.Metadata.Errors.builder()
                                .formulaParseError(true)
                                .invalidVariableError(true)
                                .modelGraderParseError(true)
                                .modelGraderRefusalError(true)
                                .modelGraderServerError(true)
                                .modelGraderServerErrorDetails("model_grader_server_error_details")
                                .otherError(true)
                                .pythonGraderRuntimeError(true)
                                .pythonGraderRuntimeErrorDetails(
                                    "python_grader_runtime_error_details"
                                )
                                .pythonGraderServerError(true)
                                .pythonGraderServerErrorType("python_grader_server_error_type")
                                .sampleParseError(true)
                                .truncatedObservationError(true)
                                .unresponsiveRewardError(true)
                                .build()
                        )
                        .executionTime(0.0)
                        .name("name")
                        .sampledModelName("sampled_model_name")
                        .scores(
                            GraderRunResponse.Metadata.Scores.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .tokenUsage(0L)
                        .type("type")
                        .build()
                )
                .modelGraderTokenUsagePerModel(
                    GraderRunResponse.ModelGraderTokenUsagePerModel.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .reward(0.0)
                .subRewards(
                    GraderRunResponse.SubRewards.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        assertThat(graderRunResponse.metadata())
            .isEqualTo(
                GraderRunResponse.Metadata.builder()
                    .errors(
                        GraderRunResponse.Metadata.Errors.builder()
                            .formulaParseError(true)
                            .invalidVariableError(true)
                            .modelGraderParseError(true)
                            .modelGraderRefusalError(true)
                            .modelGraderServerError(true)
                            .modelGraderServerErrorDetails("model_grader_server_error_details")
                            .otherError(true)
                            .pythonGraderRuntimeError(true)
                            .pythonGraderRuntimeErrorDetails("python_grader_runtime_error_details")
                            .pythonGraderServerError(true)
                            .pythonGraderServerErrorType("python_grader_server_error_type")
                            .sampleParseError(true)
                            .truncatedObservationError(true)
                            .unresponsiveRewardError(true)
                            .build()
                    )
                    .executionTime(0.0)
                    .name("name")
                    .sampledModelName("sampled_model_name")
                    .scores(
                        GraderRunResponse.Metadata.Scores.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .tokenUsage(0L)
                    .type("type")
                    .build()
            )
        assertThat(graderRunResponse.modelGraderTokenUsagePerModel())
            .isEqualTo(
                GraderRunResponse.ModelGraderTokenUsagePerModel.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(graderRunResponse.reward()).isEqualTo(0.0)
        assertThat(graderRunResponse.subRewards())
            .isEqualTo(
                GraderRunResponse.SubRewards.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val graderRunResponse =
            GraderRunResponse.builder()
                .metadata(
                    GraderRunResponse.Metadata.builder()
                        .errors(
                            GraderRunResponse.Metadata.Errors.builder()
                                .formulaParseError(true)
                                .invalidVariableError(true)
                                .modelGraderParseError(true)
                                .modelGraderRefusalError(true)
                                .modelGraderServerError(true)
                                .modelGraderServerErrorDetails("model_grader_server_error_details")
                                .otherError(true)
                                .pythonGraderRuntimeError(true)
                                .pythonGraderRuntimeErrorDetails(
                                    "python_grader_runtime_error_details"
                                )
                                .pythonGraderServerError(true)
                                .pythonGraderServerErrorType("python_grader_server_error_type")
                                .sampleParseError(true)
                                .truncatedObservationError(true)
                                .unresponsiveRewardError(true)
                                .build()
                        )
                        .executionTime(0.0)
                        .name("name")
                        .sampledModelName("sampled_model_name")
                        .scores(
                            GraderRunResponse.Metadata.Scores.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .tokenUsage(0L)
                        .type("type")
                        .build()
                )
                .modelGraderTokenUsagePerModel(
                    GraderRunResponse.ModelGraderTokenUsagePerModel.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .reward(0.0)
                .subRewards(
                    GraderRunResponse.SubRewards.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        val roundtrippedGraderRunResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(graderRunResponse),
                jacksonTypeRef<GraderRunResponse>(),
            )

        assertThat(roundtrippedGraderRunResponse).isEqualTo(graderRunResponse)
    }
}
