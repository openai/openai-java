package com.openai.helpers

import com.openai.core.jsonMapper
import com.openai.models.webhooks.UnwrapWebhookEvent
import java.nio.file.Path
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.io.TempDir
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class AgentEnvironmentWebhookVisitorCompatibilityTest {

    @TempDir lateinit var tempDir: Path

    @ParameterizedTest
    @CsvSource(
        "agent.environment.expired, false, true",
        "agent.environment.expired, true, true",
        "agent.environment.expired, false, false",
        "agent.environment.expired, true, false",
        "agent.environment.suspended, false, true",
        "agent.environment.suspended, true, true",
        "agent.environment.suspended, false, false",
        "agent.environment.suspended, true, false",
    )
    fun existingVisitorsHandleEnvironmentEvents(
        type: String,
        binaryConsumer: Boolean,
        overridesUnknown: Boolean,
    ) {
        val event =
            jsonMapper()
                .readValue(
                    """{
                        "id": "evt-environment-test", "created_at": 123,
                        "object": "event", "type": "$type", "data": {"id": "env-test"}
                    }""",
                    UnwrapWebhookEvent::class.java,
                )
        // Ensure the test exercises a typed event's default method, not an unknown union variant.
        assertThat(
                if (type == "agent.environment.expired") event.isAgentEnvironmentExpired()
                else event.isAgentEnvironmentSuspended()
            )
            .isTrue()

        // Reuse the unchanged legacy Java source/ABI fixture and its exact abstract-method check.
        SafetyWebhookVisitorCompatibilityTest()
            .also { it.tempDir = tempDir }
            .existingVisitorsRemainSourceAndBinaryCompatible(type, binaryConsumer, overridesUnknown)
    }
}
