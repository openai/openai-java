// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RunListResponseTest {

    @Test
    fun create() {
        val runListResponse =
            RunListResponse.builder()
                .id("id")
                .createdAt(0L)
                .fileContentJsonlDataSource(
                    listOf(
                        CreateEvalJsonlRunDataSource.Source.FileContent.Content.builder()
                            .item(
                                CreateEvalJsonlRunDataSource.Source.FileContent.Content.Item
                                    .builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .sample(
                                CreateEvalJsonlRunDataSource.Source.FileContent.Content.Sample
                                    .builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .build()
                    )
                )
                .error(EvalApiError.builder().code("code").message("message").build())
                .evalId("eval_id")
                .metadata(
                    RunListResponse.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .model("model")
                .name("name")
                .addPerModelUsage(
                    RunListResponse.PerModelUsage.builder()
                        .cachedTokens(0L)
                        .completionTokens(0L)
                        .invocationCount(0L)
                        .modelName("model_name")
                        .promptTokens(0L)
                        .totalTokens(0L)
                        .build()
                )
                .addPerTestingCriteriaResult(
                    RunListResponse.PerTestingCriteriaResult.builder()
                        .failed(0L)
                        .passed(0L)
                        .testingCriteria("testing_criteria")
                        .build()
                )
                .reportUrl("report_url")
                .resultCounts(
                    RunListResponse.ResultCounts.builder()
                        .errored(0L)
                        .failed(0L)
                        .passed(0L)
                        .total(0L)
                        .build()
                )
                .status("status")
                .build()

        assertThat(runListResponse.id()).isEqualTo("id")
        assertThat(runListResponse.createdAt()).isEqualTo(0L)
        assertThat(runListResponse.dataSource())
            .isEqualTo(
                RunListResponse.DataSource.ofJsonl(
                    CreateEvalJsonlRunDataSource.builder()
                        .fileContentSource(
                            listOf(
                                CreateEvalJsonlRunDataSource.Source.FileContent.Content.builder()
                                    .item(
                                        CreateEvalJsonlRunDataSource.Source.FileContent.Content.Item
                                            .builder()
                                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                                            .build()
                                    )
                                    .sample(
                                        CreateEvalJsonlRunDataSource.Source.FileContent.Content
                                            .Sample
                                            .builder()
                                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .build()
                )
            )
        assertThat(runListResponse.error())
            .isEqualTo(EvalApiError.builder().code("code").message("message").build())
        assertThat(runListResponse.evalId()).isEqualTo("eval_id")
        assertThat(runListResponse.metadata())
            .contains(
                RunListResponse.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(runListResponse.model()).isEqualTo("model")
        assertThat(runListResponse.name()).isEqualTo("name")
        assertThat(runListResponse.perModelUsage())
            .containsExactly(
                RunListResponse.PerModelUsage.builder()
                    .cachedTokens(0L)
                    .completionTokens(0L)
                    .invocationCount(0L)
                    .modelName("model_name")
                    .promptTokens(0L)
                    .totalTokens(0L)
                    .build()
            )
        assertThat(runListResponse.perTestingCriteriaResults())
            .containsExactly(
                RunListResponse.PerTestingCriteriaResult.builder()
                    .failed(0L)
                    .passed(0L)
                    .testingCriteria("testing_criteria")
                    .build()
            )
        assertThat(runListResponse.reportUrl()).isEqualTo("report_url")
        assertThat(runListResponse.resultCounts())
            .isEqualTo(
                RunListResponse.ResultCounts.builder()
                    .errored(0L)
                    .failed(0L)
                    .passed(0L)
                    .total(0L)
                    .build()
            )
        assertThat(runListResponse.status()).isEqualTo("status")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val runListResponse =
            RunListResponse.builder()
                .id("id")
                .createdAt(0L)
                .fileContentJsonlDataSource(
                    listOf(
                        CreateEvalJsonlRunDataSource.Source.FileContent.Content.builder()
                            .item(
                                CreateEvalJsonlRunDataSource.Source.FileContent.Content.Item
                                    .builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .sample(
                                CreateEvalJsonlRunDataSource.Source.FileContent.Content.Sample
                                    .builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .build()
                    )
                )
                .error(EvalApiError.builder().code("code").message("message").build())
                .evalId("eval_id")
                .metadata(
                    RunListResponse.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .model("model")
                .name("name")
                .addPerModelUsage(
                    RunListResponse.PerModelUsage.builder()
                        .cachedTokens(0L)
                        .completionTokens(0L)
                        .invocationCount(0L)
                        .modelName("model_name")
                        .promptTokens(0L)
                        .totalTokens(0L)
                        .build()
                )
                .addPerTestingCriteriaResult(
                    RunListResponse.PerTestingCriteriaResult.builder()
                        .failed(0L)
                        .passed(0L)
                        .testingCriteria("testing_criteria")
                        .build()
                )
                .reportUrl("report_url")
                .resultCounts(
                    RunListResponse.ResultCounts.builder()
                        .errored(0L)
                        .failed(0L)
                        .passed(0L)
                        .total(0L)
                        .build()
                )
                .status("status")
                .build()

        val roundtrippedRunListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(runListResponse),
                jacksonTypeRef<RunListResponse>(),
            )

        assertThat(roundtrippedRunListResponse).isEqualTo(runListResponse)
    }
}
