// File generated from our OpenAPI spec by Stainless.

package com.openai.models.batches

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchListPageResponseTest {

    @Test
    fun create() {
        val batchListPageResponse =
            BatchListPageResponse.builder()
                .addData(
                    Batch.builder()
                        .id("id")
                        .completionWindow("completion_window")
                        .createdAt(0L)
                        .endpoint("endpoint")
                        .inputFileId("input_file_id")
                        .status(Batch.Status.VALIDATING)
                        .cancelledAt(0L)
                        .cancellingAt(0L)
                        .completedAt(0L)
                        .errorFileId("error_file_id")
                        .errors(
                            Batch.Errors.builder()
                                .addData(
                                    BatchError.builder()
                                        .code("code")
                                        .line(0L)
                                        .message("message")
                                        .param("param")
                                        .build()
                                )
                                .object_("object")
                                .build()
                        )
                        .expiredAt(0L)
                        .expiresAt(0L)
                        .failedAt(0L)
                        .finalizingAt(0L)
                        .inProgressAt(0L)
                        .metadata(
                            Batch.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .outputFileId("output_file_id")
                        .requestCounts(
                            BatchRequestCounts.builder().completed(0L).failed(0L).total(0L).build()
                        )
                        .build()
                )
                .hasMore(true)
                .firstId("batch_abc123")
                .lastId("batch_abc456")
                .build()

        assertThat(batchListPageResponse.data())
            .containsExactly(
                Batch.builder()
                    .id("id")
                    .completionWindow("completion_window")
                    .createdAt(0L)
                    .endpoint("endpoint")
                    .inputFileId("input_file_id")
                    .status(Batch.Status.VALIDATING)
                    .cancelledAt(0L)
                    .cancellingAt(0L)
                    .completedAt(0L)
                    .errorFileId("error_file_id")
                    .errors(
                        Batch.Errors.builder()
                            .addData(
                                BatchError.builder()
                                    .code("code")
                                    .line(0L)
                                    .message("message")
                                    .param("param")
                                    .build()
                            )
                            .object_("object")
                            .build()
                    )
                    .expiredAt(0L)
                    .expiresAt(0L)
                    .failedAt(0L)
                    .finalizingAt(0L)
                    .inProgressAt(0L)
                    .metadata(
                        Batch.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .outputFileId("output_file_id")
                    .requestCounts(
                        BatchRequestCounts.builder().completed(0L).failed(0L).total(0L).build()
                    )
                    .build()
            )
        assertThat(batchListPageResponse.hasMore()).isEqualTo(true)
        assertThat(batchListPageResponse.firstId()).contains("batch_abc123")
        assertThat(batchListPageResponse.lastId()).contains("batch_abc456")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val batchListPageResponse =
            BatchListPageResponse.builder()
                .addData(
                    Batch.builder()
                        .id("id")
                        .completionWindow("completion_window")
                        .createdAt(0L)
                        .endpoint("endpoint")
                        .inputFileId("input_file_id")
                        .status(Batch.Status.VALIDATING)
                        .cancelledAt(0L)
                        .cancellingAt(0L)
                        .completedAt(0L)
                        .errorFileId("error_file_id")
                        .errors(
                            Batch.Errors.builder()
                                .addData(
                                    BatchError.builder()
                                        .code("code")
                                        .line(0L)
                                        .message("message")
                                        .param("param")
                                        .build()
                                )
                                .object_("object")
                                .build()
                        )
                        .expiredAt(0L)
                        .expiresAt(0L)
                        .failedAt(0L)
                        .finalizingAt(0L)
                        .inProgressAt(0L)
                        .metadata(
                            Batch.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .outputFileId("output_file_id")
                        .requestCounts(
                            BatchRequestCounts.builder().completed(0L).failed(0L).total(0L).build()
                        )
                        .build()
                )
                .hasMore(true)
                .firstId("batch_abc123")
                .lastId("batch_abc456")
                .build()

        val roundtrippedBatchListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(batchListPageResponse),
                jacksonTypeRef<BatchListPageResponse>(),
            )

        assertThat(roundtrippedBatchListPageResponse).isEqualTo(batchListPageResponse)
    }
}
