// File generated from our OpenAPI spec by Stainless.

package com.openai.models.containers.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileListPageResponseTest {

    @Test
    fun create() {
        val fileListPageResponse =
            FileListPageResponse.builder()
                .addData(
                    FileListResponse.builder()
                        .id("id")
                        .bytes(0L)
                        .containerId("container_id")
                        .createdAt(0L)
                        .path("path")
                        .source("source")
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(fileListPageResponse.data())
            .containsExactly(
                FileListResponse.builder()
                    .id("id")
                    .bytes(0L)
                    .containerId("container_id")
                    .createdAt(0L)
                    .path("path")
                    .source("source")
                    .build()
            )
        assertThat(fileListPageResponse.firstId()).isEqualTo("first_id")
        assertThat(fileListPageResponse.hasMore()).isEqualTo(true)
        assertThat(fileListPageResponse.lastId()).isEqualTo("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileListPageResponse =
            FileListPageResponse.builder()
                .addData(
                    FileListResponse.builder()
                        .id("id")
                        .bytes(0L)
                        .containerId("container_id")
                        .createdAt(0L)
                        .path("path")
                        .source("source")
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedFileListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileListPageResponse),
                jacksonTypeRef<FileListPageResponse>(),
            )

        assertThat(roundtrippedFileListPageResponse).isEqualTo(fileListPageResponse)
    }
}
