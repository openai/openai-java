// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileSearchToolCallDeltaTest {

    @Test
    fun create() {
        val fileSearchToolCallDelta =
            FileSearchToolCallDelta.builder()
                .fileSearch(JsonValue.from(mapOf<String, Any>()))
                .index(0L)
                .id("id")
                .build()

        assertThat(fileSearchToolCallDelta._fileSearch())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(fileSearchToolCallDelta.index()).isEqualTo(0L)
        assertThat(fileSearchToolCallDelta.id()).contains("id")
    }
}
