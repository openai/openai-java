// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.ChatModel
import com.openai.models.ComparisonFilter
import com.openai.models.Metadata
import com.openai.models.Reasoning
import com.openai.models.ReasoningEffort
import com.openai.models.ResponseFormatText
import com.openai.models.responses.FileSearchTool
import com.openai.models.responses.ResponseCreateParams
import com.openai.models.responses.ResponseDeleteParams
import com.openai.models.responses.ResponseIncludable
import com.openai.models.responses.ResponseRetrieveParams
import com.openai.models.responses.ResponseTextConfig
import com.openai.models.responses.ToolChoiceOptions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ResponseServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val responseServiceAsync = client.responses()

        val responseFuture =
            responseServiceAsync.create(
                ResponseCreateParams.builder()
                    .input("string")
                    .model(ChatModel.O3_MINI)
                    .addInclude(ResponseIncludable.FILE_SEARCH_CALL_RESULTS)
                    .instructions("instructions")
                    .maxOutputTokens(0L)
                    .metadata(
                        Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .parallelToolCalls(true)
                    .previousResponseId("previous_response_id")
                    .reasoning(
                        Reasoning.builder()
                            .effort(ReasoningEffort.LOW)
                            .generateSummary(Reasoning.GenerateSummary.CONCISE)
                            .build()
                    )
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
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Test
    fun createStreaming() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val responseServiceAsync = client.responses()

        val responseStreamResponse =
            responseServiceAsync.createStreaming(
                ResponseCreateParams.builder()
                    .input("string")
                    .model(ChatModel.O3_MINI)
                    .addInclude(ResponseIncludable.FILE_SEARCH_CALL_RESULTS)
                    .instructions("instructions")
                    .maxOutputTokens(0L)
                    .metadata(
                        Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .parallelToolCalls(true)
                    .previousResponseId("previous_response_id")
                    .reasoning(
                        Reasoning.builder()
                            .effort(ReasoningEffort.LOW)
                            .generateSummary(Reasoning.GenerateSummary.CONCISE)
                            .build()
                    )
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
            )

        val onCompleteFuture =
            responseStreamResponse.subscribe { response -> response.validate() }.onCompleteFuture()
        onCompleteFuture.get()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val responseServiceAsync = client.responses()

        val responseFuture =
            responseServiceAsync.retrieve(
                ResponseRetrieveParams.builder()
                    .responseId("resp_677efb5139a88190b512bc3fef8e535d")
                    .addInclude(ResponseIncludable.FILE_SEARCH_CALL_RESULTS)
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val responseServiceAsync = client.responses()

        val future =
            responseServiceAsync.delete(
                ResponseDeleteParams.builder()
                    .responseId("resp_677efb5139a88190b512bc3fef8e535d")
                    .build()
            )

        val response = future.get()
    }
}
