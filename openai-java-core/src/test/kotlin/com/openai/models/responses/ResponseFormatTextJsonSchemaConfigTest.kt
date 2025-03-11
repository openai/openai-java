// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseFormatTextJsonSchemaConfigTest {

    @Test
    fun createResponseFormatTextJsonSchemaConfig() {
        val responseFormatTextJsonSchemaConfig =
            ResponseFormatTextJsonSchemaConfig.builder()
                .schema(
                    ResponseFormatTextJsonSchemaConfig.Schema.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .description("description")
                .name("name")
                .strict(true)
                .build()
        assertThat(responseFormatTextJsonSchemaConfig).isNotNull
        assertThat(responseFormatTextJsonSchemaConfig.schema())
            .isEqualTo(
                ResponseFormatTextJsonSchemaConfig.Schema.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(responseFormatTextJsonSchemaConfig.description()).contains("description")
        assertThat(responseFormatTextJsonSchemaConfig.name()).contains("name")
        assertThat(responseFormatTextJsonSchemaConfig.strict()).contains(true)
    }
}
