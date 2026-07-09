// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseInputFileContentTest {

    @Test
    fun create() {
        val betaResponseInputFileContent =
            BetaResponseInputFileContent.builder()
                .detail(BetaResponseInputFileContent.Detail.AUTO)
                .fileData("file_data")
                .fileId("file-123")
                .fileUrl("https://example.com")
                .filename("filename")
                .promptCacheBreakpoint(
                    BetaResponseInputFileContent.PromptCacheBreakpoint.builder().build()
                )
                .build()

        assertThat(betaResponseInputFileContent.detail())
            .contains(BetaResponseInputFileContent.Detail.AUTO)
        assertThat(betaResponseInputFileContent.fileData()).contains("file_data")
        assertThat(betaResponseInputFileContent.fileId()).contains("file-123")
        assertThat(betaResponseInputFileContent.fileUrl()).contains("https://example.com")
        assertThat(betaResponseInputFileContent.filename()).contains("filename")
        assertThat(betaResponseInputFileContent.promptCacheBreakpoint())
            .contains(BetaResponseInputFileContent.PromptCacheBreakpoint.builder().build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputFileContent =
            BetaResponseInputFileContent.builder()
                .detail(BetaResponseInputFileContent.Detail.AUTO)
                .fileData("file_data")
                .fileId("file-123")
                .fileUrl("https://example.com")
                .filename("filename")
                .promptCacheBreakpoint(
                    BetaResponseInputFileContent.PromptCacheBreakpoint.builder().build()
                )
                .build()

        val roundtrippedBetaResponseInputFileContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputFileContent),
                jacksonTypeRef<BetaResponseInputFileContent>(),
            )

        assertThat(roundtrippedBetaResponseInputFileContent).isEqualTo(betaResponseInputFileContent)
    }
}
