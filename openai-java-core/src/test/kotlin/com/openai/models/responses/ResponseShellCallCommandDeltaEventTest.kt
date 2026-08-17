// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseShellCallCommandDeltaEventTest {

    @Test
    fun create() {
        val responseShellCallCommandDeltaEvent =
            ResponseShellCallCommandDeltaEvent.builder()
                .commandIndex(0L)
                .delta("delta")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .obfuscation("obfuscation")
                .build()

        assertThat(responseShellCallCommandDeltaEvent.commandIndex()).isEqualTo(0L)
        assertThat(responseShellCallCommandDeltaEvent.delta()).isEqualTo("delta")
        assertThat(responseShellCallCommandDeltaEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseShellCallCommandDeltaEvent.sequenceNumber()).isEqualTo(0L)
        assertThat(responseShellCallCommandDeltaEvent.obfuscation()).contains("obfuscation")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseShellCallCommandDeltaEvent =
            ResponseShellCallCommandDeltaEvent.builder()
                .commandIndex(0L)
                .delta("delta")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .obfuscation("obfuscation")
                .build()

        val roundtrippedResponseShellCallCommandDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseShellCallCommandDeltaEvent),
                jacksonTypeRef<ResponseShellCallCommandDeltaEvent>(),
            )

        assertThat(roundtrippedResponseShellCallCommandDeltaEvent)
            .isEqualTo(responseShellCallCommandDeltaEvent)
    }
}
