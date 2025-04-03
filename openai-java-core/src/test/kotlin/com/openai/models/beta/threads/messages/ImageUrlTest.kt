// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImageUrlTest {

    @Test
    fun create() {
        val imageUrl =
            ImageUrl.builder().url("https://example.com").detail(ImageUrl.Detail.AUTO).build()

        assertThat(imageUrl.url()).isEqualTo("https://example.com")
        assertThat(imageUrl.detail()).contains(ImageUrl.Detail.AUTO)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val imageUrl =
            ImageUrl.builder().url("https://example.com").detail(ImageUrl.Detail.AUTO).build()

        val roundtrippedImageUrl =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imageUrl),
                jacksonTypeRef<ImageUrl>(),
            )

        assertThat(roundtrippedImageUrl).isEqualTo(imageUrl)
    }
}
