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
import com.openai.errors.OpenAIException
import com.openai.errors.PermissionDeniedException
import com.openai.errors.RateLimitException
import com.openai.errors.UnauthorizedException
import com.openai.errors.UnexpectedStatusCodeException
import com.openai.errors.UnprocessableEntityException
import com.openai.models.finetuning.jobs.JobCreateParams
import com.openai.models.finetuning.methods.DpoHyperparameters
import com.openai.models.finetuning.methods.DpoMethod
import com.openai.models.finetuning.methods.ReinforcementHyperparameters
import com.openai.models.finetuning.methods.ReinforcementMethod
import com.openai.models.finetuning.methods.SupervisedHyperparameters
import com.openai.models.finetuning.methods.SupervisedMethod
import com.openai.models.graders.gradermodels.StringCheckGrader
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ErrorHandlingTest {

    companion object {

        private val ERROR_JSON: JsonValue =
            JsonValue.from(
                mapOf(
                    "error" to
                        mapOf(
                            "code" to "code",
                            "message" to "message",
                            "param" to "param",
                            "type" to "type",
                        )
                )
            )

        private val ERROR_JSON_BYTES: ByteArray = jsonMapper().writeValueAsBytes(ERROR_JSON)

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
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
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
                                                    ReinforcementHyperparameters.ReasoningEffort
                                                        .DEFAULT
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
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "code" to "code",
                        "message" to "message",
                        "param" to "param",
                        "type" to "type",
                    )
                )
            )
    }

    @Test
    fun jobsCreate400WithRawResponse() {
        val jobService = client.fineTuning().jobs().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
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
                                                    ReinforcementHyperparameters.ReasoningEffort
                                                        .DEFAULT
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
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "code" to "code",
                        "message" to "message",
                        "param" to "param",
                        "type" to "type",
                    )
                )
            )
    }

    @Test
    fun jobsCreate401() {
        val jobService = client.fineTuning().jobs()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
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
                                                    ReinforcementHyperparameters.ReasoningEffort
                                                        .DEFAULT
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
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "code" to "code",
                        "message" to "message",
                        "param" to "param",
                        "type" to "type",
                    )
                )
            )
    }

    @Test
    fun jobsCreate401WithRawResponse() {
        val jobService = client.fineTuning().jobs().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
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
                                                    ReinforcementHyperparameters.ReasoningEffort
                                                        .DEFAULT
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
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "code" to "code",
                        "message" to "message",
                        "param" to "param",
                        "type" to "type",
                    )
                )
            )
    }

    @Test
    fun jobsCreate403() {
        val jobService = client.fineTuning().jobs()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
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
                                                    ReinforcementHyperparameters.ReasoningEffort
                                                        .DEFAULT
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
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "code" to "code",
                        "message" to "message",
                        "param" to "param",
                        "type" to "type",
                    )
                )
            )
    }

    @Test
    fun jobsCreate403WithRawResponse() {
        val jobService = client.fineTuning().jobs().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
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
                                                    ReinforcementHyperparameters.ReasoningEffort
                                                        .DEFAULT
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
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "code" to "code",
                        "message" to "message",
                        "param" to "param",
                        "type" to "type",
                    )
                )
            )
    }

    @Test
    fun jobsCreate404() {
        val jobService = client.fineTuning().jobs()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
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
                                                    ReinforcementHyperparameters.ReasoningEffort
                                                        .DEFAULT
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
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "code" to "code",
                        "message" to "message",
                        "param" to "param",
                        "type" to "type",
                    )
                )
            )
    }

    @Test
    fun jobsCreate404WithRawResponse() {
        val jobService = client.fineTuning().jobs().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
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
                                                    ReinforcementHyperparameters.ReasoningEffort
                                                        .DEFAULT
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
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "code" to "code",
                        "message" to "message",
                        "param" to "param",
                        "type" to "type",
                    )
                )
            )
    }

    @Test
    fun jobsCreate422() {
        val jobService = client.fineTuning().jobs()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
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
                                                    ReinforcementHyperparameters.ReasoningEffort
                                                        .DEFAULT
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
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "code" to "code",
                        "message" to "message",
                        "param" to "param",
                        "type" to "type",
                    )
                )
            )
    }

    @Test
    fun jobsCreate422WithRawResponse() {
        val jobService = client.fineTuning().jobs().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
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
                                                    ReinforcementHyperparameters.ReasoningEffort
                                                        .DEFAULT
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
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "code" to "code",
                        "message" to "message",
                        "param" to "param",
                        "type" to "type",
                    )
                )
            )
    }

    @Test
    fun jobsCreate429() {
        val jobService = client.fineTuning().jobs()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
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
                                                    ReinforcementHyperparameters.ReasoningEffort
                                                        .DEFAULT
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
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "code" to "code",
                        "message" to "message",
                        "param" to "param",
                        "type" to "type",
                    )
                )
            )
    }

    @Test
    fun jobsCreate429WithRawResponse() {
        val jobService = client.fineTuning().jobs().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
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
                                                    ReinforcementHyperparameters.ReasoningEffort
                                                        .DEFAULT
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
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "code" to "code",
                        "message" to "message",
                        "param" to "param",
                        "type" to "type",
                    )
                )
            )
    }

    @Test
    fun jobsCreate500() {
        val jobService = client.fineTuning().jobs()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
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
                                                    ReinforcementHyperparameters.ReasoningEffort
                                                        .DEFAULT
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
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "code" to "code",
                        "message" to "message",
                        "param" to "param",
                        "type" to "type",
                    )
                )
            )
    }

    @Test
    fun jobsCreate500WithRawResponse() {
        val jobService = client.fineTuning().jobs().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
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
                                                    ReinforcementHyperparameters.ReasoningEffort
                                                        .DEFAULT
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
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "code" to "code",
                        "message" to "message",
                        "param" to "param",
                        "type" to "type",
                    )
                )
            )
    }

    @Test
    fun jobsCreate999() {
        val jobService = client.fineTuning().jobs()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
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
                                                    ReinforcementHyperparameters.ReasoningEffort
                                                        .DEFAULT
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
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "code" to "code",
                        "message" to "message",
                        "param" to "param",
                        "type" to "type",
                    )
                )
            )
    }

    @Test
    fun jobsCreate999WithRawResponse() {
        val jobService = client.fineTuning().jobs().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
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
                                                    ReinforcementHyperparameters.ReasoningEffort
                                                        .DEFAULT
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
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "code" to "code",
                        "message" to "message",
                        "param" to "param",
                        "type" to "type",
                    )
                )
            )
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
                                                    ReinforcementHyperparameters.ReasoningEffort
                                                        .DEFAULT
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
            }

        assertThat(e).hasMessage("Error reading response")
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
