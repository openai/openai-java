// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RunStepDeltaEventTest {

    @Test
    fun create() {
        val runStepDeltaEvent =
            RunStepDeltaEvent.builder()
                .id("id")
                .delta(
                    RunStepDelta.builder()
                        .stepDetails(
                            RunStepDeltaMessageDelta.builder()
                                .messageCreation(
                                    RunStepDeltaMessageDelta.MessageCreation.builder()
                                        .messageId("message_id")
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(runStepDeltaEvent.id()).isEqualTo("id")
        assertThat(runStepDeltaEvent.delta())
            .isEqualTo(
                RunStepDelta.builder()
                    .stepDetails(
                        RunStepDeltaMessageDelta.builder()
                            .messageCreation(
                                RunStepDeltaMessageDelta.MessageCreation.builder()
                                    .messageId("message_id")
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val runStepDeltaEvent =
            RunStepDeltaEvent.builder()
                .id("id")
                .delta(
                    RunStepDelta.builder()
                        .stepDetails(
                            RunStepDeltaMessageDelta.builder()
                                .messageCreation(
                                    RunStepDeltaMessageDelta.MessageCreation.builder()
                                        .messageId("message_id")
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .build()

        val roundtrippedRunStepDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(runStepDeltaEvent),
                jacksonTypeRef<RunStepDeltaEvent>(),
            )

        assertThat(roundtrippedRunStepDeltaEvent).isEqualTo(runStepDeltaEvent)
    }
}
