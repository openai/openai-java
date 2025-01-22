// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RunStepDeltaMessageDeltaTest {

    @Test
    fun createRunStepDeltaMessageDelta() {
        val runStepDeltaMessageDelta =
            RunStepDeltaMessageDelta.builder()
                .messageCreation(
                    RunStepDeltaMessageDelta.MessageCreation.builder()
                        .messageId("message_id")
                        .build()
                )
                .build()
        assertThat(runStepDeltaMessageDelta).isNotNull
        assertThat(runStepDeltaMessageDelta.messageCreation())
            .contains(
                RunStepDeltaMessageDelta.MessageCreation.builder().messageId("message_id").build()
            )
    }
}
