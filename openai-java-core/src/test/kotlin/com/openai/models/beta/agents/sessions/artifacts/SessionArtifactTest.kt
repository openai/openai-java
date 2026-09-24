// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions.artifacts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionArtifactTest {

    @Test
    fun create() {
        val sessionArtifact =
            SessionArtifact.builder()
                .id("id")
                .createdAt(0L)
                .environmentId("environment_id")
                .path("path")
                .sessionId("session_id")
                .sizeBytes(0L)
                .turnId("turn_id")
                .build()

        assertThat(sessionArtifact.id()).isEqualTo("id")
        assertThat(sessionArtifact.createdAt()).isEqualTo(0L)
        assertThat(sessionArtifact.environmentId()).isEqualTo("environment_id")
        assertThat(sessionArtifact.path()).isEqualTo("path")
        assertThat(sessionArtifact.sessionId()).isEqualTo("session_id")
        assertThat(sessionArtifact.sizeBytes()).isEqualTo(0L)
        assertThat(sessionArtifact.turnId()).isEqualTo("turn_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sessionArtifact =
            SessionArtifact.builder()
                .id("id")
                .createdAt(0L)
                .environmentId("environment_id")
                .path("path")
                .sessionId("session_id")
                .sizeBytes(0L)
                .turnId("turn_id")
                .build()

        val roundtrippedSessionArtifact =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sessionArtifact),
                jacksonTypeRef<SessionArtifact>(),
            )

        assertThat(roundtrippedSessionArtifact).isEqualTo(sessionArtifact)
    }
}
