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

internal class InputContentParamTest {

    @Test
    fun ofInputText() {
        val inputText = InputContentParam.InputText.builder().text("text").build()

        val inputContentParam = InputContentParam.ofInputText(inputText)

        assertThat(inputContentParam.inputText()).contains(inputText)
        assertThat(inputContentParam.inputImage()).isEmpty
    }

    @Test
    fun ofInputTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val inputContentParam =
            InputContentParam.ofInputText(
                InputContentParam.InputText.builder().text("text").build()
            )

        val roundtrippedInputContentParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inputContentParam),
                jacksonTypeRef<InputContentParam>(),
            )

        assertThat(roundtrippedInputContentParam).isEqualTo(inputContentParam)
    }

    @Test
    fun ofInputImage() {
        val inputImage = InputContentParam.InputImage.builder().imageUrl("image_url").build()

        val inputContentParam = InputContentParam.ofInputImage(inputImage)

        assertThat(inputContentParam.inputText()).isEmpty
        assertThat(inputContentParam.inputImage()).contains(inputImage)
    }

    @Test
    fun ofInputImageRoundtrip() {
        val jsonMapper = jsonMapper()
        val inputContentParam =
            InputContentParam.ofInputImage(
                InputContentParam.InputImage.builder().imageUrl("image_url").build()
            )

        val roundtrippedInputContentParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inputContentParam),
                jacksonTypeRef<InputContentParam>(),
            )

        assertThat(roundtrippedInputContentParam).isEqualTo(inputContentParam)
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
        val inputContentParam =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<InputContentParam>())

        val e = assertThrows<OpenAIInvalidDataException> { inputContentParam.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
