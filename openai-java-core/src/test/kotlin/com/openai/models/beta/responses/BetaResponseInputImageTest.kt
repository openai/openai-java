// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseInputImageTest {

    @Test
    fun create() {
        val betaResponseInputImage =
            BetaResponseInputImage.builder()
                .detail(BetaResponseInputImage.Detail.LOW)
                .fileId("file_id")
                .imageUrl("https://example.com")
                .promptCacheBreakpoint(
                    BetaResponseInputImage.PromptCacheBreakpoint.builder().build()
                )
                .build()

        assertThat(betaResponseInputImage.detail()).isEqualTo(BetaResponseInputImage.Detail.LOW)
        assertThat(betaResponseInputImage.fileId()).contains("file_id")
        assertThat(betaResponseInputImage.imageUrl()).contains("https://example.com")
        assertThat(betaResponseInputImage.promptCacheBreakpoint())
            .contains(BetaResponseInputImage.PromptCacheBreakpoint.builder().build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputImage =
            BetaResponseInputImage.builder()
                .detail(BetaResponseInputImage.Detail.LOW)
                .fileId("file_id")
                .imageUrl("https://example.com")
                .promptCacheBreakpoint(
                    BetaResponseInputImage.PromptCacheBreakpoint.builder().build()
                )
                .build()

        val roundtrippedBetaResponseInputImage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputImage),
                jacksonTypeRef<BetaResponseInputImage>(),
            )

        assertThat(roundtrippedBetaResponseInputImage).isEqualTo(betaResponseInputImage)
    }
}
