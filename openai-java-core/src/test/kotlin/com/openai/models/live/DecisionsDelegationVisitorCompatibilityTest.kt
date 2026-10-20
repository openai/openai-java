package com.openai.models.live

import com.openai.core.JsonValue
import com.openai.models.live.sessions.SessionAcceptParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DecisionsDelegationVisitorCompatibilityTest {
    @Test
    fun existingVisitorHandlesDecisionsAsUnknown() {
        val visitor =
            object : SessionConfig.Delegation.Visitor<JsonValue?> {
                override fun visitClient(client: ClientDelegation): JsonValue? = null

                override fun visitResponses(
                    responses: SessionConfig.Delegation.Responses
                ): JsonValue? = null

                override fun unknown(json: JsonValue?) = json
            }
        val decisions =
            SessionConfig.Delegation.Decisions.builder()
                .decisions(
                    DecisionsDelegationConfig.builder()
                        .model("decision-model")
                        .addPredicateQuestion("Is the customer asking for help?")
                        .build()
                )
                .build()

        assertThat(SessionConfig.Delegation.ofDecisions(decisions).accept(visitor))
            .isEqualTo(JsonValue.from(decisions))
    }

    @Test
    fun decisionsVisitorMethodsAreJvmDefaults() {
        for ((visitor, decisions) in
            listOf(
                MediaSessionConfig.Delegation.Visitor::class.java to
                    MediaSessionConfig.Delegation.Decisions::class.java,
                SessionConfig.Delegation.Visitor::class.java to
                    SessionConfig.Delegation.Decisions::class.java,
                SessionResource.Delegation.Visitor::class.java to
                    SessionResource.Delegation.Decisions::class.java,
                SessionUpdateConfig.Delegation.Visitor::class.java to
                    SessionUpdateConfig.Delegation.Decisions::class.java,
                SessionAcceptParams.Session.Delegation.Visitor::class.java to
                    SessionAcceptParams.Session.Delegation.Decisions::class.java,
            )) {
            assertThat(visitor.getMethod("visitDecisions", decisions).isDefault)
                .describedAs("%s.visitDecisions is a JVM default method", visitor.name)
                .isTrue()
        }
    }
}
