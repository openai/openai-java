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

internal class BetaResponseContentTest {

    @Test
    fun ofInputText() {
        val inputText =
            BetaResponseInputText.builder()
                .text("text")
                .promptCacheBreakpoint(
                    BetaResponseInputText.PromptCacheBreakpoint.builder().build()
                )
                .build()

        val betaResponseContent = BetaResponseContent.ofInputText(inputText)

        assertThat(betaResponseContent.inputText()).contains(inputText)
        assertThat(betaResponseContent.inputImage()).isEmpty
        assertThat(betaResponseContent.inputFile()).isEmpty
        assertThat(betaResponseContent.outputText()).isEmpty
        assertThat(betaResponseContent.outputRefusal()).isEmpty
        assertThat(betaResponseContent.reasoningText()).isEmpty
    }

    @Test
    fun ofInputTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseContent =
            BetaResponseContent.ofInputText(
                BetaResponseInputText.builder()
                    .text("text")
                    .promptCacheBreakpoint(
                        BetaResponseInputText.PromptCacheBreakpoint.builder().build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseContent),
                jacksonTypeRef<BetaResponseContent>(),
            )

        assertThat(roundtrippedBetaResponseContent).isEqualTo(betaResponseContent)
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

        val betaResponseContent = BetaResponseContent.ofInputImage(inputImage)

        assertThat(betaResponseContent.inputText()).isEmpty
        assertThat(betaResponseContent.inputImage()).contains(inputImage)
        assertThat(betaResponseContent.inputFile()).isEmpty
        assertThat(betaResponseContent.outputText()).isEmpty
        assertThat(betaResponseContent.outputRefusal()).isEmpty
        assertThat(betaResponseContent.reasoningText()).isEmpty
    }

    @Test
    fun ofInputImageRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseContent =
            BetaResponseContent.ofInputImage(
                BetaResponseInputImage.builder()
                    .detail(BetaResponseInputImage.Detail.LOW)
                    .fileId("file_id")
                    .imageUrl("https://example.com")
                    .promptCacheBreakpoint(
                        BetaResponseInputImage.PromptCacheBreakpoint.builder().build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseContent),
                jacksonTypeRef<BetaResponseContent>(),
            )

        assertThat(roundtrippedBetaResponseContent).isEqualTo(betaResponseContent)
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

        val betaResponseContent = BetaResponseContent.ofInputFile(inputFile)

        assertThat(betaResponseContent.inputText()).isEmpty
        assertThat(betaResponseContent.inputImage()).isEmpty
        assertThat(betaResponseContent.inputFile()).contains(inputFile)
        assertThat(betaResponseContent.outputText()).isEmpty
        assertThat(betaResponseContent.outputRefusal()).isEmpty
        assertThat(betaResponseContent.reasoningText()).isEmpty
    }

    @Test
    fun ofInputFileRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseContent =
            BetaResponseContent.ofInputFile(
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

        val roundtrippedBetaResponseContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseContent),
                jacksonTypeRef<BetaResponseContent>(),
            )

        assertThat(roundtrippedBetaResponseContent).isEqualTo(betaResponseContent)
    }

    @Test
    fun ofOutputText() {
        val outputText =
            BetaResponseOutputText.builder()
                .addAnnotation(
                    BetaResponseOutputText.Annotation.FileCitation.builder()
                        .fileId("file_id")
                        .filename("filename")
                        .index(0L)
                        .build()
                )
                .text("text")
                .addLogprob(
                    BetaResponseOutputText.Logprob.builder()
                        .token("token")
                        .addByte(0L)
                        .logprob(0.0)
                        .addTopLogprob(
                            BetaResponseOutputText.Logprob.TopLogprob.builder()
                                .token("token")
                                .addByte(0L)
                                .logprob(0.0)
                                .build()
                        )
                        .build()
                )
                .build()

        val betaResponseContent = BetaResponseContent.ofOutputText(outputText)

        assertThat(betaResponseContent.inputText()).isEmpty
        assertThat(betaResponseContent.inputImage()).isEmpty
        assertThat(betaResponseContent.inputFile()).isEmpty
        assertThat(betaResponseContent.outputText()).contains(outputText)
        assertThat(betaResponseContent.outputRefusal()).isEmpty
        assertThat(betaResponseContent.reasoningText()).isEmpty
    }

    @Test
    fun ofOutputTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseContent =
            BetaResponseContent.ofOutputText(
                BetaResponseOutputText.builder()
                    .addAnnotation(
                        BetaResponseOutputText.Annotation.FileCitation.builder()
                            .fileId("file_id")
                            .filename("filename")
                            .index(0L)
                            .build()
                    )
                    .text("text")
                    .addLogprob(
                        BetaResponseOutputText.Logprob.builder()
                            .token("token")
                            .addByte(0L)
                            .logprob(0.0)
                            .addTopLogprob(
                                BetaResponseOutputText.Logprob.TopLogprob.builder()
                                    .token("token")
                                    .addByte(0L)
                                    .logprob(0.0)
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseContent),
                jacksonTypeRef<BetaResponseContent>(),
            )

        assertThat(roundtrippedBetaResponseContent).isEqualTo(betaResponseContent)
    }

    @Test
    fun ofOutputRefusal() {
        val outputRefusal = BetaResponseOutputRefusal.builder().refusal("refusal").build()

        val betaResponseContent = BetaResponseContent.ofOutputRefusal(outputRefusal)

        assertThat(betaResponseContent.inputText()).isEmpty
        assertThat(betaResponseContent.inputImage()).isEmpty
        assertThat(betaResponseContent.inputFile()).isEmpty
        assertThat(betaResponseContent.outputText()).isEmpty
        assertThat(betaResponseContent.outputRefusal()).contains(outputRefusal)
        assertThat(betaResponseContent.reasoningText()).isEmpty
    }

    @Test
    fun ofOutputRefusalRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseContent =
            BetaResponseContent.ofOutputRefusal(
                BetaResponseOutputRefusal.builder().refusal("refusal").build()
            )

        val roundtrippedBetaResponseContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseContent),
                jacksonTypeRef<BetaResponseContent>(),
            )

        assertThat(roundtrippedBetaResponseContent).isEqualTo(betaResponseContent)
    }

    @Test
    fun ofReasoningText() {
        val reasoningText = BetaResponseContent.ReasoningText.builder().text("text").build()

        val betaResponseContent = BetaResponseContent.ofReasoningText(reasoningText)

        assertThat(betaResponseContent.inputText()).isEmpty
        assertThat(betaResponseContent.inputImage()).isEmpty
        assertThat(betaResponseContent.inputFile()).isEmpty
        assertThat(betaResponseContent.outputText()).isEmpty
        assertThat(betaResponseContent.outputRefusal()).isEmpty
        assertThat(betaResponseContent.reasoningText()).contains(reasoningText)
    }

    @Test
    fun ofReasoningTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseContent =
            BetaResponseContent.ofReasoningText(
                BetaResponseContent.ReasoningText.builder().text("text").build()
            )

        val roundtrippedBetaResponseContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseContent),
                jacksonTypeRef<BetaResponseContent>(),
            )

        assertThat(roundtrippedBetaResponseContent).isEqualTo(betaResponseContent)
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
        val betaResponseContent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<BetaResponseContent>())

        val e = assertThrows<OpenAIInvalidDataException> { betaResponseContent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
