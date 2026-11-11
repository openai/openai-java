// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.evals.runs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RunCancelResponseTest {

    @Test
    fun createAndRoundtrip() {
        val runCancelResponse =
            RunCancelResponse.builder()
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
                    RunCancelResponse.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .model("model")
                .name("name")
                .addPerModelUsage(
                    RunCancelResponse.PerModelUsage.builder()
                        .cachedTokens(0L)
                        .completionTokens(0L)
                        .invocationCount(0L)
                        .modelName("model_name")
                        .promptTokens(0L)
                        .totalTokens(0L)
                        .build()
                )
                .addPerTestingCriteriaResult(
                    RunCancelResponse.PerTestingCriteriaResult.builder()
                        .failed(0L)
                        .passed(0L)
                        .testingCriteria("testing_criteria")
                        .build()
                )
                .reportUrl("https://example.com")
                .resultCounts(
                    RunCancelResponse.ResultCounts.builder()
                        .errored(0L)
                        .failed(0L)
                        .passed(0L)
                        .total(0L)
                        .build()
                )
                .status("status")
                .build()

        assertThat(runCancelResponse.id()).contains("id")
        assertThat(runCancelResponse.createdAt()).contains(0L)
        assertThat(runCancelResponse.dataSource())
            .contains(
                RunCancelResponse.DataSource.ofJsonl(
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
        assertThat(runCancelResponse.error())
            .contains(EvalApiError.builder().code("code").message("message").build())
        assertThat(runCancelResponse.evalId()).contains("eval_id")
        assertThat(runCancelResponse.metadata())
            .contains(
                RunCancelResponse.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(runCancelResponse.model()).contains("model")
        assertThat(runCancelResponse.name()).contains("name")
        assertThat(runCancelResponse.perModelUsage().getOrNull())
            .containsExactly(
                RunCancelResponse.PerModelUsage.builder()
                    .cachedTokens(0L)
                    .completionTokens(0L)
                    .invocationCount(0L)
                    .modelName("model_name")
                    .promptTokens(0L)
                    .totalTokens(0L)
                    .build()
            )
        assertThat(runCancelResponse.perTestingCriteriaResults().getOrNull())
            .containsExactly(
                RunCancelResponse.PerTestingCriteriaResult.builder()
                    .failed(0L)
                    .passed(0L)
                    .testingCriteria("testing_criteria")
                    .build()
            )
        assertThat(runCancelResponse.reportUrl()).contains("https://example.com")
        assertThat(runCancelResponse.resultCounts())
            .contains(
                RunCancelResponse.ResultCounts.builder()
                    .errored(0L)
                    .failed(0L)
                    .passed(0L)
                    .total(0L)
                    .build()
            )
        assertThat(runCancelResponse.status()).contains("status")

        val jsonMapper = jsonMapper()

        val roundtrippedRunCancelResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(runCancelResponse),
                jacksonTypeRef<RunCancelResponse>(),
            )

        assertThat(roundtrippedRunCancelResponse).isEqualTo(runCancelResponse)
    }
}
