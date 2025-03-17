// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.finetuning

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.Metadata
import com.openai.models.finetuning.jobs.JobCancelParams
import com.openai.models.finetuning.jobs.JobCreateParams
import com.openai.models.finetuning.jobs.JobListEventsParams
import com.openai.models.finetuning.jobs.JobRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class JobServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val jobServiceAsync = client.fineTuning().jobs()

        val fineTuningJobFuture =
            jobServiceAsync.create(
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
            )

        val fineTuningJob = fineTuningJobFuture.get()
        fineTuningJob.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val jobServiceAsync = client.fineTuning().jobs()

        val fineTuningJobFuture =
            jobServiceAsync.retrieve(
                JobRetrieveParams.builder().fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F").build()
            )

        val fineTuningJob = fineTuningJobFuture.get()
        fineTuningJob.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val jobServiceAsync = client.fineTuning().jobs()

        val pageFuture = jobServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun cancel() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val jobServiceAsync = client.fineTuning().jobs()

        val fineTuningJobFuture =
            jobServiceAsync.cancel(
                JobCancelParams.builder().fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F").build()
            )

        val fineTuningJob = fineTuningJobFuture.get()
        fineTuningJob.validate()
    }

    @Test
    fun listEvents() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val jobServiceAsync = client.fineTuning().jobs()

        val pageFuture =
            jobServiceAsync.listEvents(
                JobListEventsParams.builder().fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F").build()
            )

        val page = pageFuture.get()
        page.response().validate()
    }
}
