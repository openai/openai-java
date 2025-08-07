// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CodeInterpreterLogsTest {

    @Test
    fun create() {
        val codeInterpreterLogs = CodeInterpreterLogs.builder().index(0L).logs("logs").build()

        assertThat(codeInterpreterLogs.index()).isEqualTo(0L)
        assertThat(codeInterpreterLogs.logs()).contains("logs")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val codeInterpreterLogs = CodeInterpreterLogs.builder().index(0L).logs("logs").build()

        val roundtrippedCodeInterpreterLogs =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(codeInterpreterLogs),
                jacksonTypeRef<CodeInterpreterLogs>(),
            )

        assertThat(roundtrippedCodeInterpreterLogs).isEqualTo(codeInterpreterLogs)
    }
}
