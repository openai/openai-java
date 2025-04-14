// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.threads

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.ChatModel
import com.openai.models.ReasoningEffort
import com.openai.models.beta.assistants.CodeInterpreterTool
import com.openai.models.beta.threads.AssistantToolChoiceOption
import com.openai.models.beta.threads.runs.RunCancelParams
import com.openai.models.beta.threads.runs.RunCreateParams
import com.openai.models.beta.threads.runs.RunListParams
import com.openai.models.beta.threads.runs.RunRetrieveParams
import com.openai.models.beta.threads.runs.RunSubmitToolOutputsParams
import com.openai.models.beta.threads.runs.RunUpdateParams
import com.openai.models.beta.threads.runs.steps.RunStepInclude
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class RunServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
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
                    .model(ChatModel.GPT_4_1)
                    .parallelToolCalls(true)
                    .reasoningEffort(ReasoningEffort.LOW)
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

    @Test
    fun createStreaming() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
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
                    .model(ChatModel.GPT_4_1)
                    .parallelToolCalls(true)
                    .reasoningEffort(ReasoningEffort.LOW)
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
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val runServiceAsync = client.beta().threads().runs()

        val pageFuture = runServiceAsync.list(RunListParams.builder().threadId("thread_id").build())

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

    @Test
    fun submitToolOutputsStreaming() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
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
