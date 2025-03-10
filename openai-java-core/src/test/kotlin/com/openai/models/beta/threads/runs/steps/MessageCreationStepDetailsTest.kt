// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageCreationStepDetailsTest {

    @Test
    fun createMessageCreationStepDetails() {
        val messageCreationStepDetails =
            MessageCreationStepDetails.builder()
                .messageCreation(
                    MessageCreationStepDetails.MessageCreation.builder()
                        .messageId("message_id")
                        .build()
                )
                .build()
        assertThat(messageCreationStepDetails).isNotNull
        assertThat(messageCreationStepDetails.messageCreation())
            .isEqualTo(
                MessageCreationStepDetails.MessageCreation.builder().messageId("message_id").build()
            )
    }
}
