// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs

import com.openai.core.JsonValue
import com.openai.models.finetuning.methods.DpoHyperparameters
import com.openai.models.finetuning.methods.DpoMethod
import com.openai.models.finetuning.methods.ReinforcementHyperparameters
import com.openai.models.finetuning.methods.ReinforcementMethod
import com.openai.models.finetuning.methods.SupervisedHyperparameters
import com.openai.models.finetuning.methods.SupervisedMethod
import com.openai.models.graders.gradermodels.StringCheckGrader
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JobCreateParamsTest {

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
                JobCreateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .method(
                JobCreateParams.Method.builder()
                    .type(JobCreateParams.Method.Type.SUPERVISED)
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
                    JobCreateParams.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .method(
                    JobCreateParams.Method.builder()
                        .type(JobCreateParams.Method.Type.SUPERVISED)
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
                .seed(42L)
                .suffix("x")
                .validationFile("file-abc123")
                .build()

        val body = params._body()

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
        assertThat(body.integrations().getOrNull())
            .containsExactly(
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
        assertThat(body.metadata())
            .contains(
                JobCreateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.method())
            .contains(
                JobCreateParams.Method.builder()
                    .type(JobCreateParams.Method.Type.SUPERVISED)
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

        assertThat(body.model()).isEqualTo(JobCreateParams.Model.BABBAGE_002)
        assertThat(body.trainingFile()).isEqualTo("file-abc123")
    }
}
