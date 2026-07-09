// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseInputFileTest {

    @Test
    fun create() {
        val betaResponseInputFile =
            BetaResponseInputFile.builder()
                .detail(BetaResponseInputFile.Detail.AUTO)
                .fileData("file_data")
                .fileId("file_id")
                .fileUrl("https://example.com")
                .filename("filename")
                .promptCacheBreakpoint(
                    BetaResponseInputFile.PromptCacheBreakpoint.builder().build()
                )
                .build()

        assertThat(betaResponseInputFile.detail()).contains(BetaResponseInputFile.Detail.AUTO)
        assertThat(betaResponseInputFile.fileData()).contains("file_data")
        assertThat(betaResponseInputFile.fileId()).contains("file_id")
        assertThat(betaResponseInputFile.fileUrl()).contains("https://example.com")
        assertThat(betaResponseInputFile.filename()).contains("filename")
        assertThat(betaResponseInputFile.promptCacheBreakpoint())
            .contains(BetaResponseInputFile.PromptCacheBreakpoint.builder().build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputFile =
            BetaResponseInputFile.builder()
                .detail(BetaResponseInputFile.Detail.AUTO)
                .fileData("file_data")
                .fileId("file_id")
                .fileUrl("https://example.com")
                .filename("filename")
                .promptCacheBreakpoint(
                    BetaResponseInputFile.PromptCacheBreakpoint.builder().build()
                )
                .build()

        val roundtrippedBetaResponseInputFile =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputFile),
                jacksonTypeRef<BetaResponseInputFile>(),
            )

        assertThat(roundtrippedBetaResponseInputFile).isEqualTo(betaResponseInputFile)
    }
}
