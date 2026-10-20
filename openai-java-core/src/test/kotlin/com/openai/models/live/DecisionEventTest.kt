// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.decisions.Decision
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionEventTest {

    @Test
    fun create() {
        val decisionEvent =
            DecisionEvent.builder()
                .delegationId("del_abc123")
                .event(
                    DecisionEvent.Event.builder()
                        .decision(
                            Decision.builder()
                                .addAnswer(
                                    Decision.Answer.Predicate.builder()
                                        .name("damaged")
                                        .probability(0.95)
                                        .build()
                                )
                                .model("gpt-6-luna")
                                .usage(
                                    Decision.Usage.builder()
                                        .inputTokens(42L)
                                        .inputTokensDetails(
                                            Decision.Usage.InputTokensDetails.builder()
                                                .cacheWriteTokens(0L)
                                                .cachedTokens(0L)
                                                .build()
                                        )
                                        .outputTokens(0L)
                                        .outputTokensDetails(
                                            Decision.Usage.OutputTokensDetails.builder()
                                                .reasoningTokens(0L)
                                                .build()
                                        )
                                        .totalTokens(42L)
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .eventId("evt_decision_1")
                .sourceEventId(null)
                .sourceEventType(null)
                .triggerId(null)
                .build()

        assertThat(decisionEvent.delegationId()).contains("del_abc123")
        assertThat(decisionEvent.event())
            .isEqualTo(
                DecisionEvent.Event.builder()
                    .decision(
                        Decision.builder()
                            .addAnswer(
                                Decision.Answer.Predicate.builder()
                                    .name("damaged")
                                    .probability(0.95)
                                    .build()
                            )
                            .model("gpt-6-luna")
                            .usage(
                                Decision.Usage.builder()
                                    .inputTokens(42L)
                                    .inputTokensDetails(
                                        Decision.Usage.InputTokensDetails.builder()
                                            .cacheWriteTokens(0L)
                                            .cachedTokens(0L)
                                            .build()
                                    )
                                    .outputTokens(0L)
                                    .outputTokensDetails(
                                        Decision.Usage.OutputTokensDetails.builder()
                                            .reasoningTokens(0L)
                                            .build()
                                    )
                                    .totalTokens(42L)
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
        assertThat(decisionEvent.eventId()).isEqualTo("evt_decision_1")
        assertThat(decisionEvent.sourceEventId()).isEmpty
        assertThat(decisionEvent.sourceEventType()).isEmpty
        assertThat(decisionEvent.triggerId()).isEmpty
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val decisionEvent =
            DecisionEvent.builder()
                .delegationId("del_abc123")
                .event(
                    DecisionEvent.Event.builder()
                        .decision(
                            Decision.builder()
                                .addAnswer(
                                    Decision.Answer.Predicate.builder()
                                        .name("damaged")
                                        .probability(0.95)
                                        .build()
                                )
                                .model("gpt-6-luna")
                                .usage(
                                    Decision.Usage.builder()
                                        .inputTokens(42L)
                                        .inputTokensDetails(
                                            Decision.Usage.InputTokensDetails.builder()
                                                .cacheWriteTokens(0L)
                                                .cachedTokens(0L)
                                                .build()
                                        )
                                        .outputTokens(0L)
                                        .outputTokensDetails(
                                            Decision.Usage.OutputTokensDetails.builder()
                                                .reasoningTokens(0L)
                                                .build()
                                        )
                                        .totalTokens(42L)
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .eventId("evt_decision_1")
                .sourceEventId(null)
                .sourceEventType(null)
                .triggerId(null)
                .build()

        val roundtrippedDecisionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionEvent),
                jacksonTypeRef<DecisionEvent>(),
            )

        assertThat(roundtrippedDecisionEvent).isEqualTo(decisionEvent)
    }
}
