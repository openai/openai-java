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
            ComputerScreenshotContent.builder().fileId("file_id").imageUrl("image_url").build()

        assertThat(computerScreenshotContent.fileId()).contains("file_id")
        assertThat(computerScreenshotContent.imageUrl()).contains("image_url")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val computerScreenshotContent =
            ComputerScreenshotContent.builder().fileId("file_id").imageUrl("image_url").build()

        val roundtrippedComputerScreenshotContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(computerScreenshotContent),
                jacksonTypeRef<ComputerScreenshotContent>(),
            )

        assertThat(roundtrippedComputerScreenshotContent).isEqualTo(computerScreenshotContent)
    }
}
