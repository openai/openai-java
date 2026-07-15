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

internal class BetaResponseInputContentTest {

    @Test
    fun ofInputText() {
        val inputText =
            BetaResponseInputText.builder()
                .text("text")
                .promptCacheBreakpoint(
                    BetaResponseInputText.PromptCacheBreakpoint.builder().build()
                )
                .build()

        val betaResponseInputContent = BetaResponseInputContent.ofInputText(inputText)

        assertThat(betaResponseInputContent.inputText()).contains(inputText)
        assertThat(betaResponseInputContent.inputImage()).isEmpty
        assertThat(betaResponseInputContent.inputFile()).isEmpty
    }

    @Test
    fun ofInputTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputContent =
            BetaResponseInputContent.ofInputText(
                BetaResponseInputText.builder()
                    .text("text")
                    .promptCacheBreakpoint(
                        BetaResponseInputText.PromptCacheBreakpoint.builder().build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseInputContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputContent),
                jacksonTypeRef<BetaResponseInputContent>(),
            )

        assertThat(roundtrippedBetaResponseInputContent).isEqualTo(betaResponseInputContent)
    }

    @Test
    fun ofInputImage() {
        val inputImage =
            BetaResponseInputImage.builder()
                .detail(BetaResponseInputImage.Detail.LOW)
                .fileId("file_id")
                .imageUrl("https://example.com")
                .promptCacheBreakpoint(
                    BetaResponseInputImage.PromptCacheBreakpoint.builder().build()
                )
                .build()

        val betaResponseInputContent = BetaResponseInputContent.ofInputImage(inputImage)

        assertThat(betaResponseInputContent.inputText()).isEmpty
        assertThat(betaResponseInputContent.inputImage()).contains(inputImage)
        assertThat(betaResponseInputContent.inputFile()).isEmpty
    }

    @Test
    fun ofInputImageRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputContent =
            BetaResponseInputContent.ofInputImage(
                BetaResponseInputImage.builder()
                    .detail(BetaResponseInputImage.Detail.LOW)
                    .fileId("file_id")
                    .imageUrl("https://example.com")
                    .promptCacheBreakpoint(
                        BetaResponseInputImage.PromptCacheBreakpoint.builder().build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseInputContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputContent),
                jacksonTypeRef<BetaResponseInputContent>(),
            )

        assertThat(roundtrippedBetaResponseInputContent).isEqualTo(betaResponseInputContent)
    }

    @Test
    fun ofInputFile() {
        val inputFile =
            BetaResponseInputFile.builder()
                .detail(BetaResponseInputFile.Detail.AUTO)
                .fileData("file_data")
                .fileId("file_id")
                .fileUrl("https://example.com")
                .filename("filename")
                .promptCacheBreakpoint(
                    BetaResponseInputFile.PromptCacheBreakpoint.builder().build()
                )
                .build()

        val betaResponseInputContent = BetaResponseInputContent.ofInputFile(inputFile)

        assertThat(betaResponseInputContent.inputText()).isEmpty
        assertThat(betaResponseInputContent.inputImage()).isEmpty
        assertThat(betaResponseInputContent.inputFile()).contains(inputFile)
    }

    @Test
    fun ofInputFileRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputContent =
            BetaResponseInputContent.ofInputFile(
                BetaResponseInputFile.builder()
                    .detail(BetaResponseInputFile.Detail.AUTO)
                    .fileData("file_data")
                    .fileId("file_id")
                    .fileUrl("https://example.com")
                    .filename("filename")
                    .promptCacheBreakpoint(
                        BetaResponseInputFile.PromptCacheBreakpoint.builder().build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseInputContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputContent),
                jacksonTypeRef<BetaResponseInputContent>(),
            )

        assertThat(roundtrippedBetaResponseInputContent).isEqualTo(betaResponseInputContent)
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
        val betaResponseInputContent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<BetaResponseInputContent>())

        val e = assertThrows<OpenAIInvalidDataException> { betaResponseInputContent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
