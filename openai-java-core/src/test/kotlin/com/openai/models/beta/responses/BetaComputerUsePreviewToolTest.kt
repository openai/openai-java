// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaComputerUsePreviewToolTest {

    @Test
    fun createAndRoundtrip() {
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

        val jsonMapper = jsonMapper()

        val roundtrippedBetaComputerUsePreviewTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaComputerUsePreviewTool),
                jacksonTypeRef<BetaComputerUsePreviewTool>(),
            )

        assertThat(roundtrippedBetaComputerUsePreviewTool).isEqualTo(betaComputerUsePreviewTool)
    }
}
