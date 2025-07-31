// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
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

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val imageUrlContentBlock =
            ImageUrlContentBlock.builder()
                .imageUrl(
                    ImageUrl.builder()
                        .url("https://example.com")
                        .detail(ImageUrl.Detail.AUTO)
                        .build()
                )
                .build()

        val roundtrippedImageUrlContentBlock =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imageUrlContentBlock),
                jacksonTypeRef<ImageUrlContentBlock>(),
            )

        assertThat(roundtrippedImageUrlContentBlock).isEqualTo(imageUrlContentBlock)
    }
}
