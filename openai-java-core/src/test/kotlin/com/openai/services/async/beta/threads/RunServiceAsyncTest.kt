// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.threads

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.findAll
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.reset
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.ChatModel
import com.openai.models.ReasoningEffort
import com.openai.models.beta.assistants.CodeInterpreterTool
import com.openai.models.beta.threads.AssistantToolChoiceOption
import com.openai.models.beta.threads.runs.RunCancelParams
import com.openai.models.beta.threads.runs.RunCreateParams
import com.openai.models.beta.threads.runs.RunRetrieveParams
import com.openai.models.beta.threads.runs.RunSubmitToolOutputsParams
import com.openai.models.beta.threads.runs.RunUpdateParams
import com.openai.models.beta.threads.runs.steps.RunStepInclude
import java.util.concurrent.atomic.AtomicInteger
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.parallel.ResourceLock

@ExtendWith(TestServerExtension::class)
@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class RunServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val runServiceAsync = client.beta().threads().runs()

        val runFuture =
            runServiceAsync.create(
                RunCreateParams.builder()
                    .threadId("thread_id")
                    .addInclude(RunStepInclude.STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT)
                    .assistantId("assistant_id")
                    .additionalInstructions("additional_instructions")
                    .addAdditionalMessage(
                        RunCreateParams.AdditionalMessage.builder()
                            .content("string")
                            .role(RunCreateParams.AdditionalMessage.Role.USER)
                            .addAttachment(
                                RunCreateParams.AdditionalMessage.Attachment.builder()
                                    .fileId("file_id")
                                    .addTool(CodeInterpreterTool.builder().build())
                                    .build()
                            )
                            .metadata(
                                RunCreateParams.AdditionalMessage.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .build()
                    )
                    .instructions("instructions")
                    .maxCompletionTokens(256L)
                    .maxPromptTokens(256L)
                    .metadata(
                        RunCreateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .model(ChatModel.GPT_6_ASTRA)
                    .parallelToolCalls(true)
                    .reasoningEffort(ReasoningEffort.NONE)
                    .responseFormatAuto()
                    .temperature(1.0)
                    .toolChoice(AssistantToolChoiceOption.Auto.NONE)
                    .addTool(CodeInterpreterTool.builder().build())
                    .topP(1.0)
                    .truncationStrategy(
                        RunCreateParams.TruncationStrategy.builder()
                            .type(RunCreateParams.TruncationStrategy.Type.AUTO)
                            .lastMessages(1L)
                            .build()
                    )
                    .build()
            )

        val run = runFuture.get()
        run.validate()
    }

    @Disabled("Prism does not support SSE streaming mock responses")
    @Test
    fun createStreaming() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val runServiceAsync = client.beta().threads().runs()

        val runStreamResponse =
            runServiceAsync.createStreaming(
                RunCreateParams.builder()
                    .threadId("thread_id")
                    .addInclude(RunStepInclude.STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT)
                    .assistantId("assistant_id")
                    .additionalInstructions("additional_instructions")
                    .addAdditionalMessage(
                        RunCreateParams.AdditionalMessage.builder()
                            .content("string")
                            .role(RunCreateParams.AdditionalMessage.Role.USER)
                            .addAttachment(
                                RunCreateParams.AdditionalMessage.Attachment.builder()
                                    .fileId("file_id")
                                    .addTool(CodeInterpreterTool.builder().build())
                                    .build()
                            )
                            .metadata(
                                RunCreateParams.AdditionalMessage.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .build()
                    )
                    .instructions("instructions")
                    .maxCompletionTokens(256L)
                    .maxPromptTokens(256L)
                    .metadata(
                        RunCreateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .model(ChatModel.GPT_6_ASTRA)
                    .parallelToolCalls(true)
                    .reasoningEffort(ReasoningEffort.NONE)
                    .responseFormatAuto()
                    .temperature(1.0)
                    .toolChoice(AssistantToolChoiceOption.Auto.NONE)
                    .addTool(CodeInterpreterTool.builder().build())
                    .topP(1.0)
                    .truncationStrategy(
                        RunCreateParams.TruncationStrategy.builder()
                            .type(RunCreateParams.TruncationStrategy.Type.AUTO)
                            .lastMessages(1L)
                            .build()
                    )
                    .build()
            )

        val onCompleteFuture =
            runStreamResponse.subscribe { run -> run.validate() }.onCompleteFuture()
        onCompleteFuture.get()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val runServiceAsync = client.beta().threads().runs()

        val runFuture =
            runServiceAsync.retrieve(
                RunRetrieveParams.builder().threadId("thread_id").runId("run_id").build()
            )

        val run = runFuture.get()
        run.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val runServiceAsync = client.beta().threads().runs()

        val runFuture =
            runServiceAsync.update(
                RunUpdateParams.builder()
                    .threadId("thread_id")
                    .runId("run_id")
                    .metadata(
                        RunUpdateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .build()
            )

        val run = runFuture.get()
        run.validate()
    }

    @Test
    fun listStopsOnExplicitFalse(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        try {
            // A terminal page can still contain items and a cursor
            stubFor(
                get(anyUrl())
                    .willReturn(okJson("{\"data\":[{\"id\":\"item_1\"}],\"has_more\":false}"))
            )
            val page = client.beta().threads().runs().list("thread_id").get()
            assertThat(page.items()).hasSize(1)
            assertThat(page.hasNextPage()).isFalse()

            val count = AtomicInteger()
            page.autoPager().subscribe { count.incrementAndGet() }.onCompleteFuture().get()
            assertThat(count.get()).isEqualTo(1)

            assertThat(findAll(getRequestedFor(anyUrl()))).hasSize(1)
        } finally {
            client.close()
        }
    }

    @Test
    fun listContinuesUntilExplicitFalse(wmRuntimeInfo: WireMockRuntimeInfo) {
        // Both explicit true and a missing flag preserve normal cursor traversal.
        for (firstResponse in
            listOf(
                "{\"data\":[{\"id\":\"item_1\"}],\"has_more\":true}",
                "{\"data\":[{\"id\":\"item_1\"}]}",
            )) {
            reset()
            val client =
                OpenAIOkHttpClientAsync.builder()
                    .baseUrl(wmRuntimeInfo.httpBaseUrl)
                    .apiKey("My API Key")
                    .adminApiKey("My Admin API Key")
                    .build()
            try {
                stubFor(
                    get(anyUrl())
                        .inScenario("pagination")
                        .whenScenarioStateIs("Started")
                        .willReturn(okJson(firstResponse))
                        .willSetStateTo("terminal")
                )
                stubFor(
                    get(anyUrl())
                        .inScenario("pagination")
                        .whenScenarioStateIs("terminal")
                        .willReturn(okJson("{\"data\":[{\"id\":\"item_1\"}],\"has_more\":false}"))
                        .willSetStateTo("unexpected")
                )
                // Bound a regression to one extra request instead of an infinite loop.
                stubFor(
                    get(anyUrl())
                        .inScenario("pagination")
                        .whenScenarioStateIs("unexpected")
                        .willReturn(okJson("{}"))
                )
                val page = client.beta().threads().runs().list("thread_id").get()
                assertThat(page.hasNextPage()).isTrue()

                val count = AtomicInteger()
                page.autoPager().subscribe { count.incrementAndGet() }.onCompleteFuture().get()
                assertThat(count.get()).isEqualTo(2)

                assertThat(findAll(getRequestedFor(anyUrl()))).hasSize(2)
            } finally {
                client.close()
            }
        }
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val runServiceAsync = client.beta().threads().runs()

        val pageFuture = runServiceAsync.list("thread_id")

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun cancel() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val runServiceAsync = client.beta().threads().runs()

        val runFuture =
            runServiceAsync.cancel(
                RunCancelParams.builder().threadId("thread_id").runId("run_id").build()
            )

        val run = runFuture.get()
        run.validate()
    }

    @Test
    fun submitToolOutputs() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val runServiceAsync = client.beta().threads().runs()

        val runFuture =
            runServiceAsync.submitToolOutputs(
                RunSubmitToolOutputsParams.builder()
                    .threadId("thread_id")
                    .runId("run_id")
                    .addToolOutput(
                        RunSubmitToolOutputsParams.ToolOutput.builder()
                            .output("output")
                            .toolCallId("tool_call_id")
                            .build()
                    )
                    .build()
            )

        val run = runFuture.get()
        run.validate()
    }

    @Disabled("Prism does not support SSE streaming mock responses")
    @Test
    fun submitToolOutputsStreaming() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val runServiceAsync = client.beta().threads().runs()

        val runStreamResponse =
            runServiceAsync.submitToolOutputsStreaming(
                RunSubmitToolOutputsParams.builder()
                    .threadId("thread_id")
                    .runId("run_id")
                    .addToolOutput(
                        RunSubmitToolOutputsParams.ToolOutput.builder()
                            .output("output")
                            .toolCallId("tool_call_id")
                            .build()
                    )
                    .build()
            )

        val onCompleteFuture =
            runStreamResponse.subscribe { run -> run.validate() }.onCompleteFuture()
        onCompleteFuture.get()
    }
}
