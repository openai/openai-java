// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ResponseFunctionCallOutputItemTest {

    @Test
    fun ofInputText() {
        val inputText = ResponseInputTextContent.builder().text("text").build()

        val responseFunctionCallOutputItem = ResponseFunctionCallOutputItem.ofInputText(inputText)

        assertThat(responseFunctionCallOutputItem.inputText()).contains(inputText)
        assertThat(responseFunctionCallOutputItem.inputImage()).isEmpty
        assertThat(responseFunctionCallOutputItem.inputFile()).isEmpty
    }

    @Test
    fun ofInputTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseFunctionCallOutputItem =
            ResponseFunctionCallOutputItem.ofInputText(
                ResponseInputTextContent.builder().text("text").build()
            )

        val roundtrippedResponseFunctionCallOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFunctionCallOutputItem),
                jacksonTypeRef<ResponseFunctionCallOutputItem>(),
            )

        assertThat(roundtrippedResponseFunctionCallOutputItem)
            .isEqualTo(responseFunctionCallOutputItem)
    }

    @Test
    fun ofInputImage() {
        val inputImage =
            ResponseInputImageContent.builder()
                .detail(ResponseInputImageContent.Detail.LOW)
                .fileId("file-123")
                .imageUrl("image_url")
                .build()

        val responseFunctionCallOutputItem = ResponseFunctionCallOutputItem.ofInputImage(inputImage)

        assertThat(responseFunctionCallOutputItem.inputText()).isEmpty
        assertThat(responseFunctionCallOutputItem.inputImage()).contains(inputImage)
        assertThat(responseFunctionCallOutputItem.inputFile()).isEmpty
    }

    @Test
    fun ofInputImageRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseFunctionCallOutputItem =
            ResponseFunctionCallOutputItem.ofInputImage(
                ResponseInputImageContent.builder()
                    .detail(ResponseInputImageContent.Detail.LOW)
                    .fileId("file-123")
                    .imageUrl("image_url")
                    .build()
            )

        val roundtrippedResponseFunctionCallOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFunctionCallOutputItem),
                jacksonTypeRef<ResponseFunctionCallOutputItem>(),
            )

        assertThat(roundtrippedResponseFunctionCallOutputItem)
            .isEqualTo(responseFunctionCallOutputItem)
    }

    @Test
    fun ofInputFile() {
        val inputFile =
            ResponseInputFileContent.builder()
                .fileData("file_data")
                .fileId("file-123")
                .fileUrl("file_url")
                .filename("filename")
                .build()

        val responseFunctionCallOutputItem = ResponseFunctionCallOutputItem.ofInputFile(inputFile)

        assertThat(responseFunctionCallOutputItem.inputText()).isEmpty
        assertThat(responseFunctionCallOutputItem.inputImage()).isEmpty
        assertThat(responseFunctionCallOutputItem.inputFile()).contains(inputFile)
    }

    @Test
    fun ofInputFileRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseFunctionCallOutputItem =
            ResponseFunctionCallOutputItem.ofInputFile(
                ResponseInputFileContent.builder()
                    .fileData("file_data")
                    .fileId("file-123")
                    .fileUrl("file_url")
                    .filename("filename")
                    .build()
            )

        val roundtrippedResponseFunctionCallOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFunctionCallOutputItem),
                jacksonTypeRef<ResponseFunctionCallOutputItem>(),
            )

        assertThat(roundtrippedResponseFunctionCallOutputItem)
            .isEqualTo(responseFunctionCallOutputItem)
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
        val responseFunctionCallOutputItem =
            jsonMapper()
                .convertValue(testCase.value, jacksonTypeRef<ResponseFunctionCallOutputItem>())

        val e =
            assertThrows<OpenAIInvalidDataException> { responseFunctionCallOutputItem.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
