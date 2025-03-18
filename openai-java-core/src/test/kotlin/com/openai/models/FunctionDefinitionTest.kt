// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FunctionDefinitionTest {

    @Test
    fun create() {
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
