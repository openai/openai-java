// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs.outputitems

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.evals.runs.EvalApiError
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OutputItemListPageResponseTest {

    @Test
    fun create() {
        val outputItemListPageResponse =
            OutputItemListPageResponse.builder()
                .addData(
                    OutputItemListResponse.builder()
                        .id("id")
                        .createdAt(0L)
                        .datasourceItem(
                            OutputItemListResponse.DatasourceItem.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .datasourceItemId(0L)
                        .evalId("eval_id")
                        .addResult(
                            OutputItemListResponse.Result.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .runId("run_id")
                        .sample(
                            OutputItemListResponse.Sample.builder()
                                .error(
                                    EvalApiError.builder().code("code").message("message").build()
                                )
                                .finishReason("finish_reason")
                                .addInput(
                                    OutputItemListResponse.Sample.Input.builder()
                                        .content("content")
                                        .role("role")
                                        .build()
                                )
                                .maxCompletionTokens(0L)
                                .model("model")
                                .addOutput(
                                    OutputItemListResponse.Sample.Output.builder()
                                        .content("content")
                                        .role("role")
                                        .build()
                                )
                                .seed(0L)
                                .temperature(0.0)
                                .topP(0.0)
                                .usage(
                                    OutputItemListResponse.Sample.Usage.builder()
                                        .cachedTokens(0L)
                                        .completionTokens(0L)
                                        .promptTokens(0L)
                                        .totalTokens(0L)
                                        .build()
                                )
                                .build()
                        )
                        .status("status")
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(outputItemListPageResponse.data())
            .containsExactly(
                OutputItemListResponse.builder()
                    .id("id")
                    .createdAt(0L)
                    .datasourceItem(
                        OutputItemListResponse.DatasourceItem.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .datasourceItemId(0L)
                    .evalId("eval_id")
                    .addResult(
                        OutputItemListResponse.Result.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .runId("run_id")
                    .sample(
                        OutputItemListResponse.Sample.builder()
                            .error(EvalApiError.builder().code("code").message("message").build())
                            .finishReason("finish_reason")
                            .addInput(
                                OutputItemListResponse.Sample.Input.builder()
                                    .content("content")
                                    .role("role")
                                    .build()
                            )
                            .maxCompletionTokens(0L)
                            .model("model")
                            .addOutput(
                                OutputItemListResponse.Sample.Output.builder()
                                    .content("content")
                                    .role("role")
                                    .build()
                            )
                            .seed(0L)
                            .temperature(0.0)
                            .topP(0.0)
                            .usage(
                                OutputItemListResponse.Sample.Usage.builder()
                                    .cachedTokens(0L)
                                    .completionTokens(0L)
                                    .promptTokens(0L)
                                    .totalTokens(0L)
                                    .build()
                            )
                            .build()
                    )
                    .status("status")
                    .build()
            )
        assertThat(outputItemListPageResponse.firstId()).isEqualTo("first_id")
        assertThat(outputItemListPageResponse.hasMore()).isEqualTo(true)
        assertThat(outputItemListPageResponse.lastId()).isEqualTo("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val outputItemListPageResponse =
            OutputItemListPageResponse.builder()
                .addData(
                    OutputItemListResponse.builder()
                        .id("id")
                        .createdAt(0L)
                        .datasourceItem(
                            OutputItemListResponse.DatasourceItem.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .datasourceItemId(0L)
                        .evalId("eval_id")
                        .addResult(
                            OutputItemListResponse.Result.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .runId("run_id")
                        .sample(
                            OutputItemListResponse.Sample.builder()
                                .error(
                                    EvalApiError.builder().code("code").message("message").build()
                                )
                                .finishReason("finish_reason")
                                .addInput(
                                    OutputItemListResponse.Sample.Input.builder()
                                        .content("content")
                                        .role("role")
                                        .build()
                                )
                                .maxCompletionTokens(0L)
                                .model("model")
                                .addOutput(
                                    OutputItemListResponse.Sample.Output.builder()
                                        .content("content")
                                        .role("role")
                                        .build()
                                )
                                .seed(0L)
                                .temperature(0.0)
                                .topP(0.0)
                                .usage(
                                    OutputItemListResponse.Sample.Usage.builder()
                                        .cachedTokens(0L)
                                        .completionTokens(0L)
                                        .promptTokens(0L)
                                        .totalTokens(0L)
                                        .build()
                                )
                                .build()
                        )
                        .status("status")
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedOutputItemListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(outputItemListPageResponse),
                jacksonTypeRef<OutputItemListPageResponse>(),
            )

        assertThat(roundtrippedOutputItemListPageResponse).isEqualTo(outputItemListPageResponse)
    }
}
