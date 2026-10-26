// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ToolChoiceShellTest {

    @Test
    fun createAndRoundtrip() {
        val toolChoiceShell = ToolChoiceShell.builder().build()

        val jsonMapper = jsonMapper()

        val roundtrippedToolChoiceShell =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(toolChoiceShell),
                jacksonTypeRef<ToolChoiceShell>(),
            )

        assertThat(roundtrippedToolChoiceShell).isEqualTo(toolChoiceShell)
    }
}
