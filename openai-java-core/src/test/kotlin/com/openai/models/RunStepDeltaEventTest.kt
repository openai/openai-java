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
        assertThat(runStepDeltaEvent).isNotNull
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
}
