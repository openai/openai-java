// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.finetuning

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.finetuning.jobs.JobCancelParams
import com.openai.models.finetuning.jobs.JobCreateParams
import com.openai.models.finetuning.jobs.JobListEventsParams
import com.openai.models.finetuning.jobs.JobPauseParams
import com.openai.models.finetuning.jobs.JobResumeParams
import com.openai.models.finetuning.jobs.JobRetrieveParams
import com.openai.models.finetuning.methods.DpoHyperparameters
import com.openai.models.finetuning.methods.DpoMethod
import com.openai.models.finetuning.methods.ReinforcementHyperparameters
import com.openai.models.finetuning.methods.ReinforcementMethod
import com.openai.models.finetuning.methods.SupervisedHyperparameters
import com.openai.models.finetuning.methods.SupervisedMethod
import com.openai.models.graders.gradermodels.StringCheckGrader
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class JobServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val jobService = client.fineTuning().jobs()

        val fineTuningJob =
            jobService.create(
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
            )

        fineTuningJob.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val jobService = client.fineTuning().jobs()

        val fineTuningJob =
            jobService.retrieve(
                JobRetrieveParams.builder().fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F").build()
            )

        fineTuningJob.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val jobService = client.fineTuning().jobs()

        val page = jobService.list()

        page.response().validate()
    }

    @Test
    fun cancel() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val jobService = client.fineTuning().jobs()

        val fineTuningJob =
            jobService.cancel(
                JobCancelParams.builder().fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F").build()
            )

        fineTuningJob.validate()
    }

    @Test
    fun listEvents() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val jobService = client.fineTuning().jobs()

        val page =
            jobService.listEvents(
                JobListEventsParams.builder().fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F").build()
            )

        page.response().validate()
    }

    @Test
    fun pause() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val jobService = client.fineTuning().jobs()

        val fineTuningJob =
            jobService.pause(
                JobPauseParams.builder().fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F").build()
            )

        fineTuningJob.validate()
    }

    @Test
    fun resume() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val jobService = client.fineTuning().jobs()

        val fineTuningJob =
            jobService.resume(
                JobResumeParams.builder().fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F").build()
            )

        fineTuningJob.validate()
    }
}
