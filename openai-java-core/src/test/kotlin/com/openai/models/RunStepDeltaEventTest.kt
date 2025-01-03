// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RunStepDeltaEventTest {

    @Test
    fun createRunStepDeltaEvent() {
        val runStepDeltaEvent =
            RunStepDeltaEvent.builder()
                .id("id")
                .delta(
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
                )
                .object_(RunStepDeltaEvent.Object.THREAD_RUN_STEP_DELTA)
                .build()
        assertThat(runStepDeltaEvent).isNotNull
        assertThat(runStepDeltaEvent.id()).isEqualTo("id")
        assertThat(runStepDeltaEvent.delta())
            .isEqualTo(
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
            )
        assertThat(runStepDeltaEvent.object_())
            .isEqualTo(RunStepDeltaEvent.Object.THREAD_RUN_STEP_DELTA)
    }
}
