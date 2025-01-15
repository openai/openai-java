// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RunStepTest {

    @Test
    fun createRunStep() {
        val runStep =
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
                .metadata(JsonValue.from(mapOf<String, Any>()))
                .object_(RunStep.Object.THREAD_RUN_STEP)
                .runId("run_id")
                .status(RunStep.Status.IN_PROGRESS)
                .stepDetails(
                    MessageCreationStepDetails.builder()
                        .messageCreation(
                            MessageCreationStepDetails.MessageCreation.builder()
                                .messageId("message_id")
                                .build()
                        )
                        .type(MessageCreationStepDetails.Type.MESSAGE_CREATION)
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
        assertThat(runStep).isNotNull
        assertThat(runStep.id()).isEqualTo("id")
        assertThat(runStep.assistantId()).isEqualTo("assistant_id")
        assertThat(runStep.cancelledAt()).contains(0L)
        assertThat(runStep.completedAt()).contains(0L)
        assertThat(runStep.createdAt()).isEqualTo(0L)
        assertThat(runStep.expiredAt()).contains(0L)
        assertThat(runStep.failedAt()).contains(0L)
        assertThat(runStep.lastError())
            .contains(
                RunStep.LastError.builder()
                    .code(RunStep.LastError.Code.SERVER_ERROR)
                    .message("message")
                    .build()
            )
        assertThat(runStep._metadata()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(runStep.object_()).isEqualTo(RunStep.Object.THREAD_RUN_STEP)
        assertThat(runStep.runId()).isEqualTo("run_id")
        assertThat(runStep.status()).isEqualTo(RunStep.Status.IN_PROGRESS)
        assertThat(runStep.stepDetails())
            .isEqualTo(
                RunStep.StepDetails.ofMessageCreationStepDetails(
                    MessageCreationStepDetails.builder()
                        .messageCreation(
                            MessageCreationStepDetails.MessageCreation.builder()
                                .messageId("message_id")
                                .build()
                        )
                        .type(MessageCreationStepDetails.Type.MESSAGE_CREATION)
                        .build()
                )
            )
        assertThat(runStep.threadId()).isEqualTo("thread_id")
        assertThat(runStep.type()).isEqualTo(RunStep.Type.MESSAGE_CREATION)
        assertThat(runStep.usage())
            .contains(
                RunStep.Usage.builder()
                    .completionTokens(0L)
                    .promptTokens(0L)
                    .totalTokens(0L)
                    .build()
            )
    }
}
