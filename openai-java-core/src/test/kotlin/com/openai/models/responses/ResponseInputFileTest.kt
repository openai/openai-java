// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.PromptCacheBreakpointTtl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseInputFileTest {

    @Test
    fun createAndRoundtrip() {
        val responseInputFile =
            ResponseInputFile.builder()
                .detail(ResponseInputFile.Detail.AUTO)
                .fileData("file_data")
                .fileId("file_id")
                .fileUrl("https://example.com")
                .filename("filename")
                .promptCacheBreakpoint(
                    ResponseInputFile.PromptCacheBreakpoint.builder()
                        .ttl(PromptCacheBreakpointTtl._30M)
                        .build()
                )
                .build()

        assertThat(responseInputFile.detail()).contains(ResponseInputFile.Detail.AUTO)
        assertThat(responseInputFile.fileData()).contains("file_data")
        assertThat(responseInputFile.fileId()).contains("file_id")
        assertThat(responseInputFile.fileUrl()).contains("https://example.com")
        assertThat(responseInputFile.filename()).contains("filename")
        assertThat(responseInputFile.promptCacheBreakpoint())
            .contains(
                ResponseInputFile.PromptCacheBreakpoint.builder()
                    .ttl(PromptCacheBreakpointTtl._30M)
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedResponseInputFile =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputFile),
                jacksonTypeRef<ResponseInputFile>(),
            )

        assertThat(roundtrippedResponseInputFile).isEqualTo(responseInputFile)
    }
}
