// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RunListPageResponseTest {

    @Test
    fun create() {
        val runListPageResponse =
            RunListPageResponse.builder()
                .addData(
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
                                        CreateEvalJsonlRunDataSource.Source.FileContent.Content
                                            .Sample
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
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(runListPageResponse.data())
            .containsExactly(
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
            )
        assertThat(runListPageResponse.firstId()).isEqualTo("first_id")
        assertThat(runListPageResponse.hasMore()).isEqualTo(true)
        assertThat(runListPageResponse.lastId()).isEqualTo("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val runListPageResponse =
            RunListPageResponse.builder()
                .addData(
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
                                        CreateEvalJsonlRunDataSource.Source.FileContent.Content
                                            .Sample
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
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedRunListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(runListPageResponse),
                jacksonTypeRef<RunListPageResponse>(),
            )

        assertThat(roundtrippedRunListPageResponse).isEqualTo(runListPageResponse)
    }
}
