// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.FunctionDefinition
import com.openai.models.FunctionParameters
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FunctionToolTest {

    @Test
    fun create() {
        val functionTool =
            FunctionTool.builder()
                .function(
                    FunctionDefinition.builder()
                        .name("name")
                        .description("description")
                        .parameters(
                            FunctionParameters.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .strict(true)
                        .build()
                )
                .build()

        assertThat(functionTool.function())
            .isEqualTo(
                FunctionDefinition.builder()
                    .name("name")
                    .description("description")
                    .parameters(
                        FunctionParameters.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .strict(true)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val functionTool =
            FunctionTool.builder()
                .function(
                    FunctionDefinition.builder()
                        .name("name")
                        .description("description")
                        .parameters(
                            FunctionParameters.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .strict(true)
                        .build()
                )
                .build()

        val roundtrippedFunctionTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(functionTool),
                jacksonTypeRef<FunctionTool>(),
            )

        assertThat(roundtrippedFunctionTool).isEqualTo(functionTool)
    }
}
