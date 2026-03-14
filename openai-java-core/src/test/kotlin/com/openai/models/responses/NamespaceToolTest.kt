// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceToolTest {

    @Test
    fun create() {
        val namespaceTool =
            NamespaceTool.builder()
                .description("x")
                .name("x")
                .addTool(
                    NamespaceTool.Tool.Function.builder()
                        .name("name")
                        .deferLoading(true)
                        .description("description")
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .strict(true)
                        .build()
                )
                .build()

        assertThat(namespaceTool.description()).isEqualTo("x")
        assertThat(namespaceTool.name()).isEqualTo("x")
        assertThat(namespaceTool.tools())
            .containsExactly(
                NamespaceTool.Tool.ofFunction(
                    NamespaceTool.Tool.Function.builder()
                        .name("name")
                        .deferLoading(true)
                        .description("description")
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .strict(true)
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceTool =
            NamespaceTool.builder()
                .description("x")
                .name("x")
                .addTool(
                    NamespaceTool.Tool.Function.builder()
                        .name("name")
                        .deferLoading(true)
                        .description("description")
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .strict(true)
                        .build()
                )
                .build()

        val roundtrippedNamespaceTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespaceTool),
                jacksonTypeRef<NamespaceTool>(),
            )

        assertThat(roundtrippedNamespaceTool).isEqualTo(namespaceTool)
    }
}
