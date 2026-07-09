// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseFormatTextJsonSchemaConfigTest {

    @Test
    fun create() {
        val betaResponseFormatTextJsonSchemaConfig =
            BetaResponseFormatTextJsonSchemaConfig.builder()
                .name("name")
                .schema(
                    BetaResponseFormatTextJsonSchemaConfig.Schema.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .description("description")
                .strict(true)
                .build()

        assertThat(betaResponseFormatTextJsonSchemaConfig.name()).isEqualTo("name")
        assertThat(betaResponseFormatTextJsonSchemaConfig.schema())
            .isEqualTo(
                BetaResponseFormatTextJsonSchemaConfig.Schema.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(betaResponseFormatTextJsonSchemaConfig.description()).contains("description")
        assertThat(betaResponseFormatTextJsonSchemaConfig.strict()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseFormatTextJsonSchemaConfig =
            BetaResponseFormatTextJsonSchemaConfig.builder()
                .name("name")
                .schema(
                    BetaResponseFormatTextJsonSchemaConfig.Schema.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .description("description")
                .strict(true)
                .build()

        val roundtrippedBetaResponseFormatTextJsonSchemaConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseFormatTextJsonSchemaConfig),
                jacksonTypeRef<BetaResponseFormatTextJsonSchemaConfig>(),
            )

        assertThat(roundtrippedBetaResponseFormatTextJsonSchemaConfig)
            .isEqualTo(betaResponseFormatTextJsonSchemaConfig)
    }
}
