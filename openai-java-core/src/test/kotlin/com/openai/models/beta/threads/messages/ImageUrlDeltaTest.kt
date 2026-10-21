// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.threads.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImageUrlDeltaTest {

    @Test
    fun createAndRoundtrip() {
        val imageUrlDelta =
            ImageUrlDelta.builder()
                .detail(ImageUrlDelta.Detail.AUTO)
                .url("https://example.com")
                .build()

        assertThat(imageUrlDelta.detail()).contains(ImageUrlDelta.Detail.AUTO)
        assertThat(imageUrlDelta.url()).contains("https://example.com")

        val jsonMapper = jsonMapper()

        val roundtrippedImageUrlDelta =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imageUrlDelta),
                jacksonTypeRef<ImageUrlDelta>(),
            )

        assertThat(roundtrippedImageUrlDelta).isEqualTo(imageUrlDelta)
    }
}
