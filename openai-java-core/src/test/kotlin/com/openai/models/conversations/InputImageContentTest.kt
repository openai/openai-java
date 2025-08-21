// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputImageContentTest {

    @Test
    fun create() {
        val inputImageContent =
            InputImageContent.builder()
                .detail(InputImageContent.Detail.LOW)
                .fileId("file_id")
                .imageUrl("image_url")
                .build()

        assertThat(inputImageContent.detail()).isEqualTo(InputImageContent.Detail.LOW)
        assertThat(inputImageContent.fileId()).contains("file_id")
        assertThat(inputImageContent.imageUrl()).contains("image_url")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inputImageContent =
            InputImageContent.builder()
                .detail(InputImageContent.Detail.LOW)
                .fileId("file_id")
                .imageUrl("image_url")
                .build()

        val roundtrippedInputImageContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inputImageContent),
                jacksonTypeRef<InputImageContent>(),
            )

        assertThat(roundtrippedInputImageContent).isEqualTo(inputImageContent)
    }
}
