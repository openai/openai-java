// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

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
                .description("description")
                .parameters(
                    FunctionTool.Parameters.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .strict(true)
                .build()

        assertThat(functionTool.name()).isEqualTo("name")
        assertThat(functionTool.description()).contains("description")
        assertThat(functionTool.parameters())
            .contains(
                FunctionTool.Parameters.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(functionTool.strict()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val functionTool =
            FunctionTool.builder()
                .name("name")
                .description("description")
                .parameters(
                    FunctionTool.Parameters.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .strict(true)
                .build()

        val roundtrippedFunctionTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(functionTool),
                jacksonTypeRef<FunctionTool>(),
            )

        assertThat(roundtrippedFunctionTool).isEqualTo(functionTool)
    }
}
