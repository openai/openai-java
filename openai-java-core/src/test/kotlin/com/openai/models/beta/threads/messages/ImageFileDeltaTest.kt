// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImageFileDeltaTest {

    @Test
    fun create() {
        val imageFileDelta =
            ImageFileDelta.builder().detail(ImageFileDelta.Detail.AUTO).fileId("file_id").build()

        assertThat(imageFileDelta.detail()).contains(ImageFileDelta.Detail.AUTO)
        assertThat(imageFileDelta.fileId()).contains("file_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val imageFileDelta =
            ImageFileDelta.builder().detail(ImageFileDelta.Detail.AUTO).fileId("file_id").build()

        val roundtrippedImageFileDelta =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imageFileDelta),
                jacksonTypeRef<ImageFileDelta>(),
            )

        assertThat(roundtrippedImageFileDelta).isEqualTo(imageFileDelta)
    }
}
