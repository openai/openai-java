// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseInputFileContentTest {

    @Test
    fun create() {
        val responseInputFileContent =
            ResponseInputFileContent.builder()
                .detail(ResponseInputFileContent.Detail.AUTO)
                .fileData("file_data")
                .fileId("file-123")
                .fileUrl("https://example.com")
                .filename("filename")
                .promptCacheBreakpoint(
                    ResponseInputFileContent.PromptCacheBreakpoint.builder().build()
                )
                .build()

        assertThat(responseInputFileContent.detail()).contains(ResponseInputFileContent.Detail.AUTO)
        assertThat(responseInputFileContent.fileData()).contains("file_data")
        assertThat(responseInputFileContent.fileId()).contains("file-123")
        assertThat(responseInputFileContent.fileUrl()).contains("https://example.com")
        assertThat(responseInputFileContent.filename()).contains("filename")
        assertThat(responseInputFileContent.promptCacheBreakpoint())
            .contains(ResponseInputFileContent.PromptCacheBreakpoint.builder().build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseInputFileContent =
            ResponseInputFileContent.builder()
                .detail(ResponseInputFileContent.Detail.AUTO)
                .fileData("file_data")
                .fileId("file-123")
                .fileUrl("https://example.com")
                .filename("filename")
                .promptCacheBreakpoint(
                    ResponseInputFileContent.PromptCacheBreakpoint.builder().build()
                )
                .build()

        val roundtrippedResponseInputFileContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputFileContent),
                jacksonTypeRef<ResponseInputFileContent>(),
            )

        assertThat(roundtrippedResponseInputFileContent).isEqualTo(responseInputFileContent)
    }
}
