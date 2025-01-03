// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.threads

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.AssistantResponseFormatOption
import com.openai.models.AssistantTool
import com.openai.models.AssistantToolChoiceOption
import com.openai.models.BetaThreadRunCancelParams
import com.openai.models.BetaThreadRunCreateParams
import com.openai.models.BetaThreadRunListParams
import com.openai.models.BetaThreadRunRetrieveParams
import com.openai.models.BetaThreadRunSubmitToolOutputsParams
import com.openai.models.BetaThreadRunUpdateParams
import com.openai.models.ChatModel
import com.openai.models.CodeInterpreterTool
import com.openai.models.RunStepInclude
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class RunServiceTest {

    @Test
    fun callCreate() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val runService = client.beta().threads().runs()
        val run =
            runService.create(
                BetaThreadRunCreateParams.builder()
                    .threadId("thread_id")
                    .assistantId("assistant_id")
                    .include(
                        listOf(RunStepInclude.STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT)
                    )
                    .additionalInstructions("additional_instructions")
                    .additionalMessages(
                        listOf(
                            BetaThreadRunCreateParams.AdditionalMessage.builder()
                                .content(
                                    BetaThreadRunCreateParams.AdditionalMessage.Content
                                        .ofTextContent("string")
                                )
                                .role(BetaThreadRunCreateParams.AdditionalMessage.Role.USER)
                                .attachments(
                                    listOf(
                                        BetaThreadRunCreateParams.AdditionalMessage.Attachment
                                            .builder()
                                            .fileId("file_id")
                                            .tools(
                                                listOf(
                                                    BetaThreadRunCreateParams.AdditionalMessage
                                                        .Attachment
                                                        .Tool
                                                        .ofCodeInterpreterTool(
                                                            CodeInterpreterTool.builder()
                                                                .type(
                                                                    CodeInterpreterTool.Type
                                                                        .CODE_INTERPRETER
                                                                )
                                                                .build()
                                                        )
                                                )
                                            )
                                            .build()
                                    )
                                )
                                .metadata(JsonValue.from(mapOf<String, Any>()))
                                .build()
                        )
                    )
                    .instructions("instructions")
                    .maxCompletionTokens(256L)
                    .maxPromptTokens(256L)
                    .metadata(JsonValue.from(mapOf<String, Any>()))
                    .model(ChatModel.GPT_4O)
                    .parallelToolCalls(true)
                    .responseFormat(
                        AssistantResponseFormatOption.ofBehavior(
                            AssistantResponseFormatOption.Behavior.AUTO
                        )
                    )
                    .temperature(1.0)
                    .toolChoice(
                        AssistantToolChoiceOption.ofBehavior(
                            AssistantToolChoiceOption.Behavior.NONE
                        )
                    )
                    .tools(
                        listOf(
                            AssistantTool.ofCodeInterpreterTool(
                                CodeInterpreterTool.builder()
                                    .type(CodeInterpreterTool.Type.CODE_INTERPRETER)
                                    .build()
                            )
                        )
                    )
                    .topP(1.0)
                    .truncationStrategy(
                        BetaThreadRunCreateParams.TruncationStrategy.builder()
                            .type(BetaThreadRunCreateParams.TruncationStrategy.Type.AUTO)
                            .lastMessages(1L)
                            .build()
                    )
                    .build()
            )
        println(run)
        run.validate()
    }

    @Test
    fun callCreateStreaming() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val runService = client.beta().threads().runs()

        val runStream =
            runService.createStreaming(
                BetaThreadRunCreateParams.builder()
                    .threadId("thread_id")
                    .assistantId("assistant_id")
                    .include(
                        listOf(RunStepInclude.STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT)
                    )
                    .additionalInstructions("additional_instructions")
                    .additionalMessages(
                        listOf(
                            BetaThreadRunCreateParams.AdditionalMessage.builder()
                                .content(
                                    BetaThreadRunCreateParams.AdditionalMessage.Content
                                        .ofTextContent("string")
                                )
                                .role(BetaThreadRunCreateParams.AdditionalMessage.Role.USER)
                                .attachments(
                                    listOf(
                                        BetaThreadRunCreateParams.AdditionalMessage.Attachment
                                            .builder()
                                            .fileId("file_id")
                                            .tools(
                                                listOf(
                                                    BetaThreadRunCreateParams.AdditionalMessage
                                                        .Attachment
                                                        .Tool
                                                        .ofCodeInterpreterTool(
                                                            CodeInterpreterTool.builder()
                                                                .type(
                                                                    CodeInterpreterTool.Type
                                                                        .CODE_INTERPRETER
                                                                )
                                                                .build()
                                                        )
                                                )
                                            )
                                            .build()
                                    )
                                )
                                .metadata(JsonValue.from(mapOf<String, Any>()))
                                .build()
                        )
                    )
                    .instructions("instructions")
                    .maxCompletionTokens(256L)
                    .maxPromptTokens(256L)
                    .metadata(JsonValue.from(mapOf<String, Any>()))
                    .model(ChatModel.GPT_4O)
                    .parallelToolCalls(true)
                    .responseFormat(
                        AssistantResponseFormatOption.ofBehavior(
                            AssistantResponseFormatOption.Behavior.AUTO
                        )
                    )
                    .temperature(1.0)
                    .toolChoice(
                        AssistantToolChoiceOption.ofBehavior(
                            AssistantToolChoiceOption.Behavior.NONE
                        )
                    )
                    .tools(
                        listOf(
                            AssistantTool.ofCodeInterpreterTool(
                                CodeInterpreterTool.builder()
                                    .type(CodeInterpreterTool.Type.CODE_INTERPRETER)
                                    .build()
                            )
                        )
                    )
                    .topP(1.0)
                    .truncationStrategy(
                        BetaThreadRunCreateParams.TruncationStrategy.builder()
                            .type(BetaThreadRunCreateParams.TruncationStrategy.Type.AUTO)
                            .lastMessages(1L)
                            .build()
                    )
                    .build()
            )

        runStream.use {
            runStream.stream().forEach {
                println(it)
                it.validate()
            }
        }
    }

    @Test
    fun callRetrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val runService = client.beta().threads().runs()
        val run =
            runService.retrieve(
                BetaThreadRunRetrieveParams.builder().threadId("thread_id").runId("run_id").build()
            )
        println(run)
        run.validate()
    }

    @Test
    fun callUpdate() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val runService = client.beta().threads().runs()
        val run =
            runService.update(
                BetaThreadRunUpdateParams.builder()
                    .threadId("thread_id")
                    .runId("run_id")
                    .metadata(JsonValue.from(mapOf<String, Any>()))
                    .build()
            )
        println(run)
        run.validate()
    }

    @Test
    fun callList() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val runService = client.beta().threads().runs()
        val listRunsResponse =
            runService.list(BetaThreadRunListParams.builder().threadId("thread_id").build())
        println(listRunsResponse)
        listRunsResponse.data().forEach { it.validate() }
    }

    @Test
    fun callCancel() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val runService = client.beta().threads().runs()
        val run =
            runService.cancel(
                BetaThreadRunCancelParams.builder().threadId("thread_id").runId("run_id").build()
            )
        println(run)
        run.validate()
    }

    @Test
    fun callSubmitToolOutputs() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val runService = client.beta().threads().runs()
        val run =
            runService.submitToolOutputs(
                BetaThreadRunSubmitToolOutputsParams.builder()
                    .threadId("thread_id")
                    .runId("run_id")
                    .toolOutputs(
                        listOf(
                            BetaThreadRunSubmitToolOutputsParams.ToolOutput.builder()
                                .output("output")
                                .toolCallId("tool_call_id")
                                .build()
                        )
                    )
                    .build()
            )
        println(run)
        run.validate()
    }

    @Test
    fun callSubmitToolOutputsStreaming() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val runService = client.beta().threads().runs()

        val runStream =
            runService.submitToolOutputsStreaming(
                BetaThreadRunSubmitToolOutputsParams.builder()
                    .threadId("thread_id")
                    .runId("run_id")
                    .toolOutputs(
                        listOf(
                            BetaThreadRunSubmitToolOutputsParams.ToolOutput.builder()
                                .output("output")
                                .toolCallId("tool_call_id")
                                .build()
                        )
                    )
                    .build()
            )

        runStream.use {
            runStream.stream().forEach {
                println(it)
                it.validate()
            }
        }
    }
}
