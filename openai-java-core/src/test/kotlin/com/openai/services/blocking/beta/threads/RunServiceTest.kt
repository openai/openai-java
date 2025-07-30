// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.threads

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
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
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class RunServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val runService = client.beta().threads().runs()

        val run =
            runService.create(
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

        run.validate()
    }

    @Test
    fun createStreaming() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val runService = client.beta().threads().runs()

        val runStreamResponse =
            runService.createStreaming(
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

        runStreamResponse.use { runStreamResponse.stream().forEach { run -> run.validate() } }
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val runService = client.beta().threads().runs()

        val run =
            runService.retrieve(
                RunRetrieveParams.builder().threadId("thread_id").runId("run_id").build()
            )

        run.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val runService = client.beta().threads().runs()

        val run =
            runService.update(
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

        run.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val runService = client.beta().threads().runs()

        val page = runService.list("thread_id")

        page.response().validate()
    }

    @Test
    fun cancel() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val runService = client.beta().threads().runs()

        val run =
            runService.cancel(
                RunCancelParams.builder().threadId("thread_id").runId("run_id").build()
            )

        run.validate()
    }

    @Test
    fun submitToolOutputs() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val runService = client.beta().threads().runs()

        val run =
            runService.submitToolOutputs(
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

        run.validate()
    }

    @Test
    fun submitToolOutputsStreaming() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val runService = client.beta().threads().runs()

        val runStreamResponse =
            runService.submitToolOutputsStreaming(
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

        runStreamResponse.use { runStreamResponse.stream().forEach { run -> run.validate() } }
    }
}
