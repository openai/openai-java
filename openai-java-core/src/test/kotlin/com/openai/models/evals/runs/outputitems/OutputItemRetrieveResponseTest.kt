// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs.outputitems

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.evals.runs.EvalApiError
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OutputItemRetrieveResponseTest {

    @Test
    fun create() {
        val outputItemRetrieveResponse =
            OutputItemRetrieveResponse.builder()
                .id("id")
                .createdAt(0L)
                .datasourceItem(
                    OutputItemRetrieveResponse.DatasourceItem.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .datasourceItemId(0L)
                .evalId("eval_id")
                .addResult(
                    OutputItemRetrieveResponse.Result.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .runId("run_id")
                .sample(
                    OutputItemRetrieveResponse.Sample.builder()
                        .error(EvalApiError.builder().code("code").message("message").build())
                        .finishReason("finish_reason")
                        .addInput(
                            OutputItemRetrieveResponse.Sample.Input.builder()
                                .content("content")
                                .role("role")
                                .build()
                        )
                        .maxCompletionTokens(0L)
                        .model("model")
                        .addOutput(
                            OutputItemRetrieveResponse.Sample.Output.builder()
                                .content("content")
                                .role("role")
                                .build()
                        )
                        .seed(0L)
                        .temperature(0.0)
                        .topP(0.0)
                        .usage(
                            OutputItemRetrieveResponse.Sample.Usage.builder()
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

        assertThat(outputItemRetrieveResponse.id()).isEqualTo("id")
        assertThat(outputItemRetrieveResponse.createdAt()).isEqualTo(0L)
        assertThat(outputItemRetrieveResponse.datasourceItem())
            .isEqualTo(
                OutputItemRetrieveResponse.DatasourceItem.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(outputItemRetrieveResponse.datasourceItemId()).isEqualTo(0L)
        assertThat(outputItemRetrieveResponse.evalId()).isEqualTo("eval_id")
        assertThat(outputItemRetrieveResponse.results())
            .containsExactly(
                OutputItemRetrieveResponse.Result.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(outputItemRetrieveResponse.runId()).isEqualTo("run_id")
        assertThat(outputItemRetrieveResponse.sample())
            .isEqualTo(
                OutputItemRetrieveResponse.Sample.builder()
                    .error(EvalApiError.builder().code("code").message("message").build())
                    .finishReason("finish_reason")
                    .addInput(
                        OutputItemRetrieveResponse.Sample.Input.builder()
                            .content("content")
                            .role("role")
                            .build()
                    )
                    .maxCompletionTokens(0L)
                    .model("model")
                    .addOutput(
                        OutputItemRetrieveResponse.Sample.Output.builder()
                            .content("content")
                            .role("role")
                            .build()
                    )
                    .seed(0L)
                    .temperature(0.0)
                    .topP(0.0)
                    .usage(
                        OutputItemRetrieveResponse.Sample.Usage.builder()
                            .cachedTokens(0L)
                            .completionTokens(0L)
                            .promptTokens(0L)
                            .totalTokens(0L)
                            .build()
                    )
                    .build()
            )
        assertThat(outputItemRetrieveResponse.status()).isEqualTo("status")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val outputItemRetrieveResponse =
            OutputItemRetrieveResponse.builder()
                .id("id")
                .createdAt(0L)
                .datasourceItem(
                    OutputItemRetrieveResponse.DatasourceItem.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .datasourceItemId(0L)
                .evalId("eval_id")
                .addResult(
                    OutputItemRetrieveResponse.Result.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .runId("run_id")
                .sample(
                    OutputItemRetrieveResponse.Sample.builder()
                        .error(EvalApiError.builder().code("code").message("message").build())
                        .finishReason("finish_reason")
                        .addInput(
                            OutputItemRetrieveResponse.Sample.Input.builder()
                                .content("content")
                                .role("role")
                                .build()
                        )
                        .maxCompletionTokens(0L)
                        .model("model")
                        .addOutput(
                            OutputItemRetrieveResponse.Sample.Output.builder()
                                .content("content")
                                .role("role")
                                .build()
                        )
                        .seed(0L)
                        .temperature(0.0)
                        .topP(0.0)
                        .usage(
                            OutputItemRetrieveResponse.Sample.Usage.builder()
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

        val roundtrippedOutputItemRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(outputItemRetrieveResponse),
                jacksonTypeRef<OutputItemRetrieveResponse>(),
            )

        assertThat(roundtrippedOutputItemRetrieveResponse).isEqualTo(outputItemRetrieveResponse)
    }
}
