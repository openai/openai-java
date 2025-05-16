// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.beta.assistants.CodeInterpreterTool
import com.openai.models.beta.threads.AssistantToolChoiceOption
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RunListPageResponseTest {

    @Test
    fun create() {
        val runListPageResponse =
            RunListPageResponse.builder()
                .addData(
                    Run.builder()
                        .id("id")
                        .assistantId("assistant_id")
                        .cancelledAt(0L)
                        .completedAt(0L)
                        .createdAt(0L)
                        .expiresAt(0L)
                        .failedAt(0L)
                        .incompleteDetails(
                            Run.IncompleteDetails.builder()
                                .reason(Run.IncompleteDetails.Reason.MAX_COMPLETION_TOKENS)
                                .build()
                        )
                        .instructions("instructions")
                        .lastError(
                            Run.LastError.builder()
                                .code(Run.LastError.Code.SERVER_ERROR)
                                .message("message")
                                .build()
                        )
                        .maxCompletionTokens(256L)
                        .maxPromptTokens(256L)
                        .metadata(
                            Run.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .model("model")
                        .parallelToolCalls(true)
                        .requiredAction(
                            Run.RequiredAction.builder()
                                .submitToolOutputs(
                                    Run.RequiredAction.SubmitToolOutputs.builder()
                                        .addToolCall(
                                            RequiredActionFunctionToolCall.builder()
                                                .id("id")
                                                .function(
                                                    RequiredActionFunctionToolCall.Function
                                                        .builder()
                                                        .arguments("arguments")
                                                        .name("name")
                                                        .build()
                                                )
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .responseFormatAuto()
                        .startedAt(0L)
                        .status(RunStatus.QUEUED)
                        .threadId("thread_id")
                        .toolChoice(AssistantToolChoiceOption.Auto.NONE)
                        .addTool(CodeInterpreterTool.builder().build())
                        .truncationStrategy(
                            Run.TruncationStrategy.builder()
                                .type(Run.TruncationStrategy.Type.AUTO)
                                .lastMessages(1L)
                                .build()
                        )
                        .usage(
                            Run.Usage.builder()
                                .completionTokens(0L)
                                .promptTokens(0L)
                                .totalTokens(0L)
                                .build()
                        )
                        .temperature(0.0)
                        .topP(0.0)
                        .build()
                )
                .firstId("run_abc123")
                .hasMore(false)
                .lastId("run_abc456")
                .object_("list")
                .build()

        assertThat(runListPageResponse.data())
            .containsExactly(
                Run.builder()
                    .id("id")
                    .assistantId("assistant_id")
                    .cancelledAt(0L)
                    .completedAt(0L)
                    .createdAt(0L)
                    .expiresAt(0L)
                    .failedAt(0L)
                    .incompleteDetails(
                        Run.IncompleteDetails.builder()
                            .reason(Run.IncompleteDetails.Reason.MAX_COMPLETION_TOKENS)
                            .build()
                    )
                    .instructions("instructions")
                    .lastError(
                        Run.LastError.builder()
                            .code(Run.LastError.Code.SERVER_ERROR)
                            .message("message")
                            .build()
                    )
                    .maxCompletionTokens(256L)
                    .maxPromptTokens(256L)
                    .metadata(
                        Run.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .model("model")
                    .parallelToolCalls(true)
                    .requiredAction(
                        Run.RequiredAction.builder()
                            .submitToolOutputs(
                                Run.RequiredAction.SubmitToolOutputs.builder()
                                    .addToolCall(
                                        RequiredActionFunctionToolCall.builder()
                                            .id("id")
                                            .function(
                                                RequiredActionFunctionToolCall.Function.builder()
                                                    .arguments("arguments")
                                                    .name("name")
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .responseFormatAuto()
                    .startedAt(0L)
                    .status(RunStatus.QUEUED)
                    .threadId("thread_id")
                    .toolChoice(AssistantToolChoiceOption.Auto.NONE)
                    .addTool(CodeInterpreterTool.builder().build())
                    .truncationStrategy(
                        Run.TruncationStrategy.builder()
                            .type(Run.TruncationStrategy.Type.AUTO)
                            .lastMessages(1L)
                            .build()
                    )
                    .usage(
                        Run.Usage.builder()
                            .completionTokens(0L)
                            .promptTokens(0L)
                            .totalTokens(0L)
                            .build()
                    )
                    .temperature(0.0)
                    .topP(0.0)
                    .build()
            )
        assertThat(runListPageResponse.firstId()).isEqualTo("run_abc123")
        assertThat(runListPageResponse.hasMore()).isEqualTo(false)
        assertThat(runListPageResponse.lastId()).isEqualTo("run_abc456")
        assertThat(runListPageResponse.object_()).isEqualTo("list")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val runListPageResponse =
            RunListPageResponse.builder()
                .addData(
                    Run.builder()
                        .id("id")
                        .assistantId("assistant_id")
                        .cancelledAt(0L)
                        .completedAt(0L)
                        .createdAt(0L)
                        .expiresAt(0L)
                        .failedAt(0L)
                        .incompleteDetails(
                            Run.IncompleteDetails.builder()
                                .reason(Run.IncompleteDetails.Reason.MAX_COMPLETION_TOKENS)
                                .build()
                        )
                        .instructions("instructions")
                        .lastError(
                            Run.LastError.builder()
                                .code(Run.LastError.Code.SERVER_ERROR)
                                .message("message")
                                .build()
                        )
                        .maxCompletionTokens(256L)
                        .maxPromptTokens(256L)
                        .metadata(
                            Run.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .model("model")
                        .parallelToolCalls(true)
                        .requiredAction(
                            Run.RequiredAction.builder()
                                .submitToolOutputs(
                                    Run.RequiredAction.SubmitToolOutputs.builder()
                                        .addToolCall(
                                            RequiredActionFunctionToolCall.builder()
                                                .id("id")
                                                .function(
                                                    RequiredActionFunctionToolCall.Function
                                                        .builder()
                                                        .arguments("arguments")
                                                        .name("name")
                                                        .build()
                                                )
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .responseFormatAuto()
                        .startedAt(0L)
                        .status(RunStatus.QUEUED)
                        .threadId("thread_id")
                        .toolChoice(AssistantToolChoiceOption.Auto.NONE)
                        .addTool(CodeInterpreterTool.builder().build())
                        .truncationStrategy(
                            Run.TruncationStrategy.builder()
                                .type(Run.TruncationStrategy.Type.AUTO)
                                .lastMessages(1L)
                                .build()
                        )
                        .usage(
                            Run.Usage.builder()
                                .completionTokens(0L)
                                .promptTokens(0L)
                                .totalTokens(0L)
                                .build()
                        )
                        .temperature(0.0)
                        .topP(0.0)
                        .build()
                )
                .firstId("run_abc123")
                .hasMore(false)
                .lastId("run_abc456")
                .object_("list")
                .build()

        val roundtrippedRunListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(runListPageResponse),
                jacksonTypeRef<RunListPageResponse>(),
            )

        assertThat(roundtrippedRunListPageResponse).isEqualTo(runListPageResponse)
    }
}
