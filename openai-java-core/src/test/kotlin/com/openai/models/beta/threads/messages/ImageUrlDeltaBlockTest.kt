// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImageUrlDeltaBlockTest {

    @Test
    fun create() {
        val imageUrlDeltaBlock =
            ImageUrlDeltaBlock.builder()
                .index(0L)
                .imageUrl(
                    ImageUrlDelta.builder().detail(ImageUrlDelta.Detail.AUTO).url("url").build()
                )
                .build()

        assertThat(imageUrlDeltaBlock.index()).isEqualTo(0L)
        assertThat(imageUrlDeltaBlock.imageUrl())
            .contains(ImageUrlDelta.builder().detail(ImageUrlDelta.Detail.AUTO).url("url").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val imageUrlDeltaBlock =
            ImageUrlDeltaBlock.builder()
                .index(0L)
                .imageUrl(
                    ImageUrlDelta.builder().detail(ImageUrlDelta.Detail.AUTO).url("url").build()
                )
                .build()

        val roundtrippedImageUrlDeltaBlock =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imageUrlDeltaBlock),
                jacksonTypeRef<ImageUrlDeltaBlock>(),
            )

        assertThat(roundtrippedImageUrlDeltaBlock).isEqualTo(imageUrlDeltaBlock)
    }
}
