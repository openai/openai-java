// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ImageFileDeltaTest {

    @Test
    fun createImageFileDelta() {
        val imageFileDelta =
            ImageFileDelta.builder().detail(ImageFileDelta.Detail.AUTO).fileId("file_id").build()
        assertThat(imageFileDelta).isNotNull
        assertThat(imageFileDelta.detail()).contains(ImageFileDelta.Detail.AUTO)
        assertThat(imageFileDelta.fileId()).contains("file_id")
    }
}
