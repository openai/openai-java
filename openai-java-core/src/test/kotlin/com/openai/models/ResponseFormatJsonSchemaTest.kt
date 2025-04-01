// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
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

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
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

        val roundtrippedResponseFormatJsonSchema =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFormatJsonSchema),
                jacksonTypeRef<ResponseFormatJsonSchema>(),
            )

        assertThat(roundtrippedResponseFormatJsonSchema).isEqualTo(responseFormatJsonSchema)
    }
}
