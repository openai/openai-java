// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EvalStoredCompletionsDataSourceConfigTest {

    @Test
    fun create() {
        val evalStoredCompletionsDataSourceConfig =
            EvalStoredCompletionsDataSourceConfig.builder()
                .schema(
                    EvalStoredCompletionsDataSourceConfig.Schema.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .metadata(
                    EvalStoredCompletionsDataSourceConfig.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()

        assertThat(evalStoredCompletionsDataSourceConfig.schema())
            .isEqualTo(
                EvalStoredCompletionsDataSourceConfig.Schema.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(evalStoredCompletionsDataSourceConfig.metadata())
            .contains(
                EvalStoredCompletionsDataSourceConfig.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val evalStoredCompletionsDataSourceConfig =
            EvalStoredCompletionsDataSourceConfig.builder()
                .schema(
                    EvalStoredCompletionsDataSourceConfig.Schema.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .metadata(
                    EvalStoredCompletionsDataSourceConfig.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()

        val roundtrippedEvalStoredCompletionsDataSourceConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evalStoredCompletionsDataSourceConfig),
                jacksonTypeRef<EvalStoredCompletionsDataSourceConfig>(),
            )

        assertThat(roundtrippedEvalStoredCompletionsDataSourceConfig)
            .isEqualTo(evalStoredCompletionsDataSourceConfig)
    }
}
