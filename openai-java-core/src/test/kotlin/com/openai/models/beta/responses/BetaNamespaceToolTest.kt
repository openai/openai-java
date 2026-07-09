// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaNamespaceToolTest {

    @Test
    fun create() {
        val betaNamespaceTool =
            BetaNamespaceTool.builder()
                .description("x")
                .name("x")
                .addTool(
                    BetaNamespaceTool.Tool.Function.builder()
                        .name("name")
                        .addAllowedCaller(BetaNamespaceTool.Tool.Function.AllowedCaller.DIRECT)
                        .deferLoading(true)
                        .description("description")
                        .outputSchema(
                            BetaNamespaceTool.Tool.Function.OutputSchema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .strict(true)
                        .build()
                )
                .build()

        assertThat(betaNamespaceTool.description()).isEqualTo("x")
        assertThat(betaNamespaceTool.name()).isEqualTo("x")
        assertThat(betaNamespaceTool.tools())
            .containsExactly(
                BetaNamespaceTool.Tool.ofFunction(
                    BetaNamespaceTool.Tool.Function.builder()
                        .name("name")
                        .addAllowedCaller(BetaNamespaceTool.Tool.Function.AllowedCaller.DIRECT)
                        .deferLoading(true)
                        .description("description")
                        .outputSchema(
                            BetaNamespaceTool.Tool.Function.OutputSchema.builder()
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
        val betaNamespaceTool =
            BetaNamespaceTool.builder()
                .description("x")
                .name("x")
                .addTool(
                    BetaNamespaceTool.Tool.Function.builder()
                        .name("name")
                        .addAllowedCaller(BetaNamespaceTool.Tool.Function.AllowedCaller.DIRECT)
                        .deferLoading(true)
                        .description("description")
                        .outputSchema(
                            BetaNamespaceTool.Tool.Function.OutputSchema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .strict(true)
                        .build()
                )
                .build()

        val roundtrippedBetaNamespaceTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaNamespaceTool),
                jacksonTypeRef<BetaNamespaceTool>(),
            )

        assertThat(roundtrippedBetaNamespaceTool).isEqualTo(betaNamespaceTool)
    }
}
