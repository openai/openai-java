// File generated from our OpenAPI spec by Stainless.

package com.openai.models.containers.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileListResponseTest {

    @Test
    fun create() {
        val fileListResponse =
            FileListResponse.builder()
                .id("id")
                .bytes(0L)
                .containerId("container_id")
                .createdAt(0L)
                .path("path")
                .source("source")
                .build()

        assertThat(fileListResponse.id()).isEqualTo("id")
        assertThat(fileListResponse.bytes()).isEqualTo(0L)
        assertThat(fileListResponse.containerId()).isEqualTo("container_id")
        assertThat(fileListResponse.createdAt()).isEqualTo(0L)
        assertThat(fileListResponse.path()).isEqualTo("path")
        assertThat(fileListResponse.source()).isEqualTo("source")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileListResponse =
            FileListResponse.builder()
                .id("id")
                .bytes(0L)
                .containerId("container_id")
                .createdAt(0L)
                .path("path")
                .source("source")
                .build()

        val roundtrippedFileListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileListResponse),
                jacksonTypeRef<FileListResponse>(),
            )

        assertThat(roundtrippedFileListResponse).isEqualTo(fileListResponse)
    }
}
