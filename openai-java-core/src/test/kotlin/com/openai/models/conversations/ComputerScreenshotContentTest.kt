// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ComputerScreenshotContentTest {

    @Test
    fun create() {
        val computerScreenshotContent =
            ComputerScreenshotContent.builder()
                .detail(ComputerScreenshotContent.Detail.LOW)
                .fileId("file_id")
                .imageUrl("https://example.com")
                .build()

        assertThat(computerScreenshotContent.detail())
            .isEqualTo(ComputerScreenshotContent.Detail.LOW)
        assertThat(computerScreenshotContent.fileId()).contains("file_id")
        assertThat(computerScreenshotContent.imageUrl()).contains("https://example.com")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val computerScreenshotContent =
            ComputerScreenshotContent.builder()
                .detail(ComputerScreenshotContent.Detail.LOW)
                .fileId("file_id")
                .imageUrl("https://example.com")
                .build()

        val roundtrippedComputerScreenshotContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(computerScreenshotContent),
                jacksonTypeRef<ComputerScreenshotContent>(),
            )

        assertThat(roundtrippedComputerScreenshotContent).isEqualTo(computerScreenshotContent)
    }
}
