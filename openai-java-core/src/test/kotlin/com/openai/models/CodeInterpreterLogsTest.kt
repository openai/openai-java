// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CodeInterpreterLogsTest {

    @Test
    fun createCodeInterpreterLogs() {
        val codeInterpreterLogs = CodeInterpreterLogs.builder().index(0L).logs("logs").build()
        assertThat(codeInterpreterLogs).isNotNull
        assertThat(codeInterpreterLogs.index()).isEqualTo(0L)
        assertThat(codeInterpreterLogs.logs()).contains("logs")
    }
}
