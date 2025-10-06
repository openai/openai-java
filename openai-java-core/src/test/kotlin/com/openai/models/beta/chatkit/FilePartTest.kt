// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FilePartTest {

    @Test
    fun create() {
        val filePart =
            FilePart.builder()
                .id("id")
                .mimeType("mime_type")
                .name("name")
                .uploadUrl("upload_url")
                .build()

        assertThat(filePart.id()).isEqualTo("id")
        assertThat(filePart.mimeType()).contains("mime_type")
        assertThat(filePart.name()).contains("name")
        assertThat(filePart.uploadUrl()).contains("upload_url")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val filePart =
            FilePart.builder()
                .id("id")
                .mimeType("mime_type")
                .name("name")
                .uploadUrl("upload_url")
                .build()

        val roundtrippedFilePart =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(filePart),
                jacksonTypeRef<FilePart>(),
            )

        assertThat(roundtrippedFilePart).isEqualTo(filePart)
    }
}
