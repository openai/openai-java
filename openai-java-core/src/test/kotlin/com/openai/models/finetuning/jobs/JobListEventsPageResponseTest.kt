// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.finetuning.jobs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JobListEventsPageResponseTest {

    @Test
    fun createAndRoundtrip() {
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

        assertThat(jobListEventsPageResponse.data().getOrNull())
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
        assertThat(jobListEventsPageResponse.hasMore()).contains(true)

        val jsonMapper = jsonMapper()

        val roundtrippedJobListEventsPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(jobListEventsPageResponse),
                jacksonTypeRef<JobListEventsPageResponse>(),
            )

        assertThat(roundtrippedJobListEventsPageResponse).isEqualTo(jobListEventsPageResponse)
    }
}
