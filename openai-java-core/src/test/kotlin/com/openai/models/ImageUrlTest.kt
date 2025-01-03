// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ImageUrlTest {

    @Test
    fun createImageUrl() {
        val imageUrl =
            ImageUrl.builder().url("https://example.com").detail(ImageUrl.Detail.AUTO).build()
        assertThat(imageUrl).isNotNull
        assertThat(imageUrl.url()).isEqualTo("https://example.com")
        assertThat(imageUrl.detail()).contains(ImageUrl.Detail.AUTO)
    }
}
