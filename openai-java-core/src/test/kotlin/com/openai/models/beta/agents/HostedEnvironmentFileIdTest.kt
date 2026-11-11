// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class HostedEnvironmentFileIdTest {

    @Test
    fun createAndRoundtrip() {
        val hostedEnvironmentFileId =
            HostedEnvironmentFileId.builder()
                .id("id")
                .fileId("file_id")
                .path("path")
                .sizeBytes(0L)
                .build()

        assertThat(hostedEnvironmentFileId.id()).contains("id")
        assertThat(hostedEnvironmentFileId.fileId()).contains("file_id")
        assertThat(hostedEnvironmentFileId.path()).contains("path")
        assertThat(hostedEnvironmentFileId.sizeBytes()).contains(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedHostedEnvironmentFileId =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(hostedEnvironmentFileId),
                jacksonTypeRef<HostedEnvironmentFileId>(),
            )

        assertThat(roundtrippedHostedEnvironmentFileId).isEqualTo(hostedEnvironmentFileId)
    }
}
