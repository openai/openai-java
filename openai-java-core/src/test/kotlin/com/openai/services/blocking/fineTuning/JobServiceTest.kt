// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.fineTuning

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.FineTuningJobCancelParams
import com.openai.models.FineTuningJobCreateParams
import com.openai.models.FineTuningJobListEventsParams
import com.openai.models.FineTuningJobListParams
import com.openai.models.FineTuningJobRetrieveParams
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
                    .method(
                        FineTuningJobCreateParams.Method.builder()
                            .dpo(
                                FineTuningJobCreateParams.Method.Dpo.builder()
                                    .hyperparameters(
                                        FineTuningJobCreateParams.Method.Dpo.Hyperparameters
                                            .builder()
                                            .batchSize(
                                                FineTuningJobCreateParams.Method.Dpo.Hyperparameters
                                                    .BatchSize
                                                    .ofAuto(
                                                        FineTuningJobCreateParams.Method.Dpo
                                                            .Hyperparameters
                                                            .BatchSize
                                                            .Auto
                                                            .AUTO
                                                    )
                                            )
                                            .beta(
                                                FineTuningJobCreateParams.Method.Dpo.Hyperparameters
                                                    .Beta
                                                    .ofAuto(
                                                        FineTuningJobCreateParams.Method.Dpo
                                                            .Hyperparameters
                                                            .Beta
                                                            .Auto
                                                            .AUTO
                                                    )
                                            )
                                            .learningRateMultiplier(
                                                FineTuningJobCreateParams.Method.Dpo.Hyperparameters
                                                    .LearningRateMultiplier
                                                    .ofAuto(
                                                        FineTuningJobCreateParams.Method.Dpo
                                                            .Hyperparameters
                                                            .LearningRateMultiplier
                                                            .Auto
                                                            .AUTO
                                                    )
                                            )
                                            .nEpochs(
                                                FineTuningJobCreateParams.Method.Dpo.Hyperparameters
                                                    .NEpochs
                                                    .ofAuto(
                                                        FineTuningJobCreateParams.Method.Dpo
                                                            .Hyperparameters
                                                            .NEpochs
                                                            .Auto
                                                            .AUTO
                                                    )
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .supervised(
                                FineTuningJobCreateParams.Method.Supervised.builder()
                                    .hyperparameters(
                                        FineTuningJobCreateParams.Method.Supervised.Hyperparameters
                                            .builder()
                                            .batchSize(
                                                FineTuningJobCreateParams.Method.Supervised
                                                    .Hyperparameters
                                                    .BatchSize
                                                    .ofAuto(
                                                        FineTuningJobCreateParams.Method.Supervised
                                                            .Hyperparameters
                                                            .BatchSize
                                                            .Auto
                                                            .AUTO
                                                    )
                                            )
                                            .learningRateMultiplier(
                                                FineTuningJobCreateParams.Method.Supervised
                                                    .Hyperparameters
                                                    .LearningRateMultiplier
                                                    .ofAuto(
                                                        FineTuningJobCreateParams.Method.Supervised
                                                            .Hyperparameters
                                                            .LearningRateMultiplier
                                                            .Auto
                                                            .AUTO
                                                    )
                                            )
                                            .nEpochs(
                                                FineTuningJobCreateParams.Method.Supervised
                                                    .Hyperparameters
                                                    .NEpochs
                                                    .ofAuto(
                                                        FineTuningJobCreateParams.Method.Supervised
                                                            .Hyperparameters
                                                            .NEpochs
                                                            .Auto
                                                            .AUTO
                                                    )
                                            )
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
