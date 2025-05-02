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

internal class ResponseContentTest {

    @Test
    fun ofInputText() {
        val inputText = ResponseInputText.builder().text("text").build()

        val responseContent = ResponseContent.ofInputText(inputText)

        assertThat(responseContent.inputText()).contains(inputText)
        assertThat(responseContent.inputImage()).isEmpty
        assertThat(responseContent.inputFile()).isEmpty
        assertThat(responseContent.outputText()).isEmpty
        assertThat(responseContent.outputRefusal()).isEmpty
    }

    @Test
    fun ofInputTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseContent =
            ResponseContent.ofInputText(ResponseInputText.builder().text("text").build())

        val roundtrippedResponseContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseContent),
                jacksonTypeRef<ResponseContent>(),
            )

        assertThat(roundtrippedResponseContent).isEqualTo(responseContent)
    }

    @Test
    fun ofInputImage() {
        val inputImage =
            ResponseInputImage.builder()
                .detail(ResponseInputImage.Detail.LOW)
                .fileId("file_id")
                .imageUrl("image_url")
                .build()

        val responseContent = ResponseContent.ofInputImage(inputImage)

        assertThat(responseContent.inputText()).isEmpty
        assertThat(responseContent.inputImage()).contains(inputImage)
        assertThat(responseContent.inputFile()).isEmpty
        assertThat(responseContent.outputText()).isEmpty
        assertThat(responseContent.outputRefusal()).isEmpty
    }

    @Test
    fun ofInputImageRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseContent =
            ResponseContent.ofInputImage(
                ResponseInputImage.builder()
                    .detail(ResponseInputImage.Detail.LOW)
                    .fileId("file_id")
                    .imageUrl("image_url")
                    .build()
            )

        val roundtrippedResponseContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseContent),
                jacksonTypeRef<ResponseContent>(),
            )

        assertThat(roundtrippedResponseContent).isEqualTo(responseContent)
    }

    @Test
    fun ofInputFile() {
        val inputFile =
            ResponseInputFile.builder()
                .fileData("file_data")
                .fileId("file_id")
                .filename("filename")
                .build()

        val responseContent = ResponseContent.ofInputFile(inputFile)

        assertThat(responseContent.inputText()).isEmpty
        assertThat(responseContent.inputImage()).isEmpty
        assertThat(responseContent.inputFile()).contains(inputFile)
        assertThat(responseContent.outputText()).isEmpty
        assertThat(responseContent.outputRefusal()).isEmpty
    }

    @Test
    fun ofInputFileRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseContent =
            ResponseContent.ofInputFile(
                ResponseInputFile.builder()
                    .fileData("file_data")
                    .fileId("file_id")
                    .filename("filename")
                    .build()
            )

        val roundtrippedResponseContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseContent),
                jacksonTypeRef<ResponseContent>(),
            )

        assertThat(roundtrippedResponseContent).isEqualTo(responseContent)
    }

    @Test
    fun ofOutputText() {
        val outputText =
            ResponseOutputText.builder()
                .addAnnotation(
                    ResponseOutputText.Annotation.FileCitation.builder()
                        .fileId("file_id")
                        .index(0L)
                        .build()
                )
                .text("text")
                .build()

        val responseContent = ResponseContent.ofOutputText(outputText)

        assertThat(responseContent.inputText()).isEmpty
        assertThat(responseContent.inputImage()).isEmpty
        assertThat(responseContent.inputFile()).isEmpty
        assertThat(responseContent.outputText()).contains(outputText)
        assertThat(responseContent.outputRefusal()).isEmpty
    }

    @Test
    fun ofOutputTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseContent =
            ResponseContent.ofOutputText(
                ResponseOutputText.builder()
                    .addAnnotation(
                        ResponseOutputText.Annotation.FileCitation.builder()
                            .fileId("file_id")
                            .index(0L)
                            .build()
                    )
                    .text("text")
                    .build()
            )

        val roundtrippedResponseContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseContent),
                jacksonTypeRef<ResponseContent>(),
            )

        assertThat(roundtrippedResponseContent).isEqualTo(responseContent)
    }

    @Test
    fun ofOutputRefusal() {
        val outputRefusal = ResponseOutputRefusal.builder().refusal("refusal").build()

        val responseContent = ResponseContent.ofOutputRefusal(outputRefusal)

        assertThat(responseContent.inputText()).isEmpty
        assertThat(responseContent.inputImage()).isEmpty
        assertThat(responseContent.inputFile()).isEmpty
        assertThat(responseContent.outputText()).isEmpty
        assertThat(responseContent.outputRefusal()).contains(outputRefusal)
    }

    @Test
    fun ofOutputRefusalRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseContent =
            ResponseContent.ofOutputRefusal(
                ResponseOutputRefusal.builder().refusal("refusal").build()
            )

        val roundtrippedResponseContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseContent),
                jacksonTypeRef<ResponseContent>(),
            )

        assertThat(roundtrippedResponseContent).isEqualTo(responseContent)
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
        val responseContent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ResponseContent>())

        val e = assertThrows<OpenAIInvalidDataException> { responseContent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
