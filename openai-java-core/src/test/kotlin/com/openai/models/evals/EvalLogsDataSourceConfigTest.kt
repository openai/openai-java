// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EvalLogsDataSourceConfigTest {

    @Test
    fun create() {
        val evalLogsDataSourceConfig =
            EvalLogsDataSourceConfig.builder()
                .schema(
                    EvalLogsDataSourceConfig.Schema.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .metadata(
                    EvalLogsDataSourceConfig.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()

        assertThat(evalLogsDataSourceConfig.schema())
            .isEqualTo(
                EvalLogsDataSourceConfig.Schema.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(evalLogsDataSourceConfig.metadata())
            .contains(
                EvalLogsDataSourceConfig.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val evalLogsDataSourceConfig =
            EvalLogsDataSourceConfig.builder()
                .schema(
                    EvalLogsDataSourceConfig.Schema.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .metadata(
                    EvalLogsDataSourceConfig.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()

        val roundtrippedEvalLogsDataSourceConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(evalLogsDataSourceConfig),
                jacksonTypeRef<EvalLogsDataSourceConfig>(),
            )

        assertThat(roundtrippedEvalLogsDataSourceConfig).isEqualTo(evalLogsDataSourceConfig)
    }
}
