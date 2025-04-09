// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileContentPageResponseTest {

    @Test
    fun create() {
        val fileContentPageResponse =
            FileContentPageResponse.builder()
                .addData(FileContentResponse.builder().text("text").type("type").build())
                .hasMore(true)
                .nextPage("next_page")
                .build()

        assertThat(fileContentPageResponse.data())
            .containsExactly(FileContentResponse.builder().text("text").type("type").build())
        assertThat(fileContentPageResponse.hasMore()).isEqualTo(true)
        assertThat(fileContentPageResponse.nextPage()).contains("next_page")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileContentPageResponse =
            FileContentPageResponse.builder()
                .addData(FileContentResponse.builder().text("text").type("type").build())
                .hasMore(true)
                .nextPage("next_page")
                .build()

        val roundtrippedFileContentPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileContentPageResponse),
                jacksonTypeRef<FileContentPageResponse>(),
            )

        assertThat(roundtrippedFileContentPageResponse).isEqualTo(fileContentPageResponse)
    }
}
