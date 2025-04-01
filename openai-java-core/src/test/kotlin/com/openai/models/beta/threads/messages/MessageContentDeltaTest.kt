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

internal class MessageContentDeltaTest {

    @Test
    fun ofImageFile() {
        val imageFile =
            ImageFileDeltaBlock.builder()
                .index(0L)
                .imageFile(
                    ImageFileDelta.builder()
                        .detail(ImageFileDelta.Detail.AUTO)
                        .fileId("file_id")
                        .build()
                )
                .build()

        val messageContentDelta = MessageContentDelta.ofImageFile(imageFile)

        assertThat(messageContentDelta.imageFile()).contains(imageFile)
        assertThat(messageContentDelta.text()).isEmpty
        assertThat(messageContentDelta.refusal()).isEmpty
        assertThat(messageContentDelta.imageUrl()).isEmpty
    }

    @Test
    fun ofImageFileRoundtrip() {
        val jsonMapper = jsonMapper()
        val messageContentDelta =
            MessageContentDelta.ofImageFile(
                ImageFileDeltaBlock.builder()
                    .index(0L)
                    .imageFile(
                        ImageFileDelta.builder()
                            .detail(ImageFileDelta.Detail.AUTO)
                            .fileId("file_id")
                            .build()
                    )
                    .build()
            )

        val roundtrippedMessageContentDelta =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageContentDelta),
                jacksonTypeRef<MessageContentDelta>(),
            )

        assertThat(roundtrippedMessageContentDelta).isEqualTo(messageContentDelta)
    }

    @Test
    fun ofText() {
        val text =
            TextDeltaBlock.builder()
                .index(0L)
                .text(
                    TextDelta.builder()
                        .addAnnotation(
                            FileCitationDeltaAnnotation.builder()
                                .index(0L)
                                .endIndex(0L)
                                .fileCitation(
                                    FileCitationDeltaAnnotation.FileCitation.builder()
                                        .fileId("file_id")
                                        .quote("quote")
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

        val messageContentDelta = MessageContentDelta.ofText(text)

        assertThat(messageContentDelta.imageFile()).isEmpty
        assertThat(messageContentDelta.text()).contains(text)
        assertThat(messageContentDelta.refusal()).isEmpty
        assertThat(messageContentDelta.imageUrl()).isEmpty
    }

    @Test
    fun ofTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val messageContentDelta =
            MessageContentDelta.ofText(
                TextDeltaBlock.builder()
                    .index(0L)
                    .text(
                        TextDelta.builder()
                            .addAnnotation(
                                FileCitationDeltaAnnotation.builder()
                                    .index(0L)
                                    .endIndex(0L)
                                    .fileCitation(
                                        FileCitationDeltaAnnotation.FileCitation.builder()
                                            .fileId("file_id")
                                            .quote("quote")
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

        val roundtrippedMessageContentDelta =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageContentDelta),
                jacksonTypeRef<MessageContentDelta>(),
            )

        assertThat(roundtrippedMessageContentDelta).isEqualTo(messageContentDelta)
    }

    @Test
    fun ofRefusal() {
        val refusal = RefusalDeltaBlock.builder().index(0L).refusal("refusal").build()

        val messageContentDelta = MessageContentDelta.ofRefusal(refusal)

        assertThat(messageContentDelta.imageFile()).isEmpty
        assertThat(messageContentDelta.text()).isEmpty
        assertThat(messageContentDelta.refusal()).contains(refusal)
        assertThat(messageContentDelta.imageUrl()).isEmpty
    }

    @Test
    fun ofRefusalRoundtrip() {
        val jsonMapper = jsonMapper()
        val messageContentDelta =
            MessageContentDelta.ofRefusal(
                RefusalDeltaBlock.builder().index(0L).refusal("refusal").build()
            )

        val roundtrippedMessageContentDelta =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageContentDelta),
                jacksonTypeRef<MessageContentDelta>(),
            )

        assertThat(roundtrippedMessageContentDelta).isEqualTo(messageContentDelta)
    }

    @Test
    fun ofImageUrl() {
        val imageUrl =
            ImageUrlDeltaBlock.builder()
                .index(0L)
                .imageUrl(
                    ImageUrlDelta.builder().detail(ImageUrlDelta.Detail.AUTO).url("url").build()
                )
                .build()

        val messageContentDelta = MessageContentDelta.ofImageUrl(imageUrl)

        assertThat(messageContentDelta.imageFile()).isEmpty
        assertThat(messageContentDelta.text()).isEmpty
        assertThat(messageContentDelta.refusal()).isEmpty
        assertThat(messageContentDelta.imageUrl()).contains(imageUrl)
    }

    @Test
    fun ofImageUrlRoundtrip() {
        val jsonMapper = jsonMapper()
        val messageContentDelta =
            MessageContentDelta.ofImageUrl(
                ImageUrlDeltaBlock.builder()
                    .index(0L)
                    .imageUrl(
                        ImageUrlDelta.builder().detail(ImageUrlDelta.Detail.AUTO).url("url").build()
                    )
                    .build()
            )

        val roundtrippedMessageContentDelta =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageContentDelta),
                jacksonTypeRef<MessageContentDelta>(),
            )

        assertThat(roundtrippedMessageContentDelta).isEqualTo(messageContentDelta)
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
        val messageContentDelta =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<MessageContentDelta>())

        val e = assertThrows<OpenAIInvalidDataException> { messageContentDelta.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
