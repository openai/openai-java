// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseFormatJsonSchemaTest {

    @Test
    fun createResponseFormatJsonSchema() {
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
                .type(ResponseFormatJsonSchema.Type.JSON_SCHEMA)
                .build()
        assertThat(responseFormatJsonSchema).isNotNull
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
        assertThat(responseFormatJsonSchema.type())
            .isEqualTo(ResponseFormatJsonSchema.Type.JSON_SCHEMA)
    }
}
