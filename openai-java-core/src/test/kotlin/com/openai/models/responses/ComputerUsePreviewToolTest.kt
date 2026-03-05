// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ComputerUsePreviewToolTest {

    @Test
    fun create() {
        val computerUsePreviewTool =
            ComputerUsePreviewTool.builder()
                .displayHeight(0L)
                .displayWidth(0L)
                .environment(ComputerUsePreviewTool.Environment.WINDOWS)
                .build()

        assertThat(computerUsePreviewTool.displayHeight()).isEqualTo(0L)
        assertThat(computerUsePreviewTool.displayWidth()).isEqualTo(0L)
        assertThat(computerUsePreviewTool.environment())
            .isEqualTo(ComputerUsePreviewTool.Environment.WINDOWS)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val computerUsePreviewTool =
            ComputerUsePreviewTool.builder()
                .displayHeight(0L)
                .displayWidth(0L)
                .environment(ComputerUsePreviewTool.Environment.WINDOWS)
                .build()

        val roundtrippedComputerUsePreviewTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(computerUsePreviewTool),
                jacksonTypeRef<ComputerUsePreviewTool>(),
            )

        assertThat(roundtrippedComputerUsePreviewTool).isEqualTo(computerUsePreviewTool)
    }
}
