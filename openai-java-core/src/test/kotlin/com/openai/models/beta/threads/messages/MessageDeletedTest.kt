// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageDeletedTest {

    @Test
    fun create() {
        val messageDeleted = MessageDeleted.builder().id("id").deleted(true).build()

        assertThat(messageDeleted.id()).isEqualTo("id")
        assertThat(messageDeleted.deleted()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageDeleted = MessageDeleted.builder().id("id").deleted(true).build()

        val roundtrippedMessageDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageDeleted),
                jacksonTypeRef<MessageDeleted>(),
            )

        assertThat(roundtrippedMessageDeleted).isEqualTo(messageDeleted)
    }
}
