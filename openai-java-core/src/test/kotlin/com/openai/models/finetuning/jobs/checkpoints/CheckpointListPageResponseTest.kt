// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs.checkpoints

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CheckpointListPageResponseTest {

    @Test
    fun create() {
        val checkpointListPageResponse =
            CheckpointListPageResponse.builder()
                .addData(
                    FineTuningJobCheckpoint.builder()
                        .id("id")
                        .createdAt(0L)
                        .fineTunedModelCheckpoint("fine_tuned_model_checkpoint")
                        .fineTuningJobId("fine_tuning_job_id")
                        .metrics(
                            FineTuningJobCheckpoint.Metrics.builder()
                                .fullValidLoss(0.0)
                                .fullValidMeanTokenAccuracy(0.0)
                                .step(0.0)
                                .trainLoss(0.0)
                                .trainMeanTokenAccuracy(0.0)
                                .validLoss(0.0)
                                .validMeanTokenAccuracy(0.0)
                                .build()
                        )
                        .stepNumber(0L)
                        .build()
                )
                .hasMore(true)
                .firstId("first_id")
                .lastId("last_id")
                .build()

        assertThat(checkpointListPageResponse.data())
            .containsExactly(
                FineTuningJobCheckpoint.builder()
                    .id("id")
                    .createdAt(0L)
                    .fineTunedModelCheckpoint("fine_tuned_model_checkpoint")
                    .fineTuningJobId("fine_tuning_job_id")
                    .metrics(
                        FineTuningJobCheckpoint.Metrics.builder()
                            .fullValidLoss(0.0)
                            .fullValidMeanTokenAccuracy(0.0)
                            .step(0.0)
                            .trainLoss(0.0)
                            .trainMeanTokenAccuracy(0.0)
                            .validLoss(0.0)
                            .validMeanTokenAccuracy(0.0)
                            .build()
                    )
                    .stepNumber(0L)
                    .build()
            )
        assertThat(checkpointListPageResponse.hasMore()).isEqualTo(true)
        assertThat(checkpointListPageResponse.firstId()).contains("first_id")
        assertThat(checkpointListPageResponse.lastId()).contains("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val checkpointListPageResponse =
            CheckpointListPageResponse.builder()
                .addData(
                    FineTuningJobCheckpoint.builder()
                        .id("id")
                        .createdAt(0L)
                        .fineTunedModelCheckpoint("fine_tuned_model_checkpoint")
                        .fineTuningJobId("fine_tuning_job_id")
                        .metrics(
                            FineTuningJobCheckpoint.Metrics.builder()
                                .fullValidLoss(0.0)
                                .fullValidMeanTokenAccuracy(0.0)
                                .step(0.0)
                                .trainLoss(0.0)
                                .trainMeanTokenAccuracy(0.0)
                                .validLoss(0.0)
                                .validMeanTokenAccuracy(0.0)
                                .build()
                        )
                        .stepNumber(0L)
                        .build()
                )
                .hasMore(true)
                .firstId("first_id")
                .lastId("last_id")
                .build()

        val roundtrippedCheckpointListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(checkpointListPageResponse),
                jacksonTypeRef<CheckpointListPageResponse>(),
            )

        assertThat(roundtrippedCheckpointListPageResponse).isEqualTo(checkpointListPageResponse)
    }
}
