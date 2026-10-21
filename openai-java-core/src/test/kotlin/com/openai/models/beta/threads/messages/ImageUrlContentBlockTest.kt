// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.threads.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImageUrlContentBlockTest {

    @Test
    fun createAndRoundtrip() {
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

        val jsonMapper = jsonMapper()

        val roundtrippedImageUrlContentBlock =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imageUrlContentBlock),
                jacksonTypeRef<ImageUrlContentBlock>(),
            )

        assertThat(roundtrippedImageUrlContentBlock).isEqualTo(imageUrlContentBlock)
    }
}
