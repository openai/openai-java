// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.openai.core.JsonValue
import com.openai.models.ChatModel
import com.openai.models.ComparisonFilter
import com.openai.models.Reasoning
import com.openai.models.ReasoningEffort
import com.openai.models.ResponseFormatText
import com.openai.models.ResponsesModel
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCreateParamsTest {

    @Test
    fun create() {
        ResponseCreateParams.builder()
            .input("string")
            .model(ChatModel.GPT_4O)
            .addInclude(ResponseIncludable.FILE_SEARCH_CALL_RESULTS)
            .instructions("instructions")
            .maxOutputTokens(0L)
            .metadata(
                ResponseCreateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .parallelToolCalls(true)
            .previousResponseId("previous_response_id")
            .reasoning(
                Reasoning.builder()
                    .effort(ReasoningEffort.LOW)
                    .generateSummary(Reasoning.GenerateSummary.AUTO)
                    .summary(Reasoning.Summary.AUTO)
                    .build()
            )
            .serviceTier(ResponseCreateParams.ServiceTier.AUTO)
            .store(true)
            .temperature(1.0)
            .text(ResponseTextConfig.builder().format(ResponseFormatText.builder().build()).build())
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
            .truncation(ResponseCreateParams.Truncation.AUTO)
            .user("user-1234")
            .build()
    }

    @Test
    fun body() {
        val params =
            ResponseCreateParams.builder()
                .input("string")
                .model(ChatModel.GPT_4O)
                .addInclude(ResponseIncludable.FILE_SEARCH_CALL_RESULTS)
                .instructions("instructions")
                .maxOutputTokens(0L)
                .metadata(
                    ResponseCreateParams.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .parallelToolCalls(true)
                .previousResponseId("previous_response_id")
                .reasoning(
                    Reasoning.builder()
                        .effort(ReasoningEffort.LOW)
                        .generateSummary(Reasoning.GenerateSummary.AUTO)
                        .summary(Reasoning.Summary.AUTO)
                        .build()
                )
                .serviceTier(ResponseCreateParams.ServiceTier.AUTO)
                .store(true)
                .temperature(1.0)
                .text(
                    ResponseTextConfig.builder()
                        .format(ResponseFormatText.builder().build())
                        .build()
                )
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
                .truncation(ResponseCreateParams.Truncation.AUTO)
                .user("user-1234")
                .build()

        val body = params._body()

        assertThat(body.input()).isEqualTo(ResponseCreateParams.Input.ofText("string"))
        assertThat(body.model()).isEqualTo(ResponsesModel.ofChat(ChatModel.GPT_4O))
        assertThat(body.include().getOrNull())
            .containsExactly(ResponseIncludable.FILE_SEARCH_CALL_RESULTS)
        assertThat(body.instructions()).contains("instructions")
        assertThat(body.maxOutputTokens()).contains(0L)
        assertThat(body.metadata())
            .contains(
                ResponseCreateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.parallelToolCalls()).contains(true)
        assertThat(body.previousResponseId()).contains("previous_response_id")
        assertThat(body.reasoning())
            .contains(
                Reasoning.builder()
                    .effort(ReasoningEffort.LOW)
                    .generateSummary(Reasoning.GenerateSummary.AUTO)
                    .summary(Reasoning.Summary.AUTO)
                    .build()
            )
        assertThat(body.serviceTier()).contains(ResponseCreateParams.ServiceTier.AUTO)
        assertThat(body.store()).contains(true)
        assertThat(body.temperature()).contains(1.0)
        assertThat(body.text())
            .contains(
                ResponseTextConfig.builder().format(ResponseFormatText.builder().build()).build()
            )
        assertThat(body.toolChoice())
            .contains(ResponseCreateParams.ToolChoice.ofOptions(ToolChoiceOptions.NONE))
        assertThat(body.tools().getOrNull())
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
        assertThat(body.topP()).contains(1.0)
        assertThat(body.truncation()).contains(ResponseCreateParams.Truncation.AUTO)
        assertThat(body.user()).contains("user-1234")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ResponseCreateParams.builder().input("string").model(ChatModel.GPT_4O).build()

        val body = params._body()

        assertThat(body.input()).isEqualTo(ResponseCreateParams.Input.ofText("string"))
        assertThat(body.model()).isEqualTo(ResponsesModel.ofChat(ChatModel.GPT_4O))
    }
}
