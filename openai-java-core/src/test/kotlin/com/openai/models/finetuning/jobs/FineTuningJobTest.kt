// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FineTuningJobTest {

    @Test
    fun create() {
        val fineTuningJob =
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
                        .batchSizeAuto()
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
                        .dpo(
                            FineTuningJob.Method.Dpo.builder()
                                .hyperparameters(
                                    FineTuningJob.Method.Dpo.Hyperparameters.builder()
                                        .batchSizeAuto()
                                        .betaAuto()
                                        .learningRateMultiplierAuto()
                                        .nEpochsAuto()
                                        .build()
                                )
                                .build()
                        )
                        .supervised(
                            FineTuningJob.Method.Supervised.builder()
                                .hyperparameters(
                                    FineTuningJob.Method.Supervised.Hyperparameters.builder()
                                        .batchSizeAuto()
                                        .learningRateMultiplierAuto()
                                        .nEpochsAuto()
                                        .build()
                                )
                                .build()
                        )
                        .type(FineTuningJob.Method.Type.SUPERVISED)
                        .build()
                )
                .build()

        assertThat(fineTuningJob.id()).isEqualTo("id")
        assertThat(fineTuningJob.createdAt()).isEqualTo(0L)
        assertThat(fineTuningJob.error())
            .contains(
                FineTuningJob.Error.builder().code("code").message("message").param("param").build()
            )
        assertThat(fineTuningJob.fineTunedModel()).contains("fine_tuned_model")
        assertThat(fineTuningJob.finishedAt()).contains(0L)
        assertThat(fineTuningJob.hyperparameters())
            .isEqualTo(
                FineTuningJob.Hyperparameters.builder()
                    .batchSizeAuto()
                    .learningRateMultiplierAuto()
                    .nEpochsAuto()
                    .build()
            )
        assertThat(fineTuningJob.model()).isEqualTo("model")
        assertThat(fineTuningJob.organizationId()).isEqualTo("organization_id")
        assertThat(fineTuningJob.resultFiles()).containsExactly("file-abc123")
        assertThat(fineTuningJob.seed()).isEqualTo(0L)
        assertThat(fineTuningJob.status()).isEqualTo(FineTuningJob.Status.VALIDATING_FILES)
        assertThat(fineTuningJob.trainedTokens()).contains(0L)
        assertThat(fineTuningJob.trainingFile()).isEqualTo("training_file")
        assertThat(fineTuningJob.validationFile()).contains("validation_file")
        assertThat(fineTuningJob.estimatedFinish()).contains(0L)
        assertThat(fineTuningJob.integrations().getOrNull())
            .containsExactly(
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
        assertThat(fineTuningJob.metadata())
            .contains(
                FineTuningJob.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(fineTuningJob.method())
            .contains(
                FineTuningJob.Method.builder()
                    .dpo(
                        FineTuningJob.Method.Dpo.builder()
                            .hyperparameters(
                                FineTuningJob.Method.Dpo.Hyperparameters.builder()
                                    .batchSizeAuto()
                                    .betaAuto()
                                    .learningRateMultiplierAuto()
                                    .nEpochsAuto()
                                    .build()
                            )
                            .build()
                    )
                    .supervised(
                        FineTuningJob.Method.Supervised.builder()
                            .hyperparameters(
                                FineTuningJob.Method.Supervised.Hyperparameters.builder()
                                    .batchSizeAuto()
                                    .learningRateMultiplierAuto()
                                    .nEpochsAuto()
                                    .build()
                            )
                            .build()
                    )
                    .type(FineTuningJob.Method.Type.SUPERVISED)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fineTuningJob =
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
                        .batchSizeAuto()
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
                        .dpo(
                            FineTuningJob.Method.Dpo.builder()
                                .hyperparameters(
                                    FineTuningJob.Method.Dpo.Hyperparameters.builder()
                                        .batchSizeAuto()
                                        .betaAuto()
                                        .learningRateMultiplierAuto()
                                        .nEpochsAuto()
                                        .build()
                                )
                                .build()
                        )
                        .supervised(
                            FineTuningJob.Method.Supervised.builder()
                                .hyperparameters(
                                    FineTuningJob.Method.Supervised.Hyperparameters.builder()
                                        .batchSizeAuto()
                                        .learningRateMultiplierAuto()
                                        .nEpochsAuto()
                                        .build()
                                )
                                .build()
                        )
                        .type(FineTuningJob.Method.Type.SUPERVISED)
                        .build()
                )
                .build()

        val roundtrippedFineTuningJob =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fineTuningJob),
                jacksonTypeRef<FineTuningJob>(),
            )

        assertThat(roundtrippedFineTuningJob).isEqualTo(fineTuningJob)
    }
}
