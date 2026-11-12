// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.decisions.DecisionChoiceOption
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
                            DecisionQuestion.Choice.builder()
                                .addChoice(
                                    DecisionChoiceOption.builder()
                                        .value("string")
                                        .description("description")
                                        .build()
                                )
                                .instructions("string")
                                .name("name")
                                .build()
                        )
                        .build()
                )
                .eventType(DecisionTrigger.EventType.SESSION_INPUT_TRANSCRIPT_DELTA)
                .build()

        assertThat(decisionTrigger.decisions())
            .contains(
                DecisionTrigger.Decisions.builder()
                    .addQuestion(
                        DecisionQuestion.Choice.builder()
                            .addChoice(
                                DecisionChoiceOption.builder()
                                    .value("string")
                                    .description("description")
                                    .build()
                            )
                            .instructions("string")
                            .name("name")
                            .build()
                    )
                    .build()
            )
        assertThat(decisionTrigger.eventType())
            .contains(DecisionTrigger.EventType.SESSION_INPUT_TRANSCRIPT_DELTA)

        val jsonMapper = jsonMapper()

        val roundtrippedDecisionTrigger =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionTrigger),
                jacksonTypeRef<DecisionTrigger>(),
            )

        assertThat(roundtrippedDecisionTrigger).isEqualTo(decisionTrigger)
    }
}
