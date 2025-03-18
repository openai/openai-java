// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseComputerToolCallOutputScreenshotTest {

    @Test
    fun create() {
        val responseComputerToolCallOutputScreenshot =
            ResponseComputerToolCallOutputScreenshot.builder()
                .fileId("file_id")
                .imageUrl("image_url")
                .build()

        assertThat(responseComputerToolCallOutputScreenshot.fileId()).contains("file_id")
        assertThat(responseComputerToolCallOutputScreenshot.imageUrl()).contains("image_url")
    }
}
