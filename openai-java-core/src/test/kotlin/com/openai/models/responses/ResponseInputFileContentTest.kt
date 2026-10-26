// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.PromptCacheBreakpointTtl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseInputFileContentTest {

    @Test
    fun createAndRoundtrip() {
        val responseInputFileContent =
            ResponseInputFileContent.builder()
                .detail(ResponseInputFileContent.Detail.AUTO)
                .fileData("file_data")
                .fileId("file-123")
                .fileUrl("https://example.com")
                .filename("filename")
                .promptCacheBreakpoint(
                    ResponseInputFileContent.PromptCacheBreakpoint.builder()
                        .ttl(PromptCacheBreakpointTtl._30M)
                        .build()
                )
                .build()

        assertThat(responseInputFileContent.detail()).contains(ResponseInputFileContent.Detail.AUTO)
        assertThat(responseInputFileContent.fileData()).contains("file_data")
        assertThat(responseInputFileContent.fileId()).contains("file-123")
        assertThat(responseInputFileContent.fileUrl()).contains("https://example.com")
        assertThat(responseInputFileContent.filename()).contains("filename")
        assertThat(responseInputFileContent.promptCacheBreakpoint())
            .contains(
                ResponseInputFileContent.PromptCacheBreakpoint.builder()
                    .ttl(PromptCacheBreakpointTtl._30M)
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedResponseInputFileContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputFileContent),
                jacksonTypeRef<ResponseInputFileContent>(),
            )

        assertThat(roundtrippedResponseInputFileContent).isEqualTo(responseInputFileContent)
    }
}
