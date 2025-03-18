// File generated from our OpenAPI spec by Stainless.

package com.openai.models.moderations

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ModerationMultiModalInputTest {

    @Test
    fun ofImageUrl() {
        val imageUrl =
            ModerationImageUrlInput.builder()
                .imageUrl(
                    ModerationImageUrlInput.ImageUrl.builder()
                        .url("https://example.com/image.jpg")
                        .build()
                )
                .build()

        val moderationMultiModalInput = ModerationMultiModalInput.ofImageUrl(imageUrl)

        assertThat(moderationMultiModalInput.imageUrl()).contains(imageUrl)
        assertThat(moderationMultiModalInput.text()).isEmpty
    }

    @Test
    fun ofText() {
        val text = ModerationTextInput.builder().text("I want to kill them").build()

        val moderationMultiModalInput = ModerationMultiModalInput.ofText(text)

        assertThat(moderationMultiModalInput.imageUrl()).isEmpty
        assertThat(moderationMultiModalInput.text()).contains(text)
    }
}
