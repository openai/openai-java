// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ComputerToolTest {

    @Test
    fun create() {
        val computerTool =
            ComputerTool.builder()
                .displayHeight(0.0)
                .displayWidth(0.0)
                .environment(ComputerTool.Environment.MAC)
                .build()

        assertThat(computerTool.displayHeight()).isEqualTo(0.0)
        assertThat(computerTool.displayWidth()).isEqualTo(0.0)
        assertThat(computerTool.environment()).isEqualTo(ComputerTool.Environment.MAC)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val computerTool =
            ComputerTool.builder()
                .displayHeight(0.0)
                .displayWidth(0.0)
                .environment(ComputerTool.Environment.MAC)
                .build()

        val roundtrippedComputerTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(computerTool),
                jacksonTypeRef<ComputerTool>(),
            )

        assertThat(roundtrippedComputerTool).isEqualTo(computerTool)
    }
}
