// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class InputContentTest {

    @Test
    fun ofInputText() {
        val inputText = InputContent.InputText.builder().text("text").build()

        val inputContent = InputContent.ofInputText(inputText)

        assertThat(inputContent.inputText()).contains(inputText)
        assertThat(inputContent.inputImage()).isEmpty
    }

    @Test
    fun ofInputTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val inputContent =
            InputContent.ofInputText(InputContent.InputText.builder().text("text").build())

        val roundtrippedInputContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inputContent),
                jacksonTypeRef<InputContent>(),
            )

        assertThat(roundtrippedInputContent).isEqualTo(inputContent)
    }

    @Test
    fun ofInputImage() {
        val inputImage = InputContent.InputImage.builder().imageUrl("image_url").build()

        val inputContent = InputContent.ofInputImage(inputImage)

        assertThat(inputContent.inputText()).isEmpty
        assertThat(inputContent.inputImage()).contains(inputImage)
    }

    @Test
    fun ofInputImageRoundtrip() {
        val jsonMapper = jsonMapper()
        val inputContent =
            InputContent.ofInputImage(
                InputContent.InputImage.builder().imageUrl("image_url").build()
            )

        val roundtrippedInputContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inputContent),
                jacksonTypeRef<InputContent>(),
            )

        assertThat(roundtrippedInputContent).isEqualTo(inputContent)
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
        val inputContent = jsonMapper().convertValue(testCase.value, jacksonTypeRef<InputContent>())

        val e = assertThrows<OpenAIInvalidDataException> { inputContent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
