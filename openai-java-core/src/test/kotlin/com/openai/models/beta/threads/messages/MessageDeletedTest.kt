// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageDeletedTest {

    @Test
    fun createMessageDeleted() {
        val messageDeleted = MessageDeleted.builder().id("id").deleted(true).build()
        assertThat(messageDeleted).isNotNull
        assertThat(messageDeleted.id()).isEqualTo("id")
        assertThat(messageDeleted.deleted()).isEqualTo(true)
    }
}
