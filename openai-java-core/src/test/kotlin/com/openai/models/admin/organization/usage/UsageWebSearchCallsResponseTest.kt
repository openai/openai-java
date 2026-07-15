// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.usage

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UsageWebSearchCallsResponseTest {

    @Test
    fun create() {
        val usageWebSearchCallsResponse =
            UsageWebSearchCallsResponse.builder()
                .addData(
                    UsageWebSearchCallsResponse.Data.builder()
                        .endTime(0L)
                        .addResult(
                            UsageWebSearchCallsResponse.Data.Result
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

        assertThat(usageWebSearchCallsResponse.data())
            .containsExactly(
                UsageWebSearchCallsResponse.Data.builder()
                    .endTime(0L)
                    .addResult(
                        UsageWebSearchCallsResponse.Data.Result.OrganizationUsageCompletionsResult
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
        assertThat(usageWebSearchCallsResponse.hasMore()).isEqualTo(true)
        assertThat(usageWebSearchCallsResponse.nextPage()).contains("next_page")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val usageWebSearchCallsResponse =
            UsageWebSearchCallsResponse.builder()
                .addData(
                    UsageWebSearchCallsResponse.Data.builder()
                        .endTime(0L)
                        .addResult(
                            UsageWebSearchCallsResponse.Data.Result
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

        val roundtrippedUsageWebSearchCallsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(usageWebSearchCallsResponse),
                jacksonTypeRef<UsageWebSearchCallsResponse>(),
            )

        assertThat(roundtrippedUsageWebSearchCallsResponse).isEqualTo(usageWebSearchCallsResponse)
    }
}
