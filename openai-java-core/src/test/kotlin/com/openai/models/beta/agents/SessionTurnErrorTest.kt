// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionTurnErrorTest {

    @Test
    fun createAndRoundtrip() {
        val sessionTurnError =
            SessionTurnError.builder()
                .code(SessionTurnError.Code.CONTEXT_LENGTH_EXCEEDED)
                .message("message")
                .build()

        assertThat(sessionTurnError.code()).isEqualTo(SessionTurnError.Code.CONTEXT_LENGTH_EXCEEDED)
        assertThat(sessionTurnError.message()).isEqualTo("message")

        val jsonMapper = jsonMapper()

        val roundtrippedSessionTurnError =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sessionTurnError),
                jacksonTypeRef<SessionTurnError>(),
            )

        assertThat(roundtrippedSessionTurnError).isEqualTo(sessionTurnError)
    }
}
