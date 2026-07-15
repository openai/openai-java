// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaFunctionToolTest {

    @Test
    fun create() {
        val betaFunctionTool =
            BetaFunctionTool.builder()
                .name("name")
                .parameters(
                    BetaFunctionTool.Parameters.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .strict(true)
                .addAllowedCaller(BetaFunctionTool.AllowedCaller.DIRECT)
                .deferLoading(true)
                .description("description")
                .outputSchema(
                    BetaFunctionTool.OutputSchema.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        assertThat(betaFunctionTool.name()).isEqualTo("name")
        assertThat(betaFunctionTool.parameters())
            .contains(
                BetaFunctionTool.Parameters.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(betaFunctionTool.strict()).contains(true)
        assertThat(betaFunctionTool.allowedCallers().getOrNull())
            .containsExactly(BetaFunctionTool.AllowedCaller.DIRECT)
        assertThat(betaFunctionTool.deferLoading()).contains(true)
        assertThat(betaFunctionTool.description()).contains("description")
        assertThat(betaFunctionTool.outputSchema())
            .contains(
                BetaFunctionTool.OutputSchema.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaFunctionTool =
            BetaFunctionTool.builder()
                .name("name")
                .parameters(
                    BetaFunctionTool.Parameters.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .strict(true)
                .addAllowedCaller(BetaFunctionTool.AllowedCaller.DIRECT)
                .deferLoading(true)
                .description("description")
                .outputSchema(
                    BetaFunctionTool.OutputSchema.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        val roundtrippedBetaFunctionTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaFunctionTool),
                jacksonTypeRef<BetaFunctionTool>(),
            )

        assertThat(roundtrippedBetaFunctionTool).isEqualTo(betaFunctionTool)
    }
}
