// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RunStepDeltaTest {

    @Test
    fun create() {
        val runStepDelta =
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

        assertThat(runStepDelta.stepDetails())
            .contains(
                RunStepDelta.StepDetails.ofMessageCreation(
                    RunStepDeltaMessageDelta.builder()
                        .messageCreation(
                            RunStepDeltaMessageDelta.MessageCreation.builder()
                                .messageId("message_id")
                                .build()
                        )
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val runStepDelta =
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

        val roundtrippedRunStepDelta =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(runStepDelta),
                jacksonTypeRef<RunStepDelta>(),
            )

        assertThat(roundtrippedRunStepDelta).isEqualTo(runStepDelta)
    }
}
