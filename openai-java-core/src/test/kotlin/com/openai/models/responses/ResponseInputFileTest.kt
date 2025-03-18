// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseInputFileTest {

    @Test
    fun create() {
        val responseInputFile =
            ResponseInputFile.builder()
                .fileData("file_data")
                .fileId("file_id")
                .filename("filename")
                .build()

        assertThat(responseInputFile.fileData()).contains("file_data")
        assertThat(responseInputFile.fileId()).contains("file_id")
        assertThat(responseInputFile.filename()).contains("filename")
    }
}
