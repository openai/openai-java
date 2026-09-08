// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseShellCallCommandAddedEventTest {

    @Test
    fun create() {
        val responseShellCallCommandAddedEvent =
            ResponseShellCallCommandAddedEvent.builder()
                .command("command")
                .commandIndex(0L)
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseShellCallCommandAddedEvent.command()).isEqualTo("command")
        assertThat(responseShellCallCommandAddedEvent.commandIndex()).isEqualTo(0L)
        assertThat(responseShellCallCommandAddedEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseShellCallCommandAddedEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseShellCallCommandAddedEvent =
            ResponseShellCallCommandAddedEvent.builder()
                .command("command")
                .commandIndex(0L)
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val roundtrippedResponseShellCallCommandAddedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseShellCallCommandAddedEvent),
                jacksonTypeRef<ResponseShellCallCommandAddedEvent>(),
            )

        assertThat(roundtrippedResponseShellCallCommandAddedEvent)
            .isEqualTo(responseShellCallCommandAddedEvent)
    }
}
