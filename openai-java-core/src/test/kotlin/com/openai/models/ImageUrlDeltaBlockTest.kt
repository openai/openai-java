// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ImageUrlDeltaBlockTest {

    @Test
    fun createImageUrlDeltaBlock() {
        val imageUrlDeltaBlock =
            ImageUrlDeltaBlock.builder()
                .index(0L)
                .type(ImageUrlDeltaBlock.Type.IMAGE_URL)
                .imageUrl(
                    ImageUrlDelta.builder().detail(ImageUrlDelta.Detail.AUTO).url("url").build()
                )
                .build()
        assertThat(imageUrlDeltaBlock).isNotNull
        assertThat(imageUrlDeltaBlock.index()).isEqualTo(0L)
        assertThat(imageUrlDeltaBlock.type()).isEqualTo(ImageUrlDeltaBlock.Type.IMAGE_URL)
        assertThat(imageUrlDeltaBlock.imageUrl())
            .contains(ImageUrlDelta.builder().detail(ImageUrlDelta.Detail.AUTO).url("url").build())
    }
}