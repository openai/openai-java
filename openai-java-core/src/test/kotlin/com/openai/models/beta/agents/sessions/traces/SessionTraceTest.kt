// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions.traces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionTraceTest {

    @Test
    fun create() {
        val sessionTrace =
            SessionTrace.builder()
                .id("id")
                .createdAt(0L)
                .otlp(
                    SessionTrace.Otlp.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .sessionId("session_id")
                .build()

        assertThat(sessionTrace.id()).isEqualTo("id")
        assertThat(sessionTrace.createdAt()).isEqualTo(0L)
        assertThat(sessionTrace.otlp())
            .isEqualTo(
                SessionTrace.Otlp.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(sessionTrace.sessionId()).isEqualTo("session_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sessionTrace =
            SessionTrace.builder()
                .id("id")
                .createdAt(0L)
                .otlp(
                    SessionTrace.Otlp.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .sessionId("session_id")
                .build()

        val roundtrippedSessionTrace =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sessionTrace),
                jacksonTypeRef<SessionTrace>(),
            )

        assertThat(roundtrippedSessionTrace).isEqualTo(sessionTrace)
    }
}
