// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaComputerToolTest {

    @Test
    fun create() {
        val betaComputerTool = BetaComputerTool.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaComputerTool = BetaComputerTool.builder().build()

        val roundtrippedBetaComputerTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaComputerTool),
                jacksonTypeRef<BetaComputerTool>(),
            )

        assertThat(roundtrippedBetaComputerTool).isEqualTo(betaComputerTool)
    }
}
