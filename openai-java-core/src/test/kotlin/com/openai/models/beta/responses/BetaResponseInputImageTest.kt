// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.PromptCacheBreakpointTtl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseInputImageTest {

    @Test
    fun createAndRoundtrip() {
        val betaResponseInputImage =
            BetaResponseInputImage.builder()
                .detail(BetaResponseInputImage.Detail.LOW)
                .fileId("file_id")
                .imageUrl("https://example.com")
                .promptCacheBreakpoint(
                    BetaResponseInputImage.PromptCacheBreakpoint.builder()
                        .ttl(PromptCacheBreakpointTtl._30M)
                        .build()
                )
                .build()

        assertThat(betaResponseInputImage.detail()).isEqualTo(BetaResponseInputImage.Detail.LOW)
        assertThat(betaResponseInputImage.fileId()).contains("file_id")
        assertThat(betaResponseInputImage.imageUrl()).contains("https://example.com")
        assertThat(betaResponseInputImage.promptCacheBreakpoint())
            .contains(
                BetaResponseInputImage.PromptCacheBreakpoint.builder()
                    .ttl(PromptCacheBreakpointTtl._30M)
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedBetaResponseInputImage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputImage),
                jacksonTypeRef<BetaResponseInputImage>(),
            )

        assertThat(roundtrippedBetaResponseInputImage).isEqualTo(betaResponseInputImage)
    }
}
