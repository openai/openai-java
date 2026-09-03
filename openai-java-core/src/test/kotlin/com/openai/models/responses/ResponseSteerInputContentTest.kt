// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

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

internal class ResponseSteerInputContentTest {

    @Test
    fun ofInputText() {
        val inputText =
            ResponseInputTextContent.builder()
                .text("text")
                .promptCacheBreakpoint(
                    ResponseInputTextContent.PromptCacheBreakpoint.builder().build()
                )
                .build()

        val responseSteerInputContent = ResponseSteerInputContent.ofInputText(inputText)

        assertThat(responseSteerInputContent.inputText()).contains(inputText)
        assertThat(responseSteerInputContent.inputImage()).isEmpty
        assertThat(responseSteerInputContent.inputFile()).isEmpty
    }

    @Test
    fun ofInputTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseSteerInputContent =
            ResponseSteerInputContent.ofInputText(
                ResponseInputTextContent.builder()
                    .text("text")
                    .promptCacheBreakpoint(
                        ResponseInputTextContent.PromptCacheBreakpoint.builder().build()
                    )
                    .build()
            )

        val roundtrippedResponseSteerInputContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseSteerInputContent),
                jacksonTypeRef<ResponseSteerInputContent>(),
            )

        assertThat(roundtrippedResponseSteerInputContent).isEqualTo(responseSteerInputContent)
    }

    @Test
    fun ofInputImage() {
        val inputImage =
            ResponseInputImageContent.builder()
                .detail(ResponseInputImageContent.Detail.LOW)
                .fileId("file-123")
                .imageUrl("https://example.com")
                .promptCacheBreakpoint(
                    ResponseInputImageContent.PromptCacheBreakpoint.builder().build()
                )
                .build()

        val responseSteerInputContent = ResponseSteerInputContent.ofInputImage(inputImage)

        assertThat(responseSteerInputContent.inputText()).isEmpty
        assertThat(responseSteerInputContent.inputImage()).contains(inputImage)
        assertThat(responseSteerInputContent.inputFile()).isEmpty
    }

    @Test
    fun ofInputImageRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseSteerInputContent =
            ResponseSteerInputContent.ofInputImage(
                ResponseInputImageContent.builder()
                    .detail(ResponseInputImageContent.Detail.LOW)
                    .fileId("file-123")
                    .imageUrl("https://example.com")
                    .promptCacheBreakpoint(
                        ResponseInputImageContent.PromptCacheBreakpoint.builder().build()
                    )
                    .build()
            )

        val roundtrippedResponseSteerInputContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseSteerInputContent),
                jacksonTypeRef<ResponseSteerInputContent>(),
            )

        assertThat(roundtrippedResponseSteerInputContent).isEqualTo(responseSteerInputContent)
    }

    @Test
    fun ofInputFile() {
        val inputFile =
            ResponseInputFileContent.builder()
                .detail(ResponseInputFileContent.Detail.AUTO)
                .fileData("file_data")
                .fileId("file-123")
                .fileUrl("https://example.com")
                .filename("filename")
                .promptCacheBreakpoint(
                    ResponseInputFileContent.PromptCacheBreakpoint.builder().build()
                )
                .build()

        val responseSteerInputContent = ResponseSteerInputContent.ofInputFile(inputFile)

        assertThat(responseSteerInputContent.inputText()).isEmpty
        assertThat(responseSteerInputContent.inputImage()).isEmpty
        assertThat(responseSteerInputContent.inputFile()).contains(inputFile)
    }

    @Test
    fun ofInputFileRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseSteerInputContent =
            ResponseSteerInputContent.ofInputFile(
                ResponseInputFileContent.builder()
                    .detail(ResponseInputFileContent.Detail.AUTO)
                    .fileData("file_data")
                    .fileId("file-123")
                    .fileUrl("https://example.com")
                    .filename("filename")
                    .promptCacheBreakpoint(
                        ResponseInputFileContent.PromptCacheBreakpoint.builder().build()
                    )
                    .build()
            )

        val roundtrippedResponseSteerInputContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseSteerInputContent),
                jacksonTypeRef<ResponseSteerInputContent>(),
            )

        assertThat(roundtrippedResponseSteerInputContent).isEqualTo(responseSteerInputContent)
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
        val responseSteerInputContent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ResponseSteerInputContent>())

        val e = assertThrows<OpenAIInvalidDataException> { responseSteerInputContent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
