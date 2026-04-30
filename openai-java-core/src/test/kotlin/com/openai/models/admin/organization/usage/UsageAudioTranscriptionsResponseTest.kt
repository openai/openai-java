// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.usage

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UsageAudioTranscriptionsResponseTest {

    @Test
    fun create() {
        val usageAudioTranscriptionsResponse =
            UsageAudioTranscriptionsResponse.builder()
                .addData(
                    UsageAudioTranscriptionsResponse.Data.builder()
                        .endTime(0L)
                        .addResult(
                            UsageAudioTranscriptionsResponse.Data.Result
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

        assertThat(usageAudioTranscriptionsResponse.data())
            .containsExactly(
                UsageAudioTranscriptionsResponse.Data.builder()
                    .endTime(0L)
                    .addResult(
                        UsageAudioTranscriptionsResponse.Data.Result
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
        assertThat(usageAudioTranscriptionsResponse.hasMore()).isEqualTo(true)
        assertThat(usageAudioTranscriptionsResponse.nextPage()).isEqualTo("next_page")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val usageAudioTranscriptionsResponse =
            UsageAudioTranscriptionsResponse.builder()
                .addData(
                    UsageAudioTranscriptionsResponse.Data.builder()
                        .endTime(0L)
                        .addResult(
                            UsageAudioTranscriptionsResponse.Data.Result
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

        val roundtrippedUsageAudioTranscriptionsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(usageAudioTranscriptionsResponse),
                jacksonTypeRef<UsageAudioTranscriptionsResponse>(),
            )

        assertThat(roundtrippedUsageAudioTranscriptionsResponse)
            .isEqualTo(usageAudioTranscriptionsResponse)
    }
}
