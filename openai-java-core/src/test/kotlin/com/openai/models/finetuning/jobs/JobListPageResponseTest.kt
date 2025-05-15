// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.finetuning.methods.DpoHyperparameters
import com.openai.models.finetuning.methods.DpoMethod
import com.openai.models.finetuning.methods.ReinforcementHyperparameters
import com.openai.models.finetuning.methods.ReinforcementMethod
import com.openai.models.finetuning.methods.SupervisedHyperparameters
import com.openai.models.finetuning.methods.SupervisedMethod
import com.openai.models.graders.gradermodels.StringCheckGrader
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JobListPageResponseTest {

    @Test
    fun create() {
        val jobListPageResponse =
            JobListPageResponse.builder()
                .addData(
                    FineTuningJob.builder()
                        .id("id")
                        .createdAt(0L)
                        .error(
                            FineTuningJob.Error.builder()
                                .code("code")
                                .message("message")
                                .param("param")
                                .build()
                        )
                        .fineTunedModel("fine_tuned_model")
                        .finishedAt(0L)
                        .hyperparameters(
                            FineTuningJob.Hyperparameters.builder()
                                .batchSize(JsonValue.from(mapOf<String, Any>()))
                                .learningRateMultiplierAuto()
                                .nEpochsAuto()
                                .build()
                        )
                        .model("model")
                        .organizationId("organization_id")
                        .addResultFile("file-abc123")
                        .seed(0L)
                        .status(FineTuningJob.Status.VALIDATING_FILES)
                        .trainedTokens(0L)
                        .trainingFile("training_file")
                        .validationFile("validation_file")
                        .estimatedFinish(0L)
                        .addIntegration(
                            FineTuningJobWandbIntegrationObject.builder()
                                .wandb(
                                    FineTuningJobWandbIntegration.builder()
                                        .project("my-wandb-project")
                                        .entity("entity")
                                        .name("name")
                                        .addTag("custom-tag")
                                        .build()
                                )
                                .build()
                        )
                        .metadata(
                            FineTuningJob.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .method(
                            FineTuningJob.Method.builder()
                                .type(FineTuningJob.Method.Type.SUPERVISED)
                                .dpo(
                                    DpoMethod.builder()
                                        .hyperparameters(
                                            DpoHyperparameters.builder()
                                                .batchSizeAuto()
                                                .betaAuto()
                                                .learningRateMultiplierAuto()
                                                .nEpochsAuto()
                                                .build()
                                        )
                                        .build()
                                )
                                .reinforcement(
                                    ReinforcementMethod.builder()
                                        .grader(
                                            StringCheckGrader.builder()
                                                .input("input")
                                                .name("name")
                                                .operation(StringCheckGrader.Operation.EQ)
                                                .reference("reference")
                                                .build()
                                        )
                                        .hyperparameters(
                                            ReinforcementHyperparameters.builder()
                                                .batchSizeAuto()
                                                .computeMultiplierAuto()
                                                .evalIntervalAuto()
                                                .evalSamplesAuto()
                                                .learningRateMultiplierAuto()
                                                .nEpochsAuto()
                                                .reasoningEffort(
                                                    ReinforcementHyperparameters.ReasoningEffort
                                                        .DEFAULT
                                                )
                                                .build()
                                        )
                                        .build()
                                )
                                .supervised(
                                    SupervisedMethod.builder()
                                        .hyperparameters(
                                            SupervisedHyperparameters.builder()
                                                .batchSizeAuto()
                                                .learningRateMultiplierAuto()
                                                .nEpochsAuto()
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .hasMore(true)
                .build()

        assertThat(jobListPageResponse.data())
            .containsExactly(
                FineTuningJob.builder()
                    .id("id")
                    .createdAt(0L)
                    .error(
                        FineTuningJob.Error.builder()
                            .code("code")
                            .message("message")
                            .param("param")
                            .build()
                    )
                    .fineTunedModel("fine_tuned_model")
                    .finishedAt(0L)
                    .hyperparameters(
                        FineTuningJob.Hyperparameters.builder()
                            .batchSize(JsonValue.from(mapOf<String, Any>()))
                            .learningRateMultiplierAuto()
                            .nEpochsAuto()
                            .build()
                    )
                    .model("model")
                    .organizationId("organization_id")
                    .addResultFile("file-abc123")
                    .seed(0L)
                    .status(FineTuningJob.Status.VALIDATING_FILES)
                    .trainedTokens(0L)
                    .trainingFile("training_file")
                    .validationFile("validation_file")
                    .estimatedFinish(0L)
                    .addIntegration(
                        FineTuningJobWandbIntegrationObject.builder()
                            .wandb(
                                FineTuningJobWandbIntegration.builder()
                                    .project("my-wandb-project")
                                    .entity("entity")
                                    .name("name")
                                    .addTag("custom-tag")
                                    .build()
                            )
                            .build()
                    )
                    .metadata(
                        FineTuningJob.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .method(
                        FineTuningJob.Method.builder()
                            .type(FineTuningJob.Method.Type.SUPERVISED)
                            .dpo(
                                DpoMethod.builder()
                                    .hyperparameters(
                                        DpoHyperparameters.builder()
                                            .batchSizeAuto()
                                            .betaAuto()
                                            .learningRateMultiplierAuto()
                                            .nEpochsAuto()
                                            .build()
                                    )
                                    .build()
                            )
                            .reinforcement(
                                ReinforcementMethod.builder()
                                    .grader(
                                        StringCheckGrader.builder()
                                            .input("input")
                                            .name("name")
                                            .operation(StringCheckGrader.Operation.EQ)
                                            .reference("reference")
                                            .build()
                                    )
                                    .hyperparameters(
                                        ReinforcementHyperparameters.builder()
                                            .batchSizeAuto()
                                            .computeMultiplierAuto()
                                            .evalIntervalAuto()
                                            .evalSamplesAuto()
                                            .learningRateMultiplierAuto()
                                            .nEpochsAuto()
                                            .reasoningEffort(
                                                ReinforcementHyperparameters.ReasoningEffort.DEFAULT
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .supervised(
                                SupervisedMethod.builder()
                                    .hyperparameters(
                                        SupervisedHyperparameters.builder()
                                            .batchSizeAuto()
                                            .learningRateMultiplierAuto()
                                            .nEpochsAuto()
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
        assertThat(jobListPageResponse.hasMore()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val jobListPageResponse =
            JobListPageResponse.builder()
                .addData(
                    FineTuningJob.builder()
                        .id("id")
                        .createdAt(0L)
                        .error(
                            FineTuningJob.Error.builder()
                                .code("code")
                                .message("message")
                                .param("param")
                                .build()
                        )
                        .fineTunedModel("fine_tuned_model")
                        .finishedAt(0L)
                        .hyperparameters(
                            FineTuningJob.Hyperparameters.builder()
                                .batchSize(JsonValue.from(mapOf<String, Any>()))
                                .learningRateMultiplierAuto()
                                .nEpochsAuto()
                                .build()
                        )
                        .model("model")
                        .organizationId("organization_id")
                        .addResultFile("file-abc123")
                        .seed(0L)
                        .status(FineTuningJob.Status.VALIDATING_FILES)
                        .trainedTokens(0L)
                        .trainingFile("training_file")
                        .validationFile("validation_file")
                        .estimatedFinish(0L)
                        .addIntegration(
                            FineTuningJobWandbIntegrationObject.builder()
                                .wandb(
                                    FineTuningJobWandbIntegration.builder()
                                        .project("my-wandb-project")
                                        .entity("entity")
                                        .name("name")
                                        .addTag("custom-tag")
                                        .build()
                                )
                                .build()
                        )
                        .metadata(
                            FineTuningJob.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .method(
                            FineTuningJob.Method.builder()
                                .type(FineTuningJob.Method.Type.SUPERVISED)
                                .dpo(
                                    DpoMethod.builder()
                                        .hyperparameters(
                                            DpoHyperparameters.builder()
                                                .batchSizeAuto()
                                                .betaAuto()
                                                .learningRateMultiplierAuto()
                                                .nEpochsAuto()
                                                .build()
                                        )
                                        .build()
                                )
                                .reinforcement(
                                    ReinforcementMethod.builder()
                                        .grader(
                                            StringCheckGrader.builder()
                                                .input("input")
                                                .name("name")
                                                .operation(StringCheckGrader.Operation.EQ)
                                                .reference("reference")
                                                .build()
                                        )
                                        .hyperparameters(
                                            ReinforcementHyperparameters.builder()
                                                .batchSizeAuto()
                                                .computeMultiplierAuto()
                                                .evalIntervalAuto()
                                                .evalSamplesAuto()
                                                .learningRateMultiplierAuto()
                                                .nEpochsAuto()
                                                .reasoningEffort(
                                                    ReinforcementHyperparameters.ReasoningEffort
                                                        .DEFAULT
                                                )
                                                .build()
                                        )
                                        .build()
                                )
                                .supervised(
                                    SupervisedMethod.builder()
                                        .hyperparameters(
                                            SupervisedHyperparameters.builder()
                                                .batchSizeAuto()
                                                .learningRateMultiplierAuto()
                                                .nEpochsAuto()
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .hasMore(true)
                .build()

        val roundtrippedJobListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(jobListPageResponse),
                jacksonTypeRef<JobListPageResponse>(),
            )

        assertThat(roundtrippedJobListPageResponse).isEqualTo(jobListPageResponse)
    }
}
