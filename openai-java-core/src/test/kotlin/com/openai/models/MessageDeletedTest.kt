// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageDeletedTest {

    @Test
    fun createMessageDeleted() {
        val messageDeleted =
            MessageDeleted.builder()
                .id("id")
                .deleted(true)
                .object_(MessageDeleted.Object.THREAD_MESSAGE_DELETED)
                .build()
        assertThat(messageDeleted).isNotNull
        assertThat(messageDeleted.id()).isEqualTo("id")
        assertThat(messageDeleted.deleted()).isEqualTo(true)
        assertThat(messageDeleted.object_()).isEqualTo(MessageDeleted.Object.THREAD_MESSAGE_DELETED)
    }
}
