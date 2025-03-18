// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CodeInterpreterLogsTest {

    @Test
    fun create() {
        val codeInterpreterLogs = CodeInterpreterLogs.builder().index(0L).logs("logs").build()

        assertThat(codeInterpreterLogs.index()).isEqualTo(0L)
        assertThat(codeInterpreterLogs.logs()).contains("logs")
    }
}
