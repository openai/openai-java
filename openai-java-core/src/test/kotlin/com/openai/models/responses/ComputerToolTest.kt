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
                .displayHeight(0L)
                .displayWidth(0L)
                .environment(ComputerTool.Environment.WINDOWS)
                .build()

        assertThat(computerTool.displayHeight()).isEqualTo(0L)
        assertThat(computerTool.displayWidth()).isEqualTo(0L)
        assertThat(computerTool.environment()).isEqualTo(ComputerTool.Environment.WINDOWS)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val computerTool =
            ComputerTool.builder()
                .displayHeight(0L)
                .displayWidth(0L)
                .environment(ComputerTool.Environment.WINDOWS)
                .build()

        val roundtrippedComputerTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(computerTool),
                jacksonTypeRef<ComputerTool>(),
            )

        assertThat(roundtrippedComputerTool).isEqualTo(computerTool)
    }
}
