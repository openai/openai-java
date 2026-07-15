// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.ratelimits

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RateLimitUpdateRateLimitParamsTest {

    @Test
    fun create() {
        RateLimitUpdateRateLimitParams.builder()
            .projectId("project_id")
            .rateLimitId("rate_limit_id")
            .batch1DayMaxInputTokens(0L)
            .maxAudioMegabytesPer1Minute(0L)
            .maxImagesPer1Minute(0L)
            .maxRequestsPer1Day(0L)
            .maxRequestsPer1Minute(0L)
            .maxTokensPer1Minute(0L)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            RateLimitUpdateRateLimitParams.builder()
                .projectId("project_id")
                .rateLimitId("rate_limit_id")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("project_id")
        assertThat(params._pathParam(1)).isEqualTo("rate_limit_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            RateLimitUpdateRateLimitParams.builder()
                .projectId("project_id")
                .rateLimitId("rate_limit_id")
                .batch1DayMaxInputTokens(0L)
                .maxAudioMegabytesPer1Minute(0L)
                .maxImagesPer1Minute(0L)
                .maxRequestsPer1Day(0L)
                .maxRequestsPer1Minute(0L)
                .maxTokensPer1Minute(0L)
                .build()

        val body = params._body()

        assertThat(body.batch1DayMaxInputTokens()).contains(0L)
        assertThat(body.maxAudioMegabytesPer1Minute()).contains(0L)
        assertThat(body.maxImagesPer1Minute()).contains(0L)
        assertThat(body.maxRequestsPer1Day()).contains(0L)
        assertThat(body.maxRequestsPer1Minute()).contains(0L)
        assertThat(body.maxTokensPer1Minute()).contains(0L)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            RateLimitUpdateRateLimitParams.builder()
                .projectId("project_id")
                .rateLimitId("rate_limit_id")
                .build()

        val body = params._body()
    }
}
