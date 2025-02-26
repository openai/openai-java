// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.threads

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.AssistantToolChoiceOption
import com.openai.models.BetaThreadRunCancelParams
import com.openai.models.BetaThreadRunCreateParams
import com.openai.models.BetaThreadRunListParams
import com.openai.models.BetaThreadRunRetrieveParams
import com.openai.models.BetaThreadRunSubmitToolOutputsParams
import com.openai.models.BetaThreadRunUpdateParams
import com.openai.models.ChatModel
import com.openai.models.CodeInterpreterTool
import com.openai.models.Metadata
import com.openai.models.RunStepInclude
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class RunServiceAsyncTest {

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
                BetaThreadRunCreateParams.builder()
                    .threadId("thread_id")
                    .addInclude(RunStepInclude.STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT)
                    .assistantId("assistant_id")
                    .additionalInstructions("additional_instructions")
                    .addAdditionalMessage(
                        BetaThreadRunCreateParams.AdditionalMessage.builder()
                            .content("string")
                            .role(BetaThreadRunCreateParams.AdditionalMessage.Role.USER)
                            .addAttachment(
                                BetaThreadRunCreateParams.AdditionalMessage.Attachment.builder()
                                    .fileId("file_id")
                                    .addTool(CodeInterpreterTool.builder().build())
                                    .build()
                            )
                            .metadata(
                                Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .build()
                    )
                    .instructions("instructions")
                    .maxCompletionTokens(256L)
                    .maxPromptTokens(256L)
                    .metadata(
                        Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .model(ChatModel.O3_MINI)
                    .parallelToolCalls(true)
                    .reasoningEffort(BetaThreadRunCreateParams.ReasoningEffort.LOW)
                    .responseFormatAuto()
                    .temperature(1.0)
                    .toolChoice(AssistantToolChoiceOption.Auto.NONE)
                    .addTool(CodeInterpreterTool.builder().build())
                    .topP(1.0)
                    .truncationStrategy(
                        BetaThreadRunCreateParams.TruncationStrategy.builder()
                            .type(BetaThreadRunCreateParams.TruncationStrategy.Type.AUTO)
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
                BetaThreadRunCreateParams.builder()
                    .threadId("thread_id")
                    .addInclude(RunStepInclude.STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT)
                    .assistantId("assistant_id")
                    .additionalInstructions("additional_instructions")
                    .addAdditionalMessage(
                        BetaThreadRunCreateParams.AdditionalMessage.builder()
                            .content("string")
                            .role(BetaThreadRunCreateParams.AdditionalMessage.Role.USER)
                            .addAttachment(
                                BetaThreadRunCreateParams.AdditionalMessage.Attachment.builder()
                                    .fileId("file_id")
                                    .addTool(CodeInterpreterTool.builder().build())
                                    .build()
                            )
                            .metadata(
                                Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .build()
                    )
                    .instructions("instructions")
                    .maxCompletionTokens(256L)
                    .maxPromptTokens(256L)
                    .metadata(
                        Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .model(ChatModel.O3_MINI)
                    .parallelToolCalls(true)
                    .reasoningEffort(BetaThreadRunCreateParams.ReasoningEffort.LOW)
                    .responseFormatAuto()
                    .temperature(1.0)
                    .toolChoice(AssistantToolChoiceOption.Auto.NONE)
                    .addTool(CodeInterpreterTool.builder().build())
                    .topP(1.0)
                    .truncationStrategy(
                        BetaThreadRunCreateParams.TruncationStrategy.builder()
                            .type(BetaThreadRunCreateParams.TruncationStrategy.Type.AUTO)
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
                BetaThreadRunRetrieveParams.builder().threadId("thread_id").runId("run_id").build()
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
                BetaThreadRunUpdateParams.builder()
                    .threadId("thread_id")
                    .runId("run_id")
                    .metadata(
                        Metadata.builder()
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

        val pageFuture =
            runServiceAsync.list(BetaThreadRunListParams.builder().threadId("thread_id").build())

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
                BetaThreadRunCancelParams.builder().threadId("thread_id").runId("run_id").build()
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
                BetaThreadRunSubmitToolOutputsParams.builder()
                    .threadId("thread_id")
                    .runId("run_id")
                    .addToolOutput(
                        BetaThreadRunSubmitToolOutputsParams.ToolOutput.builder()
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
                BetaThreadRunSubmitToolOutputsParams.builder()
                    .threadId("thread_id")
                    .runId("run_id")
                    .addToolOutput(
                        BetaThreadRunSubmitToolOutputsParams.ToolOutput.builder()
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
