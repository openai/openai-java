package com.openai.models.beta.agents.sessions

import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionUpdateSerializationTest {

    @Test
    fun omittedSettings() {
        assertBody(SessionUpdateParams.builder().sessionId("session_test").build(), "{}")
    }

    @Test
    fun emptyAgentAndReasoning() {
        assertBody(
            SessionUpdateParams.builder()
                .sessionId("session_test")
                .agent(
                    SessionUpdateParams.Agent.builder()
                        .model("")
                        .reasoning(SessionUpdateParams.Agent.Reasoning.builder().build())
                        .build()
                )
                .build(),
            """{"agent":{"model":"","reasoning":{}}}""",
        )
    }

    @Test
    fun populatedSettings() {
        assertBody(
            SessionUpdateParams.builder()
                .sessionId("session_test")
                .agent(
                    SessionUpdateParams.Agent.builder()
                        .model("gpt-5")
                        .reasoning(
                            SessionUpdateParams.Agent.Reasoning.builder()
                                .effort(SessionUpdateParams.Agent.Reasoning.Effort.LOW)
                                .build()
                        )
                        .serviceTier(SessionUpdateParams.Agent.ServiceTier.PRIORITY)
                        .build()
                )
                .build(),
            """{"agent":{"model":"gpt-5","reasoning":{"effort":"low"},"service_tier":"priority"}}""",
        )
    }

    @Test
    fun explicitNullResets() {
        assertBody(
            SessionUpdateParams.builder()
                .sessionId("session_test")
                .agent(
                    SessionUpdateParams.Agent.builder()
                        .reasoning(
                            SessionUpdateParams.Agent.Reasoning.builder()
                                .effort(JsonField.ofNullable(null))
                                .build()
                        )
                        .serviceTier(JsonField.ofNullable(null))
                        .build()
                )
                .build(),
            """{"agent":{"reasoning":{"effort":null},"service_tier":null}}""",
        )
    }

    @Test
    fun existingMetadataBehavior() {
        val values =
            listOf(
                JsonField.of(
                    SessionUpdateParams.Metadata.builder()
                        .putAdditionalProperty("purpose", JsonValue.from("test"))
                        .build()
                ) to """{"metadata":{"purpose":"test"}}""",
                JsonField.ofNullable<SessionUpdateParams.Metadata>(null) to """{"metadata":null}""",
                JsonField.of(SessionUpdateParams.Metadata.builder().build()) to
                    """{"metadata":{}}""",
            )
        values.forEach { (metadata, expected) ->
            assertBody(
                SessionUpdateParams.builder().sessionId("session_test").metadata(metadata).build(),
                expected,
            )
        }
    }

    private fun assertBody(params: SessionUpdateParams, expected: String) {
        val mapper = jsonMapper()
        assertThat(mapper.readTree(mapper.writeValueAsString(params._body())))
            .isEqualTo(mapper.readTree(expected))
    }
}
