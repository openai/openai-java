// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FineTuningJobEventTest {

    @Test
    fun create() {
        val fineTuningJobEvent =
            FineTuningJobEvent.builder()
                .id("id")
                .createdAt(0L)
                .level(FineTuningJobEvent.Level.INFO)
                .message("message")
                .data(JsonValue.from(mapOf<String, Any>()))
                .type(FineTuningJobEvent.Type.MESSAGE)
                .build()

        assertThat(fineTuningJobEvent.id()).isEqualTo("id")
        assertThat(fineTuningJobEvent.createdAt()).isEqualTo(0L)
        assertThat(fineTuningJobEvent.level()).isEqualTo(FineTuningJobEvent.Level.INFO)
        assertThat(fineTuningJobEvent.message()).isEqualTo("message")
        assertThat(fineTuningJobEvent._data()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(fineTuningJobEvent.type()).contains(FineTuningJobEvent.Type.MESSAGE)
    }
}
