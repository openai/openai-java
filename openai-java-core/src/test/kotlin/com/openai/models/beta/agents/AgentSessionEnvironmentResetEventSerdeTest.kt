package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class AgentSessionEnvironmentResetEventSerdeTest {
    @Test
    fun decodeResetWithoutTurn() {
        assertResetEvent(turnId = null, resetCount = 0L)
    }

    @Test
    fun decodeResetWithTurn() {
        assertResetEvent(turnId = "turn_synthetic", resetCount = 7L)
    }

    @Test
    fun explicitResetOverrideTakesPrecedence() {
        val reset =
            AgentSessionEnvironmentResetEvent.builder()
                .environmentId("environment_synthetic")
                .eventId("event_synthetic")
                .sessionId("session_synthetic")
                .turnId(null as String?)
                .resetCount(0L)
                .build()
        val result =
            AgentSessionEvent.ofEnvironmentReset(reset)
                .accept(
                    object : AgentSessionEvent.Visitor<String> {
                        override fun visitEnvironmentReset(
                            environmentReset: AgentSessionEnvironmentResetEvent
                        ): String {
                            assertThat(environmentReset).isSameAs(reset)
                            return "reset"
                        }

                        override fun unknown(json: JsonValue?) = "unknown"
                    }
                )

        assertThat(result).isEqualTo("reset")
    }

    @Test
    fun defaultUnknownHandlerStillRejectsUnhandledReset() {
        val reset =
            AgentSessionEnvironmentResetEvent.builder()
                .environmentId("environment_synthetic")
                .eventId("event_synthetic")
                .sessionId("session_synthetic")
                .turnId(null as String?)
                .resetCount(0L)
                .build()

        assertThatThrownBy {
                AgentSessionEvent.ofEnvironmentReset(reset)
                    .accept(object : AgentSessionEvent.Visitor<String> {})
            }
            .isInstanceOf(OpenAIInvalidDataException::class.java)
    }

    @Test
    fun unknownWireEventStillReachesUnknownHandler() {
        val mapper = jsonMapper()
        val payload = """{"type":"agent.session.synthetic.future","value":[null,0]}"""
        val event = mapper.readValue(payload, jacksonTypeRef<AgentSessionEvent>())
        val value =
            event.accept(
                object : AgentSessionEvent.Visitor<JsonValue?> {
                    override fun unknown(json: JsonValue?) = json
                }
            )

        assertThat(mapper.readTree(mapper.writeValueAsString(value)))
            .isEqualTo(mapper.readTree(payload))
    }

    private fun assertResetEvent(turnId: String?, resetCount: Long) {
        val mapper = jsonMapper()
        val payload =
            """
            {
                "type": "agent.session.environment.reset",
                "event_id": "event_synthetic",
                "session_id": "session_synthetic",
                "environment_id": "environment_synthetic",
                "turn_id": ${mapper.writeValueAsString(turnId)},
                "reset_count": $resetCount,
                "future_field": [null, 0, "synthetic"]
            }
            """
                .trimIndent()
        val event = mapper.readValue(payload, jacksonTypeRef<AgentSessionEvent>())

        assertThat(event.isEnvironmentReset()).isTrue()
        assertThat(event.isEnvironmentReady()).isFalse()
        val reset = event.asEnvironmentReset()
        reset.validate()
        assertThat(reset.eventId()).isEqualTo("event_synthetic")
        assertThat(reset.sessionId()).isEqualTo("session_synthetic")
        assertThat(reset.environmentId()).isEqualTo("environment_synthetic")
        assertThat(reset.resetCount()).isEqualTo(resetCount)
        assertThat(reset.turnId().orElse(null)).isEqualTo(turnId)

        val roundtrip = mapper.readTree(mapper.writeValueAsString(event))
        assertThat(roundtrip).isEqualTo(mapper.readTree(payload))
        assertThat(roundtrip.has("turn_id")).isTrue()

        val fallback =
            event.accept(
                object : AgentSessionEvent.Visitor<JsonValue?> {
                    override fun unknown(json: JsonValue?) = json
                }
            )
        assertThat(mapper.readTree(mapper.writeValueAsString(fallback))).isEqualTo(roundtrip)
    }
}
