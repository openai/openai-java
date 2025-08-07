// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.ErrorObject
import com.openai.models.beta.threads.AssistantToolChoiceOption
import com.openai.models.beta.threads.Thread
import com.openai.models.beta.threads.messages.ImageFile
import com.openai.models.beta.threads.messages.ImageFileDelta
import com.openai.models.beta.threads.messages.ImageFileDeltaBlock
import com.openai.models.beta.threads.messages.Message
import com.openai.models.beta.threads.messages.MessageDelta
import com.openai.models.beta.threads.messages.MessageDeltaEvent
import com.openai.models.beta.threads.runs.RequiredActionFunctionToolCall
import com.openai.models.beta.threads.runs.Run
import com.openai.models.beta.threads.runs.RunStatus
import com.openai.models.beta.threads.runs.steps.MessageCreationStepDetails
import com.openai.models.beta.threads.runs.steps.RunStep
import com.openai.models.beta.threads.runs.steps.RunStepDelta
import com.openai.models.beta.threads.runs.steps.RunStepDeltaEvent
import com.openai.models.beta.threads.runs.steps.RunStepDeltaMessageDelta
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class AssistantStreamEventTest {

    @Test
    fun ofThreadCreated() {
        val threadCreated =
            AssistantStreamEvent.ThreadCreated.builder()
                .data(
                    Thread.builder()
                        .id("id")
                        .createdAt(0L)
                        .metadata(
                            Thread.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .toolResources(
                            Thread.ToolResources.builder()
                                .codeInterpreter(
                                    Thread.ToolResources.CodeInterpreter.builder()
                                        .addFileId("string")
                                        .build()
                                )
                                .fileSearch(
                                    Thread.ToolResources.FileSearch.builder()
                                        .addVectorStoreId("string")
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .enabled(true)
                .build()

        val assistantStreamEvent = AssistantStreamEvent.ofThreadCreated(threadCreated)

        assertThat(assistantStreamEvent.threadCreated()).contains(threadCreated)
        assertThat(assistantStreamEvent.threadRunCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunQueued()).isEmpty
        assertThat(assistantStreamEvent.threadRunInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunRequiresAction()).isEmpty
        assertThat(assistantStreamEvent.threadRunCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunIncomplete()).isEmpty
        assertThat(assistantStreamEvent.threadRunFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelling()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunExpired()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepExpired()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCreated()).isEmpty
        assertThat(assistantStreamEvent.threadMessageInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadMessageDelta()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadMessageIncomplete()).isEmpty
        assertThat(assistantStreamEvent.errorEvent()).isEmpty
    }

    @Test
    fun ofThreadCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadCreated(
                AssistantStreamEvent.ThreadCreated.builder()
                    .data(
                        Thread.builder()
                            .id("id")
                            .createdAt(0L)
                            .metadata(
                                Thread.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .toolResources(
                                Thread.ToolResources.builder()
                                    .codeInterpreter(
                                        Thread.ToolResources.CodeInterpreter.builder()
                                            .addFileId("string")
                                            .build()
                                    )
                                    .fileSearch(
                                        Thread.ToolResources.FileSearch.builder()
                                            .addVectorStoreId("string")
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .enabled(true)
                    .build()
            )

        val roundtrippedAssistantStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantStreamEvent),
                jacksonTypeRef<AssistantStreamEvent>(),
            )

        assertThat(roundtrippedAssistantStreamEvent).isEqualTo(assistantStreamEvent)
    }

    @Test
    fun ofThreadRunCreated() {
        val threadRunCreated =
            AssistantStreamEvent.ThreadRunCreated.builder()
                .data(
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
                .build()

        val assistantStreamEvent = AssistantStreamEvent.ofThreadRunCreated(threadRunCreated)

        assertThat(assistantStreamEvent.threadCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunCreated()).contains(threadRunCreated)
        assertThat(assistantStreamEvent.threadRunQueued()).isEmpty
        assertThat(assistantStreamEvent.threadRunInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunRequiresAction()).isEmpty
        assertThat(assistantStreamEvent.threadRunCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunIncomplete()).isEmpty
        assertThat(assistantStreamEvent.threadRunFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelling()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunExpired()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepExpired()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCreated()).isEmpty
        assertThat(assistantStreamEvent.threadMessageInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadMessageDelta()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadMessageIncomplete()).isEmpty
        assertThat(assistantStreamEvent.errorEvent()).isEmpty
    }

    @Test
    fun ofThreadRunCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadRunCreated(
                AssistantStreamEvent.ThreadRunCreated.builder()
                    .data(
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
                    .build()
            )

        val roundtrippedAssistantStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantStreamEvent),
                jacksonTypeRef<AssistantStreamEvent>(),
            )

        assertThat(roundtrippedAssistantStreamEvent).isEqualTo(assistantStreamEvent)
    }

    @Test
    fun ofThreadRunQueued() {
        val threadRunQueued =
            AssistantStreamEvent.ThreadRunQueued.builder()
                .data(
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
                .build()

        val assistantStreamEvent = AssistantStreamEvent.ofThreadRunQueued(threadRunQueued)

        assertThat(assistantStreamEvent.threadCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunQueued()).contains(threadRunQueued)
        assertThat(assistantStreamEvent.threadRunInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunRequiresAction()).isEmpty
        assertThat(assistantStreamEvent.threadRunCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunIncomplete()).isEmpty
        assertThat(assistantStreamEvent.threadRunFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelling()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunExpired()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepExpired()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCreated()).isEmpty
        assertThat(assistantStreamEvent.threadMessageInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadMessageDelta()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadMessageIncomplete()).isEmpty
        assertThat(assistantStreamEvent.errorEvent()).isEmpty
    }

    @Test
    fun ofThreadRunQueuedRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadRunQueued(
                AssistantStreamEvent.ThreadRunQueued.builder()
                    .data(
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
                    .build()
            )

        val roundtrippedAssistantStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantStreamEvent),
                jacksonTypeRef<AssistantStreamEvent>(),
            )

        assertThat(roundtrippedAssistantStreamEvent).isEqualTo(assistantStreamEvent)
    }

    @Test
    fun ofThreadRunInProgress() {
        val threadRunInProgress =
            AssistantStreamEvent.ThreadRunInProgress.builder()
                .data(
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
                .build()

        val assistantStreamEvent = AssistantStreamEvent.ofThreadRunInProgress(threadRunInProgress)

        assertThat(assistantStreamEvent.threadCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunQueued()).isEmpty
        assertThat(assistantStreamEvent.threadRunInProgress()).contains(threadRunInProgress)
        assertThat(assistantStreamEvent.threadRunRequiresAction()).isEmpty
        assertThat(assistantStreamEvent.threadRunCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunIncomplete()).isEmpty
        assertThat(assistantStreamEvent.threadRunFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelling()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunExpired()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepExpired()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCreated()).isEmpty
        assertThat(assistantStreamEvent.threadMessageInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadMessageDelta()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadMessageIncomplete()).isEmpty
        assertThat(assistantStreamEvent.errorEvent()).isEmpty
    }

    @Test
    fun ofThreadRunInProgressRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadRunInProgress(
                AssistantStreamEvent.ThreadRunInProgress.builder()
                    .data(
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
                    .build()
            )

        val roundtrippedAssistantStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantStreamEvent),
                jacksonTypeRef<AssistantStreamEvent>(),
            )

        assertThat(roundtrippedAssistantStreamEvent).isEqualTo(assistantStreamEvent)
    }

    @Test
    fun ofThreadRunRequiresAction() {
        val threadRunRequiresAction =
            AssistantStreamEvent.ThreadRunRequiresAction.builder()
                .data(
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
                .build()

        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadRunRequiresAction(threadRunRequiresAction)

        assertThat(assistantStreamEvent.threadCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunQueued()).isEmpty
        assertThat(assistantStreamEvent.threadRunInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunRequiresAction()).contains(threadRunRequiresAction)
        assertThat(assistantStreamEvent.threadRunCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunIncomplete()).isEmpty
        assertThat(assistantStreamEvent.threadRunFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelling()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunExpired()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepExpired()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCreated()).isEmpty
        assertThat(assistantStreamEvent.threadMessageInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadMessageDelta()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadMessageIncomplete()).isEmpty
        assertThat(assistantStreamEvent.errorEvent()).isEmpty
    }

    @Test
    fun ofThreadRunRequiresActionRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadRunRequiresAction(
                AssistantStreamEvent.ThreadRunRequiresAction.builder()
                    .data(
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
                    .build()
            )

        val roundtrippedAssistantStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantStreamEvent),
                jacksonTypeRef<AssistantStreamEvent>(),
            )

        assertThat(roundtrippedAssistantStreamEvent).isEqualTo(assistantStreamEvent)
    }

    @Test
    fun ofThreadRunCompleted() {
        val threadRunCompleted =
            AssistantStreamEvent.ThreadRunCompleted.builder()
                .data(
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
                .build()

        val assistantStreamEvent = AssistantStreamEvent.ofThreadRunCompleted(threadRunCompleted)

        assertThat(assistantStreamEvent.threadCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunQueued()).isEmpty
        assertThat(assistantStreamEvent.threadRunInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunRequiresAction()).isEmpty
        assertThat(assistantStreamEvent.threadRunCompleted()).contains(threadRunCompleted)
        assertThat(assistantStreamEvent.threadRunIncomplete()).isEmpty
        assertThat(assistantStreamEvent.threadRunFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelling()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunExpired()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepExpired()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCreated()).isEmpty
        assertThat(assistantStreamEvent.threadMessageInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadMessageDelta()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadMessageIncomplete()).isEmpty
        assertThat(assistantStreamEvent.errorEvent()).isEmpty
    }

    @Test
    fun ofThreadRunCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadRunCompleted(
                AssistantStreamEvent.ThreadRunCompleted.builder()
                    .data(
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
                    .build()
            )

        val roundtrippedAssistantStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantStreamEvent),
                jacksonTypeRef<AssistantStreamEvent>(),
            )

        assertThat(roundtrippedAssistantStreamEvent).isEqualTo(assistantStreamEvent)
    }

    @Test
    fun ofThreadRunIncomplete() {
        val threadRunIncomplete =
            AssistantStreamEvent.ThreadRunIncomplete.builder()
                .data(
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
                .build()

        val assistantStreamEvent = AssistantStreamEvent.ofThreadRunIncomplete(threadRunIncomplete)

        assertThat(assistantStreamEvent.threadCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunQueued()).isEmpty
        assertThat(assistantStreamEvent.threadRunInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunRequiresAction()).isEmpty
        assertThat(assistantStreamEvent.threadRunCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunIncomplete()).contains(threadRunIncomplete)
        assertThat(assistantStreamEvent.threadRunFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelling()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunExpired()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepExpired()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCreated()).isEmpty
        assertThat(assistantStreamEvent.threadMessageInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadMessageDelta()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadMessageIncomplete()).isEmpty
        assertThat(assistantStreamEvent.errorEvent()).isEmpty
    }

    @Test
    fun ofThreadRunIncompleteRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadRunIncomplete(
                AssistantStreamEvent.ThreadRunIncomplete.builder()
                    .data(
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
                    .build()
            )

        val roundtrippedAssistantStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantStreamEvent),
                jacksonTypeRef<AssistantStreamEvent>(),
            )

        assertThat(roundtrippedAssistantStreamEvent).isEqualTo(assistantStreamEvent)
    }

    @Test
    fun ofThreadRunFailed() {
        val threadRunFailed =
            AssistantStreamEvent.ThreadRunFailed.builder()
                .data(
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
                .build()

        val assistantStreamEvent = AssistantStreamEvent.ofThreadRunFailed(threadRunFailed)

        assertThat(assistantStreamEvent.threadCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunQueued()).isEmpty
        assertThat(assistantStreamEvent.threadRunInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunRequiresAction()).isEmpty
        assertThat(assistantStreamEvent.threadRunCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunIncomplete()).isEmpty
        assertThat(assistantStreamEvent.threadRunFailed()).contains(threadRunFailed)
        assertThat(assistantStreamEvent.threadRunCancelling()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunExpired()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepExpired()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCreated()).isEmpty
        assertThat(assistantStreamEvent.threadMessageInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadMessageDelta()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadMessageIncomplete()).isEmpty
        assertThat(assistantStreamEvent.errorEvent()).isEmpty
    }

    @Test
    fun ofThreadRunFailedRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadRunFailed(
                AssistantStreamEvent.ThreadRunFailed.builder()
                    .data(
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
                    .build()
            )

        val roundtrippedAssistantStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantStreamEvent),
                jacksonTypeRef<AssistantStreamEvent>(),
            )

        assertThat(roundtrippedAssistantStreamEvent).isEqualTo(assistantStreamEvent)
    }

    @Test
    fun ofThreadRunCancelling() {
        val threadRunCancelling =
            AssistantStreamEvent.ThreadRunCancelling.builder()
                .data(
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
                .build()

        val assistantStreamEvent = AssistantStreamEvent.ofThreadRunCancelling(threadRunCancelling)

        assertThat(assistantStreamEvent.threadCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunQueued()).isEmpty
        assertThat(assistantStreamEvent.threadRunInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunRequiresAction()).isEmpty
        assertThat(assistantStreamEvent.threadRunCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunIncomplete()).isEmpty
        assertThat(assistantStreamEvent.threadRunFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelling()).contains(threadRunCancelling)
        assertThat(assistantStreamEvent.threadRunCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunExpired()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepExpired()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCreated()).isEmpty
        assertThat(assistantStreamEvent.threadMessageInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadMessageDelta()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadMessageIncomplete()).isEmpty
        assertThat(assistantStreamEvent.errorEvent()).isEmpty
    }

    @Test
    fun ofThreadRunCancellingRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadRunCancelling(
                AssistantStreamEvent.ThreadRunCancelling.builder()
                    .data(
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
                    .build()
            )

        val roundtrippedAssistantStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantStreamEvent),
                jacksonTypeRef<AssistantStreamEvent>(),
            )

        assertThat(roundtrippedAssistantStreamEvent).isEqualTo(assistantStreamEvent)
    }

    @Test
    fun ofThreadRunCancelled() {
        val threadRunCancelled =
            AssistantStreamEvent.ThreadRunCancelled.builder()
                .data(
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
                .build()

        val assistantStreamEvent = AssistantStreamEvent.ofThreadRunCancelled(threadRunCancelled)

        assertThat(assistantStreamEvent.threadCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunQueued()).isEmpty
        assertThat(assistantStreamEvent.threadRunInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunRequiresAction()).isEmpty
        assertThat(assistantStreamEvent.threadRunCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunIncomplete()).isEmpty
        assertThat(assistantStreamEvent.threadRunFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelling()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelled()).contains(threadRunCancelled)
        assertThat(assistantStreamEvent.threadRunExpired()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepExpired()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCreated()).isEmpty
        assertThat(assistantStreamEvent.threadMessageInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadMessageDelta()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadMessageIncomplete()).isEmpty
        assertThat(assistantStreamEvent.errorEvent()).isEmpty
    }

    @Test
    fun ofThreadRunCancelledRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadRunCancelled(
                AssistantStreamEvent.ThreadRunCancelled.builder()
                    .data(
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
                    .build()
            )

        val roundtrippedAssistantStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantStreamEvent),
                jacksonTypeRef<AssistantStreamEvent>(),
            )

        assertThat(roundtrippedAssistantStreamEvent).isEqualTo(assistantStreamEvent)
    }

    @Test
    fun ofThreadRunExpired() {
        val threadRunExpired =
            AssistantStreamEvent.ThreadRunExpired.builder()
                .data(
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
                .build()

        val assistantStreamEvent = AssistantStreamEvent.ofThreadRunExpired(threadRunExpired)

        assertThat(assistantStreamEvent.threadCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunQueued()).isEmpty
        assertThat(assistantStreamEvent.threadRunInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunRequiresAction()).isEmpty
        assertThat(assistantStreamEvent.threadRunCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunIncomplete()).isEmpty
        assertThat(assistantStreamEvent.threadRunFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelling()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunExpired()).contains(threadRunExpired)
        assertThat(assistantStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepExpired()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCreated()).isEmpty
        assertThat(assistantStreamEvent.threadMessageInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadMessageDelta()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadMessageIncomplete()).isEmpty
        assertThat(assistantStreamEvent.errorEvent()).isEmpty
    }

    @Test
    fun ofThreadRunExpiredRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadRunExpired(
                AssistantStreamEvent.ThreadRunExpired.builder()
                    .data(
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
                    .build()
            )

        val roundtrippedAssistantStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantStreamEvent),
                jacksonTypeRef<AssistantStreamEvent>(),
            )

        assertThat(roundtrippedAssistantStreamEvent).isEqualTo(assistantStreamEvent)
    }

    @Test
    fun ofThreadRunStepCreated() {
        val threadRunStepCreated =
            AssistantStreamEvent.ThreadRunStepCreated.builder()
                .data(
                    RunStep.builder()
                        .id("id")
                        .assistantId("assistant_id")
                        .cancelledAt(0L)
                        .completedAt(0L)
                        .createdAt(0L)
                        .expiredAt(0L)
                        .failedAt(0L)
                        .lastError(
                            RunStep.LastError.builder()
                                .code(RunStep.LastError.Code.SERVER_ERROR)
                                .message("message")
                                .build()
                        )
                        .metadata(
                            RunStep.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .runId("run_id")
                        .status(RunStep.Status.IN_PROGRESS)
                        .messageCreationStepDetails(
                            MessageCreationStepDetails.MessageCreation.builder()
                                .messageId("message_id")
                                .build()
                        )
                        .threadId("thread_id")
                        .type(RunStep.Type.MESSAGE_CREATION)
                        .usage(
                            RunStep.Usage.builder()
                                .completionTokens(0L)
                                .promptTokens(0L)
                                .totalTokens(0L)
                                .build()
                        )
                        .build()
                )
                .build()

        val assistantStreamEvent = AssistantStreamEvent.ofThreadRunStepCreated(threadRunStepCreated)

        assertThat(assistantStreamEvent.threadCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunQueued()).isEmpty
        assertThat(assistantStreamEvent.threadRunInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunRequiresAction()).isEmpty
        assertThat(assistantStreamEvent.threadRunCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunIncomplete()).isEmpty
        assertThat(assistantStreamEvent.threadRunFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelling()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunExpired()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCreated()).contains(threadRunStepCreated)
        assertThat(assistantStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepExpired()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCreated()).isEmpty
        assertThat(assistantStreamEvent.threadMessageInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadMessageDelta()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadMessageIncomplete()).isEmpty
        assertThat(assistantStreamEvent.errorEvent()).isEmpty
    }

    @Test
    fun ofThreadRunStepCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadRunStepCreated(
                AssistantStreamEvent.ThreadRunStepCreated.builder()
                    .data(
                        RunStep.builder()
                            .id("id")
                            .assistantId("assistant_id")
                            .cancelledAt(0L)
                            .completedAt(0L)
                            .createdAt(0L)
                            .expiredAt(0L)
                            .failedAt(0L)
                            .lastError(
                                RunStep.LastError.builder()
                                    .code(RunStep.LastError.Code.SERVER_ERROR)
                                    .message("message")
                                    .build()
                            )
                            .metadata(
                                RunStep.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .runId("run_id")
                            .status(RunStep.Status.IN_PROGRESS)
                            .messageCreationStepDetails(
                                MessageCreationStepDetails.MessageCreation.builder()
                                    .messageId("message_id")
                                    .build()
                            )
                            .threadId("thread_id")
                            .type(RunStep.Type.MESSAGE_CREATION)
                            .usage(
                                RunStep.Usage.builder()
                                    .completionTokens(0L)
                                    .promptTokens(0L)
                                    .totalTokens(0L)
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        val roundtrippedAssistantStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantStreamEvent),
                jacksonTypeRef<AssistantStreamEvent>(),
            )

        assertThat(roundtrippedAssistantStreamEvent).isEqualTo(assistantStreamEvent)
    }

    @Test
    fun ofThreadRunStepInProgress() {
        val threadRunStepInProgress =
            AssistantStreamEvent.ThreadRunStepInProgress.builder()
                .data(
                    RunStep.builder()
                        .id("id")
                        .assistantId("assistant_id")
                        .cancelledAt(0L)
                        .completedAt(0L)
                        .createdAt(0L)
                        .expiredAt(0L)
                        .failedAt(0L)
                        .lastError(
                            RunStep.LastError.builder()
                                .code(RunStep.LastError.Code.SERVER_ERROR)
                                .message("message")
                                .build()
                        )
                        .metadata(
                            RunStep.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .runId("run_id")
                        .status(RunStep.Status.IN_PROGRESS)
                        .messageCreationStepDetails(
                            MessageCreationStepDetails.MessageCreation.builder()
                                .messageId("message_id")
                                .build()
                        )
                        .threadId("thread_id")
                        .type(RunStep.Type.MESSAGE_CREATION)
                        .usage(
                            RunStep.Usage.builder()
                                .completionTokens(0L)
                                .promptTokens(0L)
                                .totalTokens(0L)
                                .build()
                        )
                        .build()
                )
                .build()

        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadRunStepInProgress(threadRunStepInProgress)

        assertThat(assistantStreamEvent.threadCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunQueued()).isEmpty
        assertThat(assistantStreamEvent.threadRunInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunRequiresAction()).isEmpty
        assertThat(assistantStreamEvent.threadRunCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunIncomplete()).isEmpty
        assertThat(assistantStreamEvent.threadRunFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelling()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunExpired()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepInProgress()).contains(threadRunStepInProgress)
        assertThat(assistantStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepExpired()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCreated()).isEmpty
        assertThat(assistantStreamEvent.threadMessageInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadMessageDelta()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadMessageIncomplete()).isEmpty
        assertThat(assistantStreamEvent.errorEvent()).isEmpty
    }

    @Test
    fun ofThreadRunStepInProgressRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadRunStepInProgress(
                AssistantStreamEvent.ThreadRunStepInProgress.builder()
                    .data(
                        RunStep.builder()
                            .id("id")
                            .assistantId("assistant_id")
                            .cancelledAt(0L)
                            .completedAt(0L)
                            .createdAt(0L)
                            .expiredAt(0L)
                            .failedAt(0L)
                            .lastError(
                                RunStep.LastError.builder()
                                    .code(RunStep.LastError.Code.SERVER_ERROR)
                                    .message("message")
                                    .build()
                            )
                            .metadata(
                                RunStep.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .runId("run_id")
                            .status(RunStep.Status.IN_PROGRESS)
                            .messageCreationStepDetails(
                                MessageCreationStepDetails.MessageCreation.builder()
                                    .messageId("message_id")
                                    .build()
                            )
                            .threadId("thread_id")
                            .type(RunStep.Type.MESSAGE_CREATION)
                            .usage(
                                RunStep.Usage.builder()
                                    .completionTokens(0L)
                                    .promptTokens(0L)
                                    .totalTokens(0L)
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        val roundtrippedAssistantStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantStreamEvent),
                jacksonTypeRef<AssistantStreamEvent>(),
            )

        assertThat(roundtrippedAssistantStreamEvent).isEqualTo(assistantStreamEvent)
    }

    @Test
    fun ofThreadRunStepDelta() {
        val threadRunStepDelta =
            AssistantStreamEvent.ThreadRunStepDelta.builder()
                .data(
                    RunStepDeltaEvent.builder()
                        .id("id")
                        .delta(
                            RunStepDelta.builder()
                                .stepDetails(
                                    RunStepDeltaMessageDelta.builder()
                                        .messageCreation(
                                            RunStepDeltaMessageDelta.MessageCreation.builder()
                                                .messageId("message_id")
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .build()

        val assistantStreamEvent = AssistantStreamEvent.ofThreadRunStepDelta(threadRunStepDelta)

        assertThat(assistantStreamEvent.threadCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunQueued()).isEmpty
        assertThat(assistantStreamEvent.threadRunInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunRequiresAction()).isEmpty
        assertThat(assistantStreamEvent.threadRunCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunIncomplete()).isEmpty
        assertThat(assistantStreamEvent.threadRunFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelling()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunExpired()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepDelta()).contains(threadRunStepDelta)
        assertThat(assistantStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepExpired()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCreated()).isEmpty
        assertThat(assistantStreamEvent.threadMessageInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadMessageDelta()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadMessageIncomplete()).isEmpty
        assertThat(assistantStreamEvent.errorEvent()).isEmpty
    }

    @Test
    fun ofThreadRunStepDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadRunStepDelta(
                AssistantStreamEvent.ThreadRunStepDelta.builder()
                    .data(
                        RunStepDeltaEvent.builder()
                            .id("id")
                            .delta(
                                RunStepDelta.builder()
                                    .stepDetails(
                                        RunStepDeltaMessageDelta.builder()
                                            .messageCreation(
                                                RunStepDeltaMessageDelta.MessageCreation.builder()
                                                    .messageId("message_id")
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        val roundtrippedAssistantStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantStreamEvent),
                jacksonTypeRef<AssistantStreamEvent>(),
            )

        assertThat(roundtrippedAssistantStreamEvent).isEqualTo(assistantStreamEvent)
    }

    @Test
    fun ofThreadRunStepCompleted() {
        val threadRunStepCompleted =
            AssistantStreamEvent.ThreadRunStepCompleted.builder()
                .data(
                    RunStep.builder()
                        .id("id")
                        .assistantId("assistant_id")
                        .cancelledAt(0L)
                        .completedAt(0L)
                        .createdAt(0L)
                        .expiredAt(0L)
                        .failedAt(0L)
                        .lastError(
                            RunStep.LastError.builder()
                                .code(RunStep.LastError.Code.SERVER_ERROR)
                                .message("message")
                                .build()
                        )
                        .metadata(
                            RunStep.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .runId("run_id")
                        .status(RunStep.Status.IN_PROGRESS)
                        .messageCreationStepDetails(
                            MessageCreationStepDetails.MessageCreation.builder()
                                .messageId("message_id")
                                .build()
                        )
                        .threadId("thread_id")
                        .type(RunStep.Type.MESSAGE_CREATION)
                        .usage(
                            RunStep.Usage.builder()
                                .completionTokens(0L)
                                .promptTokens(0L)
                                .totalTokens(0L)
                                .build()
                        )
                        .build()
                )
                .build()

        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadRunStepCompleted(threadRunStepCompleted)

        assertThat(assistantStreamEvent.threadCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunQueued()).isEmpty
        assertThat(assistantStreamEvent.threadRunInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunRequiresAction()).isEmpty
        assertThat(assistantStreamEvent.threadRunCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunIncomplete()).isEmpty
        assertThat(assistantStreamEvent.threadRunFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelling()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunExpired()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCompleted()).contains(threadRunStepCompleted)
        assertThat(assistantStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepExpired()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCreated()).isEmpty
        assertThat(assistantStreamEvent.threadMessageInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadMessageDelta()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadMessageIncomplete()).isEmpty
        assertThat(assistantStreamEvent.errorEvent()).isEmpty
    }

    @Test
    fun ofThreadRunStepCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadRunStepCompleted(
                AssistantStreamEvent.ThreadRunStepCompleted.builder()
                    .data(
                        RunStep.builder()
                            .id("id")
                            .assistantId("assistant_id")
                            .cancelledAt(0L)
                            .completedAt(0L)
                            .createdAt(0L)
                            .expiredAt(0L)
                            .failedAt(0L)
                            .lastError(
                                RunStep.LastError.builder()
                                    .code(RunStep.LastError.Code.SERVER_ERROR)
                                    .message("message")
                                    .build()
                            )
                            .metadata(
                                RunStep.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .runId("run_id")
                            .status(RunStep.Status.IN_PROGRESS)
                            .messageCreationStepDetails(
                                MessageCreationStepDetails.MessageCreation.builder()
                                    .messageId("message_id")
                                    .build()
                            )
                            .threadId("thread_id")
                            .type(RunStep.Type.MESSAGE_CREATION)
                            .usage(
                                RunStep.Usage.builder()
                                    .completionTokens(0L)
                                    .promptTokens(0L)
                                    .totalTokens(0L)
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        val roundtrippedAssistantStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantStreamEvent),
                jacksonTypeRef<AssistantStreamEvent>(),
            )

        assertThat(roundtrippedAssistantStreamEvent).isEqualTo(assistantStreamEvent)
    }

    @Test
    fun ofThreadRunStepFailed() {
        val threadRunStepFailed =
            AssistantStreamEvent.ThreadRunStepFailed.builder()
                .data(
                    RunStep.builder()
                        .id("id")
                        .assistantId("assistant_id")
                        .cancelledAt(0L)
                        .completedAt(0L)
                        .createdAt(0L)
                        .expiredAt(0L)
                        .failedAt(0L)
                        .lastError(
                            RunStep.LastError.builder()
                                .code(RunStep.LastError.Code.SERVER_ERROR)
                                .message("message")
                                .build()
                        )
                        .metadata(
                            RunStep.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .runId("run_id")
                        .status(RunStep.Status.IN_PROGRESS)
                        .messageCreationStepDetails(
                            MessageCreationStepDetails.MessageCreation.builder()
                                .messageId("message_id")
                                .build()
                        )
                        .threadId("thread_id")
                        .type(RunStep.Type.MESSAGE_CREATION)
                        .usage(
                            RunStep.Usage.builder()
                                .completionTokens(0L)
                                .promptTokens(0L)
                                .totalTokens(0L)
                                .build()
                        )
                        .build()
                )
                .build()

        val assistantStreamEvent = AssistantStreamEvent.ofThreadRunStepFailed(threadRunStepFailed)

        assertThat(assistantStreamEvent.threadCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunQueued()).isEmpty
        assertThat(assistantStreamEvent.threadRunInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunRequiresAction()).isEmpty
        assertThat(assistantStreamEvent.threadRunCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunIncomplete()).isEmpty
        assertThat(assistantStreamEvent.threadRunFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelling()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunExpired()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepFailed()).contains(threadRunStepFailed)
        assertThat(assistantStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepExpired()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCreated()).isEmpty
        assertThat(assistantStreamEvent.threadMessageInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadMessageDelta()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadMessageIncomplete()).isEmpty
        assertThat(assistantStreamEvent.errorEvent()).isEmpty
    }

    @Test
    fun ofThreadRunStepFailedRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadRunStepFailed(
                AssistantStreamEvent.ThreadRunStepFailed.builder()
                    .data(
                        RunStep.builder()
                            .id("id")
                            .assistantId("assistant_id")
                            .cancelledAt(0L)
                            .completedAt(0L)
                            .createdAt(0L)
                            .expiredAt(0L)
                            .failedAt(0L)
                            .lastError(
                                RunStep.LastError.builder()
                                    .code(RunStep.LastError.Code.SERVER_ERROR)
                                    .message("message")
                                    .build()
                            )
                            .metadata(
                                RunStep.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .runId("run_id")
                            .status(RunStep.Status.IN_PROGRESS)
                            .messageCreationStepDetails(
                                MessageCreationStepDetails.MessageCreation.builder()
                                    .messageId("message_id")
                                    .build()
                            )
                            .threadId("thread_id")
                            .type(RunStep.Type.MESSAGE_CREATION)
                            .usage(
                                RunStep.Usage.builder()
                                    .completionTokens(0L)
                                    .promptTokens(0L)
                                    .totalTokens(0L)
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        val roundtrippedAssistantStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantStreamEvent),
                jacksonTypeRef<AssistantStreamEvent>(),
            )

        assertThat(roundtrippedAssistantStreamEvent).isEqualTo(assistantStreamEvent)
    }

    @Test
    fun ofThreadRunStepCancelled() {
        val threadRunStepCancelled =
            AssistantStreamEvent.ThreadRunStepCancelled.builder()
                .data(
                    RunStep.builder()
                        .id("id")
                        .assistantId("assistant_id")
                        .cancelledAt(0L)
                        .completedAt(0L)
                        .createdAt(0L)
                        .expiredAt(0L)
                        .failedAt(0L)
                        .lastError(
                            RunStep.LastError.builder()
                                .code(RunStep.LastError.Code.SERVER_ERROR)
                                .message("message")
                                .build()
                        )
                        .metadata(
                            RunStep.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .runId("run_id")
                        .status(RunStep.Status.IN_PROGRESS)
                        .messageCreationStepDetails(
                            MessageCreationStepDetails.MessageCreation.builder()
                                .messageId("message_id")
                                .build()
                        )
                        .threadId("thread_id")
                        .type(RunStep.Type.MESSAGE_CREATION)
                        .usage(
                            RunStep.Usage.builder()
                                .completionTokens(0L)
                                .promptTokens(0L)
                                .totalTokens(0L)
                                .build()
                        )
                        .build()
                )
                .build()

        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadRunStepCancelled(threadRunStepCancelled)

        assertThat(assistantStreamEvent.threadCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunQueued()).isEmpty
        assertThat(assistantStreamEvent.threadRunInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunRequiresAction()).isEmpty
        assertThat(assistantStreamEvent.threadRunCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunIncomplete()).isEmpty
        assertThat(assistantStreamEvent.threadRunFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelling()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunExpired()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCancelled()).contains(threadRunStepCancelled)
        assertThat(assistantStreamEvent.threadRunStepExpired()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCreated()).isEmpty
        assertThat(assistantStreamEvent.threadMessageInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadMessageDelta()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadMessageIncomplete()).isEmpty
        assertThat(assistantStreamEvent.errorEvent()).isEmpty
    }

    @Test
    fun ofThreadRunStepCancelledRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadRunStepCancelled(
                AssistantStreamEvent.ThreadRunStepCancelled.builder()
                    .data(
                        RunStep.builder()
                            .id("id")
                            .assistantId("assistant_id")
                            .cancelledAt(0L)
                            .completedAt(0L)
                            .createdAt(0L)
                            .expiredAt(0L)
                            .failedAt(0L)
                            .lastError(
                                RunStep.LastError.builder()
                                    .code(RunStep.LastError.Code.SERVER_ERROR)
                                    .message("message")
                                    .build()
                            )
                            .metadata(
                                RunStep.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .runId("run_id")
                            .status(RunStep.Status.IN_PROGRESS)
                            .messageCreationStepDetails(
                                MessageCreationStepDetails.MessageCreation.builder()
                                    .messageId("message_id")
                                    .build()
                            )
                            .threadId("thread_id")
                            .type(RunStep.Type.MESSAGE_CREATION)
                            .usage(
                                RunStep.Usage.builder()
                                    .completionTokens(0L)
                                    .promptTokens(0L)
                                    .totalTokens(0L)
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        val roundtrippedAssistantStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantStreamEvent),
                jacksonTypeRef<AssistantStreamEvent>(),
            )

        assertThat(roundtrippedAssistantStreamEvent).isEqualTo(assistantStreamEvent)
    }

    @Test
    fun ofThreadRunStepExpired() {
        val threadRunStepExpired =
            AssistantStreamEvent.ThreadRunStepExpired.builder()
                .data(
                    RunStep.builder()
                        .id("id")
                        .assistantId("assistant_id")
                        .cancelledAt(0L)
                        .completedAt(0L)
                        .createdAt(0L)
                        .expiredAt(0L)
                        .failedAt(0L)
                        .lastError(
                            RunStep.LastError.builder()
                                .code(RunStep.LastError.Code.SERVER_ERROR)
                                .message("message")
                                .build()
                        )
                        .metadata(
                            RunStep.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .runId("run_id")
                        .status(RunStep.Status.IN_PROGRESS)
                        .messageCreationStepDetails(
                            MessageCreationStepDetails.MessageCreation.builder()
                                .messageId("message_id")
                                .build()
                        )
                        .threadId("thread_id")
                        .type(RunStep.Type.MESSAGE_CREATION)
                        .usage(
                            RunStep.Usage.builder()
                                .completionTokens(0L)
                                .promptTokens(0L)
                                .totalTokens(0L)
                                .build()
                        )
                        .build()
                )
                .build()

        val assistantStreamEvent = AssistantStreamEvent.ofThreadRunStepExpired(threadRunStepExpired)

        assertThat(assistantStreamEvent.threadCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunQueued()).isEmpty
        assertThat(assistantStreamEvent.threadRunInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunRequiresAction()).isEmpty
        assertThat(assistantStreamEvent.threadRunCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunIncomplete()).isEmpty
        assertThat(assistantStreamEvent.threadRunFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelling()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunExpired()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepExpired()).contains(threadRunStepExpired)
        assertThat(assistantStreamEvent.threadMessageCreated()).isEmpty
        assertThat(assistantStreamEvent.threadMessageInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadMessageDelta()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadMessageIncomplete()).isEmpty
        assertThat(assistantStreamEvent.errorEvent()).isEmpty
    }

    @Test
    fun ofThreadRunStepExpiredRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadRunStepExpired(
                AssistantStreamEvent.ThreadRunStepExpired.builder()
                    .data(
                        RunStep.builder()
                            .id("id")
                            .assistantId("assistant_id")
                            .cancelledAt(0L)
                            .completedAt(0L)
                            .createdAt(0L)
                            .expiredAt(0L)
                            .failedAt(0L)
                            .lastError(
                                RunStep.LastError.builder()
                                    .code(RunStep.LastError.Code.SERVER_ERROR)
                                    .message("message")
                                    .build()
                            )
                            .metadata(
                                RunStep.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .runId("run_id")
                            .status(RunStep.Status.IN_PROGRESS)
                            .messageCreationStepDetails(
                                MessageCreationStepDetails.MessageCreation.builder()
                                    .messageId("message_id")
                                    .build()
                            )
                            .threadId("thread_id")
                            .type(RunStep.Type.MESSAGE_CREATION)
                            .usage(
                                RunStep.Usage.builder()
                                    .completionTokens(0L)
                                    .promptTokens(0L)
                                    .totalTokens(0L)
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        val roundtrippedAssistantStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantStreamEvent),
                jacksonTypeRef<AssistantStreamEvent>(),
            )

        assertThat(roundtrippedAssistantStreamEvent).isEqualTo(assistantStreamEvent)
    }

    @Test
    fun ofThreadMessageCreated() {
        val threadMessageCreated =
            AssistantStreamEvent.ThreadMessageCreated.builder()
                .data(
                    Message.builder()
                        .id("id")
                        .assistantId("assistant_id")
                        .addAttachment(
                            Message.Attachment.builder()
                                .fileId("file_id")
                                .addTool(CodeInterpreterTool.builder().build())
                                .build()
                        )
                        .completedAt(0L)
                        .addImageFileContent(
                            ImageFile.builder()
                                .fileId("file_id")
                                .detail(ImageFile.Detail.AUTO)
                                .build()
                        )
                        .createdAt(0L)
                        .incompleteAt(0L)
                        .incompleteDetails(
                            Message.IncompleteDetails.builder()
                                .reason(Message.IncompleteDetails.Reason.CONTENT_FILTER)
                                .build()
                        )
                        .metadata(
                            Message.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .role(Message.Role.USER)
                        .runId("run_id")
                        .status(Message.Status.IN_PROGRESS)
                        .threadId("thread_id")
                        .build()
                )
                .build()

        val assistantStreamEvent = AssistantStreamEvent.ofThreadMessageCreated(threadMessageCreated)

        assertThat(assistantStreamEvent.threadCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunQueued()).isEmpty
        assertThat(assistantStreamEvent.threadRunInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunRequiresAction()).isEmpty
        assertThat(assistantStreamEvent.threadRunCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunIncomplete()).isEmpty
        assertThat(assistantStreamEvent.threadRunFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelling()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunExpired()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepExpired()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCreated()).contains(threadMessageCreated)
        assertThat(assistantStreamEvent.threadMessageInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadMessageDelta()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadMessageIncomplete()).isEmpty
        assertThat(assistantStreamEvent.errorEvent()).isEmpty
    }

    @Test
    fun ofThreadMessageCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadMessageCreated(
                AssistantStreamEvent.ThreadMessageCreated.builder()
                    .data(
                        Message.builder()
                            .id("id")
                            .assistantId("assistant_id")
                            .addAttachment(
                                Message.Attachment.builder()
                                    .fileId("file_id")
                                    .addTool(CodeInterpreterTool.builder().build())
                                    .build()
                            )
                            .completedAt(0L)
                            .addImageFileContent(
                                ImageFile.builder()
                                    .fileId("file_id")
                                    .detail(ImageFile.Detail.AUTO)
                                    .build()
                            )
                            .createdAt(0L)
                            .incompleteAt(0L)
                            .incompleteDetails(
                                Message.IncompleteDetails.builder()
                                    .reason(Message.IncompleteDetails.Reason.CONTENT_FILTER)
                                    .build()
                            )
                            .metadata(
                                Message.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .role(Message.Role.USER)
                            .runId("run_id")
                            .status(Message.Status.IN_PROGRESS)
                            .threadId("thread_id")
                            .build()
                    )
                    .build()
            )

        val roundtrippedAssistantStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantStreamEvent),
                jacksonTypeRef<AssistantStreamEvent>(),
            )

        assertThat(roundtrippedAssistantStreamEvent).isEqualTo(assistantStreamEvent)
    }

    @Test
    fun ofThreadMessageInProgress() {
        val threadMessageInProgress =
            AssistantStreamEvent.ThreadMessageInProgress.builder()
                .data(
                    Message.builder()
                        .id("id")
                        .assistantId("assistant_id")
                        .addAttachment(
                            Message.Attachment.builder()
                                .fileId("file_id")
                                .addTool(CodeInterpreterTool.builder().build())
                                .build()
                        )
                        .completedAt(0L)
                        .addImageFileContent(
                            ImageFile.builder()
                                .fileId("file_id")
                                .detail(ImageFile.Detail.AUTO)
                                .build()
                        )
                        .createdAt(0L)
                        .incompleteAt(0L)
                        .incompleteDetails(
                            Message.IncompleteDetails.builder()
                                .reason(Message.IncompleteDetails.Reason.CONTENT_FILTER)
                                .build()
                        )
                        .metadata(
                            Message.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .role(Message.Role.USER)
                        .runId("run_id")
                        .status(Message.Status.IN_PROGRESS)
                        .threadId("thread_id")
                        .build()
                )
                .build()

        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadMessageInProgress(threadMessageInProgress)

        assertThat(assistantStreamEvent.threadCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunQueued()).isEmpty
        assertThat(assistantStreamEvent.threadRunInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunRequiresAction()).isEmpty
        assertThat(assistantStreamEvent.threadRunCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunIncomplete()).isEmpty
        assertThat(assistantStreamEvent.threadRunFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelling()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunExpired()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepExpired()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCreated()).isEmpty
        assertThat(assistantStreamEvent.threadMessageInProgress()).contains(threadMessageInProgress)
        assertThat(assistantStreamEvent.threadMessageDelta()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadMessageIncomplete()).isEmpty
        assertThat(assistantStreamEvent.errorEvent()).isEmpty
    }

    @Test
    fun ofThreadMessageInProgressRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadMessageInProgress(
                AssistantStreamEvent.ThreadMessageInProgress.builder()
                    .data(
                        Message.builder()
                            .id("id")
                            .assistantId("assistant_id")
                            .addAttachment(
                                Message.Attachment.builder()
                                    .fileId("file_id")
                                    .addTool(CodeInterpreterTool.builder().build())
                                    .build()
                            )
                            .completedAt(0L)
                            .addImageFileContent(
                                ImageFile.builder()
                                    .fileId("file_id")
                                    .detail(ImageFile.Detail.AUTO)
                                    .build()
                            )
                            .createdAt(0L)
                            .incompleteAt(0L)
                            .incompleteDetails(
                                Message.IncompleteDetails.builder()
                                    .reason(Message.IncompleteDetails.Reason.CONTENT_FILTER)
                                    .build()
                            )
                            .metadata(
                                Message.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .role(Message.Role.USER)
                            .runId("run_id")
                            .status(Message.Status.IN_PROGRESS)
                            .threadId("thread_id")
                            .build()
                    )
                    .build()
            )

        val roundtrippedAssistantStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantStreamEvent),
                jacksonTypeRef<AssistantStreamEvent>(),
            )

        assertThat(roundtrippedAssistantStreamEvent).isEqualTo(assistantStreamEvent)
    }

    @Test
    fun ofThreadMessageDelta() {
        val threadMessageDelta =
            AssistantStreamEvent.ThreadMessageDelta.builder()
                .data(
                    MessageDeltaEvent.builder()
                        .id("id")
                        .delta(
                            MessageDelta.builder()
                                .addContent(
                                    ImageFileDeltaBlock.builder()
                                        .index(0L)
                                        .imageFile(
                                            ImageFileDelta.builder()
                                                .detail(ImageFileDelta.Detail.AUTO)
                                                .fileId("file_id")
                                                .build()
                                        )
                                        .build()
                                )
                                .role(MessageDelta.Role.USER)
                                .build()
                        )
                        .build()
                )
                .build()

        val assistantStreamEvent = AssistantStreamEvent.ofThreadMessageDelta(threadMessageDelta)

        assertThat(assistantStreamEvent.threadCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunQueued()).isEmpty
        assertThat(assistantStreamEvent.threadRunInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunRequiresAction()).isEmpty
        assertThat(assistantStreamEvent.threadRunCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunIncomplete()).isEmpty
        assertThat(assistantStreamEvent.threadRunFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelling()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunExpired()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepExpired()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCreated()).isEmpty
        assertThat(assistantStreamEvent.threadMessageInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadMessageDelta()).contains(threadMessageDelta)
        assertThat(assistantStreamEvent.threadMessageCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadMessageIncomplete()).isEmpty
        assertThat(assistantStreamEvent.errorEvent()).isEmpty
    }

    @Test
    fun ofThreadMessageDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadMessageDelta(
                AssistantStreamEvent.ThreadMessageDelta.builder()
                    .data(
                        MessageDeltaEvent.builder()
                            .id("id")
                            .delta(
                                MessageDelta.builder()
                                    .addContent(
                                        ImageFileDeltaBlock.builder()
                                            .index(0L)
                                            .imageFile(
                                                ImageFileDelta.builder()
                                                    .detail(ImageFileDelta.Detail.AUTO)
                                                    .fileId("file_id")
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .role(MessageDelta.Role.USER)
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        val roundtrippedAssistantStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantStreamEvent),
                jacksonTypeRef<AssistantStreamEvent>(),
            )

        assertThat(roundtrippedAssistantStreamEvent).isEqualTo(assistantStreamEvent)
    }

    @Test
    fun ofThreadMessageCompleted() {
        val threadMessageCompleted =
            AssistantStreamEvent.ThreadMessageCompleted.builder()
                .data(
                    Message.builder()
                        .id("id")
                        .assistantId("assistant_id")
                        .addAttachment(
                            Message.Attachment.builder()
                                .fileId("file_id")
                                .addTool(CodeInterpreterTool.builder().build())
                                .build()
                        )
                        .completedAt(0L)
                        .addImageFileContent(
                            ImageFile.builder()
                                .fileId("file_id")
                                .detail(ImageFile.Detail.AUTO)
                                .build()
                        )
                        .createdAt(0L)
                        .incompleteAt(0L)
                        .incompleteDetails(
                            Message.IncompleteDetails.builder()
                                .reason(Message.IncompleteDetails.Reason.CONTENT_FILTER)
                                .build()
                        )
                        .metadata(
                            Message.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .role(Message.Role.USER)
                        .runId("run_id")
                        .status(Message.Status.IN_PROGRESS)
                        .threadId("thread_id")
                        .build()
                )
                .build()

        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadMessageCompleted(threadMessageCompleted)

        assertThat(assistantStreamEvent.threadCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunQueued()).isEmpty
        assertThat(assistantStreamEvent.threadRunInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunRequiresAction()).isEmpty
        assertThat(assistantStreamEvent.threadRunCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunIncomplete()).isEmpty
        assertThat(assistantStreamEvent.threadRunFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelling()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunExpired()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepExpired()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCreated()).isEmpty
        assertThat(assistantStreamEvent.threadMessageInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadMessageDelta()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCompleted()).contains(threadMessageCompleted)
        assertThat(assistantStreamEvent.threadMessageIncomplete()).isEmpty
        assertThat(assistantStreamEvent.errorEvent()).isEmpty
    }

    @Test
    fun ofThreadMessageCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadMessageCompleted(
                AssistantStreamEvent.ThreadMessageCompleted.builder()
                    .data(
                        Message.builder()
                            .id("id")
                            .assistantId("assistant_id")
                            .addAttachment(
                                Message.Attachment.builder()
                                    .fileId("file_id")
                                    .addTool(CodeInterpreterTool.builder().build())
                                    .build()
                            )
                            .completedAt(0L)
                            .addImageFileContent(
                                ImageFile.builder()
                                    .fileId("file_id")
                                    .detail(ImageFile.Detail.AUTO)
                                    .build()
                            )
                            .createdAt(0L)
                            .incompleteAt(0L)
                            .incompleteDetails(
                                Message.IncompleteDetails.builder()
                                    .reason(Message.IncompleteDetails.Reason.CONTENT_FILTER)
                                    .build()
                            )
                            .metadata(
                                Message.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .role(Message.Role.USER)
                            .runId("run_id")
                            .status(Message.Status.IN_PROGRESS)
                            .threadId("thread_id")
                            .build()
                    )
                    .build()
            )

        val roundtrippedAssistantStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantStreamEvent),
                jacksonTypeRef<AssistantStreamEvent>(),
            )

        assertThat(roundtrippedAssistantStreamEvent).isEqualTo(assistantStreamEvent)
    }

    @Test
    fun ofThreadMessageIncomplete() {
        val threadMessageIncomplete =
            AssistantStreamEvent.ThreadMessageIncomplete.builder()
                .data(
                    Message.builder()
                        .id("id")
                        .assistantId("assistant_id")
                        .addAttachment(
                            Message.Attachment.builder()
                                .fileId("file_id")
                                .addTool(CodeInterpreterTool.builder().build())
                                .build()
                        )
                        .completedAt(0L)
                        .addImageFileContent(
                            ImageFile.builder()
                                .fileId("file_id")
                                .detail(ImageFile.Detail.AUTO)
                                .build()
                        )
                        .createdAt(0L)
                        .incompleteAt(0L)
                        .incompleteDetails(
                            Message.IncompleteDetails.builder()
                                .reason(Message.IncompleteDetails.Reason.CONTENT_FILTER)
                                .build()
                        )
                        .metadata(
                            Message.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .role(Message.Role.USER)
                        .runId("run_id")
                        .status(Message.Status.IN_PROGRESS)
                        .threadId("thread_id")
                        .build()
                )
                .build()

        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadMessageIncomplete(threadMessageIncomplete)

        assertThat(assistantStreamEvent.threadCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunQueued()).isEmpty
        assertThat(assistantStreamEvent.threadRunInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunRequiresAction()).isEmpty
        assertThat(assistantStreamEvent.threadRunCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunIncomplete()).isEmpty
        assertThat(assistantStreamEvent.threadRunFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelling()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunExpired()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepExpired()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCreated()).isEmpty
        assertThat(assistantStreamEvent.threadMessageInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadMessageDelta()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadMessageIncomplete()).contains(threadMessageIncomplete)
        assertThat(assistantStreamEvent.errorEvent()).isEmpty
    }

    @Test
    fun ofThreadMessageIncompleteRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantStreamEvent =
            AssistantStreamEvent.ofThreadMessageIncomplete(
                AssistantStreamEvent.ThreadMessageIncomplete.builder()
                    .data(
                        Message.builder()
                            .id("id")
                            .assistantId("assistant_id")
                            .addAttachment(
                                Message.Attachment.builder()
                                    .fileId("file_id")
                                    .addTool(CodeInterpreterTool.builder().build())
                                    .build()
                            )
                            .completedAt(0L)
                            .addImageFileContent(
                                ImageFile.builder()
                                    .fileId("file_id")
                                    .detail(ImageFile.Detail.AUTO)
                                    .build()
                            )
                            .createdAt(0L)
                            .incompleteAt(0L)
                            .incompleteDetails(
                                Message.IncompleteDetails.builder()
                                    .reason(Message.IncompleteDetails.Reason.CONTENT_FILTER)
                                    .build()
                            )
                            .metadata(
                                Message.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .role(Message.Role.USER)
                            .runId("run_id")
                            .status(Message.Status.IN_PROGRESS)
                            .threadId("thread_id")
                            .build()
                    )
                    .build()
            )

        val roundtrippedAssistantStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantStreamEvent),
                jacksonTypeRef<AssistantStreamEvent>(),
            )

        assertThat(roundtrippedAssistantStreamEvent).isEqualTo(assistantStreamEvent)
    }

    @Test
    fun ofErrorEvent() {
        val errorEvent =
            AssistantStreamEvent.ErrorEvent.builder()
                .data(
                    ErrorObject.builder()
                        .code("code")
                        .message("message")
                        .param("param")
                        .type("type")
                        .build()
                )
                .build()

        val assistantStreamEvent = AssistantStreamEvent.ofErrorEvent(errorEvent)

        assertThat(assistantStreamEvent.threadCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunQueued()).isEmpty
        assertThat(assistantStreamEvent.threadRunInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunRequiresAction()).isEmpty
        assertThat(assistantStreamEvent.threadRunCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunIncomplete()).isEmpty
        assertThat(assistantStreamEvent.threadRunFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelling()).isEmpty
        assertThat(assistantStreamEvent.threadRunCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunExpired()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(assistantStreamEvent.threadRunStepExpired()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCreated()).isEmpty
        assertThat(assistantStreamEvent.threadMessageInProgress()).isEmpty
        assertThat(assistantStreamEvent.threadMessageDelta()).isEmpty
        assertThat(assistantStreamEvent.threadMessageCompleted()).isEmpty
        assertThat(assistantStreamEvent.threadMessageIncomplete()).isEmpty
        assertThat(assistantStreamEvent.errorEvent()).contains(errorEvent)
    }

    @Test
    fun ofErrorEventRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantStreamEvent =
            AssistantStreamEvent.ofErrorEvent(
                AssistantStreamEvent.ErrorEvent.builder()
                    .data(
                        ErrorObject.builder()
                            .code("code")
                            .message("message")
                            .param("param")
                            .type("type")
                            .build()
                    )
                    .build()
            )

        val roundtrippedAssistantStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantStreamEvent),
                jacksonTypeRef<AssistantStreamEvent>(),
            )

        assertThat(roundtrippedAssistantStreamEvent).isEqualTo(assistantStreamEvent)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val assistantStreamEvent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<AssistantStreamEvent>())

        val e = assertThrows<OpenAIInvalidDataException> { assistantStreamEvent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
