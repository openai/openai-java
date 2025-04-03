// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileContentResponseTest {

    @Test
    fun create() {
        val fileContentResponse = FileContentResponse.builder().text("text").type("type").build()

        assertThat(fileContentResponse.text()).contains("text")
        assertThat(fileContentResponse.type()).contains("type")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileContentResponse = FileContentResponse.builder().text("text").type("type").build()

        val roundtrippedFileContentResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileContentResponse),
                jacksonTypeRef<FileContentResponse>(),
            )

        assertThat(roundtrippedFileContentResponse).isEqualTo(fileContentResponse)
    }
}
