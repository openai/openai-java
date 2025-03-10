// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

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
                .build()
        assertThat(imageFileContentBlock).isNotNull
        assertThat(imageFileContentBlock.imageFile())
            .isEqualTo(ImageFile.builder().fileId("file_id").detail(ImageFile.Detail.AUTO).build())
    }
}
