// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseComputerToolCallOutputScreenshotTest {

    @Test
    fun create() {
        val betaResponseComputerToolCallOutputScreenshot =
            BetaResponseComputerToolCallOutputScreenshot.builder()
                .fileId("file_id")
                .imageUrl("https://example.com")
                .build()

        assertThat(betaResponseComputerToolCallOutputScreenshot.fileId()).contains("file_id")
        assertThat(betaResponseComputerToolCallOutputScreenshot.imageUrl())
            .contains("https://example.com")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseComputerToolCallOutputScreenshot =
            BetaResponseComputerToolCallOutputScreenshot.builder()
                .fileId("file_id")
                .imageUrl("https://example.com")
                .build()

        val roundtrippedBetaResponseComputerToolCallOutputScreenshot =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseComputerToolCallOutputScreenshot),
                jacksonTypeRef<BetaResponseComputerToolCallOutputScreenshot>(),
            )

        assertThat(roundtrippedBetaResponseComputerToolCallOutputScreenshot)
            .isEqualTo(betaResponseComputerToolCallOutputScreenshot)
    }
}
