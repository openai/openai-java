// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions.artifacts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionArtifactTest {

    @Test
    fun createAndRoundtrip() {
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

        assertThat(sessionArtifact.id()).contains("id")
        assertThat(sessionArtifact.createdAt()).contains(0L)
        assertThat(sessionArtifact.environmentId()).contains("environment_id")
        assertThat(sessionArtifact.path()).contains("path")
        assertThat(sessionArtifact.sessionId()).contains("session_id")
        assertThat(sessionArtifact.sizeBytes()).contains(0L)
        assertThat(sessionArtifact.turnId()).contains("turn_id")

        val jsonMapper = jsonMapper()

        val roundtrippedSessionArtifact =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sessionArtifact),
                jacksonTypeRef<SessionArtifact>(),
            )

        assertThat(roundtrippedSessionArtifact).isEqualTo(sessionArtifact)
    }
}
