// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class BetaResponseSteerInputContentTest {

    @Test
    fun ofInputText() {
        val inputText =
            BetaResponseInputTextContent.builder()
                .text("text")
                .promptCacheBreakpoint(
                    BetaResponseInputTextContent.PromptCacheBreakpoint.builder().build()
                )
                .build()

        val betaResponseSteerInputContent = BetaResponseSteerInputContent.ofInputText(inputText)

        assertThat(betaResponseSteerInputContent.inputText()).contains(inputText)
        assertThat(betaResponseSteerInputContent.inputImage()).isEmpty
        assertThat(betaResponseSteerInputContent.inputFile()).isEmpty
    }

    @Test
    fun ofInputTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseSteerInputContent =
            BetaResponseSteerInputContent.ofInputText(
                BetaResponseInputTextContent.builder()
                    .text("text")
                    .promptCacheBreakpoint(
                        BetaResponseInputTextContent.PromptCacheBreakpoint.builder().build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseSteerInputContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseSteerInputContent),
                jacksonTypeRef<BetaResponseSteerInputContent>(),
            )

        assertThat(roundtrippedBetaResponseSteerInputContent)
            .isEqualTo(betaResponseSteerInputContent)
    }

    @Test
    fun ofInputImage() {
        val inputImage =
            BetaResponseInputImageContent.builder()
                .detail(BetaResponseInputImageContent.Detail.LOW)
                .fileId("file-123")
                .imageUrl("https://example.com")
                .promptCacheBreakpoint(
                    BetaResponseInputImageContent.PromptCacheBreakpoint.builder().build()
                )
                .build()

        val betaResponseSteerInputContent = BetaResponseSteerInputContent.ofInputImage(inputImage)

        assertThat(betaResponseSteerInputContent.inputText()).isEmpty
        assertThat(betaResponseSteerInputContent.inputImage()).contains(inputImage)
        assertThat(betaResponseSteerInputContent.inputFile()).isEmpty
    }

    @Test
    fun ofInputImageRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseSteerInputContent =
            BetaResponseSteerInputContent.ofInputImage(
                BetaResponseInputImageContent.builder()
                    .detail(BetaResponseInputImageContent.Detail.LOW)
                    .fileId("file-123")
                    .imageUrl("https://example.com")
                    .promptCacheBreakpoint(
                        BetaResponseInputImageContent.PromptCacheBreakpoint.builder().build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseSteerInputContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseSteerInputContent),
                jacksonTypeRef<BetaResponseSteerInputContent>(),
            )

        assertThat(roundtrippedBetaResponseSteerInputContent)
            .isEqualTo(betaResponseSteerInputContent)
    }

    @Test
    fun ofInputFile() {
        val inputFile =
            BetaResponseInputFileContent.builder()
                .detail(BetaResponseInputFileContent.Detail.AUTO)
                .fileData("file_data")
                .fileId("file-123")
                .fileUrl("https://example.com")
                .filename("filename")
                .promptCacheBreakpoint(
                    BetaResponseInputFileContent.PromptCacheBreakpoint.builder().build()
                )
                .build()

        val betaResponseSteerInputContent = BetaResponseSteerInputContent.ofInputFile(inputFile)

        assertThat(betaResponseSteerInputContent.inputText()).isEmpty
        assertThat(betaResponseSteerInputContent.inputImage()).isEmpty
        assertThat(betaResponseSteerInputContent.inputFile()).contains(inputFile)
    }

    @Test
    fun ofInputFileRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseSteerInputContent =
            BetaResponseSteerInputContent.ofInputFile(
                BetaResponseInputFileContent.builder()
                    .detail(BetaResponseInputFileContent.Detail.AUTO)
                    .fileData("file_data")
                    .fileId("file-123")
                    .fileUrl("https://example.com")
                    .filename("filename")
                    .promptCacheBreakpoint(
                        BetaResponseInputFileContent.PromptCacheBreakpoint.builder().build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseSteerInputContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseSteerInputContent),
                jacksonTypeRef<BetaResponseSteerInputContent>(),
            )

        assertThat(roundtrippedBetaResponseSteerInputContent)
            .isEqualTo(betaResponseSteerInputContent)
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
        val betaResponseSteerInputContent =
            jsonMapper()
                .convertValue(testCase.value, jacksonTypeRef<BetaResponseSteerInputContent>())

        val e =
            assertThrows<OpenAIInvalidDataException> { betaResponseSteerInputContent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
