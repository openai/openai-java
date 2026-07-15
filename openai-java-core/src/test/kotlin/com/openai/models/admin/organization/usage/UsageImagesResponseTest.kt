// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.usage

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UsageImagesResponseTest {

    @Test
    fun create() {
        val usageImagesResponse =
            UsageImagesResponse.builder()
                .addData(
                    UsageImagesResponse.Data.builder()
                        .endTime(0L)
                        .addResult(
                            UsageImagesResponse.Data.Result.OrganizationUsageCompletionsResult
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

        assertThat(usageImagesResponse.data())
            .containsExactly(
                UsageImagesResponse.Data.builder()
                    .endTime(0L)
                    .addResult(
                        UsageImagesResponse.Data.Result.OrganizationUsageCompletionsResult.builder()
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
        assertThat(usageImagesResponse.hasMore()).isEqualTo(true)
        assertThat(usageImagesResponse.nextPage()).contains("next_page")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val usageImagesResponse =
            UsageImagesResponse.builder()
                .addData(
                    UsageImagesResponse.Data.builder()
                        .endTime(0L)
                        .addResult(
                            UsageImagesResponse.Data.Result.OrganizationUsageCompletionsResult
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

        val roundtrippedUsageImagesResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(usageImagesResponse),
                jacksonTypeRef<UsageImagesResponse>(),
            )

        assertThat(roundtrippedUsageImagesResponse).isEqualTo(usageImagesResponse)
    }
}
