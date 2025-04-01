// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

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
    fun ofTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionContentPart =
            ChatCompletionContentPart.ofText(
                ChatCompletionContentPartText.builder().text("text").build()
            )

        val roundtrippedChatCompletionContentPart =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionContentPart),
                jacksonTypeRef<ChatCompletionContentPart>(),
            )

        assertThat(roundtrippedChatCompletionContentPart).isEqualTo(chatCompletionContentPart)
    }

    @Test
    fun ofImageUrl() {
        val imageUrl =
            ChatCompletionContentPartImage.builder()
                .imageUrl(
                    ChatCompletionContentPartImage.ImageUrl.builder()
                        .url("https://example.com")
                        .detail(ChatCompletionContentPartImage.ImageUrl.Detail.AUTO)
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
    fun ofImageUrlRoundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionContentPart =
            ChatCompletionContentPart.ofImageUrl(
                ChatCompletionContentPartImage.builder()
                    .imageUrl(
                        ChatCompletionContentPartImage.ImageUrl.builder()
                            .url("https://example.com")
                            .detail(ChatCompletionContentPartImage.ImageUrl.Detail.AUTO)
                            .build()
                    )
                    .build()
            )

        val roundtrippedChatCompletionContentPart =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionContentPart),
                jacksonTypeRef<ChatCompletionContentPart>(),
            )

        assertThat(roundtrippedChatCompletionContentPart).isEqualTo(chatCompletionContentPart)
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
    fun ofInputAudioRoundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionContentPart =
            ChatCompletionContentPart.ofInputAudio(
                ChatCompletionContentPartInputAudio.builder()
                    .inputAudio(
                        ChatCompletionContentPartInputAudio.InputAudio.builder()
                            .data("data")
                            .format(ChatCompletionContentPartInputAudio.InputAudio.Format.WAV)
                            .build()
                    )
                    .build()
            )

        val roundtrippedChatCompletionContentPart =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionContentPart),
                jacksonTypeRef<ChatCompletionContentPart>(),
            )

        assertThat(roundtrippedChatCompletionContentPart).isEqualTo(chatCompletionContentPart)
    }

    @Test
    fun ofFile() {
        val file =
            ChatCompletionContentPart.File.builder()
                .file(
                    ChatCompletionContentPart.File.FileObject.builder()
                        .fileData("file_data")
                        .fileId("file_id")
                        .filename("filename")
                        .build()
                )
                .build()

        val chatCompletionContentPart = ChatCompletionContentPart.ofFile(file)

        assertThat(chatCompletionContentPart.text()).isEmpty
        assertThat(chatCompletionContentPart.imageUrl()).isEmpty
        assertThat(chatCompletionContentPart.inputAudio()).isEmpty
        assertThat(chatCompletionContentPart.file()).contains(file)
    }

    @Test
    fun ofFileRoundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionContentPart =
            ChatCompletionContentPart.ofFile(
                ChatCompletionContentPart.File.builder()
                    .file(
                        ChatCompletionContentPart.File.FileObject.builder()
                            .fileData("file_data")
                            .fileId("file_id")
                            .filename("filename")
                            .build()
                    )
                    .build()
            )

        val roundtrippedChatCompletionContentPart =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionContentPart),
                jacksonTypeRef<ChatCompletionContentPart>(),
            )

        assertThat(roundtrippedChatCompletionContentPart).isEqualTo(chatCompletionContentPart)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val chatCompletionContentPart =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ChatCompletionContentPart>())

        val e = assertThrows<OpenAIInvalidDataException> { chatCompletionContentPart.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
