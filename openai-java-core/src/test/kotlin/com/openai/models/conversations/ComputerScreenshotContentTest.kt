// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.conversations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.PromptCacheBreakpointTtl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ComputerScreenshotContentTest {

    @Test
    fun createAndRoundtrip() {
        val computerScreenshotContent =
            ComputerScreenshotContent.builder()
                .detail(ComputerScreenshotContent.Detail.LOW)
                .fileId("file_id")
                .imageUrl("https://example.com")
                .promptCacheBreakpoint(
                    ComputerScreenshotContent.PromptCacheBreakpoint.builder()
                        .ttl(PromptCacheBreakpointTtl._30M)
                        .build()
                )
                .build()

        assertThat(computerScreenshotContent.detail())
            .isEqualTo(ComputerScreenshotContent.Detail.LOW)
        assertThat(computerScreenshotContent.fileId()).contains("file_id")
        assertThat(computerScreenshotContent.imageUrl()).contains("https://example.com")
        assertThat(computerScreenshotContent.promptCacheBreakpoint())
            .contains(
                ComputerScreenshotContent.PromptCacheBreakpoint.builder()
                    .ttl(PromptCacheBreakpointTtl._30M)
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedComputerScreenshotContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(computerScreenshotContent),
                jacksonTypeRef<ComputerScreenshotContent>(),
            )

        assertThat(roundtrippedComputerScreenshotContent).isEqualTo(computerScreenshotContent)
    }
}
