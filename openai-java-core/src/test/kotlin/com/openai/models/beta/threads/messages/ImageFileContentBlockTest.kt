// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImageFileContentBlockTest {

    @Test
    fun create() {
        val imageFileContentBlock =
            ImageFileContentBlock.builder()
                .imageFile(
                    ImageFile.builder().fileId("file_id").detail(ImageFile.Detail.AUTO).build()
                )
                .build()

        assertThat(imageFileContentBlock.imageFile())
            .isEqualTo(ImageFile.builder().fileId("file_id").detail(ImageFile.Detail.AUTO).build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val imageFileContentBlock =
            ImageFileContentBlock.builder()
                .imageFile(
                    ImageFile.builder().fileId("file_id").detail(ImageFile.Detail.AUTO).build()
                )
                .build()

        val roundtrippedImageFileContentBlock =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imageFileContentBlock),
                jacksonTypeRef<ImageFileContentBlock>(),
            )

        assertThat(roundtrippedImageFileContentBlock).isEqualTo(imageFileContentBlock)
    }
}
