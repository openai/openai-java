// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceToolTest {

    @Test
    fun createAndRoundtrip() {
        val namespaceTool =
            NamespaceTool.builder()
                .description("description")
                .name("x")
                .addTool(
                    NamespaceTool.Tool.Function.builder()
                        .name("name")
                        .addAllowedCaller(NamespaceTool.Tool.Function.AllowedCaller.DIRECT)
                        .async(true)
                        .deferLoading(true)
                        .description("description")
                        .outputSchema(
                            NamespaceTool.Tool.Function.OutputSchema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .strict(true)
                        .build()
                )
                .build()

        assertThat(namespaceTool.description()).contains("description")
        assertThat(namespaceTool.name()).contains("x")
        assertThat(namespaceTool.tools().getOrNull())
            .containsExactly(
                NamespaceTool.Tool.ofFunction(
                    NamespaceTool.Tool.Function.builder()
                        .name("name")
                        .addAllowedCaller(NamespaceTool.Tool.Function.AllowedCaller.DIRECT)
                        .async(true)
                        .deferLoading(true)
                        .description("description")
                        .outputSchema(
                            NamespaceTool.Tool.Function.OutputSchema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .strict(true)
                        .build()
                )
            )

        val jsonMapper = jsonMapper()

        val roundtrippedNamespaceTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespaceTool),
                jacksonTypeRef<NamespaceTool>(),
            )

        assertThat(roundtrippedNamespaceTool).isEqualTo(namespaceTool)
    }
}
