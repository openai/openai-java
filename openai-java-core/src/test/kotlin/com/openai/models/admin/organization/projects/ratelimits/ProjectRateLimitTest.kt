// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.ratelimits

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectRateLimitTest {

    @Test
    fun create() {
        val projectRateLimit =
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

        assertThat(projectRateLimit.id()).isEqualTo("id")
        assertThat(projectRateLimit.maxRequestsPer1Minute()).isEqualTo(0L)
        assertThat(projectRateLimit.maxTokensPer1Minute()).isEqualTo(0L)
        assertThat(projectRateLimit.model()).isEqualTo("model")
        assertThat(projectRateLimit.batch1DayMaxInputTokens()).contains(0L)
        assertThat(projectRateLimit.maxAudioMegabytesPer1Minute()).contains(0L)
        assertThat(projectRateLimit.maxImagesPer1Minute()).contains(0L)
        assertThat(projectRateLimit.maxRequestsPer1Day()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val projectRateLimit =
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

        val roundtrippedProjectRateLimit =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(projectRateLimit),
                jacksonTypeRef<ProjectRateLimit>(),
            )

        assertThat(roundtrippedProjectRateLimit).isEqualTo(projectRateLimit)
    }
}
