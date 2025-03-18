// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCodeInterpreterCallCodeDeltaEventTest {

    @Test
    fun create() {
        val responseCodeInterpreterCallCodeDeltaEvent =
            ResponseCodeInterpreterCallCodeDeltaEvent.builder()
                .delta("delta")
                .outputIndex(0L)
                .build()

        assertThat(responseCodeInterpreterCallCodeDeltaEvent.delta()).isEqualTo("delta")
        assertThat(responseCodeInterpreterCallCodeDeltaEvent.outputIndex()).isEqualTo(0L)
    }
}
