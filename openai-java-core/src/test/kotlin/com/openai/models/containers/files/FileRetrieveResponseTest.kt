// File generated from our OpenAPI spec by Stainless.

package com.openai.models.containers.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileRetrieveResponseTest {

    @Test
    fun create() {
        val fileRetrieveResponse =
            FileRetrieveResponse.builder()
                .id("id")
                .bytes(0L)
                .containerId("container_id")
                .createdAt(0L)
                .path("path")
                .source("source")
                .build()

        assertThat(fileRetrieveResponse.id()).isEqualTo("id")
        assertThat(fileRetrieveResponse.bytes()).isEqualTo(0L)
        assertThat(fileRetrieveResponse.containerId()).isEqualTo("container_id")
        assertThat(fileRetrieveResponse.createdAt()).isEqualTo(0L)
        assertThat(fileRetrieveResponse.path()).isEqualTo("path")
        assertThat(fileRetrieveResponse.source()).isEqualTo("source")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileRetrieveResponse =
            FileRetrieveResponse.builder()
                .id("id")
                .bytes(0L)
                .containerId("container_id")
                .createdAt(0L)
                .path("path")
                .source("source")
                .build()

        val roundtrippedFileRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileRetrieveResponse),
                jacksonTypeRef<FileRetrieveResponse>(),
            )

        assertThat(roundtrippedFileRetrieveResponse).isEqualTo(fileRetrieveResponse)
    }
}
