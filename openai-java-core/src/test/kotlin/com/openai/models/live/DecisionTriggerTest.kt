// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionTriggerTest {

    @Test
    fun createAndRoundtrip() {
        val decisionTrigger =
            DecisionTrigger.builder()
                .decisions(
                    DecisionTrigger.Decisions.builder()
                        .addQuestion(
                            DecisionTrigger.Decisions.Question.Predicate.builder()
                                .instructions("instructions")
                                .name("name")
                                .build()
                        )
                        .build()
                )
                .eventType(DecisionTrigger.EventType.SESSION_INPUT_TRANSCRIPT_DELTA)
                .build()

        assertThat(decisionTrigger.decisions())
            .isEqualTo(
                DecisionTrigger.Decisions.builder()
                    .addQuestion(
                        DecisionTrigger.Decisions.Question.Predicate.builder()
                            .instructions("instructions")
                            .name("name")
                            .build()
                    )
                    .build()
            )
        assertThat(decisionTrigger.eventType())
            .isEqualTo(DecisionTrigger.EventType.SESSION_INPUT_TRANSCRIPT_DELTA)

        val jsonMapper = jsonMapper()

        val roundtrippedDecisionTrigger =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionTrigger),
                jacksonTypeRef<DecisionTrigger>(),
            )

        assertThat(roundtrippedDecisionTrigger).isEqualTo(decisionTrigger)
    }
}
