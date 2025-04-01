// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CodeInterpreterOutputImageTest {

    @Test
    fun create() {
        val codeInterpreterOutputImage =
            CodeInterpreterOutputImage.builder()
                .index(0L)
                .image(CodeInterpreterOutputImage.Image.builder().fileId("file_id").build())
                .build()

        assertThat(codeInterpreterOutputImage.index()).isEqualTo(0L)
        assertThat(codeInterpreterOutputImage.image())
            .contains(CodeInterpreterOutputImage.Image.builder().fileId("file_id").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val codeInterpreterOutputImage =
            CodeInterpreterOutputImage.builder()
                .index(0L)
                .image(CodeInterpreterOutputImage.Image.builder().fileId("file_id").build())
                .build()

        val roundtrippedCodeInterpreterOutputImage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(codeInterpreterOutputImage),
                jacksonTypeRef<CodeInterpreterOutputImage>(),
            )

        assertThat(roundtrippedCodeInterpreterOutputImage).isEqualTo(codeInterpreterOutputImage)
    }
}
