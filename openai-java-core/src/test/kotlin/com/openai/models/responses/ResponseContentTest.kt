// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

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
    fun ofInputImage() {
        val inputImage = ResponseInputImage.builder().detail(ResponseInputImage.Detail.HIGH).build()

        val responseContent = ResponseContent.ofInputImage(inputImage)

        assertThat(responseContent.inputText()).isEmpty
        assertThat(responseContent.inputImage()).contains(inputImage)
        assertThat(responseContent.inputFile()).isEmpty
        assertThat(responseContent.outputText()).isEmpty
        assertThat(responseContent.outputRefusal()).isEmpty
    }

    @Test
    fun ofInputFile() {
        val inputFile = ResponseInputFile.builder().build()

        val responseContent = ResponseContent.ofInputFile(inputFile)

        assertThat(responseContent.inputText()).isEmpty
        assertThat(responseContent.inputImage()).isEmpty
        assertThat(responseContent.inputFile()).contains(inputFile)
        assertThat(responseContent.outputText()).isEmpty
        assertThat(responseContent.outputRefusal()).isEmpty
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
    fun ofOutputRefusal() {
        val outputRefusal = ResponseOutputRefusal.builder().refusal("refusal").build()

        val responseContent = ResponseContent.ofOutputRefusal(outputRefusal)

        assertThat(responseContent.inputText()).isEmpty
        assertThat(responseContent.inputImage()).isEmpty
        assertThat(responseContent.inputFile()).isEmpty
        assertThat(responseContent.outputText()).isEmpty
        assertThat(responseContent.outputRefusal()).contains(outputRefusal)
    }
}
