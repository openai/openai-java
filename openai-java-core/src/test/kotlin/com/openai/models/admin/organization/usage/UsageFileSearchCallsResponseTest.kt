// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.usage

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UsageFileSearchCallsResponseTest {

    @Test
    fun create() {
        val usageFileSearchCallsResponse =
            UsageFileSearchCallsResponse.builder()
                .addData(
                    UsageFileSearchCallsResponse.Data.builder()
                        .endTime(0L)
                        .addResult(
                            UsageFileSearchCallsResponse.Data.Result
                                .OrganizationUsageCompletionsResult
                                .builder()
                                .inputTokens(0L)
                                .numModelRequests(0L)
                                .outputTokens(0L)
                                .apiKeyId("api_key_id")
                                .batch(true)
                                .inputAudioTokens(0L)
                                .inputCacheWriteTokens(0L)
                                .inputCachedAudioTokens(0L)
                                .inputCachedImageTokens(0L)
                                .inputCachedTextTokens(0L)
                                .inputCachedTokens(0L)
                                .inputImageTokens(0L)
                                .inputTextTokens(0L)
                                .inputUncachedTokens(0L)
                                .model("model")
                                .outputAudioTokens(0L)
                                .outputImageTokens(0L)
                                .outputTextTokens(0L)
                                .projectId("project_id")
                                .serviceTier("service_tier")
                                .userId("user_id")
                                .build()
                        )
                        .startTime(0L)
                        .build()
                )
                .hasMore(true)
                .nextPage("next_page")
                .build()

        assertThat(usageFileSearchCallsResponse.data())
            .containsExactly(
                UsageFileSearchCallsResponse.Data.builder()
                    .endTime(0L)
                    .addResult(
                        UsageFileSearchCallsResponse.Data.Result.OrganizationUsageCompletionsResult
                            .builder()
                            .inputTokens(0L)
                            .numModelRequests(0L)
                            .outputTokens(0L)
                            .apiKeyId("api_key_id")
                            .batch(true)
                            .inputAudioTokens(0L)
                            .inputCacheWriteTokens(0L)
                            .inputCachedAudioTokens(0L)
                            .inputCachedImageTokens(0L)
                            .inputCachedTextTokens(0L)
                            .inputCachedTokens(0L)
                            .inputImageTokens(0L)
                            .inputTextTokens(0L)
                            .inputUncachedTokens(0L)
                            .model("model")
                            .outputAudioTokens(0L)
                            .outputImageTokens(0L)
                            .outputTextTokens(0L)
                            .projectId("project_id")
                            .serviceTier("service_tier")
                            .userId("user_id")
                            .build()
                    )
                    .startTime(0L)
                    .build()
            )
        assertThat(usageFileSearchCallsResponse.hasMore()).isEqualTo(true)
        assertThat(usageFileSearchCallsResponse.nextPage()).contains("next_page")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val usageFileSearchCallsResponse =
            UsageFileSearchCallsResponse.builder()
                .addData(
                    UsageFileSearchCallsResponse.Data.builder()
                        .endTime(0L)
                        .addResult(
                            UsageFileSearchCallsResponse.Data.Result
                                .OrganizationUsageCompletionsResult
                                .builder()
                                .inputTokens(0L)
                                .numModelRequests(0L)
                                .outputTokens(0L)
                                .apiKeyId("api_key_id")
                                .batch(true)
                                .inputAudioTokens(0L)
                                .inputCacheWriteTokens(0L)
                                .inputCachedAudioTokens(0L)
                                .inputCachedImageTokens(0L)
                                .inputCachedTextTokens(0L)
                                .inputCachedTokens(0L)
                                .inputImageTokens(0L)
                                .inputTextTokens(0L)
                                .inputUncachedTokens(0L)
                                .model("model")
                                .outputAudioTokens(0L)
                                .outputImageTokens(0L)
                                .outputTextTokens(0L)
                                .projectId("project_id")
                                .serviceTier("service_tier")
                                .userId("user_id")
                                .build()
                        )
                        .startTime(0L)
                        .build()
                )
                .hasMore(true)
                .nextPage("next_page")
                .build()

        val roundtrippedUsageFileSearchCallsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(usageFileSearchCallsResponse),
                jacksonTypeRef<UsageFileSearchCallsResponse>(),
            )

        assertThat(roundtrippedUsageFileSearchCallsResponse).isEqualTo(usageFileSearchCallsResponse)
    }
}
