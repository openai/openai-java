// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ToolChoiceMcpTest {

    @Test
    fun createAndRoundtrip() {
        val toolChoiceMcp = ToolChoiceMcp.builder().serverLabel("server_label").name("name").build()

        assertThat(toolChoiceMcp.serverLabel()).isEqualTo("server_label")
        assertThat(toolChoiceMcp.name()).contains("name")

        val jsonMapper = jsonMapper()

        val roundtrippedToolChoiceMcp =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(toolChoiceMcp),
                jacksonTypeRef<ToolChoiceMcp>(),
            )

        assertThat(roundtrippedToolChoiceMcp).isEqualTo(toolChoiceMcp)
    }
}
