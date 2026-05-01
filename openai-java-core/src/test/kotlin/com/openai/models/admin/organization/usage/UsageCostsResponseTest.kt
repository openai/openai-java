// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.usage

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UsageCostsResponseTest {

    @Test
    fun create() {
        val usageCostsResponse =
            UsageCostsResponse.builder()
                .addData(
                    UsageCostsResponse.Data.builder()
                        .endTime(0L)
                        .addResult(
                            UsageCostsResponse.Data.Result.OrganizationUsageCompletionsResult
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

        assertThat(usageCostsResponse.data())
            .containsExactly(
                UsageCostsResponse.Data.builder()
                    .endTime(0L)
                    .addResult(
                        UsageCostsResponse.Data.Result.OrganizationUsageCompletionsResult.builder()
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
        assertThat(usageCostsResponse.hasMore()).isEqualTo(true)
        assertThat(usageCostsResponse.nextPage()).contains("next_page")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val usageCostsResponse =
            UsageCostsResponse.builder()
                .addData(
                    UsageCostsResponse.Data.builder()
                        .endTime(0L)
                        .addResult(
                            UsageCostsResponse.Data.Result.OrganizationUsageCompletionsResult
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

        val roundtrippedUsageCostsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(usageCostsResponse),
                jacksonTypeRef<UsageCostsResponse>(),
            )

        assertThat(roundtrippedUsageCostsResponse).isEqualTo(usageCostsResponse)
    }
}
