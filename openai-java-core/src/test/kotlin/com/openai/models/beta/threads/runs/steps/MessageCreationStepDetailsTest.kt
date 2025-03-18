// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

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
}
