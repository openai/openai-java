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
                .fileData("file_data")
                .fileId("file-123")
                .fileUrl("file_url")
                .filename("filename")
                .build()

        assertThat(responseInputFileContent.fileData()).contains("file_data")
        assertThat(responseInputFileContent.fileId()).contains("file-123")
        assertThat(responseInputFileContent.fileUrl()).contains("file_url")
        assertThat(responseInputFileContent.filename()).contains("filename")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseInputFileContent =
            ResponseInputFileContent.builder()
                .fileData("file_data")
                .fileId("file-123")
                .fileUrl("file_url")
                .filename("filename")
                .build()

        val roundtrippedResponseInputFileContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputFileContent),
                jacksonTypeRef<ResponseInputFileContent>(),
            )

        assertThat(roundtrippedResponseInputFileContent).isEqualTo(responseInputFileContent)
    }
}
