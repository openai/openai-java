// File generated from our OpenAPI spec by Stainless.

package com.openai.services

import com.fasterxml.jackson.databind.json.JsonMapper
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.ok
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
import com.openai.models.*
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.InstanceOfAssertFactories
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@WireMockTest
class ErrorHandlingTest {

    private val JSON_MAPPER: JsonMapper = jsonMapper()

    private val OPENAI_ERROR: OpenAIError =
        OpenAIError.builder().putAdditionalProperty("key", JsonValue.from("value")).build()

    private lateinit var client: OpenAIClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            OpenAIOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.getHttpBaseUrl())
                .apiKey("My API Key")
                .organization("My Organization")
                .project("My Project")
                .build()
    }

    @Test
    fun jobsCreate200() {
        val params =
            FineTuningJobCreateParams.builder()
                .model(FineTuningJobCreateParams.Model.BABBAGE_002)
                .trainingFile("file-abc123")
                .hyperparameters(
                    FineTuningJobCreateParams.Hyperparameters.builder()
                        .batchSize(
                            FineTuningJobCreateParams.Hyperparameters.BatchSize.ofBehavior(
                                FineTuningJobCreateParams.Hyperparameters.BatchSize.Behavior.AUTO
                            )
                        )
                        .learningRateMultiplier(
                            FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
                                .ofBehavior(
                                    FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
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

        val expected =
            FineTuningJob.builder()
                .id("id")
                .createdAt(0L)
                .error(
                    FineTuningJob.Error.builder()
                        .code("code")
                        .message("message")
                        .param("param")
                        .build()
                )
                .fineTunedModel("fine_tuned_model")
                .finishedAt(0L)
                .hyperparameters(
                    FineTuningJob.Hyperparameters.builder()
                        .nEpochs(
                            FineTuningJob.Hyperparameters.NEpochs.ofBehavior(
                                FineTuningJob.Hyperparameters.NEpochs.Behavior.AUTO
                            )
                        )
                        .build()
                )
                .model("model")
                .object_(FineTuningJob.Object.FINE_TUNING_JOB)
                .organizationId("organization_id")
                .resultFiles(listOf("file-abc123"))
                .seed(0L)
                .status(FineTuningJob.Status.VALIDATING_FILES)
                .trainedTokens(0L)
                .trainingFile("training_file")
                .validationFile("validation_file")
                .estimatedFinish(0L)
                .integrations(
                    listOf(
                        FineTuningJobWandbIntegrationObject.builder()
                            .type(FineTuningJobWandbIntegrationObject.Type.WANDB)
                            .wandb(
                                FineTuningJobWandbIntegration.builder()
                                    .project("my-wandb-project")
                                    .entity("entity")
                                    .name("name")
                                    .tags(listOf("custom-tag"))
                                    .build()
                            )
                            .build()
                    )
                )
                .build()

        stubFor(post(anyUrl()).willReturn(ok().withBody(toJson(expected))))

        assertThat(client.fineTuning().jobs().create(params)).isEqualTo(expected)
    }

    @Test
    fun jobsCreate400() {
        val params =
            FineTuningJobCreateParams.builder()
                .model(FineTuningJobCreateParams.Model.BABBAGE_002)
                .trainingFile("file-abc123")
                .hyperparameters(
                    FineTuningJobCreateParams.Hyperparameters.builder()
                        .batchSize(
                            FineTuningJobCreateParams.Hyperparameters.BatchSize.ofBehavior(
                                FineTuningJobCreateParams.Hyperparameters.BatchSize.Behavior.AUTO
                            )
                        )
                        .learningRateMultiplier(
                            FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
                                .ofBehavior(
                                    FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
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

        stubFor(
            post(anyUrl())
                .willReturn(status(400).withHeader("Foo", "Bar").withBody(toJson(OPENAI_ERROR)))
        )

        assertThatThrownBy({ client.fineTuning().jobs().create(params) })
            .satisfies({ e ->
                assertBadRequest(e, Headers.builder().put("Foo", "Bar").build(), OPENAI_ERROR)
            })
    }

    @Test
    fun jobsCreate401() {
        val params =
            FineTuningJobCreateParams.builder()
                .model(FineTuningJobCreateParams.Model.BABBAGE_002)
                .trainingFile("file-abc123")
                .hyperparameters(
                    FineTuningJobCreateParams.Hyperparameters.builder()
                        .batchSize(
                            FineTuningJobCreateParams.Hyperparameters.BatchSize.ofBehavior(
                                FineTuningJobCreateParams.Hyperparameters.BatchSize.Behavior.AUTO
                            )
                        )
                        .learningRateMultiplier(
                            FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
                                .ofBehavior(
                                    FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
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

        stubFor(
            post(anyUrl())
                .willReturn(status(401).withHeader("Foo", "Bar").withBody(toJson(OPENAI_ERROR)))
        )

        assertThatThrownBy({ client.fineTuning().jobs().create(params) })
            .satisfies({ e ->
                assertUnauthorized(e, Headers.builder().put("Foo", "Bar").build(), OPENAI_ERROR)
            })
    }

    @Test
    fun jobsCreate403() {
        val params =
            FineTuningJobCreateParams.builder()
                .model(FineTuningJobCreateParams.Model.BABBAGE_002)
                .trainingFile("file-abc123")
                .hyperparameters(
                    FineTuningJobCreateParams.Hyperparameters.builder()
                        .batchSize(
                            FineTuningJobCreateParams.Hyperparameters.BatchSize.ofBehavior(
                                FineTuningJobCreateParams.Hyperparameters.BatchSize.Behavior.AUTO
                            )
                        )
                        .learningRateMultiplier(
                            FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
                                .ofBehavior(
                                    FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
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

        stubFor(
            post(anyUrl())
                .willReturn(status(403).withHeader("Foo", "Bar").withBody(toJson(OPENAI_ERROR)))
        )

        assertThatThrownBy({ client.fineTuning().jobs().create(params) })
            .satisfies({ e ->
                assertPermissionDenied(e, Headers.builder().put("Foo", "Bar").build(), OPENAI_ERROR)
            })
    }

    @Test
    fun jobsCreate404() {
        val params =
            FineTuningJobCreateParams.builder()
                .model(FineTuningJobCreateParams.Model.BABBAGE_002)
                .trainingFile("file-abc123")
                .hyperparameters(
                    FineTuningJobCreateParams.Hyperparameters.builder()
                        .batchSize(
                            FineTuningJobCreateParams.Hyperparameters.BatchSize.ofBehavior(
                                FineTuningJobCreateParams.Hyperparameters.BatchSize.Behavior.AUTO
                            )
                        )
                        .learningRateMultiplier(
                            FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
                                .ofBehavior(
                                    FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
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

        stubFor(
            post(anyUrl())
                .willReturn(status(404).withHeader("Foo", "Bar").withBody(toJson(OPENAI_ERROR)))
        )

        assertThatThrownBy({ client.fineTuning().jobs().create(params) })
            .satisfies({ e ->
                assertNotFound(e, Headers.builder().put("Foo", "Bar").build(), OPENAI_ERROR)
            })
    }

    @Test
    fun jobsCreate422() {
        val params =
            FineTuningJobCreateParams.builder()
                .model(FineTuningJobCreateParams.Model.BABBAGE_002)
                .trainingFile("file-abc123")
                .hyperparameters(
                    FineTuningJobCreateParams.Hyperparameters.builder()
                        .batchSize(
                            FineTuningJobCreateParams.Hyperparameters.BatchSize.ofBehavior(
                                FineTuningJobCreateParams.Hyperparameters.BatchSize.Behavior.AUTO
                            )
                        )
                        .learningRateMultiplier(
                            FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
                                .ofBehavior(
                                    FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
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

        stubFor(
            post(anyUrl())
                .willReturn(status(422).withHeader("Foo", "Bar").withBody(toJson(OPENAI_ERROR)))
        )

        assertThatThrownBy({ client.fineTuning().jobs().create(params) })
            .satisfies({ e ->
                assertUnprocessableEntity(
                    e,
                    Headers.builder().put("Foo", "Bar").build(),
                    OPENAI_ERROR
                )
            })
    }

    @Test
    fun jobsCreate429() {
        val params =
            FineTuningJobCreateParams.builder()
                .model(FineTuningJobCreateParams.Model.BABBAGE_002)
                .trainingFile("file-abc123")
                .hyperparameters(
                    FineTuningJobCreateParams.Hyperparameters.builder()
                        .batchSize(
                            FineTuningJobCreateParams.Hyperparameters.BatchSize.ofBehavior(
                                FineTuningJobCreateParams.Hyperparameters.BatchSize.Behavior.AUTO
                            )
                        )
                        .learningRateMultiplier(
                            FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
                                .ofBehavior(
                                    FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
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

        stubFor(
            post(anyUrl())
                .willReturn(status(429).withHeader("Foo", "Bar").withBody(toJson(OPENAI_ERROR)))
        )

        assertThatThrownBy({ client.fineTuning().jobs().create(params) })
            .satisfies({ e ->
                assertRateLimit(e, Headers.builder().put("Foo", "Bar").build(), OPENAI_ERROR)
            })
    }

    @Test
    fun jobsCreate500() {
        val params =
            FineTuningJobCreateParams.builder()
                .model(FineTuningJobCreateParams.Model.BABBAGE_002)
                .trainingFile("file-abc123")
                .hyperparameters(
                    FineTuningJobCreateParams.Hyperparameters.builder()
                        .batchSize(
                            FineTuningJobCreateParams.Hyperparameters.BatchSize.ofBehavior(
                                FineTuningJobCreateParams.Hyperparameters.BatchSize.Behavior.AUTO
                            )
                        )
                        .learningRateMultiplier(
                            FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
                                .ofBehavior(
                                    FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
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

        stubFor(
            post(anyUrl())
                .willReturn(status(500).withHeader("Foo", "Bar").withBody(toJson(OPENAI_ERROR)))
        )

        assertThatThrownBy({ client.fineTuning().jobs().create(params) })
            .satisfies({ e ->
                assertInternalServer(e, Headers.builder().put("Foo", "Bar").build(), OPENAI_ERROR)
            })
    }

    @Test
    fun unexpectedStatusCode() {
        val params =
            FineTuningJobCreateParams.builder()
                .model(FineTuningJobCreateParams.Model.BABBAGE_002)
                .trainingFile("file-abc123")
                .hyperparameters(
                    FineTuningJobCreateParams.Hyperparameters.builder()
                        .batchSize(
                            FineTuningJobCreateParams.Hyperparameters.BatchSize.ofBehavior(
                                FineTuningJobCreateParams.Hyperparameters.BatchSize.Behavior.AUTO
                            )
                        )
                        .learningRateMultiplier(
                            FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
                                .ofBehavior(
                                    FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
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

        stubFor(
            post(anyUrl())
                .willReturn(status(999).withHeader("Foo", "Bar").withBody(toJson(OPENAI_ERROR)))
        )

        assertThatThrownBy({ client.fineTuning().jobs().create(params) })
            .satisfies({ e ->
                assertUnexpectedStatusCodeException(
                    e,
                    999,
                    Headers.builder().put("Foo", "Bar").build(),
                    toJson(OPENAI_ERROR)
                )
            })
    }

    @Test
    fun invalidBody() {
        val params =
            FineTuningJobCreateParams.builder()
                .model(FineTuningJobCreateParams.Model.BABBAGE_002)
                .trainingFile("file-abc123")
                .hyperparameters(
                    FineTuningJobCreateParams.Hyperparameters.builder()
                        .batchSize(
                            FineTuningJobCreateParams.Hyperparameters.BatchSize.ofBehavior(
                                FineTuningJobCreateParams.Hyperparameters.BatchSize.Behavior.AUTO
                            )
                        )
                        .learningRateMultiplier(
                            FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
                                .ofBehavior(
                                    FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
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

        stubFor(post(anyUrl()).willReturn(status(200).withBody("Not JSON")))

        assertThatThrownBy({ client.fineTuning().jobs().create(params) })
            .satisfies({ e ->
                assertThat(e)
                    .isInstanceOf(OpenAIException::class.java)
                    .hasMessage("Error reading response")
            })
    }

    @Test
    fun invalidErrorBody() {
        val params =
            FineTuningJobCreateParams.builder()
                .model(FineTuningJobCreateParams.Model.BABBAGE_002)
                .trainingFile("file-abc123")
                .hyperparameters(
                    FineTuningJobCreateParams.Hyperparameters.builder()
                        .batchSize(
                            FineTuningJobCreateParams.Hyperparameters.BatchSize.ofBehavior(
                                FineTuningJobCreateParams.Hyperparameters.BatchSize.Behavior.AUTO
                            )
                        )
                        .learningRateMultiplier(
                            FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
                                .ofBehavior(
                                    FineTuningJobCreateParams.Hyperparameters.LearningRateMultiplier
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

        stubFor(post(anyUrl()).willReturn(status(400).withBody("Not JSON")))

        assertThatThrownBy({ client.fineTuning().jobs().create(params) })
            .satisfies({ e ->
                assertBadRequest(e, Headers.builder().build(), OpenAIError.builder().build())
            })
    }

    private fun <T> toJson(body: T): ByteArray {
        return JSON_MAPPER.writeValueAsBytes(body)
    }

    private fun assertUnexpectedStatusCodeException(
        throwable: Throwable,
        statusCode: Int,
        headers: Headers,
        responseBody: ByteArray
    ) {
        assertThat(throwable)
            .asInstanceOf(
                InstanceOfAssertFactories.throwable(UnexpectedStatusCodeException::class.java)
            )
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(statusCode)
                assertThat(e.body()).isEqualTo(String(responseBody))
                assertThat(e.headers().toMap()).containsAllEntriesOf(headers.toMap())
            })
    }

    private fun assertBadRequest(throwable: Throwable, headers: Headers, error: OpenAIError) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(BadRequestException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(400)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers().toMap()).containsAllEntriesOf(headers.toMap())
            })
    }

    private fun assertUnauthorized(throwable: Throwable, headers: Headers, error: OpenAIError) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(UnauthorizedException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(401)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers().toMap()).containsAllEntriesOf(headers.toMap())
            })
    }

    private fun assertPermissionDenied(throwable: Throwable, headers: Headers, error: OpenAIError) {
        assertThat(throwable)
            .asInstanceOf(
                InstanceOfAssertFactories.throwable(PermissionDeniedException::class.java)
            )
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(403)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers().toMap()).containsAllEntriesOf(headers.toMap())
            })
    }

    private fun assertNotFound(throwable: Throwable, headers: Headers, error: OpenAIError) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(NotFoundException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(404)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers().toMap()).containsAllEntriesOf(headers.toMap())
            })
    }

    private fun assertUnprocessableEntity(
        throwable: Throwable,
        headers: Headers,
        error: OpenAIError
    ) {
        assertThat(throwable)
            .asInstanceOf(
                InstanceOfAssertFactories.throwable(UnprocessableEntityException::class.java)
            )
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(422)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers().toMap()).containsAllEntriesOf(headers.toMap())
            })
    }

    private fun assertRateLimit(throwable: Throwable, headers: Headers, error: OpenAIError) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(RateLimitException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(429)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers().toMap()).containsAllEntriesOf(headers.toMap())
            })
    }

    private fun assertInternalServer(throwable: Throwable, headers: Headers, error: OpenAIError) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(InternalServerException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(500)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers().toMap()).containsAllEntriesOf(headers.toMap())
            })
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
