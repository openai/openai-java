// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FunctionToolTest {

    @Test
    fun create() {
        val functionTool =
            FunctionTool.builder()
                .name("name")
                .parameters(
                    FunctionTool.Parameters.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .strict(true)
                .description("description")
                .build()

        assertThat(functionTool.name()).isEqualTo("name")
        assertThat(functionTool.parameters())
            .contains(
                FunctionTool.Parameters.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(functionTool.strict()).contains(true)
        assertThat(functionTool.description()).contains("description")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val functionTool =
            FunctionTool.builder()
                .name("name")
                .parameters(
                    FunctionTool.Parameters.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .strict(true)
                .description("description")
                .build()

        val roundtrippedFunctionTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(functionTool),
                jacksonTypeRef<FunctionTool>(),
            )

        assertThat(roundtrippedFunctionTool).isEqualTo(functionTool)
    }
}
