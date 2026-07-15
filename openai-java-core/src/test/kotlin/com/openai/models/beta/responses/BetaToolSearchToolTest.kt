// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaToolSearchToolTest {

    @Test
    fun create() {
        val betaToolSearchTool =
            BetaToolSearchTool.builder()
                .description("description")
                .execution(BetaToolSearchTool.Execution.SERVER)
                .parameters(JsonValue.from(mapOf<String, Any>()))
                .build()

        assertThat(betaToolSearchTool.description()).contains("description")
        assertThat(betaToolSearchTool.execution()).contains(BetaToolSearchTool.Execution.SERVER)
        assertThat(betaToolSearchTool._parameters()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaToolSearchTool =
            BetaToolSearchTool.builder()
                .description("description")
                .execution(BetaToolSearchTool.Execution.SERVER)
                .parameters(JsonValue.from(mapOf<String, Any>()))
                .build()

        val roundtrippedBetaToolSearchTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaToolSearchTool),
                jacksonTypeRef<BetaToolSearchTool>(),
            )

        assertThat(roundtrippedBetaToolSearchTool).isEqualTo(betaToolSearchTool)
    }
}
