// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions.artifacts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionArtifactDeletedTest {

    @Test
    fun createAndRoundtrip() {
        val sessionArtifactDeleted = SessionArtifactDeleted.builder().id("id").deleted(true).build()

        assertThat(sessionArtifactDeleted.id()).isEqualTo("id")
        assertThat(sessionArtifactDeleted.deleted()).isEqualTo(true)

        val jsonMapper = jsonMapper()

        val roundtrippedSessionArtifactDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sessionArtifactDeleted),
                jacksonTypeRef<SessionArtifactDeleted>(),
            )

        assertThat(roundtrippedSessionArtifactDeleted).isEqualTo(sessionArtifactDeleted)
    }
}
