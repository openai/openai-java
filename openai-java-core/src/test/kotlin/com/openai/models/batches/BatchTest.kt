// File generated from our OpenAPI spec by Stainless.

package com.openai.models.batches

import com.openai.core.JsonValue
import com.openai.models.Metadata
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchTest {

    @Test
    fun create() {
        val batch =
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
                    Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .outputFileId("output_file_id")
                .requestCounts(
                    BatchRequestCounts.builder().completed(0L).failed(0L).total(0L).build()
                )
                .build()

        assertThat(batch.id()).isEqualTo("id")
        assertThat(batch.completionWindow()).isEqualTo("completion_window")
        assertThat(batch.createdAt()).isEqualTo(0L)
        assertThat(batch.endpoint()).isEqualTo("endpoint")
        assertThat(batch.inputFileId()).isEqualTo("input_file_id")
        assertThat(batch.status()).isEqualTo(Batch.Status.VALIDATING)
        assertThat(batch.cancelledAt()).contains(0L)
        assertThat(batch.cancellingAt()).contains(0L)
        assertThat(batch.completedAt()).contains(0L)
        assertThat(batch.errorFileId()).contains("error_file_id")
        assertThat(batch.errors())
            .contains(
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
        assertThat(batch.expiredAt()).contains(0L)
        assertThat(batch.expiresAt()).contains(0L)
        assertThat(batch.failedAt()).contains(0L)
        assertThat(batch.finalizingAt()).contains(0L)
        assertThat(batch.inProgressAt()).contains(0L)
        assertThat(batch.metadata())
            .contains(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
        assertThat(batch.outputFileId()).contains("output_file_id")
        assertThat(batch.requestCounts())
            .contains(BatchRequestCounts.builder().completed(0L).failed(0L).total(0L).build())
    }
}
