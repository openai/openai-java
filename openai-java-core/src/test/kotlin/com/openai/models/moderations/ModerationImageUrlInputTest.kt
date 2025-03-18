// File generated from our OpenAPI spec by Stainless.

package com.openai.models.moderations

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ModerationImageUrlInputTest {

    @Test
    fun create() {
        val moderationImageUrlInput =
            ModerationImageUrlInput.builder()
                .imageUrl(
                    ModerationImageUrlInput.ImageUrl.builder()
                        .url("https://example.com/image.jpg")
                        .build()
                )
                .build()

        assertThat(moderationImageUrlInput.imageUrl())
            .isEqualTo(
                ModerationImageUrlInput.ImageUrl.builder()
                    .url("https://example.com/image.jpg")
                    .build()
            )
    }
}
