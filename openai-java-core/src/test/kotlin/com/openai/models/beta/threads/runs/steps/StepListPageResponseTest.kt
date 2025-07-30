// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StepListPageResponseTest {

    @Test
    fun create() {
        val stepListPageResponse =
            StepListPageResponse.builder()
                .addData(
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
                .firstId("step_abc123")
                .hasMore(false)
                .lastId("step_abc456")
                .object_("list")
                .build()

        assertThat(stepListPageResponse.data())
            .containsExactly(
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
        assertThat(stepListPageResponse.firstId()).isEqualTo("step_abc123")
        assertThat(stepListPageResponse.hasMore()).isEqualTo(false)
        assertThat(stepListPageResponse.lastId()).isEqualTo("step_abc456")
        assertThat(stepListPageResponse.object_()).isEqualTo("list")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val stepListPageResponse =
            StepListPageResponse.builder()
                .addData(
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
                .firstId("step_abc123")
                .hasMore(false)
                .lastId("step_abc456")
                .object_("list")
                .build()

        val roundtrippedStepListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(stepListPageResponse),
                jacksonTypeRef<StepListPageResponse>(),
            )

        assertThat(roundtrippedStepListPageResponse).isEqualTo(stepListPageResponse)
    }
}
