// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionUpdateConfigTest {

    @Test
    fun createAndRoundtrip() {
        val sessionUpdateConfig =
            SessionUpdateConfig.builder()
                .delegation(ClientDelegation.builder().acknowledgementDelayMs(0L).build())
                .addTrigger(
                    DecisionTrigger.builder()
                        .decisions(
                            DecisionTrigger.Decisions.builder()
                                .addQuestion(
                                    DecisionTrigger.Decisions.Question.Predicate.builder()
                                        .instructions("string")
                                        .name("name")
                                        .build()
                                )
                                .build()
                        )
                        .eventType(DecisionTrigger.EventType.SESSION_INPUT_TRANSCRIPT_DELTA)
                        .build()
                )
                .build()

        assertThat(sessionUpdateConfig.delegation())
            .contains(
                SessionUpdateConfig.Delegation.ofClient(
                    ClientDelegation.builder().acknowledgementDelayMs(0L).build()
                )
            )
        assertThat(sessionUpdateConfig.triggers().getOrNull())
            .containsExactly(
                DecisionTrigger.builder()
                    .decisions(
                        DecisionTrigger.Decisions.builder()
                            .addQuestion(
                                DecisionTrigger.Decisions.Question.Predicate.builder()
                                    .instructions("string")
                                    .name("name")
                                    .build()
                            )
                            .build()
                    )
                    .eventType(DecisionTrigger.EventType.SESSION_INPUT_TRANSCRIPT_DELTA)
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedSessionUpdateConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sessionUpdateConfig),
                jacksonTypeRef<SessionUpdateConfig>(),
            )

        assertThat(roundtrippedSessionUpdateConfig).isEqualTo(sessionUpdateConfig)
    }
}
