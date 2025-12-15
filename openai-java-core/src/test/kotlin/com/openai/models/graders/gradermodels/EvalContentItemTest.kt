// File generated from our OpenAPI spec by Stainless.

package com.openai.models.graders.gradermodels

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.responses.ResponseInputAudio
import com.openai.models.responses.ResponseInputText
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class EvalContentItemTest {

    @Test
    fun ofTextInput() {
        val textInput = "string"

        val evalContentItem = EvalContentItem.ofTextInput(textInput)

        assertThat(evalContentItem.textInput()).contains(textInput)
        assertThat(evalContentItem.responseInputText()).isEmpty
        assertThat(evalContentItem.outputText()).isEmpty
        assertThat(evalContentItem.inputImage()).isEmpty
        assertThat(evalContentItem.responseInputAudio()).isEmpty
    }

    @Test
    fun ofTextInputRoundtrip() {
        val jsonMapper = jsonMapper()
        val evalContentItem = EvalContentItem.ofTextInput("string")

        val roundtrippedEvalContentItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evalContentItem),
                jacksonTypeRef<EvalContentItem>(),
            )

        assertThat(roundtrippedEvalContentItem).isEqualTo(evalContentItem)
    }

    @Test
    fun ofResponseInputText() {
        val responseInputText = ResponseInputText.builder().text("text").build()

        val evalContentItem = EvalContentItem.ofResponseInputText(responseInputText)

        assertThat(evalContentItem.textInput()).isEmpty
        assertThat(evalContentItem.responseInputText()).contains(responseInputText)
        assertThat(evalContentItem.outputText()).isEmpty
        assertThat(evalContentItem.inputImage()).isEmpty
        assertThat(evalContentItem.responseInputAudio()).isEmpty
    }

    @Test
    fun ofResponseInputTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val evalContentItem =
            EvalContentItem.ofResponseInputText(ResponseInputText.builder().text("text").build())

        val roundtrippedEvalContentItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evalContentItem),
                jacksonTypeRef<EvalContentItem>(),
            )

        assertThat(roundtrippedEvalContentItem).isEqualTo(evalContentItem)
    }

    @Test
    fun ofOutputText() {
        val outputText = EvalContentItem.OutputText.builder().text("text").build()

        val evalContentItem = EvalContentItem.ofOutputText(outputText)

        assertThat(evalContentItem.textInput()).isEmpty
        assertThat(evalContentItem.responseInputText()).isEmpty
        assertThat(evalContentItem.outputText()).contains(outputText)
        assertThat(evalContentItem.inputImage()).isEmpty
        assertThat(evalContentItem.responseInputAudio()).isEmpty
    }

    @Test
    fun ofOutputTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val evalContentItem =
            EvalContentItem.ofOutputText(EvalContentItem.OutputText.builder().text("text").build())

        val roundtrippedEvalContentItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evalContentItem),
                jacksonTypeRef<EvalContentItem>(),
            )

        assertThat(roundtrippedEvalContentItem).isEqualTo(evalContentItem)
    }

    @Test
    fun ofInputImage() {
        val inputImage =
            EvalContentItem.InputImage.builder().imageUrl("image_url").detail("detail").build()

        val evalContentItem = EvalContentItem.ofInputImage(inputImage)

        assertThat(evalContentItem.textInput()).isEmpty
        assertThat(evalContentItem.responseInputText()).isEmpty
        assertThat(evalContentItem.outputText()).isEmpty
        assertThat(evalContentItem.inputImage()).contains(inputImage)
        assertThat(evalContentItem.responseInputAudio()).isEmpty
    }

    @Test
    fun ofInputImageRoundtrip() {
        val jsonMapper = jsonMapper()
        val evalContentItem =
            EvalContentItem.ofInputImage(
                EvalContentItem.InputImage.builder().imageUrl("image_url").detail("detail").build()
            )

        val roundtrippedEvalContentItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evalContentItem),
                jacksonTypeRef<EvalContentItem>(),
            )

        assertThat(roundtrippedEvalContentItem).isEqualTo(evalContentItem)
    }

    @Test
    fun ofResponseInputAudio() {
        val responseInputAudio =
            ResponseInputAudio.builder()
                .inputAudio(
                    ResponseInputAudio.InputAudio.builder()
                        .data("data")
                        .format(ResponseInputAudio.InputAudio.Format.MP3)
                        .build()
                )
                .build()

        val evalContentItem = EvalContentItem.ofResponseInputAudio(responseInputAudio)

        assertThat(evalContentItem.textInput()).isEmpty
        assertThat(evalContentItem.responseInputText()).isEmpty
        assertThat(evalContentItem.outputText()).isEmpty
        assertThat(evalContentItem.inputImage()).isEmpty
        assertThat(evalContentItem.responseInputAudio()).contains(responseInputAudio)
    }

    @Test
    fun ofResponseInputAudioRoundtrip() {
        val jsonMapper = jsonMapper()
        val evalContentItem =
            EvalContentItem.ofResponseInputAudio(
                ResponseInputAudio.builder()
                    .inputAudio(
                        ResponseInputAudio.InputAudio.builder()
                            .data("data")
                            .format(ResponseInputAudio.InputAudio.Format.MP3)
                            .build()
                    )
                    .build()
            )

        val roundtrippedEvalContentItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evalContentItem),
                jacksonTypeRef<EvalContentItem>(),
            )

        assertThat(roundtrippedEvalContentItem).isEqualTo(evalContentItem)
    }

    @Test
    fun incompatibleJsonShapeDeserializesToUnknown() {
        val value = JsonValue.from(listOf("invalid", "array"))
        val evalContentItem = jsonMapper().convertValue(value, jacksonTypeRef<EvalContentItem>())

        val e = assertThrows<OpenAIInvalidDataException> { evalContentItem.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
