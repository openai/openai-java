// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaComputerUsePreviewToolTest {

    @Test
    fun create() {
        val betaComputerUsePreviewTool =
            BetaComputerUsePreviewTool.builder()
                .displayHeight(0L)
                .displayWidth(0L)
                .environment(BetaComputerUsePreviewTool.Environment.WINDOWS)
                .build()

        assertThat(betaComputerUsePreviewTool.displayHeight()).isEqualTo(0L)
        assertThat(betaComputerUsePreviewTool.displayWidth()).isEqualTo(0L)
        assertThat(betaComputerUsePreviewTool.environment())
            .isEqualTo(BetaComputerUsePreviewTool.Environment.WINDOWS)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaComputerUsePreviewTool =
            BetaComputerUsePreviewTool.builder()
                .displayHeight(0L)
                .displayWidth(0L)
                .environment(BetaComputerUsePreviewTool.Environment.WINDOWS)
                .build()

        val roundtrippedBetaComputerUsePreviewTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaComputerUsePreviewTool),
                jacksonTypeRef<BetaComputerUsePreviewTool>(),
            )

        assertThat(roundtrippedBetaComputerUsePreviewTool).isEqualTo(betaComputerUsePreviewTool)
    }
}
