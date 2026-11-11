// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.containers.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileListResponseTest {

    @Test
    fun createAndRoundtrip() {
        val fileListResponse =
            FileListResponse.builder()
                .id("id")
                .bytes(0L)
                .containerId("container_id")
                .createdAt(0L)
                .path("path")
                .source("source")
                .build()

        assertThat(fileListResponse.id()).contains("id")
        assertThat(fileListResponse.bytes()).contains(0L)
        assertThat(fileListResponse.containerId()).contains("container_id")
        assertThat(fileListResponse.createdAt()).contains(0L)
        assertThat(fileListResponse.path()).contains("path")
        assertThat(fileListResponse.source()).contains("source")

        val jsonMapper = jsonMapper()

        val roundtrippedFileListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileListResponse),
                jacksonTypeRef<FileListResponse>(),
            )

        assertThat(roundtrippedFileListResponse).isEqualTo(fileListResponse)
    }
}
