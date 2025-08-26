// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputFileContentTest {

    @Test
    fun create() {
        val inputFileContent =
            InputFileContent.builder()
                .fileId("file_id")
                .fileUrl("file_url")
                .filename("filename")
                .build()

        assertThat(inputFileContent.fileId()).contains("file_id")
        assertThat(inputFileContent.fileUrl()).contains("file_url")
        assertThat(inputFileContent.filename()).contains("filename")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inputFileContent =
            InputFileContent.builder()
                .fileId("file_id")
                .fileUrl("file_url")
                .filename("filename")
                .build()

        val roundtrippedInputFileContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inputFileContent),
                jacksonTypeRef<InputFileContent>(),
            )

        assertThat(roundtrippedInputFileContent).isEqualTo(inputFileContent)
    }
}
