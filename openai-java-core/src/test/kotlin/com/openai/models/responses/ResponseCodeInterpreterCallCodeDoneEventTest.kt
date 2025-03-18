// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCodeInterpreterCallCodeDoneEventTest {

    @Test
    fun create() {
        val responseCodeInterpreterCallCodeDoneEvent =
            ResponseCodeInterpreterCallCodeDoneEvent.builder().code("code").outputIndex(0L).build()

        assertThat(responseCodeInterpreterCallCodeDoneEvent.code()).isEqualTo("code")
        assertThat(responseCodeInterpreterCallCodeDoneEvent.outputIndex()).isEqualTo(0L)
    }
}
