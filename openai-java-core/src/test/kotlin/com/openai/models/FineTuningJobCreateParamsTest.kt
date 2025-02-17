// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FineTuningJobCreateParamsTest {

    @Test
    fun create() {
        FineTuningJobCreateParams.builder()
            .model(FineTuningJobCreateParams.Model.BABBAGE_002)
            .trainingFile("file-abc123")
            .hyperparameters(
                FineTuningJobCreateParams.Hyperparameters.builder()
                    .batchSizeAuto()
                    .learningRateMultiplierAuto()
                    .nEpochsAuto()
                    .build()
            )
            .addIntegration(
                FineTuningJobCreateParams.Integration.builder()
                    .wandb(
                        FineTuningJobCreateParams.Integration.Wandb.builder()
                            .project("my-wandb-project")
                            .entity("entity")
                            .name("name")
                            .addTag("custom-tag")
                            .build()
                    )
                    .build()
            )
            .method(
                FineTuningJobCreateParams.Method.builder()
                    .dpo(
                        FineTuningJobCreateParams.Method.Dpo.builder()
                            .hyperparameters(
                                FineTuningJobCreateParams.Method.Dpo.Hyperparameters.builder()
                                    .batchSizeAuto()
                                    .betaAuto()
                                    .learningRateMultiplierAuto()
                                    .nEpochsAuto()
                                    .build()
                            )
                            .build()
                    )
                    .supervised(
                        FineTuningJobCreateParams.Method.Supervised.builder()
                            .hyperparameters(
                                FineTuningJobCreateParams.Method.Supervised.Hyperparameters
                                    .builder()
                                    .batchSizeAuto()
                                    .learningRateMultiplierAuto()
                                    .nEpochsAuto()
                                    .build()
                            )
                            .build()
                    )
                    .type(FineTuningJobCreateParams.Method.Type.SUPERVISED)
                    .build()
            )
            .seed(42L)
            .suffix("x")
            .validationFile("file-abc123")
            .build()
    }

    @Test
    fun body() {
        val params =
            FineTuningJobCreateParams.builder()
                .model(FineTuningJobCreateParams.Model.BABBAGE_002)
                .trainingFile("file-abc123")
                .hyperparameters(
                    FineTuningJobCreateParams.Hyperparameters.builder()
                        .batchSizeAuto()
                        .learningRateMultiplierAuto()
                        .nEpochsAuto()
                        .build()
                )
                .addIntegration(
                    FineTuningJobCreateParams.Integration.builder()
                        .wandb(
                            FineTuningJobCreateParams.Integration.Wandb.builder()
                                .project("my-wandb-project")
                                .entity("entity")
                                .name("name")
                                .addTag("custom-tag")
                                .build()
                        )
                        .build()
                )
                .method(
                    FineTuningJobCreateParams.Method.builder()
                        .dpo(
                            FineTuningJobCreateParams.Method.Dpo.builder()
                                .hyperparameters(
                                    FineTuningJobCreateParams.Method.Dpo.Hyperparameters.builder()
                                        .batchSizeAuto()
                                        .betaAuto()
                                        .learningRateMultiplierAuto()
                                        .nEpochsAuto()
                                        .build()
                                )
                                .build()
                        )
                        .supervised(
                            FineTuningJobCreateParams.Method.Supervised.builder()
                                .hyperparameters(
                                    FineTuningJobCreateParams.Method.Supervised.Hyperparameters
                                        .builder()
                                        .batchSizeAuto()
                                        .learningRateMultiplierAuto()
                                        .nEpochsAuto()
                                        .build()
                                )
                                .build()
                        )
                        .type(FineTuningJobCreateParams.Method.Type.SUPERVISED)
                        .build()
                )
                .seed(42L)
                .suffix("x")
                .validationFile("file-abc123")
                .build()

        val body = params._body()

        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(FineTuningJobCreateParams.Model.BABBAGE_002)
        assertThat(body.trainingFile()).isEqualTo("file-abc123")
        assertThat(body.hyperparameters())
            .contains(
                FineTuningJobCreateParams.Hyperparameters.builder()
                    .batchSizeAuto()
                    .learningRateMultiplierAuto()
                    .nEpochsAuto()
                    .build()
            )
        assertThat(body.integrations())
            .contains(
                listOf(
                    FineTuningJobCreateParams.Integration.builder()
                        .wandb(
                            FineTuningJobCreateParams.Integration.Wandb.builder()
                                .project("my-wandb-project")
                                .entity("entity")
                                .name("name")
                                .addTag("custom-tag")
                                .build()
                        )
                        .build()
                )
            )
        assertThat(body.method())
            .contains(
                FineTuningJobCreateParams.Method.builder()
                    .dpo(
                        FineTuningJobCreateParams.Method.Dpo.builder()
                            .hyperparameters(
                                FineTuningJobCreateParams.Method.Dpo.Hyperparameters.builder()
                                    .batchSizeAuto()
                                    .betaAuto()
                                    .learningRateMultiplierAuto()
                                    .nEpochsAuto()
                                    .build()
                            )
                            .build()
                    )
                    .supervised(
                        FineTuningJobCreateParams.Method.Supervised.builder()
                            .hyperparameters(
                                FineTuningJobCreateParams.Method.Supervised.Hyperparameters
                                    .builder()
                                    .batchSizeAuto()
                                    .learningRateMultiplierAuto()
                                    .nEpochsAuto()
                                    .build()
                            )
                            .build()
                    )
                    .type(FineTuningJobCreateParams.Method.Type.SUPERVISED)
                    .build()
            )
        assertThat(body.seed()).contains(42L)
        assertThat(body.suffix()).contains("x")
        assertThat(body.validationFile()).contains("file-abc123")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            FineTuningJobCreateParams.builder()
                .model(FineTuningJobCreateParams.Model.BABBAGE_002)
                .trainingFile("file-abc123")
                .build()

        val body = params._body()

        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(FineTuningJobCreateParams.Model.BABBAGE_002)
        assertThat(body.trainingFile()).isEqualTo("file-abc123")
    }
}
