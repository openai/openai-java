// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions.artifacts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ArtifactListPageResponseTest {

    @Test
    fun create() {
        val artifactListPageResponse =
            ArtifactListPageResponse.builder()
                .addData(
                    SessionArtifact.builder()
                        .id("id")
                        .createdAt(0L)
                        .environmentId("environment_id")
                        .path("path")
                        .sessionId("session_id")
                        .sizeBytes(0L)
                        .turnId("turn_id")
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(artifactListPageResponse.data())
            .containsExactly(
                SessionArtifact.builder()
                    .id("id")
                    .createdAt(0L)
                    .environmentId("environment_id")
                    .path("path")
                    .sessionId("session_id")
                    .sizeBytes(0L)
                    .turnId("turn_id")
                    .build()
            )
        assertThat(artifactListPageResponse.firstId()).contains("first_id")
        assertThat(artifactListPageResponse.hasMore()).isEqualTo(true)
        assertThat(artifactListPageResponse.lastId()).contains("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val artifactListPageResponse =
            ArtifactListPageResponse.builder()
                .addData(
                    SessionArtifact.builder()
                        .id("id")
                        .createdAt(0L)
                        .environmentId("environment_id")
                        .path("path")
                        .sessionId("session_id")
                        .sizeBytes(0L)
                        .turnId("turn_id")
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedArtifactListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(artifactListPageResponse),
                jacksonTypeRef<ArtifactListPageResponse>(),
            )

        assertThat(roundtrippedArtifactListPageResponse).isEqualTo(artifactListPageResponse)
    }
}
