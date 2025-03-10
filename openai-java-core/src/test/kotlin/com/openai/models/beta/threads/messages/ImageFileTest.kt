// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ImageFileTest {

    @Test
    fun createImageFile() {
        val imageFile = ImageFile.builder().fileId("file_id").detail(ImageFile.Detail.AUTO).build()
        assertThat(imageFile).isNotNull
        assertThat(imageFile.fileId()).isEqualTo("file_id")
        assertThat(imageFile.detail()).contains(ImageFile.Detail.AUTO)
    }
}
