// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.usage

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UsageCodeInterpreterSessionsResponseTest {

    @Test
    fun create() {
        val usageCodeInterpreterSessionsResponse =
            UsageCodeInterpreterSessionsResponse.builder()
                .addData(
                    UsageCodeInterpreterSessionsResponse.Data.builder()
                        .endTime(0L)
                        .addResult(
                            UsageCodeInterpreterSessionsResponse.Data.Result
                                .OrganizationUsageCompletionsResult
                                .builder()
                                .inputTokens(0L)
                                .numModelRequests(0L)
                                .outputTokens(0L)
                                .apiKeyId("api_key_id")
                                .batch(true)
                                .inputAudioTokens(0L)
                                .inputCachedTokens(0L)
                                .model("model")
                                .outputAudioTokens(0L)
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

        assertThat(usageCodeInterpreterSessionsResponse.data())
            .containsExactly(
                UsageCodeInterpreterSessionsResponse.Data.builder()
                    .endTime(0L)
                    .addResult(
                        UsageCodeInterpreterSessionsResponse.Data.Result
                            .OrganizationUsageCompletionsResult
                            .builder()
                            .inputTokens(0L)
                            .numModelRequests(0L)
                            .outputTokens(0L)
                            .apiKeyId("api_key_id")
                            .batch(true)
                            .inputAudioTokens(0L)
                            .inputCachedTokens(0L)
                            .model("model")
                            .outputAudioTokens(0L)
                            .projectId("project_id")
                            .serviceTier("service_tier")
                            .userId("user_id")
                            .build()
                    )
                    .startTime(0L)
                    .build()
            )
        assertThat(usageCodeInterpreterSessionsResponse.hasMore()).isEqualTo(true)
        assertThat(usageCodeInterpreterSessionsResponse.nextPage()).contains("next_page")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val usageCodeInterpreterSessionsResponse =
            UsageCodeInterpreterSessionsResponse.builder()
                .addData(
                    UsageCodeInterpreterSessionsResponse.Data.builder()
                        .endTime(0L)
                        .addResult(
                            UsageCodeInterpreterSessionsResponse.Data.Result
                                .OrganizationUsageCompletionsResult
                                .builder()
                                .inputTokens(0L)
                                .numModelRequests(0L)
                                .outputTokens(0L)
                                .apiKeyId("api_key_id")
                                .batch(true)
                                .inputAudioTokens(0L)
                                .inputCachedTokens(0L)
                                .model("model")
                                .outputAudioTokens(0L)
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

        val roundtrippedUsageCodeInterpreterSessionsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(usageCodeInterpreterSessionsResponse),
                jacksonTypeRef<UsageCodeInterpreterSessionsResponse>(),
            )

        assertThat(roundtrippedUsageCodeInterpreterSessionsResponse)
            .isEqualTo(usageCodeInterpreterSessionsResponse)
    }
}
