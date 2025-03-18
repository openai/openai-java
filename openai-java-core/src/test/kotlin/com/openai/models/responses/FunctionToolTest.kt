// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.openai.core.JsonValue
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
            .isEqualTo(
                FunctionTool.Parameters.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(functionTool.strict()).isEqualTo(true)
        assertThat(functionTool.description()).contains("description")
    }
}
