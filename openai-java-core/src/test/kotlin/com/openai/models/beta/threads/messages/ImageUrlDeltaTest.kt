// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ImageUrlDeltaTest {

    @Test
    fun create() {
        val imageUrlDelta =
            ImageUrlDelta.builder().detail(ImageUrlDelta.Detail.AUTO).url("url").build()

        assertThat(imageUrlDelta.detail()).contains(ImageUrlDelta.Detail.AUTO)
        assertThat(imageUrlDelta.url()).contains("url")
    }
}
