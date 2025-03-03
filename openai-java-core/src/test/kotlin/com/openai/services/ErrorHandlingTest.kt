// File generated from our OpenAPI spec by Stainless.

package com.openai.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.client.OpenAIClient
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.core.http.Headers
import com.openai.core.jsonMapper
import com.openai.errors.BadRequestException
import com.openai.errors.InternalServerException
import com.openai.errors.NotFoundException
import com.openai.errors.OpenAIError
import com.openai.errors.OpenAIException
import com.openai.errors.PermissionDeniedException
import com.openai.errors.RateLimitException
import com.openai.errors.UnauthorizedException
import com.openai.errors.UnexpectedStatusCodeException
import com.openai.errors.UnprocessableEntityException
import com.openai.models.FineTuningJobCreateParams
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@WireMockTest
class ErrorHandlingTest {

    companion object {

        private val ERROR: OpenAIError =
            OpenAIError.builder()
                .putAdditionalProperty("errorProperty", JsonValue.from("42"))
                .build()

        private val ERROR_JSON: ByteArray = jsonMapper().writeValueAsBytes(ERROR)

        private const val HEADER_NAME: String = "Error-Header"

        private const val HEADER_VALUE: String = "42"

        private const val NOT_JSON: String = "Not JSON"
    }

    private lateinit var client: OpenAIClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            OpenAIOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
    }

    @Test
    fun jobsCreate400() {
        val jobService = client.fineTuning().jobs()
        stubFor(
            post(anyUrl())
                .willReturn(status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<BadRequestException> {
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
                                            FineTuningJobCreateParams.Method.Supervised
                                                .Hyperparameters
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
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun jobsCreate401() {
        val jobService = client.fineTuning().jobs()
        stubFor(
            post(anyUrl())
                .willReturn(status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<UnauthorizedException> {
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
                                            FineTuningJobCreateParams.Method.Supervised
                                                .Hyperparameters
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
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun jobsCreate403() {
        val jobService = client.fineTuning().jobs()
        stubFor(
            post(anyUrl())
                .willReturn(status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<PermissionDeniedException> {
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
                                            FineTuningJobCreateParams.Method.Supervised
                                                .Hyperparameters
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
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun jobsCreate404() {
        val jobService = client.fineTuning().jobs()
        stubFor(
            post(anyUrl())
                .willReturn(status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<NotFoundException> {
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
                                            FineTuningJobCreateParams.Method.Supervised
                                                .Hyperparameters
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
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun jobsCreate422() {
        val jobService = client.fineTuning().jobs()
        stubFor(
            post(anyUrl())
                .willReturn(status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<UnprocessableEntityException> {
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
                                            FineTuningJobCreateParams.Method.Supervised
                                                .Hyperparameters
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
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun jobsCreate429() {
        val jobService = client.fineTuning().jobs()
        stubFor(
            post(anyUrl())
                .willReturn(status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<RateLimitException> {
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
                                            FineTuningJobCreateParams.Method.Supervised
                                                .Hyperparameters
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
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun jobsCreate500() {
        val jobService = client.fineTuning().jobs()
        stubFor(
            post(anyUrl())
                .willReturn(status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<InternalServerException> {
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
                                            FineTuningJobCreateParams.Method.Supervised
                                                .Hyperparameters
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
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun jobsCreate999() {
        val jobService = client.fineTuning().jobs()
        stubFor(
            post(anyUrl())
                .willReturn(status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
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
                                            FineTuningJobCreateParams.Method.Supervised
                                                .Hyperparameters
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
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun jobsCreateInvalidJsonBody() {
        val jobService = client.fineTuning().jobs()
        stubFor(
            post(anyUrl())
                .willReturn(status(200).withHeader(HEADER_NAME, HEADER_VALUE).withBody(NOT_JSON))
        )

        val e =
            assertThrows<OpenAIException> {
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
                                            FineTuningJobCreateParams.Method.Supervised
                                                .Hyperparameters
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
            }

        assertThat(e).hasMessage("Error reading response")
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
