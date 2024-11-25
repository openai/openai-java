// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FineTuningJobTest {

    @Test
    fun createFineTuningJob() {
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
                        .nEpochs(
                            FineTuningJob.Hyperparameters.NEpochs.ofBehavior(
                                FineTuningJob.Hyperparameters.NEpochs.Behavior.AUTO
                            )
                        )
                        .build()
                )
                .model("model")
                .object_(FineTuningJob.Object.FINE_TUNING_JOB)
                .organizationId("organization_id")
                .resultFiles(listOf("file-abc123"))
                .seed(0L)
                .status(FineTuningJob.Status.VALIDATING_FILES)
                .trainedTokens(0L)
                .trainingFile("training_file")
                .validationFile("validation_file")
                .estimatedFinish(0L)
                .integrations(
                    listOf(
                        FineTuningJobWandbIntegrationObject.builder()
                            .type(FineTuningJobWandbIntegrationObject.Type.WANDB)
                            .wandb(
                                FineTuningJobWandbIntegration.builder()
                                    .project("my-wandb-project")
                                    .entity("entity")
                                    .name("name")
                                    .tags(listOf("custom-tag"))
                                    .build()
                            )
                            .build()
                    )
                )
                .build()
        assertThat(fineTuningJob).isNotNull
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
                    .nEpochs(
                        FineTuningJob.Hyperparameters.NEpochs.ofBehavior(
                            FineTuningJob.Hyperparameters.NEpochs.Behavior.AUTO
                        )
                    )
                    .build()
            )
        assertThat(fineTuningJob.model()).isEqualTo("model")
        assertThat(fineTuningJob.object_()).isEqualTo(FineTuningJob.Object.FINE_TUNING_JOB)
        assertThat(fineTuningJob.organizationId()).isEqualTo("organization_id")
        assertThat(fineTuningJob.resultFiles()).containsExactly("file-abc123")
        assertThat(fineTuningJob.seed()).isEqualTo(0L)
        assertThat(fineTuningJob.status()).isEqualTo(FineTuningJob.Status.VALIDATING_FILES)
        assertThat(fineTuningJob.trainedTokens()).contains(0L)
        assertThat(fineTuningJob.trainingFile()).isEqualTo("training_file")
        assertThat(fineTuningJob.validationFile()).contains("validation_file")
        assertThat(fineTuningJob.estimatedFinish()).contains(0L)
        assertThat(fineTuningJob.integrations().get())
            .containsExactly(
                FineTuningJobWandbIntegrationObject.builder()
                    .type(FineTuningJobWandbIntegrationObject.Type.WANDB)
                    .wandb(
                        FineTuningJobWandbIntegration.builder()
                            .project("my-wandb-project")
                            .entity("entity")
                            .name("name")
                            .tags(listOf("custom-tag"))
                            .build()
                    )
                    .build()
            )
    }
}
