// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EvalCustomDataSourceConfigTest {

    @Test
    fun create() {
        val evalCustomDataSourceConfig =
            EvalCustomDataSourceConfig.builder()
                .schema(
                    EvalCustomDataSourceConfig.Schema.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        assertThat(evalCustomDataSourceConfig.schema())
            .isEqualTo(
                EvalCustomDataSourceConfig.Schema.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val evalCustomDataSourceConfig =
            EvalCustomDataSourceConfig.builder()
                .schema(
                    EvalCustomDataSourceConfig.Schema.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        val roundtrippedEvalCustomDataSourceConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evalCustomDataSourceConfig),
                jacksonTypeRef<EvalCustomDataSourceConfig>(),
            )

        assertThat(roundtrippedEvalCustomDataSourceConfig).isEqualTo(evalCustomDataSourceConfig)
    }
}
