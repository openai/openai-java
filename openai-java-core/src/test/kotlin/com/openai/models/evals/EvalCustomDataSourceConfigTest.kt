// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.evals

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EvalCustomDataSourceConfigTest {

    @Test
    fun createAndRoundtrip() {
        val evalCustomDataSourceConfig =
            EvalCustomDataSourceConfig.builder()
                .schema(
                    EvalCustomDataSourceConfig.Schema.builder()
                        .putAdditionalProperty("type", JsonValue.from("object"))
                        .putAdditionalProperty("properties", JsonValue.from("bar"))
                        .putAdditionalProperty("required", JsonValue.from(listOf("item")))
                        .build()
                )
                .build()

        assertThat(evalCustomDataSourceConfig.schema())
            .isEqualTo(
                EvalCustomDataSourceConfig.Schema.builder()
                    .putAdditionalProperty("type", JsonValue.from("object"))
                    .putAdditionalProperty("properties", JsonValue.from("bar"))
                    .putAdditionalProperty("required", JsonValue.from(listOf("item")))
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedEvalCustomDataSourceConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evalCustomDataSourceConfig),
                jacksonTypeRef<EvalCustomDataSourceConfig>(),
            )

        assertThat(roundtrippedEvalCustomDataSourceConfig).isEqualTo(evalCustomDataSourceConfig)
    }
}
