// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class HostedEnvironmentFileIdTest {

    @Test
    fun create() {
        val hostedEnvironmentFileId =
            HostedEnvironmentFileId.builder()
                .id("id")
                .fileId("file_id")
                .path("path")
                .sizeBytes(0L)
                .build()

        assertThat(hostedEnvironmentFileId.id()).isEqualTo("id")
        assertThat(hostedEnvironmentFileId.fileId()).isEqualTo("file_id")
        assertThat(hostedEnvironmentFileId.path()).isEqualTo("path")
        assertThat(hostedEnvironmentFileId.sizeBytes()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val hostedEnvironmentFileId =
            HostedEnvironmentFileId.builder()
                .id("id")
                .fileId("file_id")
                .path("path")
                .sizeBytes(0L)
                .build()

        val roundtrippedHostedEnvironmentFileId =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(hostedEnvironmentFileId),
                jacksonTypeRef<HostedEnvironmentFileId>(),
            )

        assertThat(roundtrippedHostedEnvironmentFileId).isEqualTo(hostedEnvironmentFileId)
    }
}
