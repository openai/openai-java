// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFormatTextJsonSchemaConfigTest {

    @Test
    fun create() {
        val responseFormatTextJsonSchemaConfig =
            ResponseFormatTextJsonSchemaConfig.builder()
                .name("name")
                .schema(
                    ResponseFormatTextJsonSchemaConfig.Schema.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .description("description")
                .strict(true)
                .build()

        assertThat(responseFormatTextJsonSchemaConfig.name()).isEqualTo("name")
        assertThat(responseFormatTextJsonSchemaConfig.schema())
            .isEqualTo(
                ResponseFormatTextJsonSchemaConfig.Schema.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(responseFormatTextJsonSchemaConfig.description()).contains("description")
        assertThat(responseFormatTextJsonSchemaConfig.strict()).contains(true)
    }
}
