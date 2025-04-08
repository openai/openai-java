// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs.outputitems

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.evals.runs.EvalApiError
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OutputItemListResponseTest {

    @Test
    fun create() {
        val outputItemListResponse =
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

        assertThat(outputItemListResponse.id()).isEqualTo("id")
        assertThat(outputItemListResponse.createdAt()).isEqualTo(0L)
        assertThat(outputItemListResponse.datasourceItem())
            .isEqualTo(
                OutputItemListResponse.DatasourceItem.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(outputItemListResponse.datasourceItemId()).isEqualTo(0L)
        assertThat(outputItemListResponse.evalId()).isEqualTo("eval_id")
        assertThat(outputItemListResponse.results())
            .containsExactly(
                OutputItemListResponse.Result.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(outputItemListResponse.runId()).isEqualTo("run_id")
        assertThat(outputItemListResponse.sample())
            .isEqualTo(
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
        assertThat(outputItemListResponse.status()).isEqualTo("status")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val outputItemListResponse =
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

        val roundtrippedOutputItemListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(outputItemListResponse),
                jacksonTypeRef<OutputItemListResponse>(),
            )

        assertThat(roundtrippedOutputItemListResponse).isEqualTo(outputItemListResponse)
    }
}
