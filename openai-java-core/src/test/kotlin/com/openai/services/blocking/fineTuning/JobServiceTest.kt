// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.fineTuning

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.*
import com.openai.models.FineTuningJobListEventsParams
import com.openai.models.FineTuningJobListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class JobServiceTest {

    @Test
    fun callCreate() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val jobService = client.fineTuning().jobs()
        val fineTuningJob =
            jobService.create(
                FineTuningJobCreateParams.builder()
                    .model(FineTuningJobCreateParams.Model.BABBAGE_002)
                    .trainingFile("file-abc123")
                    .hyperparameters(
                        FineTuningJobCreateParams.Hyperparameters.builder()
                            .batchSize(
                                FineTuningJobCreateParams.Hyperparameters.BatchSize.ofBehavior(
                                    FineTuningJobCreateParams.Hyperparameters.BatchSize.Behavior
                                        .AUTO
                                )
                            )
                            .learningRateMultiplier(
                                FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
                                    .ofBehavior(
                                        FineTuningJobCreateParams.Hyperparameters
                                            .LearningRateMultiplier
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
            )
        println(fineTuningJob)
        fineTuningJob.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val jobService = client.fineTuning().jobs()
        val fineTuningJob =
            jobService.retrieve(
                FineTuningJobRetrieveParams.builder()
                    .fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
                    .build()
            )
        println(fineTuningJob)
        fineTuningJob.validate()
    }

    @Test
    fun callList() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val jobService = client.fineTuning().jobs()
        val listPaginatedFineTuningJobsResponse =
            jobService.list(FineTuningJobListParams.builder().build())
        println(listPaginatedFineTuningJobsResponse)
        listPaginatedFineTuningJobsResponse.data().forEach { it.validate() }
    }

    @Test
    fun callCancel() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val jobService = client.fineTuning().jobs()
        val fineTuningJob =
            jobService.cancel(
                FineTuningJobCancelParams.builder()
                    .fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
                    .build()
            )
        println(fineTuningJob)
        fineTuningJob.validate()
    }

    @Test
    fun callListEvents() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val jobService = client.fineTuning().jobs()
        val listFineTuningJobEventsResponse =
            jobService.listEvents(
                FineTuningJobListEventsParams.builder()
                    .fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
                    .build()
            )
        println(listFineTuningJobEventsResponse)
        listFineTuningJobEventsResponse.data().forEach { it.validate() }
    }
}
