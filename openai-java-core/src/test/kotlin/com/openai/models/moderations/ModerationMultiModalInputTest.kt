// File generated from our OpenAPI spec by Stainless.

package com.openai.models.moderations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

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
    fun ofImageUrlRoundtrip() {
        val jsonMapper = jsonMapper()
        val moderationMultiModalInput =
            ModerationMultiModalInput.ofImageUrl(
                ModerationImageUrlInput.builder()
                    .imageUrl(
                        ModerationImageUrlInput.ImageUrl.builder()
                            .url("https://example.com/image.jpg")
                            .build()
                    )
                    .build()
            )

        val roundtrippedModerationMultiModalInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(moderationMultiModalInput),
                jacksonTypeRef<ModerationMultiModalInput>(),
            )

        assertThat(roundtrippedModerationMultiModalInput).isEqualTo(moderationMultiModalInput)
    }

    @Test
    fun ofText() {
        val text = ModerationTextInput.builder().text("I want to kill them").build()

        val moderationMultiModalInput = ModerationMultiModalInput.ofText(text)

        assertThat(moderationMultiModalInput.imageUrl()).isEmpty
        assertThat(moderationMultiModalInput.text()).contains(text)
    }

    @Test
    fun ofTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val moderationMultiModalInput =
            ModerationMultiModalInput.ofText(
                ModerationTextInput.builder().text("I want to kill them").build()
            )

        val roundtrippedModerationMultiModalInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(moderationMultiModalInput),
                jacksonTypeRef<ModerationMultiModalInput>(),
            )

        assertThat(roundtrippedModerationMultiModalInput).isEqualTo(moderationMultiModalInput)
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
        val moderationMultiModalInput =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ModerationMultiModalInput>())

        val e = assertThrows<OpenAIInvalidDataException> { moderationMultiModalInput.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
