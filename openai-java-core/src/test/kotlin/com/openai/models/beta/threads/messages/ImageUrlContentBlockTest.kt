// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImageUrlContentBlockTest {

    @Test
    fun create() {
        val imageUrlContentBlock =
            ImageUrlContentBlock.builder()
                .imageUrl(
                    ImageUrl.builder()
                        .url("https://example.com")
                        .detail(ImageUrl.Detail.AUTO)
                        .build()
                )
                .build()

        assertThat(imageUrlContentBlock.imageUrl())
            .isEqualTo(
                ImageUrl.builder().url("https://example.com").detail(ImageUrl.Detail.AUTO).build()
            )
    }
}
