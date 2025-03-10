// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs

import com.openai.core.JsonValue
import com.openai.models.Metadata
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class JobCreateParamsTest {

    @Test
    fun create() {
        JobCreateParams.builder()
            .model(JobCreateParams.Model.BABBAGE_002)
            .trainingFile("file-abc123")
            .hyperparameters(
                JobCreateParams.Hyperparameters.builder()
                    .batchSizeAuto()
                    .learningRateMultiplierAuto()
                    .nEpochsAuto()
                    .build()
            )
            .addIntegration(
                JobCreateParams.Integration.builder()
                    .wandb(
                        JobCreateParams.Integration.Wandb.builder()
                            .project("my-wandb-project")
                            .entity("entity")
                            .name("name")
                            .addTag("custom-tag")
                            .build()
                    )
                    .build()
            )
            .metadata(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
            .method(
                JobCreateParams.Method.builder()
                    .dpo(
                        JobCreateParams.Method.Dpo.builder()
                            .hyperparameters(
                                JobCreateParams.Method.Dpo.Hyperparameters.builder()
                                    .batchSizeAuto()
                                    .betaAuto()
                                    .learningRateMultiplierAuto()
                                    .nEpochsAuto()
                                    .build()
                            )
                            .build()
                    )
                    .supervised(
                        JobCreateParams.Method.Supervised.builder()
                            .hyperparameters(
                                JobCreateParams.Method.Supervised.Hyperparameters.builder()
                                    .batchSizeAuto()
                                    .learningRateMultiplierAuto()
                                    .nEpochsAuto()
                                    .build()
                            )
                            .build()
                    )
                    .type(JobCreateParams.Method.Type.SUPERVISED)
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
            JobCreateParams.builder()
                .model(JobCreateParams.Model.BABBAGE_002)
                .trainingFile("file-abc123")
                .hyperparameters(
                    JobCreateParams.Hyperparameters.builder()
                        .batchSizeAuto()
                        .learningRateMultiplierAuto()
                        .nEpochsAuto()
                        .build()
                )
                .addIntegration(
                    JobCreateParams.Integration.builder()
                        .wandb(
                            JobCreateParams.Integration.Wandb.builder()
                                .project("my-wandb-project")
                                .entity("entity")
                                .name("name")
                                .addTag("custom-tag")
                                .build()
                        )
                        .build()
                )
                .metadata(
                    Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .method(
                    JobCreateParams.Method.builder()
                        .dpo(
                            JobCreateParams.Method.Dpo.builder()
                                .hyperparameters(
                                    JobCreateParams.Method.Dpo.Hyperparameters.builder()
                                        .batchSizeAuto()
                                        .betaAuto()
                                        .learningRateMultiplierAuto()
                                        .nEpochsAuto()
                                        .build()
                                )
                                .build()
                        )
                        .supervised(
                            JobCreateParams.Method.Supervised.builder()
                                .hyperparameters(
                                    JobCreateParams.Method.Supervised.Hyperparameters.builder()
                                        .batchSizeAuto()
                                        .learningRateMultiplierAuto()
                                        .nEpochsAuto()
                                        .build()
                                )
                                .build()
                        )
                        .type(JobCreateParams.Method.Type.SUPERVISED)
                        .build()
                )
                .seed(42L)
                .suffix("x")
                .validationFile("file-abc123")
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.model()).isEqualTo(JobCreateParams.Model.BABBAGE_002)
        assertThat(body.trainingFile()).isEqualTo("file-abc123")
        assertThat(body.hyperparameters())
            .contains(
                JobCreateParams.Hyperparameters.builder()
                    .batchSizeAuto()
                    .learningRateMultiplierAuto()
                    .nEpochsAuto()
                    .build()
            )
        assertThat(body.integrations())
            .contains(
                listOf(
                    JobCreateParams.Integration.builder()
                        .wandb(
                            JobCreateParams.Integration.Wandb.builder()
                                .project("my-wandb-project")
                                .entity("entity")
                                .name("name")
                                .addTag("custom-tag")
                                .build()
                        )
                        .build()
                )
            )
        assertThat(body.metadata())
            .contains(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
        assertThat(body.method())
            .contains(
                JobCreateParams.Method.builder()
                    .dpo(
                        JobCreateParams.Method.Dpo.builder()
                            .hyperparameters(
                                JobCreateParams.Method.Dpo.Hyperparameters.builder()
                                    .batchSizeAuto()
                                    .betaAuto()
                                    .learningRateMultiplierAuto()
                                    .nEpochsAuto()
                                    .build()
                            )
                            .build()
                    )
                    .supervised(
                        JobCreateParams.Method.Supervised.builder()
                            .hyperparameters(
                                JobCreateParams.Method.Supervised.Hyperparameters.builder()
                                    .batchSizeAuto()
                                    .learningRateMultiplierAuto()
                                    .nEpochsAuto()
                                    .build()
                            )
                            .build()
                    )
                    .type(JobCreateParams.Method.Type.SUPERVISED)
                    .build()
            )
        assertThat(body.seed()).contains(42L)
        assertThat(body.suffix()).contains("x")
        assertThat(body.validationFile()).contains("file-abc123")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            JobCreateParams.builder()
                .model(JobCreateParams.Model.BABBAGE_002)
                .trainingFile("file-abc123")
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.model()).isEqualTo(JobCreateParams.Model.BABBAGE_002)
        assertThat(body.trainingFile()).isEqualTo("file-abc123")
    }
}
