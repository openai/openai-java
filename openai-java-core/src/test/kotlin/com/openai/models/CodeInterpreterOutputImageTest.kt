// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CodeInterpreterOutputImageTest {

    @Test
    fun createCodeInterpreterOutputImage() {
        val codeInterpreterOutputImage =
            CodeInterpreterOutputImage.builder()
                .index(0L)
                .image(CodeInterpreterOutputImage.Image.builder().fileId("file_id").build())
                .build()
        assertThat(codeInterpreterOutputImage).isNotNull
        assertThat(codeInterpreterOutputImage.index()).isEqualTo(0L)
        assertThat(codeInterpreterOutputImage.image())
            .contains(CodeInterpreterOutputImage.Image.builder().fileId("file_id").build())
    }
}
