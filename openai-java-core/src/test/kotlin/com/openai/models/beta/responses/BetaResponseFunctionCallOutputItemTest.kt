// File generated from our OpenAPI spec by Stainless.

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

internal class BetaResponseFunctionCallOutputItemTest {

    @Test
    fun ofInputText() {
        val inputText =
            BetaResponseInputTextContent.builder()
                .text("text")
                .promptCacheBreakpoint(
                    BetaResponseInputTextContent.PromptCacheBreakpoint.builder().build()
                )
                .build()

        val betaResponseFunctionCallOutputItem =
            BetaResponseFunctionCallOutputItem.ofInputText(inputText)

        assertThat(betaResponseFunctionCallOutputItem.inputText()).contains(inputText)
        assertThat(betaResponseFunctionCallOutputItem.inputImage()).isEmpty
        assertThat(betaResponseFunctionCallOutputItem.inputFile()).isEmpty
    }

    @Test
    fun ofInputTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseFunctionCallOutputItem =
            BetaResponseFunctionCallOutputItem.ofInputText(
                BetaResponseInputTextContent.builder()
                    .text("text")
                    .promptCacheBreakpoint(
                        BetaResponseInputTextContent.PromptCacheBreakpoint.builder().build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseFunctionCallOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseFunctionCallOutputItem),
                jacksonTypeRef<BetaResponseFunctionCallOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseFunctionCallOutputItem)
            .isEqualTo(betaResponseFunctionCallOutputItem)
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

        val betaResponseFunctionCallOutputItem =
            BetaResponseFunctionCallOutputItem.ofInputImage(inputImage)

        assertThat(betaResponseFunctionCallOutputItem.inputText()).isEmpty
        assertThat(betaResponseFunctionCallOutputItem.inputImage()).contains(inputImage)
        assertThat(betaResponseFunctionCallOutputItem.inputFile()).isEmpty
    }

    @Test
    fun ofInputImageRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseFunctionCallOutputItem =
            BetaResponseFunctionCallOutputItem.ofInputImage(
                BetaResponseInputImageContent.builder()
                    .detail(BetaResponseInputImageContent.Detail.LOW)
                    .fileId("file-123")
                    .imageUrl("https://example.com")
                    .promptCacheBreakpoint(
                        BetaResponseInputImageContent.PromptCacheBreakpoint.builder().build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseFunctionCallOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseFunctionCallOutputItem),
                jacksonTypeRef<BetaResponseFunctionCallOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseFunctionCallOutputItem)
            .isEqualTo(betaResponseFunctionCallOutputItem)
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

        val betaResponseFunctionCallOutputItem =
            BetaResponseFunctionCallOutputItem.ofInputFile(inputFile)

        assertThat(betaResponseFunctionCallOutputItem.inputText()).isEmpty
        assertThat(betaResponseFunctionCallOutputItem.inputImage()).isEmpty
        assertThat(betaResponseFunctionCallOutputItem.inputFile()).contains(inputFile)
    }

    @Test
    fun ofInputFileRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseFunctionCallOutputItem =
            BetaResponseFunctionCallOutputItem.ofInputFile(
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

        val roundtrippedBetaResponseFunctionCallOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseFunctionCallOutputItem),
                jacksonTypeRef<BetaResponseFunctionCallOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseFunctionCallOutputItem)
            .isEqualTo(betaResponseFunctionCallOutputItem)
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
        val betaResponseFunctionCallOutputItem =
            jsonMapper()
                .convertValue(testCase.value, jacksonTypeRef<BetaResponseFunctionCallOutputItem>())

        val e =
            assertThrows<OpenAIInvalidDataException> {
                betaResponseFunctionCallOutputItem.validate()
            }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
