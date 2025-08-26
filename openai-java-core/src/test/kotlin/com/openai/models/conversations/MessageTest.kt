// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageTest {

    @Test
    fun create() {
        val message =
            Message.builder()
                .id("id")
                .addInputTextContent("text")
                .role(Message.Role.UNKNOWN)
                .status(Message.Status.IN_PROGRESS)
                .build()

        assertThat(message.id()).isEqualTo("id")
        assertThat(message.content())
            .containsExactly(
                Message.Content.ofInputText(InputTextContent.builder().text("text").build())
            )
        assertThat(message.role()).isEqualTo(Message.Role.UNKNOWN)
        assertThat(message.status()).isEqualTo(Message.Status.IN_PROGRESS)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val message =
            Message.builder()
                .id("id")
                .addInputTextContent("text")
                .role(Message.Role.UNKNOWN)
                .status(Message.Status.IN_PROGRESS)
                .build()

        val roundtrippedMessage =
            jsonMapper.readValue(jsonMapper.writeValueAsString(message), jacksonTypeRef<Message>())

        assertThat(roundtrippedMessage).isEqualTo(message)
    }
}
