// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FineTuningJobCreateParamsTest {

    @Test
    fun createFineTuningJobCreateParams() {
        FineTuningJobCreateParams.builder()
            .model(FineTuningJobCreateParams.Model.BABBAGE_002)
            .trainingFile("file-abc123")
            .hyperparameters(
                FineTuningJobCreateParams.Hyperparameters.builder()
                    .batchSize(
                        FineTuningJobCreateParams.Hyperparameters.BatchSize.ofBehavior(
                            FineTuningJobCreateParams.Hyperparameters.BatchSize.Behavior.AUTO
                        )
                    )
                    .learningRateMultiplier(
                        FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier.ofBehavior(
                            FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
                                .Behavior
                                .AUTO
                        )
                    )
                    .nEpochs(
                        FineTuningJobCreateParams.Hyperparameters.NEpochs.ofBehavior(
                            FineTuningJobCreateParams.Hyperparameters.NEpochs.Behavior.AUTO
                        )
                    )
                    .build()
            )
            .integrations(
                listOf(
                    FineTuningJobCreateParams.Integration.builder()
                        .type(FineTuningJobCreateParams.Integration.Type.WANDB)
                        .wandb(
                            FineTuningJobCreateParams.Integration.Wandb.builder()
                                .project("my-wandb-project")
                                .entity("entity")
                                .name("name")
                                .tags(listOf("custom-tag"))
                                .build()
                        )
                        .build()
                )
            )
            .seed(42L)
            .suffix("x")
            .validationFile("file-abc123")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            FineTuningJobCreateParams.builder()
                .model(FineTuningJobCreateParams.Model.BABBAGE_002)
                .trainingFile("file-abc123")
                .hyperparameters(
                    FineTuningJobCreateParams.Hyperparameters.builder()
                        .batchSize(
                            FineTuningJobCreateParams.Hyperparameters.BatchSize.ofBehavior(
                                FineTuningJobCreateParams.Hyperparameters.BatchSize.Behavior.AUTO
                            )
                        )
                        .learningRateMultiplier(
                            FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
                                .ofBehavior(
                                    FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
                                        .Behavior
                                        .AUTO
                                )
                        )
                        .nEpochs(
                            FineTuningJobCreateParams.Hyperparameters.NEpochs.ofBehavior(
                                FineTuningJobCreateParams.Hyperparameters.NEpochs.Behavior.AUTO
                            )
                        )
                        .build()
                )
                .integrations(
                    listOf(
                        FineTuningJobCreateParams.Integration.builder()
                            .type(FineTuningJobCreateParams.Integration.Type.WANDB)
                            .wandb(
                                FineTuningJobCreateParams.Integration.Wandb.builder()
                                    .project("my-wandb-project")
                                    .entity("entity")
                                    .name("name")
                                    .tags(listOf("custom-tag"))
                                    .build()
                            )
                            .build()
                    )
                )
                .seed(42L)
                .suffix("x")
                .validationFile("file-abc123")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(FineTuningJobCreateParams.Model.BABBAGE_002)
        assertThat(body.trainingFile()).isEqualTo("file-abc123")
        assertThat(body.hyperparameters())
            .isEqualTo(
                FineTuningJobCreateParams.Hyperparameters.builder()
                    .batchSize(
                        FineTuningJobCreateParams.Hyperparameters.BatchSize.ofBehavior(
                            FineTuningJobCreateParams.Hyperparameters.BatchSize.Behavior.AUTO
                        )
                    )
                    .learningRateMultiplier(
                        FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier.ofBehavior(
                            FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
                                .Behavior
                                .AUTO
                        )
                    )
                    .nEpochs(
                        FineTuningJobCreateParams.Hyperparameters.NEpochs.ofBehavior(
                            FineTuningJobCreateParams.Hyperparameters.NEpochs.Behavior.AUTO
                        )
                    )
                    .build()
            )
        assertThat(body.integrations())
            .isEqualTo(
                listOf(
                    FineTuningJobCreateParams.Integration.builder()
                        .type(FineTuningJobCreateParams.Integration.Type.WANDB)
                        .wandb(
                            FineTuningJobCreateParams.Integration.Wandb.builder()
                                .project("my-wandb-project")
                                .entity("entity")
                                .name("name")
                                .tags(listOf("custom-tag"))
                                .build()
                        )
                        .build()
                )
            )
        assertThat(body.seed()).isEqualTo(42L)
        assertThat(body.suffix()).isEqualTo("x")
        assertThat(body.validationFile()).isEqualTo("file-abc123")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            FineTuningJobCreateParams.builder()
                .model(FineTuningJobCreateParams.Model.BABBAGE_002)
                .trainingFile("file-abc123")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(FineTuningJobCreateParams.Model.BABBAGE_002)
        assertThat(body.trainingFile()).isEqualTo("file-abc123")
    }
}
