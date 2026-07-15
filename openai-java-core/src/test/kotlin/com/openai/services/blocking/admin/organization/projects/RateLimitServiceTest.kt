// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.admin.organization.projects.ratelimits.RateLimitUpdateRateLimitParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class RateLimitServiceTest {

    @Test
    fun listRateLimits() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val rateLimitService = client.admin().organization().projects().rateLimits()

        val page = rateLimitService.listRateLimits("project_id")

        page.response().validate()
    }

    @Test
    fun updateRateLimit() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val rateLimitService = client.admin().organization().projects().rateLimits()

        val projectRateLimit =
            rateLimitService.updateRateLimit(
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
            )

        projectRateLimit.validate()
    }
}
