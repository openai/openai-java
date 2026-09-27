// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseShellCallOutputContentDoneEventTest {

    @Test
    fun create() {
        val responseShellCallOutputContentDoneEvent =
            ResponseShellCallOutputContentDoneEvent.builder()
                .commandIndex(0L)
                .itemId("item_id")
                .addOutput(
                    ResponseShellCallOutputContentDoneEvent.Output.builder()
                        .outcomeTimeout()
                        .stderr("stderr")
                        .stdout("stdout")
                        .createdBy("created_by")
                        .build()
                )
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseShellCallOutputContentDoneEvent.commandIndex()).isEqualTo(0L)
        assertThat(responseShellCallOutputContentDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(responseShellCallOutputContentDoneEvent.output())
            .containsExactly(
                ResponseShellCallOutputContentDoneEvent.Output.builder()
                    .outcomeTimeout()
                    .stderr("stderr")
                    .stdout("stdout")
                    .createdBy("created_by")
                    .build()
            )
        assertThat(responseShellCallOutputContentDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseShellCallOutputContentDoneEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseShellCallOutputContentDoneEvent =
            ResponseShellCallOutputContentDoneEvent.builder()
                .commandIndex(0L)
                .itemId("item_id")
                .addOutput(
                    ResponseShellCallOutputContentDoneEvent.Output.builder()
                        .outcomeTimeout()
                        .stderr("stderr")
                        .stdout("stdout")
                        .createdBy("created_by")
                        .build()
                )
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val roundtrippedResponseShellCallOutputContentDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseShellCallOutputContentDoneEvent),
                jacksonTypeRef<ResponseShellCallOutputContentDoneEvent>(),
            )

        assertThat(roundtrippedResponseShellCallOutputContentDoneEvent)
            .isEqualTo(responseShellCallOutputContentDoneEvent)
    }
}
