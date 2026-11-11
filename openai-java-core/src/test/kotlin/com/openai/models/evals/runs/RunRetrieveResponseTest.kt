// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.evals.runs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RunRetrieveResponseTest {

    @Test
    fun createAndRoundtrip() {
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
                .reportUrl("https://example.com")
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

        assertThat(runRetrieveResponse.id()).contains("id")
        assertThat(runRetrieveResponse.createdAt()).contains(0L)
        assertThat(runRetrieveResponse.dataSource())
            .contains(
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
            .contains(EvalApiError.builder().code("code").message("message").build())
        assertThat(runRetrieveResponse.evalId()).contains("eval_id")
        assertThat(runRetrieveResponse.metadata())
            .contains(
                RunRetrieveResponse.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(runRetrieveResponse.model()).contains("model")
        assertThat(runRetrieveResponse.name()).contains("name")
        assertThat(runRetrieveResponse.perModelUsage().getOrNull())
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
        assertThat(runRetrieveResponse.perTestingCriteriaResults().getOrNull())
            .containsExactly(
                RunRetrieveResponse.PerTestingCriteriaResult.builder()
                    .failed(0L)
                    .passed(0L)
                    .testingCriteria("testing_criteria")
                    .build()
            )
        assertThat(runRetrieveResponse.reportUrl()).contains("https://example.com")
        assertThat(runRetrieveResponse.resultCounts())
            .contains(
                RunRetrieveResponse.ResultCounts.builder()
                    .errored(0L)
                    .failed(0L)
                    .passed(0L)
                    .total(0L)
                    .build()
            )
        assertThat(runRetrieveResponse.status()).contains("status")

        val jsonMapper = jsonMapper()

        val roundtrippedRunRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(runRetrieveResponse),
                jacksonTypeRef<RunRetrieveResponse>(),
            )

        assertThat(roundtrippedRunRetrieveResponse).isEqualTo(runRetrieveResponse)
    }
}
