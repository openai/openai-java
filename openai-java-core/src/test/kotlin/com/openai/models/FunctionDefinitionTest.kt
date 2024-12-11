// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FunctionDefinitionTest {

    @Test
    fun createFunctionDefinition() {
        val functionDefinition =
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
        assertThat(functionDefinition).isNotNull
        assertThat(functionDefinition.name()).isEqualTo("name")
        assertThat(functionDefinition.description()).contains("description")
        assertThat(functionDefinition.parameters())
            .contains(
                FunctionParameters.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(functionDefinition.strict()).contains(true)
    }
}
