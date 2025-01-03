// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ImageFileContentBlockTest {

    @Test
    fun createImageFileContentBlock() {
        val imageFileContentBlock =
            ImageFileContentBlock.builder()
                .imageFile(
                    ImageFile.builder().fileId("file_id").detail(ImageFile.Detail.AUTO).build()
                )
                .type(ImageFileContentBlock.Type.IMAGE_FILE)
                .build()
        assertThat(imageFileContentBlock).isNotNull
        assertThat(imageFileContentBlock.imageFile())
            .isEqualTo(ImageFile.builder().fileId("file_id").detail(ImageFile.Detail.AUTO).build())
        assertThat(imageFileContentBlock.type()).isEqualTo(ImageFileContentBlock.Type.IMAGE_FILE)
    }
}
