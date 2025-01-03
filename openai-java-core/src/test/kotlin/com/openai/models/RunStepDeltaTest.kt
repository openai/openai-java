// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RunStepDeltaTest {

    @Test
    fun createRunStepDelta() {
        val runStepDelta =
            RunStepDelta.builder()
                .stepDetails(
                    RunStepDelta.StepDetails.ofRunStepDeltaMessageDelta(
                        RunStepDeltaMessageDelta.builder()
                            .type(RunStepDeltaMessageDelta.Type.MESSAGE_CREATION)
                            .messageCreation(
                                RunStepDeltaMessageDelta.MessageCreation.builder()
                                    .messageId("message_id")
                                    .build()
                            )
                            .build()
                    )
                )
                .build()
        assertThat(runStepDelta).isNotNull
        assertThat(runStepDelta.stepDetails())
            .contains(
                RunStepDelta.StepDetails.ofRunStepDeltaMessageDelta(
                    RunStepDeltaMessageDelta.builder()
                        .type(RunStepDeltaMessageDelta.Type.MESSAGE_CREATION)
                        .messageCreation(
                            RunStepDeltaMessageDelta.MessageCreation.builder()
                                .messageId("message_id")
                                .build()
                        )
                        .build()
                )
            )
    }
}
