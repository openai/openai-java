// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ImageUrlContentBlockTest {

    @Test
    fun createImageUrlContentBlock() {
        val imageUrlContentBlock =
            ImageUrlContentBlock.builder()
                .imageUrl(
                    ImageUrl.builder()
                        .url("https://example.com")
                        .detail(ImageUrl.Detail.AUTO)
                        .build()
                )
                .build()
        assertThat(imageUrlContentBlock).isNotNull
        assertThat(imageUrlContentBlock.imageUrl())
            .isEqualTo(
                ImageUrl.builder().url("https://example.com").detail(ImageUrl.Detail.AUTO).build()
            )
    }
}
