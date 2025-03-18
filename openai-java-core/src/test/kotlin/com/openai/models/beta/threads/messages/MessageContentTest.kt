// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageContentTest {

    @Test
    fun ofImageFile() {
        val imageFile =
            ImageFileContentBlock.builder()
                .imageFile(ImageFile.builder().fileId("file_id").build())
                .build()

        val messageContent = MessageContent.ofImageFile(imageFile)

        assertThat(messageContent.imageFile()).contains(imageFile)
        assertThat(messageContent.imageUrl()).isEmpty
        assertThat(messageContent.text()).isEmpty
        assertThat(messageContent.refusal()).isEmpty
    }

    @Test
    fun ofImageUrl() {
        val imageUrl =
            ImageUrlContentBlock.builder()
                .imageUrl(ImageUrl.builder().url("https://example.com").build())
                .build()

        val messageContent = MessageContent.ofImageUrl(imageUrl)

        assertThat(messageContent.imageFile()).isEmpty
        assertThat(messageContent.imageUrl()).contains(imageUrl)
        assertThat(messageContent.text()).isEmpty
        assertThat(messageContent.refusal()).isEmpty
    }

    @Test
    fun ofText() {
        val text =
            TextContentBlock.builder()
                .text(
                    Text.builder()
                        .addAnnotation(
                            FileCitationAnnotation.builder()
                                .endIndex(0L)
                                .fileCitation(
                                    FileCitationAnnotation.FileCitation.builder()
                                        .fileId("file_id")
                                        .build()
                                )
                                .startIndex(0L)
                                .text("text")
                                .build()
                        )
                        .value("value")
                        .build()
                )
                .build()

        val messageContent = MessageContent.ofText(text)

        assertThat(messageContent.imageFile()).isEmpty
        assertThat(messageContent.imageUrl()).isEmpty
        assertThat(messageContent.text()).contains(text)
        assertThat(messageContent.refusal()).isEmpty
    }

    @Test
    fun ofRefusal() {
        val refusal = RefusalContentBlock.builder().refusal("refusal").build()

        val messageContent = MessageContent.ofRefusal(refusal)

        assertThat(messageContent.imageFile()).isEmpty
        assertThat(messageContent.imageUrl()).isEmpty
        assertThat(messageContent.text()).isEmpty
        assertThat(messageContent.refusal()).contains(refusal)
    }
}
