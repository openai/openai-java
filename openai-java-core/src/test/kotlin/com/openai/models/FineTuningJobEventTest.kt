// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FineTuningJobEventTest {

    @Test
    fun createFineTuningJobEvent() {
        val fineTuningJobEvent =
            FineTuningJobEvent.builder()
                .id("id")
                .createdAt(0L)
                .level(FineTuningJobEvent.Level.INFO)
                .message("message")
                .object_(FineTuningJobEvent.Object.FINE_TUNING_JOB_EVENT)
                .build()
        assertThat(fineTuningJobEvent).isNotNull
        assertThat(fineTuningJobEvent.id()).isEqualTo("id")
        assertThat(fineTuningJobEvent.createdAt()).isEqualTo(0L)
        assertThat(fineTuningJobEvent.level()).isEqualTo(FineTuningJobEvent.Level.INFO)
        assertThat(fineTuningJobEvent.message()).isEqualTo("message")
        assertThat(fineTuningJobEvent.object_())
            .isEqualTo(FineTuningJobEvent.Object.FINE_TUNING_JOB_EVENT)
    }
}
