// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ToolSearchOutputNamespaceToolTest {

    @Test
    fun create() {
        val toolSearchOutputNamespaceTool =
            ToolSearchOutputNamespaceTool.builder()
                .description("description")
                .name("x")
                .addTool(
                    ToolSearchOutputNamespaceTool.Tool.Function.builder()
                        .name("x")
                        .addAllowedCaller(
                            ToolSearchOutputNamespaceTool.Tool.Function.AllowedCaller.DIRECT
                        )
                        .async(true)
                        .deferLoading(true)
                        .description("description")
                        .outputSchema(
                            ToolSearchOutputNamespaceTool.Tool.Function.OutputSchema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .strict(true)
                        .build()
                )
                .build()

        assertThat(toolSearchOutputNamespaceTool.description()).isEqualTo("description")
        assertThat(toolSearchOutputNamespaceTool.name()).isEqualTo("x")
        assertThat(toolSearchOutputNamespaceTool.tools())
            .containsExactly(
                ToolSearchOutputNamespaceTool.Tool.ofFunction(
                    ToolSearchOutputNamespaceTool.Tool.Function.builder()
                        .name("x")
                        .addAllowedCaller(
                            ToolSearchOutputNamespaceTool.Tool.Function.AllowedCaller.DIRECT
                        )
                        .async(true)
                        .deferLoading(true)
                        .description("description")
                        .outputSchema(
                            ToolSearchOutputNamespaceTool.Tool.Function.OutputSchema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .strict(true)
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val toolSearchOutputNamespaceTool =
            ToolSearchOutputNamespaceTool.builder()
                .description("description")
                .name("x")
                .addTool(
                    ToolSearchOutputNamespaceTool.Tool.Function.builder()
                        .name("x")
                        .addAllowedCaller(
                            ToolSearchOutputNamespaceTool.Tool.Function.AllowedCaller.DIRECT
                        )
                        .async(true)
                        .deferLoading(true)
                        .description("description")
                        .outputSchema(
                            ToolSearchOutputNamespaceTool.Tool.Function.OutputSchema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .strict(true)
                        .build()
                )
                .build()

        val roundtrippedToolSearchOutputNamespaceTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(toolSearchOutputNamespaceTool),
                jacksonTypeRef<ToolSearchOutputNamespaceTool>(),
            )

        assertThat(roundtrippedToolSearchOutputNamespaceTool)
            .isEqualTo(toolSearchOutputNamespaceTool)
    }
}
