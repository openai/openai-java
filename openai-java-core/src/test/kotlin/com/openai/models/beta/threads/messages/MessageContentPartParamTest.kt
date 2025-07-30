// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class MessageContentPartParamTest {

    @Test
    fun ofImageFile() {
        val imageFile =
            ImageFileContentBlock.builder()
                .imageFile(
                    ImageFile.builder().fileId("file_id").detail(ImageFile.Detail.AUTO).build()
                )
                .build()

        val messageContentPartParam = MessageContentPartParam.ofImageFile(imageFile)

        assertThat(messageContentPartParam.imageFile()).contains(imageFile)
        assertThat(messageContentPartParam.imageUrl()).isEmpty
        assertThat(messageContentPartParam.text()).isEmpty
    }

    @Test
    fun ofImageFileRoundtrip() {
        val jsonMapper = jsonMapper()
        val messageContentPartParam =
            MessageContentPartParam.ofImageFile(
                ImageFileContentBlock.builder()
                    .imageFile(
                        ImageFile.builder().fileId("file_id").detail(ImageFile.Detail.AUTO).build()
                    )
                    .build()
            )

        val roundtrippedMessageContentPartParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageContentPartParam),
                jacksonTypeRef<MessageContentPartParam>(),
            )

        assertThat(roundtrippedMessageContentPartParam).isEqualTo(messageContentPartParam)
    }

    @Test
    fun ofImageUrl() {
        val imageUrl =
            ImageUrlContentBlock.builder()
                .imageUrl(
                    ImageUrl.builder()
                        .url("https://example.com")
                        .detail(ImageUrl.Detail.AUTO)
                        .build()
                )
                .build()

        val messageContentPartParam = MessageContentPartParam.ofImageUrl(imageUrl)

        assertThat(messageContentPartParam.imageFile()).isEmpty
        assertThat(messageContentPartParam.imageUrl()).contains(imageUrl)
        assertThat(messageContentPartParam.text()).isEmpty
    }

    @Test
    fun ofImageUrlRoundtrip() {
        val jsonMapper = jsonMapper()
        val messageContentPartParam =
            MessageContentPartParam.ofImageUrl(
                ImageUrlContentBlock.builder()
                    .imageUrl(
                        ImageUrl.builder()
                            .url("https://example.com")
                            .detail(ImageUrl.Detail.AUTO)
                            .build()
                    )
                    .build()
            )

        val roundtrippedMessageContentPartParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageContentPartParam),
                jacksonTypeRef<MessageContentPartParam>(),
            )

        assertThat(roundtrippedMessageContentPartParam).isEqualTo(messageContentPartParam)
    }

    @Test
    fun ofText() {
        val text = TextContentBlockParam.builder().text("text").build()

        val messageContentPartParam = MessageContentPartParam.ofText(text)

        assertThat(messageContentPartParam.imageFile()).isEmpty
        assertThat(messageContentPartParam.imageUrl()).isEmpty
        assertThat(messageContentPartParam.text()).contains(text)
    }

    @Test
    fun ofTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val messageContentPartParam =
            MessageContentPartParam.ofText(TextContentBlockParam.builder().text("text").build())

        val roundtrippedMessageContentPartParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageContentPartParam),
                jacksonTypeRef<MessageContentPartParam>(),
            )

        assertThat(roundtrippedMessageContentPartParam).isEqualTo(messageContentPartParam)
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
        val messageContentPartParam =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<MessageContentPartParam>())

        val e = assertThrows<OpenAIInvalidDataException> { messageContentPartParam.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
