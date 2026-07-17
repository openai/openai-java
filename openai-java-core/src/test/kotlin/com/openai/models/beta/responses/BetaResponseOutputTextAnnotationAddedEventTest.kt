// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseOutputTextAnnotationAddedEventTest {

    @Test
    fun create() {
        val betaResponseOutputTextAnnotationAddedEvent =
            BetaResponseOutputTextAnnotationAddedEvent.builder()
                .annotation(JsonValue.from(mapOf<String, Any>()))
                .annotationIndex(0L)
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseOutputTextAnnotationAddedEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        assertThat(betaResponseOutputTextAnnotationAddedEvent._annotation())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(betaResponseOutputTextAnnotationAddedEvent.annotationIndex()).isEqualTo(0L)
        assertThat(betaResponseOutputTextAnnotationAddedEvent.contentIndex()).isEqualTo(0L)
        assertThat(betaResponseOutputTextAnnotationAddedEvent.itemId()).isEqualTo("item_id")
        assertThat(betaResponseOutputTextAnnotationAddedEvent.outputIndex()).isEqualTo(0L)
        assertThat(betaResponseOutputTextAnnotationAddedEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(betaResponseOutputTextAnnotationAddedEvent.agent())
            .contains(
                BetaResponseOutputTextAnnotationAddedEvent.Agent.builder()
                    .agentName("agent_name")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputTextAnnotationAddedEvent =
            BetaResponseOutputTextAnnotationAddedEvent.builder()
                .annotation(JsonValue.from(mapOf<String, Any>()))
                .annotationIndex(0L)
                .contentIndex(0L)
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .agent(
                    BetaResponseOutputTextAnnotationAddedEvent.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val roundtrippedBetaResponseOutputTextAnnotationAddedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputTextAnnotationAddedEvent),
                jacksonTypeRef<BetaResponseOutputTextAnnotationAddedEvent>(),
            )

        assertThat(roundtrippedBetaResponseOutputTextAnnotationAddedEvent)
            .isEqualTo(betaResponseOutputTextAnnotationAddedEvent)
    }
}
