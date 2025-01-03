// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileSearchToolCallDeltaTest {

    @Test
    fun createFileSearchToolCallDelta() {
        val fileSearchToolCallDelta =
            FileSearchToolCallDelta.builder()
                .fileSearch(JsonValue.from(mapOf<String, Any>()))
                .index(0L)
                .type(FileSearchToolCallDelta.Type.FILE_SEARCH)
                .id("id")
                .build()
        assertThat(fileSearchToolCallDelta).isNotNull
        assertThat(fileSearchToolCallDelta._fileSearch())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(fileSearchToolCallDelta.index()).isEqualTo(0L)
        assertThat(fileSearchToolCallDelta.type())
            .isEqualTo(FileSearchToolCallDelta.Type.FILE_SEARCH)
        assertThat(fileSearchToolCallDelta.id()).contains("id")
    }
}
