// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseShellCallOutputContentDeltaEventTest {

    @Test
    fun create() {
        val responseShellCallOutputContentDeltaEvent =
            ResponseShellCallOutputContentDeltaEvent.builder()
                .commandIndex(0L)
                .delta(
                    ResponseShellCallOutputContentDeltaEvent.Delta.builder()
                        .stderr("stderr")
                        .stdout("stdout")
                        .build()
                )
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseShellCallOutputContentDeltaEvent.commandIndex()).isEqualTo(0L)
        assertThat(responseShellCallOutputContentDeltaEvent.delta())
            .isEqualTo(
                ResponseShellCallOutputContentDeltaEvent.Delta.builder()
                    .stderr("stderr")
                    .stdout("stdout")
                    .build()
            )
        assertThat(responseShellCallOutputContentDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(responseShellCallOutputContentDeltaEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseShellCallOutputContentDeltaEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseShellCallOutputContentDeltaEvent =
            ResponseShellCallOutputContentDeltaEvent.builder()
                .commandIndex(0L)
                .delta(
                    ResponseShellCallOutputContentDeltaEvent.Delta.builder()
                        .stderr("stderr")
                        .stdout("stdout")
                        .build()
                )
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val roundtrippedResponseShellCallOutputContentDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseShellCallOutputContentDeltaEvent),
                jacksonTypeRef<ResponseShellCallOutputContentDeltaEvent>(),
            )

        assertThat(roundtrippedResponseShellCallOutputContentDeltaEvent)
            .isEqualTo(responseShellCallOutputContentDeltaEvent)
    }
}
