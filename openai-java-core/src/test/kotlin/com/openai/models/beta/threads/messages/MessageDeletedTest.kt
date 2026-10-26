// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.threads.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageDeletedTest {

    @Test
    fun createAndRoundtrip() {
        val messageDeleted = MessageDeleted.builder().id("id").deleted(true).build()

        assertThat(messageDeleted.id()).isEqualTo("id")
        assertThat(messageDeleted.deleted()).isEqualTo(true)

        val jsonMapper = jsonMapper()

        val roundtrippedMessageDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageDeleted),
                jacksonTypeRef<MessageDeleted>(),
            )

        assertThat(roundtrippedMessageDeleted).isEqualTo(messageDeleted)
    }
}
