// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.containers.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileRetrieveResponseTest {

    @Test
    fun createAndRoundtrip() {
        val fileRetrieveResponse =
            FileRetrieveResponse.builder()
                .id("id")
                .bytes(0L)
                .containerId("container_id")
                .createdAt(0L)
                .path("path")
                .source("source")
                .build()

        assertThat(fileRetrieveResponse.id()).contains("id")
        assertThat(fileRetrieveResponse.bytes()).contains(0L)
        assertThat(fileRetrieveResponse.containerId()).contains("container_id")
        assertThat(fileRetrieveResponse.createdAt()).contains(0L)
        assertThat(fileRetrieveResponse.path()).contains("path")
        assertThat(fileRetrieveResponse.source()).contains("source")

        val jsonMapper = jsonMapper()

        val roundtrippedFileRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileRetrieveResponse),
                jacksonTypeRef<FileRetrieveResponse>(),
            )

        assertThat(roundtrippedFileRetrieveResponse).isEqualTo(fileRetrieveResponse)
    }
}
