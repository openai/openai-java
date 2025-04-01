// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImageFileDeltaBlockTest {

    @Test
    fun create() {
        val imageFileDeltaBlock =
            ImageFileDeltaBlock.builder()
                .index(0L)
                .imageFile(
                    ImageFileDelta.builder()
                        .detail(ImageFileDelta.Detail.AUTO)
                        .fileId("file_id")
                        .build()
                )
                .build()

        assertThat(imageFileDeltaBlock.index()).isEqualTo(0L)
        assertThat(imageFileDeltaBlock.imageFile())
            .contains(
                ImageFileDelta.builder()
                    .detail(ImageFileDelta.Detail.AUTO)
                    .fileId("file_id")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val imageFileDeltaBlock =
            ImageFileDeltaBlock.builder()
                .index(0L)
                .imageFile(
                    ImageFileDelta.builder()
                        .detail(ImageFileDelta.Detail.AUTO)
                        .fileId("file_id")
                        .build()
                )
                .build()

        val roundtrippedImageFileDeltaBlock =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imageFileDeltaBlock),
                jacksonTypeRef<ImageFileDeltaBlock>(),
            )

        assertThat(roundtrippedImageFileDeltaBlock).isEqualTo(imageFileDeltaBlock)
    }
}
