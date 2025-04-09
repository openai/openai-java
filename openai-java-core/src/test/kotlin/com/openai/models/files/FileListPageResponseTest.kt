// File generated from our OpenAPI spec by Stainless.

package com.openai.models.files

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
                    FileObject.builder()
                        .id("id")
                        .bytes(0L)
                        .createdAt(0L)
                        .filename("filename")
                        .purpose(FileObject.Purpose.ASSISTANTS)
                        .status(FileObject.Status.UPLOADED)
                        .expiresAt(0L)
                        .statusDetails("status_details")
                        .build()
                )
                .firstId("file-abc123")
                .hasMore(false)
                .lastId("file-abc456")
                .object_("list")
                .build()

        assertThat(fileListPageResponse.data())
            .containsExactly(
                FileObject.builder()
                    .id("id")
                    .bytes(0L)
                    .createdAt(0L)
                    .filename("filename")
                    .purpose(FileObject.Purpose.ASSISTANTS)
                    .status(FileObject.Status.UPLOADED)
                    .expiresAt(0L)
                    .statusDetails("status_details")
                    .build()
            )
        assertThat(fileListPageResponse.firstId()).isEqualTo("file-abc123")
        assertThat(fileListPageResponse.hasMore()).isEqualTo(false)
        assertThat(fileListPageResponse.lastId()).isEqualTo("file-abc456")
        assertThat(fileListPageResponse.object_()).isEqualTo("list")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileListPageResponse =
            FileListPageResponse.builder()
                .addData(
                    FileObject.builder()
                        .id("id")
                        .bytes(0L)
                        .createdAt(0L)
                        .filename("filename")
                        .purpose(FileObject.Purpose.ASSISTANTS)
                        .status(FileObject.Status.UPLOADED)
                        .expiresAt(0L)
                        .statusDetails("status_details")
                        .build()
                )
                .firstId("file-abc123")
                .hasMore(false)
                .lastId("file-abc456")
                .object_("list")
                .build()

        val roundtrippedFileListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileListPageResponse),
                jacksonTypeRef<FileListPageResponse>(),
            )

        assertThat(roundtrippedFileListPageResponse).isEqualTo(fileListPageResponse)
    }
}
