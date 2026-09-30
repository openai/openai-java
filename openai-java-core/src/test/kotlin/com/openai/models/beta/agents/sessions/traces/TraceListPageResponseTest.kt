// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions.traces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TraceListPageResponseTest {

    @Test
    fun create() {
        val traceListPageResponse =
            TraceListPageResponse.builder()
                .addData(
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
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(traceListPageResponse.data())
            .containsExactly(
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
            )
        assertThat(traceListPageResponse.firstId()).contains("first_id")
        assertThat(traceListPageResponse.hasMore()).isEqualTo(true)
        assertThat(traceListPageResponse.lastId()).contains("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val traceListPageResponse =
            TraceListPageResponse.builder()
                .addData(
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
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedTraceListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(traceListPageResponse),
                jacksonTypeRef<TraceListPageResponse>(),
            )

        assertThat(roundtrippedTraceListPageResponse).isEqualTo(traceListPageResponse)
    }
}
