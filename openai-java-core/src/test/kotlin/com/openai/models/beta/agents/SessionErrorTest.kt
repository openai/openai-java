// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionErrorTest {

    @Test
    fun createAndRoundtrip() {
        val sessionError =
            SessionError.builder()
                .code("code")
                .message("message")
                .param("param")
                .type("type")
                .build()

        assertThat(sessionError.code()).contains("code")
        assertThat(sessionError.message()).isEqualTo("message")
        assertThat(sessionError.param()).contains("param")
        assertThat(sessionError.type()).isEqualTo("type")

        val jsonMapper = jsonMapper()

        val roundtrippedSessionError =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sessionError),
                jacksonTypeRef<SessionError>(),
            )

        assertThat(roundtrippedSessionError).isEqualTo(sessionError)
    }
}
