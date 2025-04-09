// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JobListEventsPageResponseTest {

    @Test
    fun create() {
        val jobListEventsPageResponse =
            JobListEventsPageResponse.builder()
                .addData(
                    FineTuningJobEvent.builder()
                        .id("id")
                        .createdAt(0L)
                        .level(FineTuningJobEvent.Level.INFO)
                        .message("message")
                        .data(JsonValue.from(mapOf<String, Any>()))
                        .type(FineTuningJobEvent.Type.MESSAGE)
                        .build()
                )
                .hasMore(true)
                .build()

        assertThat(jobListEventsPageResponse.data())
            .containsExactly(
                FineTuningJobEvent.builder()
                    .id("id")
                    .createdAt(0L)
                    .level(FineTuningJobEvent.Level.INFO)
                    .message("message")
                    .data(JsonValue.from(mapOf<String, Any>()))
                    .type(FineTuningJobEvent.Type.MESSAGE)
                    .build()
            )
        assertThat(jobListEventsPageResponse.hasMore()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val jobListEventsPageResponse =
            JobListEventsPageResponse.builder()
                .addData(
                    FineTuningJobEvent.builder()
                        .id("id")
                        .createdAt(0L)
                        .level(FineTuningJobEvent.Level.INFO)
                        .message("message")
                        .data(JsonValue.from(mapOf<String, Any>()))
                        .type(FineTuningJobEvent.Type.MESSAGE)
                        .build()
                )
                .hasMore(true)
                .build()

        val roundtrippedJobListEventsPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(jobListEventsPageResponse),
                jacksonTypeRef<JobListEventsPageResponse>(),
            )

        assertThat(roundtrippedJobListEventsPageResponse).isEqualTo(jobListEventsPageResponse)
    }
}
