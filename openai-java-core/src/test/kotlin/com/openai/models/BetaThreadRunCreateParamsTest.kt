// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import com.openai.core.http.QueryParams
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaThreadRunCreateParamsTest {

    @Test
    fun create() {
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
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
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
    }

    @Test
    fun queryParams() {
        val params =
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
        val expected = QueryParams.builder()
        expected.put(
            "include[]",
            RunStepInclude.STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT.toString(),
        )
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            BetaThreadRunCreateParams.builder()
                .threadId("thread_id")
                .assistantId("assistant_id")
                .build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun body() {
        val params =
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

        val body = params._body()

        assertNotNull(body)
        assertThat(body.assistantId()).isEqualTo("assistant_id")
        assertThat(body.additionalInstructions()).contains("additional_instructions")
        assertThat(body.additionalMessages())
            .contains(
                listOf(
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
            )
        assertThat(body.instructions()).contains("instructions")
        assertThat(body.maxCompletionTokens()).contains(256L)
        assertThat(body.maxPromptTokens()).contains(256L)
        assertThat(body.metadata())
            .contains(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
        assertThat(body.model()).contains(ChatModel.O3_MINI)
        assertThat(body.parallelToolCalls()).contains(true)
        assertThat(body.reasoningEffort()).contains(BetaThreadRunCreateParams.ReasoningEffort.LOW)
        assertThat(body.responseFormat()).contains(AssistantResponseFormatOption.ofAuto())
        assertThat(body.temperature()).contains(1.0)
        assertThat(body.toolChoice())
            .contains(AssistantToolChoiceOption.ofAuto(AssistantToolChoiceOption.Auto.NONE))
        assertThat(body.tools())
            .contains(
                listOf(AssistantTool.ofCodeInterpreter(CodeInterpreterTool.builder().build()))
            )
        assertThat(body.topP()).contains(1.0)
        assertThat(body.truncationStrategy())
            .contains(
                BetaThreadRunCreateParams.TruncationStrategy.builder()
                    .type(BetaThreadRunCreateParams.TruncationStrategy.Type.AUTO)
                    .lastMessages(1L)
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            BetaThreadRunCreateParams.builder()
                .threadId("thread_id")
                .assistantId("assistant_id")
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.assistantId()).isEqualTo("assistant_id")
    }

    @Test
    fun getPathParam() {
        val params =
            BetaThreadRunCreateParams.builder()
                .threadId("thread_id")
                .assistantId("assistant_id")
                .build()
        assertThat(params).isNotNull
        // path param "threadId"
        assertThat(params.getPathParam(0)).isEqualTo("thread_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
