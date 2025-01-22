// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FunctionToolTest {

    @Test
    fun createFunctionTool() {
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
        assertThat(functionTool).isNotNull
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
}
