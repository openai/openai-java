// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ToolSearchToolTest {

    @Test
    fun create() {
        val toolSearchTool =
            ToolSearchTool.builder()
                .description("description")
                .execution(ToolSearchTool.Execution.SERVER)
                .parameters(JsonValue.from(mapOf<String, Any>()))
                .build()

        assertThat(toolSearchTool.description()).contains("description")
        assertThat(toolSearchTool.execution()).contains(ToolSearchTool.Execution.SERVER)
        assertThat(toolSearchTool._parameters()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val toolSearchTool =
            ToolSearchTool.builder()
                .description("description")
                .execution(ToolSearchTool.Execution.SERVER)
                .parameters(JsonValue.from(mapOf<String, Any>()))
                .build()

        val roundtrippedToolSearchTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(toolSearchTool),
                jacksonTypeRef<ToolSearchTool>(),
            )

        assertThat(roundtrippedToolSearchTool).isEqualTo(toolSearchTool)
    }
}
