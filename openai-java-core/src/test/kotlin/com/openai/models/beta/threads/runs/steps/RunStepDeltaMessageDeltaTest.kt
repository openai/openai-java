// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RunStepDeltaMessageDeltaTest {

    @Test
    fun create() {
        val runStepDeltaMessageDelta =
            RunStepDeltaMessageDelta.builder()
                .messageCreation(
                    RunStepDeltaMessageDelta.MessageCreation.builder()
                        .messageId("message_id")
                        .build()
                )
                .build()

        assertThat(runStepDeltaMessageDelta.messageCreation())
            .contains(
                RunStepDeltaMessageDelta.MessageCreation.builder().messageId("message_id").build()
            )
    }
}
