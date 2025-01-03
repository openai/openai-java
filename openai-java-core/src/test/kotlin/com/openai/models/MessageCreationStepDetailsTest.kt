// File generated from our OpenAPI spec by Stainless.

package com.openai.models

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
                .type(MessageCreationStepDetails.Type.MESSAGE_CREATION)
                .build()
        assertThat(messageCreationStepDetails).isNotNull
        assertThat(messageCreationStepDetails.messageCreation())
            .isEqualTo(
                MessageCreationStepDetails.MessageCreation.builder().messageId("message_id").build()
            )
        assertThat(messageCreationStepDetails.type())
            .isEqualTo(MessageCreationStepDetails.Type.MESSAGE_CREATION)
    }
}
