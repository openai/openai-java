// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.usage

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UsageVectorStoresResponseTest {

    @Test
    fun create() {
        val usageVectorStoresResponse =
            UsageVectorStoresResponse.builder()
                .addData(
                    UsageVectorStoresResponse.Data.builder()
                        .endTime(0L)
                        .addResult(
                            UsageVectorStoresResponse.Data.Result.OrganizationUsageCompletionsResult
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

        assertThat(usageVectorStoresResponse.data())
            .containsExactly(
                UsageVectorStoresResponse.Data.builder()
                    .endTime(0L)
                    .addResult(
                        UsageVectorStoresResponse.Data.Result.OrganizationUsageCompletionsResult
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
        assertThat(usageVectorStoresResponse.hasMore()).isEqualTo(true)
        assertThat(usageVectorStoresResponse.nextPage()).isEqualTo("next_page")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val usageVectorStoresResponse =
            UsageVectorStoresResponse.builder()
                .addData(
                    UsageVectorStoresResponse.Data.builder()
                        .endTime(0L)
                        .addResult(
                            UsageVectorStoresResponse.Data.Result.OrganizationUsageCompletionsResult
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

        val roundtrippedUsageVectorStoresResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(usageVectorStoresResponse),
                jacksonTypeRef<UsageVectorStoresResponse>(),
            )

        assertThat(roundtrippedUsageVectorStoresResponse).isEqualTo(usageVectorStoresResponse)
    }
}
