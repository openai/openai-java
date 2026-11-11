// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaToolSearchOutputNamespaceToolTest {

    @Test
    fun createAndRoundtrip() {
        val betaToolSearchOutputNamespaceTool =
            BetaToolSearchOutputNamespaceTool.builder()
                .description("description")
                .name("x")
                .addTool(
                    BetaToolSearchOutputNamespaceTool.Tool.Function.builder()
                        .name("x")
                        .addAllowedCaller(
                            BetaToolSearchOutputNamespaceTool.Tool.Function.AllowedCaller.DIRECT
                        )
                        .async(true)
                        .deferLoading(true)
                        .description("description")
                        .outputSchema(
                            BetaToolSearchOutputNamespaceTool.Tool.Function.OutputSchema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .strict(true)
                        .build()
                )
                .build()

        assertThat(betaToolSearchOutputNamespaceTool.description()).contains("description")
        assertThat(betaToolSearchOutputNamespaceTool.name()).contains("x")
        assertThat(betaToolSearchOutputNamespaceTool.tools().getOrNull())
            .containsExactly(
                BetaToolSearchOutputNamespaceTool.Tool.ofFunction(
                    BetaToolSearchOutputNamespaceTool.Tool.Function.builder()
                        .name("x")
                        .addAllowedCaller(
                            BetaToolSearchOutputNamespaceTool.Tool.Function.AllowedCaller.DIRECT
                        )
                        .async(true)
                        .deferLoading(true)
                        .description("description")
                        .outputSchema(
                            BetaToolSearchOutputNamespaceTool.Tool.Function.OutputSchema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .parameters(JsonValue.from(mapOf<String, Any>()))
                        .strict(true)
                        .build()
                )
            )

        val jsonMapper = jsonMapper()

        val roundtrippedBetaToolSearchOutputNamespaceTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaToolSearchOutputNamespaceTool),
                jacksonTypeRef<BetaToolSearchOutputNamespaceTool>(),
            )

        assertThat(roundtrippedBetaToolSearchOutputNamespaceTool)
            .isEqualTo(betaToolSearchOutputNamespaceTool)
    }
}
