// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImageFileTest {

    @Test
    fun create() {
        val imageFile = ImageFile.builder().fileId("file_id").detail(ImageFile.Detail.AUTO).build()

        assertThat(imageFile.fileId()).isEqualTo("file_id")
        assertThat(imageFile.detail()).contains(ImageFile.Detail.AUTO)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val imageFile = ImageFile.builder().fileId("file_id").detail(ImageFile.Detail.AUTO).build()

        val roundtrippedImageFile =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imageFile),
                jacksonTypeRef<ImageFile>(),
            )

        assertThat(roundtrippedImageFile).isEqualTo(imageFile)
    }
}
