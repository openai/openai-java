// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.environments.files

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
                    EnvironmentFile.builder()
                        .environmentId("environment_id")
                        .path("path")
                        .sizeBytes(0L)
                        .build()
                )
                .hasMore(true)
                .next("next")
                .object_(FileListPageResponse.Object.PAGE)
                .build()

        assertThat(fileListPageResponse.data())
            .containsExactly(
                EnvironmentFile.builder()
                    .environmentId("environment_id")
                    .path("path")
                    .sizeBytes(0L)
                    .build()
            )
        assertThat(fileListPageResponse.hasMore()).isEqualTo(true)
        assertThat(fileListPageResponse.next()).contains("next")
        assertThat(fileListPageResponse.object_()).isEqualTo(FileListPageResponse.Object.PAGE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileListPageResponse =
            FileListPageResponse.builder()
                .addData(
                    EnvironmentFile.builder()
                        .environmentId("environment_id")
                        .path("path")
                        .sizeBytes(0L)
                        .build()
                )
                .hasMore(true)
                .next("next")
                .object_(FileListPageResponse.Object.PAGE)
                .build()

        val roundtrippedFileListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileListPageResponse),
                jacksonTypeRef<FileListPageResponse>(),
            )

        assertThat(roundtrippedFileListPageResponse).isEqualTo(fileListPageResponse)
    }
}
