// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFormatJsonSchemaTest {

    @Test
    fun create() {
        val responseFormatJsonSchema =
            ResponseFormatJsonSchema.builder()
                .jsonSchema(
                    ResponseFormatJsonSchema.JsonSchema.builder()
                        .name("name")
                        .description("description")
                        .schema(
                            ResponseFormatJsonSchema.JsonSchema.Schema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .strict(true)
                        .build()
                )
                .build()

        assertThat(responseFormatJsonSchema.jsonSchema())
            .isEqualTo(
                ResponseFormatJsonSchema.JsonSchema.builder()
                    .name("name")
                    .description("description")
                    .schema(
                        ResponseFormatJsonSchema.JsonSchema.Schema.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .strict(true)
                    .build()
            )
    }
}
