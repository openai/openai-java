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

internal class MessageContentTest {

    @Test
    fun ofImageFile() {
        val imageFile =
            ImageFileContentBlock.builder()
                .imageFile(
                    ImageFile.builder().fileId("file_id").detail(ImageFile.Detail.AUTO).build()
                )
                .build()

        val messageContent = MessageContent.ofImageFile(imageFile)

        assertThat(messageContent.imageFile()).contains(imageFile)
        assertThat(messageContent.imageUrl()).isEmpty
        assertThat(messageContent.text()).isEmpty
        assertThat(messageContent.refusal()).isEmpty
    }

    @Test
    fun ofImageFileRoundtrip() {
        val jsonMapper = jsonMapper()
        val messageContent =
            MessageContent.ofImageFile(
                ImageFileContentBlock.builder()
                    .imageFile(
                        ImageFile.builder().fileId("file_id").detail(ImageFile.Detail.AUTO).build()
                    )
                    .build()
            )

        val roundtrippedMessageContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageContent),
                jacksonTypeRef<MessageContent>(),
            )

        assertThat(roundtrippedMessageContent).isEqualTo(messageContent)
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

        val messageContent = MessageContent.ofImageUrl(imageUrl)

        assertThat(messageContent.imageFile()).isEmpty
        assertThat(messageContent.imageUrl()).contains(imageUrl)
        assertThat(messageContent.text()).isEmpty
        assertThat(messageContent.refusal()).isEmpty
    }

    @Test
    fun ofImageUrlRoundtrip() {
        val jsonMapper = jsonMapper()
        val messageContent =
            MessageContent.ofImageUrl(
                ImageUrlContentBlock.builder()
                    .imageUrl(
                        ImageUrl.builder()
                            .url("https://example.com")
                            .detail(ImageUrl.Detail.AUTO)
                            .build()
                    )
                    .build()
            )

        val roundtrippedMessageContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageContent),
                jacksonTypeRef<MessageContent>(),
            )

        assertThat(roundtrippedMessageContent).isEqualTo(messageContent)
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
    fun ofTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val messageContent =
            MessageContent.ofText(
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
            )

        val roundtrippedMessageContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageContent),
                jacksonTypeRef<MessageContent>(),
            )

        assertThat(roundtrippedMessageContent).isEqualTo(messageContent)
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

    @Test
    fun ofRefusalRoundtrip() {
        val jsonMapper = jsonMapper()
        val messageContent =
            MessageContent.ofRefusal(RefusalContentBlock.builder().refusal("refusal").build())

        val roundtrippedMessageContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageContent),
                jacksonTypeRef<MessageContent>(),
            )

        assertThat(roundtrippedMessageContent).isEqualTo(messageContent)
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
        val messageContent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<MessageContent>())

        val e = assertThrows<OpenAIInvalidDataException> { messageContent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
