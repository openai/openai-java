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

internal class ResponseTest {

    @Test
    fun create() {
        val response =
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
                        .inputTokensDetails(
                            ResponseUsage.InputTokensDetails.builder().cachedTokens(0L).build()
                        )
                        .outputTokens(0L)
                        .outputTokensDetails(
                            ResponseUsage.OutputTokensDetails.builder().reasoningTokens(0L).build()
                        )
                        .totalTokens(0L)
                        .build()
                )
                .user("user-1234")
                .build()

        assertThat(response.id()).isEqualTo("id")
        assertThat(response.createdAt()).isEqualTo(0.0)
        assertThat(response.error())
            .contains(
                ResponseError.builder()
                    .code(ResponseError.Code.SERVER_ERROR)
                    .message("message")
                    .build()
            )
        assertThat(response.incompleteDetails())
            .contains(
                Response.IncompleteDetails.builder()
                    .reason(Response.IncompleteDetails.Reason.MAX_OUTPUT_TOKENS)
                    .build()
            )
        assertThat(response.instructions()).contains("instructions")
        assertThat(response.metadata())
            .contains(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
        assertThat(response.model()).isEqualTo(ChatModel.O3_MINI)
        assertThat(response.output())
            .containsExactly(
                ResponseOutputItem.ofMessage(
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
            )
        assertThat(response.parallelToolCalls()).isEqualTo(true)
        assertThat(response.temperature()).contains(1.0)
        assertThat(response.toolChoice())
            .isEqualTo(Response.ToolChoice.ofOptions(ToolChoiceOptions.NONE))
        assertThat(response.tools())
            .containsExactly(
                Tool.ofFileSearch(
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
            )
        assertThat(response.topP()).contains(1.0)
        assertThat(response.maxOutputTokens()).contains(0L)
        assertThat(response.previousResponseId()).contains("previous_response_id")
        assertThat(response.reasoning())
            .contains(
                Reasoning.builder()
                    .effort(ReasoningEffort.LOW)
                    .generateSummary(Reasoning.GenerateSummary.CONCISE)
                    .build()
            )
        assertThat(response.status()).contains(ResponseStatus.COMPLETED)
        assertThat(response.text())
            .contains(
                ResponseTextConfig.builder().format(ResponseFormatText.builder().build()).build()
            )
        assertThat(response.truncation()).contains(Response.Truncation.AUTO)
        assertThat(response.usage())
            .contains(
                ResponseUsage.builder()
                    .inputTokens(0L)
                    .inputTokensDetails(
                        ResponseUsage.InputTokensDetails.builder().cachedTokens(0L).build()
                    )
                    .outputTokens(0L)
                    .outputTokensDetails(
                        ResponseUsage.OutputTokensDetails.builder().reasoningTokens(0L).build()
                    )
                    .totalTokens(0L)
                    .build()
            )
        assertThat(response.user()).contains("user-1234")
    }
}
