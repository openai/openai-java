// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.containers.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileCreateResponseTest {

    @Test
    fun createAndRoundtrip() {
        val fileCreateResponse =
            FileCreateResponse.builder()
                .id("id")
                .bytes(0L)
                .containerId("container_id")
                .createdAt(0L)
                .path("path")
                .source("source")
                .build()

        assertThat(fileCreateResponse.id()).contains("id")
        assertThat(fileCreateResponse.bytes()).contains(0L)
        assertThat(fileCreateResponse.containerId()).contains("container_id")
        assertThat(fileCreateResponse.createdAt()).contains(0L)
        assertThat(fileCreateResponse.path()).contains("path")
        assertThat(fileCreateResponse.source()).contains("source")

        val jsonMapper = jsonMapper()

        val roundtrippedFileCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileCreateResponse),
                jacksonTypeRef<FileCreateResponse>(),
            )

        assertThat(roundtrippedFileCreateResponse).isEqualTo(fileCreateResponse)
    }
}
