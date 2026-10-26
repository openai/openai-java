// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.vectorstores.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileContentPageResponseTest {

    @Test
    fun createAndRoundtrip() {
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

        val jsonMapper = jsonMapper()

        val roundtrippedFileContentPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileContentPageResponse),
                jacksonTypeRef<FileContentPageResponse>(),
            )

        assertThat(roundtrippedFileContentPageResponse).isEqualTo(fileContentPageResponse)
    }
}
