// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.fineTuning

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.FineTuningJobCancelParams
import com.openai.models.FineTuningJobCreateParams
import com.openai.models.FineTuningJobListEventsParams
import com.openai.models.FineTuningJobRetrieveParams
import com.openai.models.Metadata
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class JobServiceTest {

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
                    .metadata(
                        Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .method(
                        FineTuningJobCreateParams.Method.builder()
                            .dpo(
                                FineTuningJobCreateParams.Method.Dpo.builder()
                                    .hyperparameters(
                                        FineTuningJobCreateParams.Method.Dpo.Hyperparameters
                                            .builder()
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
                FineTuningJobRetrieveParams.builder()
                    .fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
                    .build()
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
                FineTuningJobCancelParams.builder()
                    .fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
                    .build()
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
                FineTuningJobListEventsParams.builder()
                    .fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
                    .build()
            )

        page.response().validate()
    }
}
