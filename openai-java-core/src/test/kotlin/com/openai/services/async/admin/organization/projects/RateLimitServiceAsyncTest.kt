// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.projects

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.projects.ratelimits.RateLimitUpdateRateLimitParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class RateLimitServiceAsyncTest {

    @Test
    fun listRateLimits() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val rateLimitServiceAsync = client.admin().organization().projects().rateLimits()

        val pageFuture = rateLimitServiceAsync.listRateLimits("project_id")

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun updateRateLimit() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val rateLimitServiceAsync = client.admin().organization().projects().rateLimits()

        val projectRateLimitFuture =
            rateLimitServiceAsync.updateRateLimit(
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

        val projectRateLimit = projectRateLimitFuture.get()
        projectRateLimit.validate()
    }
}
