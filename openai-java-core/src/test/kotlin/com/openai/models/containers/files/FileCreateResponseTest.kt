// File generated from our OpenAPI spec by Stainless.

package com.openai.models.containers.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileCreateResponseTest {

    @Test
    fun create() {
        val fileCreateResponse =
            FileCreateResponse.builder()
                .id("id")
                .bytes(0L)
                .containerId("container_id")
                .createdAt(0L)
                .path("path")
                .source("source")
                .build()

        assertThat(fileCreateResponse.id()).isEqualTo("id")
        assertThat(fileCreateResponse.bytes()).isEqualTo(0L)
        assertThat(fileCreateResponse.containerId()).isEqualTo("container_id")
        assertThat(fileCreateResponse.createdAt()).isEqualTo(0L)
        assertThat(fileCreateResponse.path()).isEqualTo("path")
        assertThat(fileCreateResponse.source()).isEqualTo("source")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileCreateResponse =
            FileCreateResponse.builder()
                .id("id")
                .bytes(0L)
                .containerId("container_id")
                .createdAt(0L)
                .path("path")
                .source("source")
                .build()

        val roundtrippedFileCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileCreateResponse),
                jacksonTypeRef<FileCreateResponse>(),
            )

        assertThat(roundtrippedFileCreateResponse).isEqualTo(fileCreateResponse)
    }
}
