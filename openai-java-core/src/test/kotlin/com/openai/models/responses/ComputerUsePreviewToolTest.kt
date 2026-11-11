// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ComputerUsePreviewToolTest {

    @Test
    fun createAndRoundtrip() {
        val computerUsePreviewTool =
            ComputerUsePreviewTool.builder()
                .displayHeight(0L)
                .displayWidth(0L)
                .environment(ComputerUsePreviewTool.Environment.WINDOWS)
                .build()

        assertThat(computerUsePreviewTool.displayHeight()).contains(0L)
        assertThat(computerUsePreviewTool.displayWidth()).contains(0L)
        assertThat(computerUsePreviewTool.environment())
            .contains(ComputerUsePreviewTool.Environment.WINDOWS)

        val jsonMapper = jsonMapper()

        val roundtrippedComputerUsePreviewTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(computerUsePreviewTool),
                jacksonTypeRef<ComputerUsePreviewTool>(),
            )

        assertThat(roundtrippedComputerUsePreviewTool).isEqualTo(computerUsePreviewTool)
    }
}
