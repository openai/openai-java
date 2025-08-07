// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
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

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val runStepDeltaMessageDelta =
            RunStepDeltaMessageDelta.builder()
                .messageCreation(
                    RunStepDeltaMessageDelta.MessageCreation.builder()
                        .messageId("message_id")
                        .build()
                )
                .build()

        val roundtrippedRunStepDeltaMessageDelta =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(runStepDeltaMessageDelta),
                jacksonTypeRef<RunStepDeltaMessageDelta>(),
            )

        assertThat(roundtrippedRunStepDeltaMessageDelta).isEqualTo(runStepDeltaMessageDelta)
    }
}
