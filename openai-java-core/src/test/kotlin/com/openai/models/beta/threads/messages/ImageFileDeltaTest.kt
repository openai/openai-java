// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.threads.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImageFileDeltaTest {

    @Test
    fun createAndRoundtrip() {
        val imageFileDelta =
            ImageFileDelta.builder().detail(ImageFileDelta.Detail.AUTO).fileId("file_id").build()

        assertThat(imageFileDelta.detail()).contains(ImageFileDelta.Detail.AUTO)
        assertThat(imageFileDelta.fileId()).contains("file_id")

        val jsonMapper = jsonMapper()

        val roundtrippedImageFileDelta =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imageFileDelta),
                jacksonTypeRef<ImageFileDelta>(),
            )

        assertThat(roundtrippedImageFileDelta).isEqualTo(imageFileDelta)
    }
}
