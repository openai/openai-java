// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseInputImageContentTest {

    @Test
    fun create() {
        val betaResponseInputImageContent =
            BetaResponseInputImageContent.builder()
                .detail(BetaResponseInputImageContent.Detail.LOW)
                .fileId("file-123")
                .imageUrl("https://example.com")
                .promptCacheBreakpoint(
                    BetaResponseInputImageContent.PromptCacheBreakpoint.builder().build()
                )
                .build()

        assertThat(betaResponseInputImageContent.detail())
            .contains(BetaResponseInputImageContent.Detail.LOW)
        assertThat(betaResponseInputImageContent.fileId()).contains("file-123")
        assertThat(betaResponseInputImageContent.imageUrl()).contains("https://example.com")
        assertThat(betaResponseInputImageContent.promptCacheBreakpoint())
            .contains(BetaResponseInputImageContent.PromptCacheBreakpoint.builder().build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputImageContent =
            BetaResponseInputImageContent.builder()
                .detail(BetaResponseInputImageContent.Detail.LOW)
                .fileId("file-123")
                .imageUrl("https://example.com")
                .promptCacheBreakpoint(
                    BetaResponseInputImageContent.PromptCacheBreakpoint.builder().build()
                )
                .build()

        val roundtrippedBetaResponseInputImageContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputImageContent),
                jacksonTypeRef<BetaResponseInputImageContent>(),
            )

        assertThat(roundtrippedBetaResponseInputImageContent)
            .isEqualTo(betaResponseInputImageContent)
    }
}
