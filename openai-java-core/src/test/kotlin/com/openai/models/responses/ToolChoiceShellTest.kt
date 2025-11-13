// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ToolChoiceShellTest {

    @Test
    fun create() {
        val toolChoiceShell = ToolChoiceShell.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val toolChoiceShell = ToolChoiceShell.builder().build()

        val roundtrippedToolChoiceShell =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(toolChoiceShell),
                jacksonTypeRef<ToolChoiceShell>(),
            )

        assertThat(roundtrippedToolChoiceShell).isEqualTo(toolChoiceShell)
    }
}
