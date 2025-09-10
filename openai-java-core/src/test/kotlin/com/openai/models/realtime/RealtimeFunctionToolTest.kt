// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeFunctionToolTest {

    @Test
    fun create() {
        val realtimeFunctionTool =
            RealtimeFunctionTool.builder()
                .description("description")
                .name("name")
                .parameters(JsonValue.from(mapOf<String, Any>()))
                .type(RealtimeFunctionTool.Type.FUNCTION)
                .build()

        assertThat(realtimeFunctionTool.description()).contains("description")
        assertThat(realtimeFunctionTool.name()).contains("name")
        assertThat(realtimeFunctionTool._parameters())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(realtimeFunctionTool.type()).contains(RealtimeFunctionTool.Type.FUNCTION)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeFunctionTool =
            RealtimeFunctionTool.builder()
                .description("description")
                .name("name")
                .parameters(JsonValue.from(mapOf<String, Any>()))
                .type(RealtimeFunctionTool.Type.FUNCTION)
                .build()

        val roundtrippedRealtimeFunctionTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeFunctionTool),
                jacksonTypeRef<RealtimeFunctionTool>(),
            )

        assertThat(roundtrippedRealtimeFunctionTool).isEqualTo(realtimeFunctionTool)
    }
}
