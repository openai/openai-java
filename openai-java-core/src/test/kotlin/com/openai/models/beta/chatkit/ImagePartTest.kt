// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImagePartTest {

    @Test
    fun create() {
        val imagePart =
            ImagePart.builder()
                .id("id")
                .mimeType("mime_type")
                .name("name")
                .previewUrl("preview_url")
                .uploadUrl("upload_url")
                .build()

        assertThat(imagePart.id()).isEqualTo("id")
        assertThat(imagePart.mimeType()).isEqualTo("mime_type")
        assertThat(imagePart.name()).contains("name")
        assertThat(imagePart.previewUrl()).isEqualTo("preview_url")
        assertThat(imagePart.uploadUrl()).contains("upload_url")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val imagePart =
            ImagePart.builder()
                .id("id")
                .mimeType("mime_type")
                .name("name")
                .previewUrl("preview_url")
                .uploadUrl("upload_url")
                .build()

        val roundtrippedImagePart =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imagePart),
                jacksonTypeRef<ImagePart>(),
            )

        assertThat(roundtrippedImagePart).isEqualTo(imagePart)
    }
}
