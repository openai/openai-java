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

internal class ResponseInputContentTest {

    @Test
    fun ofInputText() {
        val inputText = ResponseInputText.builder().text("text").build()

        val responseInputContent = ResponseInputContent.ofInputText(inputText)

        assertThat(responseInputContent.inputText()).contains(inputText)
        assertThat(responseInputContent.inputImage()).isEmpty
        assertThat(responseInputContent.inputFile()).isEmpty
    }

    @Test
    fun ofInputTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseInputContent =
            ResponseInputContent.ofInputText(ResponseInputText.builder().text("text").build())

        val roundtrippedResponseInputContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputContent),
                jacksonTypeRef<ResponseInputContent>(),
            )

        assertThat(roundtrippedResponseInputContent).isEqualTo(responseInputContent)
    }

    @Test
    fun ofInputImage() {
        val inputImage =
            ResponseInputImage.builder()
                .detail(ResponseInputImage.Detail.HIGH)
                .fileId("file_id")
                .imageUrl("image_url")
                .build()

        val responseInputContent = ResponseInputContent.ofInputImage(inputImage)

        assertThat(responseInputContent.inputText()).isEmpty
        assertThat(responseInputContent.inputImage()).contains(inputImage)
        assertThat(responseInputContent.inputFile()).isEmpty
    }

    @Test
    fun ofInputImageRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseInputContent =
            ResponseInputContent.ofInputImage(
                ResponseInputImage.builder()
                    .detail(ResponseInputImage.Detail.HIGH)
                    .fileId("file_id")
                    .imageUrl("image_url")
                    .build()
            )

        val roundtrippedResponseInputContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputContent),
                jacksonTypeRef<ResponseInputContent>(),
            )

        assertThat(roundtrippedResponseInputContent).isEqualTo(responseInputContent)
    }

    @Test
    fun ofInputFile() {
        val inputFile =
            ResponseInputFile.builder()
                .fileData("file_data")
                .fileId("file_id")
                .filename("filename")
                .build()

        val responseInputContent = ResponseInputContent.ofInputFile(inputFile)

        assertThat(responseInputContent.inputText()).isEmpty
        assertThat(responseInputContent.inputImage()).isEmpty
        assertThat(responseInputContent.inputFile()).contains(inputFile)
    }

    @Test
    fun ofInputFileRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseInputContent =
            ResponseInputContent.ofInputFile(
                ResponseInputFile.builder()
                    .fileData("file_data")
                    .fileId("file_id")
                    .filename("filename")
                    .build()
            )

        val roundtrippedResponseInputContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputContent),
                jacksonTypeRef<ResponseInputContent>(),
            )

        assertThat(roundtrippedResponseInputContent).isEqualTo(responseInputContent)
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
        val responseInputContent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ResponseInputContent>())

        val e = assertThrows<OpenAIInvalidDataException> { responseInputContent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
