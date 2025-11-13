// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FunctionShellToolTest {

    @Test
    fun create() {
        val functionShellTool = FunctionShellTool.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val functionShellTool = FunctionShellTool.builder().build()

        val roundtrippedFunctionShellTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(functionShellTool),
                jacksonTypeRef<FunctionShellTool>(),
            )

        assertThat(roundtrippedFunctionShellTool).isEqualTo(functionShellTool)
    }
}
