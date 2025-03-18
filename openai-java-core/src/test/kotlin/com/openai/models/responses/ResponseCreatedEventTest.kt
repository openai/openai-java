// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.openai.core.JsonValue
import com.openai.models.ChatModel
import com.openai.models.ComparisonFilter
import com.openai.models.Metadata
import com.openai.models.Reasoning
import com.openai.models.ReasoningEffort
import com.openai.models.ResponseFormatText
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCreatedEventTest {

    @Test
    fun create() {
        val responseCreatedEvent =
            ResponseCreatedEvent.builder()
                .response(
                    Response.builder()
                        .id("id")
                        .createdAt(0.0)
                        .error(
                            ResponseError.builder()
                                .code(ResponseError.Code.SERVER_ERROR)
                                .message("message")
                                .build()
                        )
                        .incompleteDetails(
                            Response.IncompleteDetails.builder()
                                .reason(Response.IncompleteDetails.Reason.MAX_OUTPUT_TOKENS)
                                .build()
                        )
                        .instructions("instructions")
                        .metadata(
                            Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .model(ChatModel.O3_MINI)
                        .addOutput(
                            ResponseOutputMessage.builder()
                                .id("id")
                                .addContent(
                                    ResponseOutputText.builder()
                                        .addAnnotation(
                                            ResponseOutputText.Annotation.FileCitation.builder()
                                                .fileId("file_id")
                                                .index(0L)
                                                .build()
                                        )
                                        .text("text")
                                        .build()
                                )
                                .status(ResponseOutputMessage.Status.IN_PROGRESS)
                                .build()
                        )
                        .parallelToolCalls(true)
                        .temperature(1.0)
                        .toolChoice(ToolChoiceOptions.NONE)
                        .addTool(
                            FileSearchTool.builder()
                                .addVectorStoreId("string")
                                .filters(
                                    ComparisonFilter.builder()
                                        .key("key")
                                        .type(ComparisonFilter.Type.EQ)
                                        .value("string")
                                        .build()
                                )
                                .maxNumResults(0L)
                                .rankingOptions(
                                    FileSearchTool.RankingOptions.builder()
                                        .ranker(FileSearchTool.RankingOptions.Ranker.AUTO)
                                        .scoreThreshold(0.0)
                                        .build()
                                )
                                .build()
                        )
                        .topP(1.0)
                        .maxOutputTokens(0L)
                        .previousResponseId("previous_response_id")
                        .reasoning(
                            Reasoning.builder()
                                .effort(ReasoningEffort.LOW)
                                .generateSummary(Reasoning.GenerateSummary.CONCISE)
                                .build()
                        )
                        .status(ResponseStatus.COMPLETED)
                        .text(
                            ResponseTextConfig.builder()
                                .format(ResponseFormatText.builder().build())
                                .build()
                        )
                        .truncation(Response.Truncation.AUTO)
                        .usage(
                            ResponseUsage.builder()
                                .inputTokens(0L)
                                .outputTokens(0L)
                                .outputTokensDetails(
                                    ResponseUsage.OutputTokensDetails.builder()
                                        .reasoningTokens(0L)
                                        .build()
                                )
                                .totalTokens(0L)
                                .build()
                        )
                        .user("user-1234")
                        .build()
                )
                .build()

        assertThat(responseCreatedEvent.response())
            .isEqualTo(
                Response.builder()
                    .id("id")
                    .createdAt(0.0)
                    .error(
                        ResponseError.builder()
                            .code(ResponseError.Code.SERVER_ERROR)
                            .message("message")
                            .build()
                    )
                    .incompleteDetails(
                        Response.IncompleteDetails.builder()
                            .reason(Response.IncompleteDetails.Reason.MAX_OUTPUT_TOKENS)
                            .build()
                    )
                    .instructions("instructions")
                    .metadata(
                        Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .model(ChatModel.O3_MINI)
                    .addOutput(
                        ResponseOutputMessage.builder()
                            .id("id")
                            .addContent(
                                ResponseOutputText.builder()
                                    .addAnnotation(
                                        ResponseOutputText.Annotation.FileCitation.builder()
                                            .fileId("file_id")
                                            .index(0L)
                                            .build()
                                    )
                                    .text("text")
                                    .build()
                            )
                            .status(ResponseOutputMessage.Status.IN_PROGRESS)
                            .build()
                    )
                    .parallelToolCalls(true)
                    .temperature(1.0)
                    .toolChoice(ToolChoiceOptions.NONE)
                    .addTool(
                        FileSearchTool.builder()
                            .addVectorStoreId("string")
                            .filters(
                                ComparisonFilter.builder()
                                    .key("key")
                                    .type(ComparisonFilter.Type.EQ)
                                    .value("string")
                                    .build()
                            )
                            .maxNumResults(0L)
                            .rankingOptions(
                                FileSearchTool.RankingOptions.builder()
                                    .ranker(FileSearchTool.RankingOptions.Ranker.AUTO)
                                    .scoreThreshold(0.0)
                                    .build()
                            )
                            .build()
                    )
                    .topP(1.0)
                    .maxOutputTokens(0L)
                    .previousResponseId("previous_response_id")
                    .reasoning(
                        Reasoning.builder()
                            .effort(ReasoningEffort.LOW)
                            .generateSummary(Reasoning.GenerateSummary.CONCISE)
                            .build()
                    )
                    .status(ResponseStatus.COMPLETED)
                    .text(
                        ResponseTextConfig.builder()
                            .format(ResponseFormatText.builder().build())
                            .build()
                    )
                    .truncation(Response.Truncation.AUTO)
                    .usage(
                        ResponseUsage.builder()
                            .inputTokens(0L)
                            .outputTokens(0L)
                            .outputTokensDetails(
                                ResponseUsage.OutputTokensDetails.builder()
                                    .reasoningTokens(0L)
                                    .build()
                            )
                            .totalTokens(0L)
                            .build()
                    )
                    .user("user-1234")
                    .build()
            )
    }
}
