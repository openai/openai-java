// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

import com.openai.core.JsonValue
import com.openai.models.beta.threads.runs.steps.MessageCreationStepDetails
import com.openai.models.beta.threads.runs.steps.RunStep
import com.openai.models.beta.threads.runs.steps.RunStepDelta
import com.openai.models.beta.threads.runs.steps.RunStepDeltaEvent
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RunStepStreamEventTest {

    @Test
    fun ofThreadRunStepCreated() {
        val threadRunStepCreated =
            RunStepStreamEvent.ThreadRunStepCreated.builder()
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

        val runStepStreamEvent = RunStepStreamEvent.ofThreadRunStepCreated(threadRunStepCreated)

        assertThat(runStepStreamEvent.threadRunStepCreated()).contains(threadRunStepCreated)
        assertThat(runStepStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepExpired()).isEmpty
    }

    @Test
    fun ofThreadRunStepInProgress() {
        val threadRunStepInProgress =
            RunStepStreamEvent.ThreadRunStepInProgress.builder()
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

        val runStepStreamEvent =
            RunStepStreamEvent.ofThreadRunStepInProgress(threadRunStepInProgress)

        assertThat(runStepStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepInProgress()).contains(threadRunStepInProgress)
        assertThat(runStepStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepExpired()).isEmpty
    }

    @Test
    fun ofThreadRunStepDelta() {
        val threadRunStepDelta =
            RunStepStreamEvent.ThreadRunStepDelta.builder()
                .data(
                    RunStepDeltaEvent.builder()
                        .id("id")
                        .delta(RunStepDelta.builder().build())
                        .build()
                )
                .build()

        val runStepStreamEvent = RunStepStreamEvent.ofThreadRunStepDelta(threadRunStepDelta)

        assertThat(runStepStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepDelta()).contains(threadRunStepDelta)
        assertThat(runStepStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepExpired()).isEmpty
    }

    @Test
    fun ofThreadRunStepCompleted() {
        val threadRunStepCompleted =
            RunStepStreamEvent.ThreadRunStepCompleted.builder()
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

        val runStepStreamEvent = RunStepStreamEvent.ofThreadRunStepCompleted(threadRunStepCompleted)

        assertThat(runStepStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepCompleted()).contains(threadRunStepCompleted)
        assertThat(runStepStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepExpired()).isEmpty
    }

    @Test
    fun ofThreadRunStepFailed() {
        val threadRunStepFailed =
            RunStepStreamEvent.ThreadRunStepFailed.builder()
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

        val runStepStreamEvent = RunStepStreamEvent.ofThreadRunStepFailed(threadRunStepFailed)

        assertThat(runStepStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepFailed()).contains(threadRunStepFailed)
        assertThat(runStepStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepExpired()).isEmpty
    }

    @Test
    fun ofThreadRunStepCancelled() {
        val threadRunStepCancelled =
            RunStepStreamEvent.ThreadRunStepCancelled.builder()
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

        val runStepStreamEvent = RunStepStreamEvent.ofThreadRunStepCancelled(threadRunStepCancelled)

        assertThat(runStepStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepCancelled()).contains(threadRunStepCancelled)
        assertThat(runStepStreamEvent.threadRunStepExpired()).isEmpty
    }

    @Test
    fun ofThreadRunStepExpired() {
        val threadRunStepExpired =
            RunStepStreamEvent.ThreadRunStepExpired.builder()
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

        val runStepStreamEvent = RunStepStreamEvent.ofThreadRunStepExpired(threadRunStepExpired)

        assertThat(runStepStreamEvent.threadRunStepCreated()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepInProgress()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepDelta()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepCompleted()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepFailed()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepCancelled()).isEmpty
        assertThat(runStepStreamEvent.threadRunStepExpired()).contains(threadRunStepExpired)
    }
}
