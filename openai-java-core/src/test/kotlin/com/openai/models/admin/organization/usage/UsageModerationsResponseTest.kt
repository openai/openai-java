// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.usage

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UsageModerationsResponseTest {

    @Test
    fun create() {
        val usageModerationsResponse =
            UsageModerationsResponse.builder()
                .addData(
                    UsageModerationsResponse.Data.builder()
                        .endTime(0L)
                        .addResult(
                            UsageModerationsResponse.Data.Result.OrganizationUsageCompletionsResult
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

        assertThat(usageModerationsResponse.data())
            .containsExactly(
                UsageModerationsResponse.Data.builder()
                    .endTime(0L)
                    .addResult(
                        UsageModerationsResponse.Data.Result.OrganizationUsageCompletionsResult
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
        assertThat(usageModerationsResponse.hasMore()).isEqualTo(true)
        assertThat(usageModerationsResponse.nextPage()).isEqualTo("next_page")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val usageModerationsResponse =
            UsageModerationsResponse.builder()
                .addData(
                    UsageModerationsResponse.Data.builder()
                        .endTime(0L)
                        .addResult(
                            UsageModerationsResponse.Data.Result.OrganizationUsageCompletionsResult
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

        val roundtrippedUsageModerationsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(usageModerationsResponse),
                jacksonTypeRef<UsageModerationsResponse>(),
            )

        assertThat(roundtrippedUsageModerationsResponse).isEqualTo(usageModerationsResponse)
    }
}
