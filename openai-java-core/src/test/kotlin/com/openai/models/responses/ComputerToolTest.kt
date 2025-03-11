// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ComputerToolTest {

    @Test
    fun createComputerTool() {
        val computerTool =
            ComputerTool.builder()
                .displayHeight(0.0)
                .displayWidth(0.0)
                .environment(ComputerTool.Environment.MAC)
                .build()
        assertThat(computerTool).isNotNull
        assertThat(computerTool.displayHeight()).isEqualTo(0.0)
        assertThat(computerTool.displayWidth()).isEqualTo(0.0)
        assertThat(computerTool.environment()).isEqualTo(ComputerTool.Environment.MAC)
    }
}
