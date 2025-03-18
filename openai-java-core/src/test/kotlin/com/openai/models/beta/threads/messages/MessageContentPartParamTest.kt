// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageContentPartParamTest {

    @Test
    fun ofImageFile() {
        val imageFile =
            ImageFileContentBlock.builder()
                .imageFile(ImageFile.builder().fileId("file_id").build())
                .build()

        val messageContentPartParam = MessageContentPartParam.ofImageFile(imageFile)

        assertThat(messageContentPartParam.imageFile()).contains(imageFile)
        assertThat(messageContentPartParam.imageUrl()).isEmpty
        assertThat(messageContentPartParam.text()).isEmpty
    }

    @Test
    fun ofImageUrl() {
        val imageUrl =
            ImageUrlContentBlock.builder()
                .imageUrl(ImageUrl.builder().url("https://example.com").build())
                .build()

        val messageContentPartParam = MessageContentPartParam.ofImageUrl(imageUrl)

        assertThat(messageContentPartParam.imageFile()).isEmpty
        assertThat(messageContentPartParam.imageUrl()).contains(imageUrl)
        assertThat(messageContentPartParam.text()).isEmpty
    }

    @Test
    fun ofText() {
        val text = TextContentBlockParam.builder().text("text").build()

        val messageContentPartParam = MessageContentPartParam.ofText(text)

        assertThat(messageContentPartParam.imageFile()).isEmpty
        assertThat(messageContentPartParam.imageUrl()).isEmpty
        assertThat(messageContentPartParam.text()).contains(text)
    }
}
