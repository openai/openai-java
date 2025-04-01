// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageCreationStepDetailsTest {

    @Test
    fun create() {
        val messageCreationStepDetails =
            MessageCreationStepDetails.builder()
                .messageCreation(
                    MessageCreationStepDetails.MessageCreation.builder()
                        .messageId("message_id")
                        .build()
                )
                .build()

        assertThat(messageCreationStepDetails.messageCreation())
            .isEqualTo(
                MessageCreationStepDetails.MessageCreation.builder().messageId("message_id").build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageCreationStepDetails =
            MessageCreationStepDetails.builder()
                .messageCreation(
                    MessageCreationStepDetails.MessageCreation.builder()
                        .messageId("message_id")
                        .build()
                )
                .build()

        val roundtrippedMessageCreationStepDetails =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageCreationStepDetails),
                jacksonTypeRef<MessageCreationStepDetails>(),
            )

        assertThat(roundtrippedMessageCreationStepDetails).isEqualTo(messageCreationStepDetails)
    }
}
