// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileListPageResponseTest {

    @Test
    fun createAndRoundtrip() {
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

        assertThat(fileListPageResponse.data().getOrNull())
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
        assertThat(fileListPageResponse.firstId()).contains("file-abc123")
        assertThat(fileListPageResponse.hasMore()).contains(false)
        assertThat(fileListPageResponse.lastId()).contains("file-abc456")
        assertThat(fileListPageResponse.object_()).contains("list")

        val jsonMapper = jsonMapper()

        val roundtrippedFileListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileListPageResponse),
                jacksonTypeRef<FileListPageResponse>(),
            )

        assertThat(roundtrippedFileListPageResponse).isEqualTo(fileListPageResponse)
    }
}
