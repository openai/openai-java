// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
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
    fun ofThreadRunStepCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val runStepStreamEvent =
            RunStepStreamEvent.ofThreadRunStepCreated(
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
            )

        val roundtrippedRunStepStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(runStepStreamEvent),
                jacksonTypeRef<RunStepStreamEvent>(),
            )

        assertThat(roundtrippedRunStepStreamEvent).isEqualTo(runStepStreamEvent)
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
    fun ofThreadRunStepInProgressRoundtrip() {
        val jsonMapper = jsonMapper()
        val runStepStreamEvent =
            RunStepStreamEvent.ofThreadRunStepInProgress(
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
            )

        val roundtrippedRunStepStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(runStepStreamEvent),
                jacksonTypeRef<RunStepStreamEvent>(),
            )

        assertThat(roundtrippedRunStepStreamEvent).isEqualTo(runStepStreamEvent)
    }

    @Test
    fun ofThreadRunStepDelta() {
        val threadRunStepDelta =
            RunStepStreamEvent.ThreadRunStepDelta.builder()
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
    fun ofThreadRunStepDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val runStepStreamEvent =
            RunStepStreamEvent.ofThreadRunStepDelta(
                RunStepStreamEvent.ThreadRunStepDelta.builder()
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

        val roundtrippedRunStepStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(runStepStreamEvent),
                jacksonTypeRef<RunStepStreamEvent>(),
            )

        assertThat(roundtrippedRunStepStreamEvent).isEqualTo(runStepStreamEvent)
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
    fun ofThreadRunStepCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val runStepStreamEvent =
            RunStepStreamEvent.ofThreadRunStepCompleted(
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
            )

        val roundtrippedRunStepStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(runStepStreamEvent),
                jacksonTypeRef<RunStepStreamEvent>(),
            )

        assertThat(roundtrippedRunStepStreamEvent).isEqualTo(runStepStreamEvent)
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
    fun ofThreadRunStepFailedRoundtrip() {
        val jsonMapper = jsonMapper()
        val runStepStreamEvent =
            RunStepStreamEvent.ofThreadRunStepFailed(
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
            )

        val roundtrippedRunStepStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(runStepStreamEvent),
                jacksonTypeRef<RunStepStreamEvent>(),
            )

        assertThat(roundtrippedRunStepStreamEvent).isEqualTo(runStepStreamEvent)
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
    fun ofThreadRunStepCancelledRoundtrip() {
        val jsonMapper = jsonMapper()
        val runStepStreamEvent =
            RunStepStreamEvent.ofThreadRunStepCancelled(
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
            )

        val roundtrippedRunStepStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(runStepStreamEvent),
                jacksonTypeRef<RunStepStreamEvent>(),
            )

        assertThat(roundtrippedRunStepStreamEvent).isEqualTo(runStepStreamEvent)
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

    @Test
    fun ofThreadRunStepExpiredRoundtrip() {
        val jsonMapper = jsonMapper()
        val runStepStreamEvent =
            RunStepStreamEvent.ofThreadRunStepExpired(
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
            )

        val roundtrippedRunStepStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(runStepStreamEvent),
                jacksonTypeRef<RunStepStreamEvent>(),
            )

        assertThat(roundtrippedRunStepStreamEvent).isEqualTo(runStepStreamEvent)
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
        val runStepStreamEvent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<RunStepStreamEvent>())

        val e = assertThrows<OpenAIInvalidDataException> { runStepStreamEvent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
