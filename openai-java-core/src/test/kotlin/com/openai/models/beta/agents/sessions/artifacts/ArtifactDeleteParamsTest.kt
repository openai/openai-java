// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions.artifacts

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ArtifactDeleteParamsTest {

    @Test
    fun create() {
        ArtifactDeleteParams.builder().sessionId("session_id").artifactId("artifact_id").build()
    }

    @Test
    fun pathParams() {
        val params =
            ArtifactDeleteParams.builder().sessionId("session_id").artifactId("artifact_id").build()

        assertThat(params._pathParam(0)).isEqualTo("session_id")
        assertThat(params._pathParam(1)).isEqualTo("artifact_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
