// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

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
    fun ofInputImage() {
        val inputImage = ResponseInputImage.builder().detail(ResponseInputImage.Detail.HIGH).build()

        val responseInputContent = ResponseInputContent.ofInputImage(inputImage)

        assertThat(responseInputContent.inputText()).isEmpty
        assertThat(responseInputContent.inputImage()).contains(inputImage)
        assertThat(responseInputContent.inputFile()).isEmpty
    }

    @Test
    fun ofInputFile() {
        val inputFile = ResponseInputFile.builder().build()

        val responseInputContent = ResponseInputContent.ofInputFile(inputFile)

        assertThat(responseInputContent.inputText()).isEmpty
        assertThat(responseInputContent.inputImage()).isEmpty
        assertThat(responseInputContent.inputFile()).contains(inputFile)
    }
}
