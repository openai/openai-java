// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.ratelimits

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RateLimitListRateLimitsPageResponseTest {

    @Test
    fun create() {
        val rateLimitListRateLimitsPageResponse =
            RateLimitListRateLimitsPageResponse.builder()
                .addData(
                    ProjectRateLimit.builder()
                        .id("id")
                        .maxRequestsPer1Minute(0L)
                        .maxTokensPer1Minute(0L)
                        .model("model")
                        .batch1DayMaxInputTokens(0L)
                        .maxAudioMegabytesPer1Minute(0L)
                        .maxImagesPer1Minute(0L)
                        .maxRequestsPer1Day(0L)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(rateLimitListRateLimitsPageResponse.data())
            .containsExactly(
                ProjectRateLimit.builder()
                    .id("id")
                    .maxRequestsPer1Minute(0L)
                    .maxTokensPer1Minute(0L)
                    .model("model")
                    .batch1DayMaxInputTokens(0L)
                    .maxAudioMegabytesPer1Minute(0L)
                    .maxImagesPer1Minute(0L)
                    .maxRequestsPer1Day(0L)
                    .build()
            )
        assertThat(rateLimitListRateLimitsPageResponse.firstId()).isEqualTo("first_id")
        assertThat(rateLimitListRateLimitsPageResponse.hasMore()).isEqualTo(true)
        assertThat(rateLimitListRateLimitsPageResponse.lastId()).isEqualTo("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val rateLimitListRateLimitsPageResponse =
            RateLimitListRateLimitsPageResponse.builder()
                .addData(
                    ProjectRateLimit.builder()
                        .id("id")
                        .maxRequestsPer1Minute(0L)
                        .maxTokensPer1Minute(0L)
                        .model("model")
                        .batch1DayMaxInputTokens(0L)
                        .maxAudioMegabytesPer1Minute(0L)
                        .maxImagesPer1Minute(0L)
                        .maxRequestsPer1Day(0L)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedRateLimitListRateLimitsPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(rateLimitListRateLimitsPageResponse),
                jacksonTypeRef<RateLimitListRateLimitsPageResponse>(),
            )

        assertThat(roundtrippedRateLimitListRateLimitsPageResponse)
            .isEqualTo(rateLimitListRateLimitsPageResponse)
    }
}
