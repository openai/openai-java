// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RunRetrieveResponseTest {

    @Test
    fun create() {
        val runRetrieveResponse =
            RunRetrieveResponse.builder()
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
                    RunRetrieveResponse.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .model("model")
                .name("name")
                .addPerModelUsage(
                    RunRetrieveResponse.PerModelUsage.builder()
                        .cachedTokens(0L)
                        .completionTokens(0L)
                        .invocationCount(0L)
                        .modelName("model_name")
                        .promptTokens(0L)
                        .totalTokens(0L)
                        .build()
                )
                .addPerTestingCriteriaResult(
                    RunRetrieveResponse.PerTestingCriteriaResult.builder()
                        .failed(0L)
                        .passed(0L)
                        .testingCriteria("testing_criteria")
                        .build()
                )
                .reportUrl("report_url")
                .resultCounts(
                    RunRetrieveResponse.ResultCounts.builder()
                        .errored(0L)
                        .failed(0L)
                        .passed(0L)
                        .total(0L)
                        .build()
                )
                .status("status")
                .build()

        assertThat(runRetrieveResponse.id()).isEqualTo("id")
        assertThat(runRetrieveResponse.createdAt()).isEqualTo(0L)
        assertThat(runRetrieveResponse.dataSource())
            .isEqualTo(
                RunRetrieveResponse.DataSource.ofJsonl(
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
        assertThat(runRetrieveResponse.error())
            .isEqualTo(EvalApiError.builder().code("code").message("message").build())
        assertThat(runRetrieveResponse.evalId()).isEqualTo("eval_id")
        assertThat(runRetrieveResponse.metadata())
            .contains(
                RunRetrieveResponse.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(runRetrieveResponse.model()).isEqualTo("model")
        assertThat(runRetrieveResponse.name()).isEqualTo("name")
        assertThat(runRetrieveResponse.perModelUsage())
            .containsExactly(
                RunRetrieveResponse.PerModelUsage.builder()
                    .cachedTokens(0L)
                    .completionTokens(0L)
                    .invocationCount(0L)
                    .modelName("model_name")
                    .promptTokens(0L)
                    .totalTokens(0L)
                    .build()
            )
        assertThat(runRetrieveResponse.perTestingCriteriaResults())
            .containsExactly(
                RunRetrieveResponse.PerTestingCriteriaResult.builder()
                    .failed(0L)
                    .passed(0L)
                    .testingCriteria("testing_criteria")
                    .build()
            )
        assertThat(runRetrieveResponse.reportUrl()).isEqualTo("report_url")
        assertThat(runRetrieveResponse.resultCounts())
            .isEqualTo(
                RunRetrieveResponse.ResultCounts.builder()
                    .errored(0L)
                    .failed(0L)
                    .passed(0L)
                    .total(0L)
                    .build()
            )
        assertThat(runRetrieveResponse.status()).isEqualTo("status")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val runRetrieveResponse =
            RunRetrieveResponse.builder()
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
                    RunRetrieveResponse.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .model("model")
                .name("name")
                .addPerModelUsage(
                    RunRetrieveResponse.PerModelUsage.builder()
                        .cachedTokens(0L)
                        .completionTokens(0L)
                        .invocationCount(0L)
                        .modelName("model_name")
                        .promptTokens(0L)
                        .totalTokens(0L)
                        .build()
                )
                .addPerTestingCriteriaResult(
                    RunRetrieveResponse.PerTestingCriteriaResult.builder()
                        .failed(0L)
                        .passed(0L)
                        .testingCriteria("testing_criteria")
                        .build()
                )
                .reportUrl("report_url")
                .resultCounts(
                    RunRetrieveResponse.ResultCounts.builder()
                        .errored(0L)
                        .failed(0L)
                        .passed(0L)
                        .total(0L)
                        .build()
                )
                .status("status")
                .build()

        val roundtrippedRunRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(runRetrieveResponse),
                jacksonTypeRef<RunRetrieveResponse>(),
            )

        assertThat(roundtrippedRunRetrieveResponse).isEqualTo(runRetrieveResponse)
    }
}
