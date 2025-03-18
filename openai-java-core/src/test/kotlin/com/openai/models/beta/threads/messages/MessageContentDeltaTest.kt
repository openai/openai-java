// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageContentDeltaTest {

    @Test
    fun ofImageFile() {
        val imageFile = ImageFileDeltaBlock.builder().index(0L).build()

        val messageContentDelta = MessageContentDelta.ofImageFile(imageFile)

        assertThat(messageContentDelta.imageFile()).contains(imageFile)
        assertThat(messageContentDelta.text()).isEmpty
        assertThat(messageContentDelta.refusal()).isEmpty
        assertThat(messageContentDelta.imageUrl()).isEmpty
    }

    @Test
    fun ofText() {
        val text = TextDeltaBlock.builder().index(0L).build()

        val messageContentDelta = MessageContentDelta.ofText(text)

        assertThat(messageContentDelta.imageFile()).isEmpty
        assertThat(messageContentDelta.text()).contains(text)
        assertThat(messageContentDelta.refusal()).isEmpty
        assertThat(messageContentDelta.imageUrl()).isEmpty
    }

    @Test
    fun ofRefusal() {
        val refusal = RefusalDeltaBlock.builder().index(0L).build()

        val messageContentDelta = MessageContentDelta.ofRefusal(refusal)

        assertThat(messageContentDelta.imageFile()).isEmpty
        assertThat(messageContentDelta.text()).isEmpty
        assertThat(messageContentDelta.refusal()).contains(refusal)
        assertThat(messageContentDelta.imageUrl()).isEmpty
    }

    @Test
    fun ofImageUrl() {
        val imageUrl = ImageUrlDeltaBlock.builder().index(0L).build()

        val messageContentDelta = MessageContentDelta.ofImageUrl(imageUrl)

        assertThat(messageContentDelta.imageFile()).isEmpty
        assertThat(messageContentDelta.text()).isEmpty
        assertThat(messageContentDelta.refusal()).isEmpty
        assertThat(messageContentDelta.imageUrl()).contains(imageUrl)
    }
}
