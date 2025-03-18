// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionContentPartTest {

    @Test
    fun ofText() {
        val text = ChatCompletionContentPartText.builder().text("text").build()

        val chatCompletionContentPart = ChatCompletionContentPart.ofText(text)

        assertThat(chatCompletionContentPart.text()).contains(text)
        assertThat(chatCompletionContentPart.imageUrl()).isEmpty
        assertThat(chatCompletionContentPart.inputAudio()).isEmpty
        assertThat(chatCompletionContentPart.file()).isEmpty
    }

    @Test
    fun ofImageUrl() {
        val imageUrl =
            ChatCompletionContentPartImage.builder()
                .imageUrl(
                    ChatCompletionContentPartImage.ImageUrl.builder()
                        .url("https://example.com")
                        .build()
                )
                .build()

        val chatCompletionContentPart = ChatCompletionContentPart.ofImageUrl(imageUrl)

        assertThat(chatCompletionContentPart.text()).isEmpty
        assertThat(chatCompletionContentPart.imageUrl()).contains(imageUrl)
        assertThat(chatCompletionContentPart.inputAudio()).isEmpty
        assertThat(chatCompletionContentPart.file()).isEmpty
    }

    @Test
    fun ofInputAudio() {
        val inputAudio =
            ChatCompletionContentPartInputAudio.builder()
                .inputAudio(
                    ChatCompletionContentPartInputAudio.InputAudio.builder()
                        .data("data")
                        .format(ChatCompletionContentPartInputAudio.InputAudio.Format.WAV)
                        .build()
                )
                .build()

        val chatCompletionContentPart = ChatCompletionContentPart.ofInputAudio(inputAudio)

        assertThat(chatCompletionContentPart.text()).isEmpty
        assertThat(chatCompletionContentPart.imageUrl()).isEmpty
        assertThat(chatCompletionContentPart.inputAudio()).contains(inputAudio)
        assertThat(chatCompletionContentPart.file()).isEmpty
    }

    @Test
    fun ofFile() {
        val file =
            ChatCompletionContentPart.File.builder()
                .file(ChatCompletionContentPart.File.FileObject.builder().build())
                .build()

        val chatCompletionContentPart = ChatCompletionContentPart.ofFile(file)

        assertThat(chatCompletionContentPart.text()).isEmpty
        assertThat(chatCompletionContentPart.imageUrl()).isEmpty
        assertThat(chatCompletionContentPart.inputAudio()).isEmpty
        assertThat(chatCompletionContentPart.file()).contains(file)
    }
}
