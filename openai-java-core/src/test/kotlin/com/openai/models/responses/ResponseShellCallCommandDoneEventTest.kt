// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseShellCallCommandDoneEventTest {

    @Test
    fun create() {
        val responseShellCallCommandDoneEvent =
            ResponseShellCallCommandDoneEvent.builder()
                .command("command")
                .commandIndex(0L)
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseShellCallCommandDoneEvent.command()).isEqualTo("command")
        assertThat(responseShellCallCommandDoneEvent.commandIndex()).isEqualTo(0L)
        assertThat(responseShellCallCommandDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseShellCallCommandDoneEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseShellCallCommandDoneEvent =
            ResponseShellCallCommandDoneEvent.builder()
                .command("command")
                .commandIndex(0L)
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val roundtrippedResponseShellCallCommandDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseShellCallCommandDoneEvent),
                jacksonTypeRef<ResponseShellCallCommandDoneEvent>(),
            )

        assertThat(roundtrippedResponseShellCallCommandDoneEvent)
            .isEqualTo(responseShellCallCommandDoneEvent)
    }
}
