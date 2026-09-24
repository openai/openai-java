// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live.sessions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionForkResponseTest {

    @Test
    fun create() {
        val sessionForkResponse =
            SessionForkResponse.builder()
                .session(SessionForkResponse.Session.builder().id("id").build())
                .transport(SessionForkResponse.Transport.builder().sdp("x").build())
                .build()

        assertThat(sessionForkResponse.session())
            .isEqualTo(SessionForkResponse.Session.builder().id("id").build())
        assertThat(sessionForkResponse.transport())
            .isEqualTo(SessionForkResponse.Transport.builder().sdp("x").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sessionForkResponse =
            SessionForkResponse.builder()
                .session(SessionForkResponse.Session.builder().id("id").build())
                .transport(SessionForkResponse.Transport.builder().sdp("x").build())
                .build()

        val roundtrippedSessionForkResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sessionForkResponse),
                jacksonTypeRef<SessionForkResponse>(),
            )

        assertThat(roundtrippedSessionForkResponse).isEqualTo(sessionForkResponse)
    }
}
